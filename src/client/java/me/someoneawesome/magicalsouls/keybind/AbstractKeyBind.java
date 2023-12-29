package me.someoneawesome.magicalsouls.keybind;

import me.someoneawesome.magicalsouls.common.Initializable;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractKeyBind implements Initializable {
    public static final Logger LOGGER = LoggerFactory.getLogger("magical-souls-client");

    private final int keyCode;
    private final InputUtil.Type keyType;
    private final String keybindName;
    private final String keybindCategory;
    private KeyBinding keyBinding;

    private boolean wasPreviouslyPressed = false;

    public AbstractKeyBind(int keyCode, InputUtil.Type keyType, String keyBindId, String categoryId) {
        this.keyCode = keyCode;
        this.keyType = keyType;
        this.keybindName = keyBindId;
        this.keybindCategory = categoryId;
    }

    @Override
    public void initialize() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                keybindName,
                keyType,
                keyCode,
                keybindCategory
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(keyBinding.isPressed()) {
                whilePressed();
                if(!wasPreviouslyPressed) {
                    wasPreviouslyPressed = true;
                    LOGGER.info("pressed once");
                    onPressOnce();
                }
            } else {
                wasPreviouslyPressed = false;
            }
        });
    }

    protected void onPressOnce() {};

    protected void whilePressed() {};
}
