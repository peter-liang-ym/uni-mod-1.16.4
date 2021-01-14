package com.srntrsest.unimod.registry;

import com.srntrsest.unimod.helpers.RegistryHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;

public class ModBlocks {

    // Blocks
    public static final Block UNI_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.5f).breakByTool(FabricToolTags.PICKAXES));

    public static void registerBlocks() {

        // Blocks
        RegistryHelper.registerBlock(UNI_ORE, "uni_ore", ItemGroup.MISC);
    }
}
