package me.someoneawesome.magicalsouls;

import me.someoneawesome.magicalsouls.constants.KeyBindConstants;
import me.someoneawesome.magicalsouls.utils.ConstantUtils;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicalSoulsClient implements ClientModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("magical-souls-client");

	public MagicalSoulsClient() {
		LOGGER.info("Loading Magical Souls (Client)");

		KeyBindConstants.defineKeyBinds();

		LOGGER.info("Loaded Magical Souls (Client)");
	}

	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing Magical Souls (Client)");

		ConstantUtils.initializeGenericInitializable(KeyBindConstants.KEY_BINDS);

		LOGGER.info("Initialized Magical Souls (Client)");
	}
}