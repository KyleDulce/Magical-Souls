package me.someoneawesome.magicalsouls.item;

import me.someoneawesome.magicalsouls.common.Registry;
import net.minecraft.item.Item;

public class MagicalItemRegistry extends Registry<MagicalItem> {
    public MagicalItemRegistry() {
        super("Item");
    }

    public Item getItemById(String id) {
        return getById(id).getItem();
    }
}
