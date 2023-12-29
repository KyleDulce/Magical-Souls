package me.someoneawesome.magicalsouls.utils;

import me.someoneawesome.magicalsouls.common.Initializable;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.Collection;
import java.util.Map;

import static me.someoneawesome.magicalsouls.constants.MagicalItemConstants.*;

public class ConstantUtils {
    public static void initializeGroupDefinitions() {
        for(Map.Entry<String, ItemGroup> group : ITEM_GROUPS.entrySet()) {
            Registry.register(Registries.ITEM_GROUP, McUtils.createId(group.getKey()), group.getValue());
        }
    }

    public static void initializeGenericInitializable(Collection<? extends Initializable> initializable) {
        for(Initializable item : initializable) {
            item.initialize();
        }
    }

    public static String getToolTipTranslationKey(String itemId) {
        return ITEM_TRANSLATION_KEY_PREFIX + itemId + ITEM_TRANSLATION_KEY_TOOLTIP_POSTFIX;
    }
}
