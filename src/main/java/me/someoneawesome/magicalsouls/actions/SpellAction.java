package me.someoneawesome.magicalsouls.actions;

import me.someoneawesome.magicalsouls.stats.SpellStats;

public abstract class SpellAction implements MagicalAction<SpellStats> {

    private final byte minReqLevel;

    public SpellAction(byte minReqLevel) {
        this.minReqLevel = minReqLevel;
    }

    public byte getMinReqLevel() {
        return minReqLevel;
    }
}
