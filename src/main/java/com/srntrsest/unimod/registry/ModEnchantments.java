package com.srntrsest.unimod.registry;

import com.srntrsest.unimod.enchantments.FrostEnchantment;
import com.srntrsest.unimod.enchantments.LavaWalkerEnchantment;
import com.srntrsest.unimod.helpers.RegistryHelper;
import net.minecraft.enchantment.Enchantment;

public class ModEnchantments {

    public static final Enchantment FROST = new FrostEnchantment();
    public static final Enchantment LAVA_WALKER = new LavaWalkerEnchantment();

    public static void registerEnchantments() {
        RegistryHelper.registerEnchantment(FROST, "frost");
        RegistryHelper.registerEnchantment(LAVA_WALKER, "lava_walker");
    }

}
