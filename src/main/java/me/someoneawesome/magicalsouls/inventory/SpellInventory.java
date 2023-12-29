package me.someoneawesome.magicalsouls.inventory;

import me.someoneawesome.magicalsouls.item.SpellItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public final class SpellInventory implements Inventory {

    private final DefaultedList<ItemStack> items;

    public static SpellInventory of(int size) {
        return of(DefaultedList.ofSize(size, ItemStack.EMPTY));
    }

    public static SpellInventory of(DefaultedList<ItemStack> items) {
        return new SpellInventory(items);
    }

    private SpellInventory(DefaultedList<ItemStack> items) {
        this.items = items;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack item : items) {
            if(!item.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        if(slot < 0 || slot >= size()) {
            return ItemStack.EMPTY;
        }
        return items.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack stack = getStack(slot);
        if(stack.isEmpty() || stack.getCount() <= amount) {
            return stack;
        }

        ItemStack newStack = stack.copy();
        newStack.setCount(amount);

        stack.setCount(stack.getCount() - amount);
        setStack(slot, stack);

        return newStack;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack stack = getStack(slot);
        setStack(slot, ItemStack.EMPTY);

        return stack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        items.set(slot, stack);
    }

    @Override
    public void markDirty() {
        // No behavior
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return stack.getItem() instanceof SpellItem;
    }

    @Override
    public void clear() {
        items.clear();
    }
}
