package me.someoneawesome.magicalsouls.constants;

import me.someoneawesome.magicalsouls.item.MagicalItemRegistry;
import me.someoneawesome.magicalsouls.item.SpellItem;
import me.someoneawesome.magicalsouls.item.WandItem;
import me.someoneawesome.magicalsouls.stats.SpellStats;
import me.someoneawesome.magicalsouls.utils.McUtils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MagicalItemConstants {

    // ITEM GROUPS
    public static final String ITEM_GROUP_SPELL_ID = "spell_group";
    public static final String ITEM_GROUP_CASTER_ID = "caster_group";

    public static final String ITEM_GROUP_TRANSLATION_KEY_PREFIX = "itemGroup." + MagicalSoulsConstants.NAMESPACE + ".";
    public static final HashMap<String, ItemGroup> ITEM_GROUPS = new HashMap<>();
    public static void addItemGroupDefinitions(MagicalItemRegistry registry) {
        ITEM_GROUPS.put(ITEM_GROUP_SPELL_ID, FabricItemGroup.builder()
                        .icon(() -> new ItemStack(registry.getItemById(SPELL_FIRE_ID)))
                        .displayName(Text.translatable(ITEM_GROUP_TRANSLATION_KEY_PREFIX + ITEM_GROUP_SPELL_ID))
                        .entries((context, entries) -> {
                            entries.add(registry.getItemById(SPELL_FIRE_ID));
                        })
                .build());
        ITEM_GROUPS.put(ITEM_GROUP_CASTER_ID, FabricItemGroup.builder()
                        .icon(() -> new ItemStack(registry.getItemById(WAND_BASIC_ID)))
                        .displayName(Text.translatable(ITEM_GROUP_TRANSLATION_KEY_PREFIX + ITEM_GROUP_CASTER_ID))
                        .entries((context, entries) -> {
                            entries.add(registry.getItemById(WAND_BASIC_ID));
                        })
                .build());
    }

    // ITEM NAMES
    public static final String ITEM_TRANSLATION_KEY_PREFIX = "item.magical-souls.";
    public static final String ITEM_TRANSLATION_KEY_TOOLTIP_POSTFIX = ".tooltip";

    // Spells
    public static final String SPELL_FIRE_ID = "spell_fire_item";

    // Wands
    public static final String WAND_BASIC_ID = "wand_basic_item";

    // Item Registry
    public static void addAllItemsToRegistry(MagicalItemRegistry registry) {
        // Spells
        registry.register(SPELL_FIRE_ID, new SpellItem(SPELL_FIRE_ID, Collections.singletonList(MagicalActionConstants.SPELL_ACTION_FIRE)));

        // Wands
        registry.register(WAND_BASIC_ID, new WandItem(WAND_BASIC_ID, 9, new SpellStats()));
    }
}
