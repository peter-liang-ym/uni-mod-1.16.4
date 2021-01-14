package com.srntrsest.unimod.helpers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.InvocationTargetException;

public class RegistryHelper {

    public static void registerItem(Item item, String name) {
        Registry.register(Registry.ITEM, IdentifierHelper.createId(name), item);
    }

    public static void registerBlock(Block block, String name) {
        Registry.register(Registry.BLOCK, IdentifierHelper.createId(name), block);
        Registry.register(Registry.ITEM, IdentifierHelper.createId(name), new BlockItem(block, new FabricItemSettings().fireproof()));
    }

    public static void registerBlock(Block block, String name, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, IdentifierHelper.createId(name), block);
        Registry.register(Registry.ITEM, IdentifierHelper.createId(name), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
    }


    public static void registerEnchantment(Enchantment enchantment, String name) {
        Registry.register(Registry.ENCHANTMENT, IdentifierHelper.createId(name), enchantment);
    }

}
