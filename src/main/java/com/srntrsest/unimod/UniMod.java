package com.srntrsest.unimod;

import com.srntrsest.unimod.helpers.IdentifierHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class UniMod implements ModInitializer {

    public static final String MOD_ID = "unimod";

    public static final ItemGroup UNI_ITEM_GROUP = FabricItemGroupBuilder
            .create(IdentifierHelper.createId("general"))
            .icon(() -> new ItemStack(Items.POTATO))
            .appendItems(stacks -> {

            })
            .build();

    @Override
    public void onInitialize() {

    }

}
