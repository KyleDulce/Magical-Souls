package me.someoneawesome.magicalsouls.actions;

import me.someoneawesome.magicalsouls.common.Registry;
import me.someoneawesome.magicalsouls.exceptions.MagicalSoulsException;

public class MagicalActionRegistry extends Registry<MagicalAction<?>> {
    public MagicalActionRegistry() {
        super("Magical Action");
    }

    public SpellAction getAsSpellAction(String id) {
        MagicalAction<?> action = getById(id);

        if(!(action instanceof SpellAction)) {
            throw new MagicalSoulsException("MagicalAction of type 'SpellAction' expected. Try re downloading the mod.");
        }

        return (SpellAction) action;
    }
}
