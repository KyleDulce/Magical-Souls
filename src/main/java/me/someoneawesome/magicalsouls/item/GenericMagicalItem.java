package me.someoneawesome.magicalsouls.item;

import me.someoneawesome.magicalsouls.utils.ConstantUtils;
import me.someoneawesome.magicalsouls.utils.McUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GenericMagicalItem extends Item implements MagicalItem {

    protected final String ITEM_ID;

    public GenericMagicalItem(String itemId, Settings settings) {
        super(settings);
        ITEM_ID = itemId;
    }

    @Override
    public void initialize() {
        Registry.register(Registries.ITEM, McUtils.createId(ITEM_ID), this);
    }

    @Override
    public Item getItem() {
        return this;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(ConstantUtils.getToolTipTranslationKey(ITEM_ID)));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
