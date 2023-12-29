package me.someoneawesome.magicalsouls;

import me.someoneawesome.magicalsouls.constants.MagicalInventoryConstants;
import me.someoneawesome.magicalsouls.constants.MagicalItemConstants;
import me.someoneawesome.magicalsouls.inventory.SpellInventoryScreenHandler;
import me.someoneawesome.magicalsouls.item.MagicalItemRegistry;
import me.someoneawesome.magicalsouls.utils.ConstantUtils;
import me.someoneawesome.magicalsouls.utils.McUtils;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicalSouls implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("magical-souls");
	public final MagicalItemRegistry magicalItemRegistry;

	public MagicalSouls() {
		LOGGER.info("Loading Magical Souls (Main)");

		magicalItemRegistry = new MagicalItemRegistry();

		LOGGER.debug("Registering Items");
		MagicalItemConstants.addAllItemsToRegistry(magicalItemRegistry);
		MagicalItemConstants.addItemGroupDefinitions(magicalItemRegistry);

		LOGGER.info("Loaded Magical Souls (Main)");
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Magical Souls (Main)");

		magicalItemRegistry.initializeAll();
		ConstantUtils.initializeGroupDefinitions();

		LOGGER.info("Initialized Magical Souls (Main)");
	}
}