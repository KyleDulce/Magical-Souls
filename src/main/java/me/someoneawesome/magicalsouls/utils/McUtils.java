package me.someoneawesome.magicalsouls.utils;

import me.someoneawesome.magicalsouls.constants.MagicalItemConstants;
import me.someoneawesome.magicalsouls.constants.MagicalSoulsConstants;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Map;

public class McUtils {
    public static Identifier createId(String id) {
        return new Identifier(MagicalSoulsConstants.NAMESPACE, id);
    }
}
