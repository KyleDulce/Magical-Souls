package me.someoneawesome.magicalsouls.constants;

import me.someoneawesome.magicalsouls.keybind.AbstractKeyBind;
import me.someoneawesome.magicalsouls.keybind.PacketedKeyBind;
import net.minecraft.client.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static me.someoneawesome.magicalsouls.constants.NetworkConstants.*;

public class KeyBindConstants {
    // Translation Keys
    public static final String KEYBIND_KEY_PREFIX = "key.";
    public static final String KEYBIND_CATEGORY_PREFIX = "category.";

    // Categories
    public static final String CATEGORY_MAIN = "magic-souls-category";

    // Keybinds
    public static final String KEYBINDING_SPELL_SELECT_LEFT = "spell-select-left";
    public static final String KEYBINDING_SPELL_SELECT_RIGHT = "spell-select-right";
    public static final String KEYBINDING_SPELL_OPEN = "spell-open";

    public static List<AbstractKeyBind> KEY_BINDS = new ArrayList<>();

    public static void defineKeyBinds() {
        KEY_BINDS.add(new PacketedKeyBind(GLFW_KEY_Z, InputUtil.Type.KEYSYM, KEYBINDING_SPELL_SELECT_LEFT, CATEGORY_MAIN, KEYBIND_SPELL_SELECT_LEFT_PACKET));
        KEY_BINDS.add(new PacketedKeyBind(GLFW_KEY_X, InputUtil.Type.KEYSYM, KEYBINDING_SPELL_SELECT_RIGHT, CATEGORY_MAIN, KEYBIND_SPELL_SELECT_RIGHT_PACKET));
        KEY_BINDS.add(new PacketedKeyBind(GLFW_KEY_G, InputUtil.Type.KEYSYM, KEYBINDING_SPELL_OPEN, CATEGORY_MAIN, KEYBIND_SPELL_INV_OPEN_PACKET));
    }
}
