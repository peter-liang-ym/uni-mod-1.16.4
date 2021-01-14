package com.srntrsest.unimod;

import com.srntrsest.unimod.helpers.IdentifierHelper;
import com.srntrsest.unimod.registry.ModBlocks;
import com.srntrsest.unimod.registry.ModEnchantments;
import com.srntrsest.unimod.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class UniMod implements ModInitializer {

    public static final String MOD_ID = "unimod";

    public static final ItemGroup UNI_ITEM_GROUP = FabricItemGroupBuilder
            .create(IdentifierHelper.createId("general"))
            .icon(() -> new ItemStack(ModItems.UNI_DUST))
            .appendItems(stacks -> {

            })
            .build();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModEnchantments.registerEnchantments();
    }

}
