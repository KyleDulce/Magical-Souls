package me.someoneawesome.magicalsouls.item;

import java.util.List;

public class SpellItem extends GenericMagicalItem {

    private final List<String> spellIds;
    public SpellItem(String itemId, List<String> spellIds) {
        super(itemId, new Settings().maxCount(1).fireproof());
        this.spellIds = spellIds;
    }

    public List<String> getSpellIds() {
        return spellIds;
    }
}
