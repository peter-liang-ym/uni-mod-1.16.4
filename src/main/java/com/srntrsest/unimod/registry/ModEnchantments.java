package com.srntrsest.unimod.registry;

import com.srntrsest.unimod.enchantments.FrostEnchantment;
import com.srntrsest.unimod.helpers.RegistryHelper;
import net.minecraft.enchantment.Enchantment;

public class ModEnchantments {

    public static final Enchantment FROST = new FrostEnchantment();

    public static void registerEnchantments() {
        RegistryHelper.registerEnchantment(FROST, "frost");
    }

}
