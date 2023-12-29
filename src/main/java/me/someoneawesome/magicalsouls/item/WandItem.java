package me.someoneawesome.magicalsouls.item;

import me.someoneawesome.magicalsouls.actions.SpellAction;
import me.someoneawesome.magicalsouls.stats.SpellStats;

public class WandItem extends AbstractCaster {

    public WandItem(String itemId, int baseInventorySize, SpellStats baseStats) {
        super(itemId, baseInventorySize, baseStats);
    }

    @Override
    public boolean canCastSpell(SpellAction spellAction) {
        return true;
    }
}
