package me.someoneawesome.magicalsouls.resource;

import net.minecraft.resource.ResourceManager;

public interface ResourceReloadListener<T> {
    T prepare(ResourceManager manager);
    void apply(T preparedObject, ResourceManager manager);
}
