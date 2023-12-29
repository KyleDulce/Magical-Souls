package me.someoneawesome.magicalsouls.utils;

import me.someoneawesome.magicalsouls.constants.MagicalSoulsConstants;

import static me.someoneawesome.magicalsouls.constants.KeyBindConstants.*;

public class ClientConstantUtils {
    public static String getKeyBindTranslationKey(String keybindId) {
        return KEYBIND_KEY_PREFIX + MagicalSoulsConstants.NAMESPACE + "." + keybindId;
    }

    public static String getKeyBindCategoryTranslationKey(String categoryId) {
        return KEYBIND_CATEGORY_PREFIX + MagicalSoulsConstants.NAMESPACE + "." + categoryId;
    }
}
