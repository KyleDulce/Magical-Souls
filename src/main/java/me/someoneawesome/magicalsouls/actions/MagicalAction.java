package me.someoneawesome.magicalsouls.actions;

import me.someoneawesome.magicalsouls.common.Initializable;
import me.someoneawesome.magicalsouls.stats.Stats;

public interface MagicalAction<T extends Stats> extends Initializable {
    void trigger(T stats);
}
