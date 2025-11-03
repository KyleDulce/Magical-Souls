package me.someoneawesome.magicalsouls.resource;

import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReloader;
import net.minecraft.util.profiler.Profiler;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class MagicalSoulResourceLoader implements ResourceReloader {
    private final ResourceReloadListener<?>[] RESOURCE_LOADERS = new ResourceReloadListener[] {};

    @Override
    public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager, Profiler prepareProfiler, Profiler applyProfiler, Executor prepareExecutor, Executor applyExecutor) {
        List<CompletableFuture<Void>> futures = Arrays.stream(RESOURCE_LOADERS)
                .map(reloader ->
                        CompletableFuture.supplyAsync(() -> runPrepare(reloader, manager, prepareProfiler), prepareExecutor)
                                .thenCompose(synchronizer::whenPrepared)
                                .thenAcceptAsync(preparedObject -> runApply(reloader, preparedObject, manager, applyProfiler), applyExecutor)
                ).toList();

        return CompletableFuture.allOf((CompletableFuture<?>) futures);
    }

    private <ReloaderType> ReloaderType runPrepare(ResourceReloadListener<ReloaderType> reloader, ResourceManager manager, Profiler prepareProfiler) {
        prepareProfiler.startTick();
        prepareProfiler.push(reloader.getClass().getSimpleName() + "-prepare");
        ReloaderType preparedObject = reloader.prepare(manager);
        prepareProfiler.pop();
        prepareProfiler.endTick();

        return preparedObject;
    }

    @SuppressWarnings("unchecked cast")
    private <ReloaderType> void runApply(ResourceReloadListener<ReloaderType> reloader, Object preparedObject, ResourceManager manager, Profiler applyProfiler) {
        applyProfiler.startTick();
        applyProfiler.push(reloader.getClass().getSimpleName() + "-apply");
        reloader.apply((ReloaderType) preparedObject, manager);
        applyProfiler.pop();
        applyProfiler.endTick();
    }
}
