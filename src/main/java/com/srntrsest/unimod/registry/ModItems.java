package com.srntrsest.unimod.registry;

import com.srntrsest.unimod.UniMod;
import com.srntrsest.unimod.tools.CustomAxeItem;
import com.srntrsest.unimod.tools.CustomHoeItem;
import com.srntrsest.unimod.tools.CustomPickaxeItem;
import com.srntrsest.unimod.tools.UniToolMaterial;
import com.srntrsest.unimod.armor.CustomArmorMaterial;
import com.srntrsest.unimod.helpers.RegistryHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class ModItems {

    // Items
    public static final Item UNI_DUST = new Item(new FabricItemSettings().group(UniMod.UNI_ITEM_GROUP).fireproof());

    // Food
    public static final Item CHOCOLATE = newFoodItem(1, true);
    public static final Item CANDY_CANE = newFoodItem(1, true);
    public static final Item CANDY_CORN = newFoodItem(1, true);
    public static final Item CARAMEL = newFoodItem(1, true);
    public static final Item KIT_KAT = newFoodItem(1, true);
    public static final Item LOLLIPOP = newFoodItem(1, true);
    public static final Item M_AND_M = newFoodItem(1, true);
    public static final Item SWEDISH_FISH = newFoodItem(1, true);
    public static final Item SOUR_PATCH_KIDS = newFoodItem(1, true);
    public static final Item TWIX = newFoodItem(1, true);
    public static final Item WHOPPERS = newFoodItem(1, true);

    // Armor
    public static final ArmorMaterial uniArmorMaterial = new CustomArmorMaterial();

    public static final Item UNI_HELMET = new ArmorItem(uniArmorMaterial, EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());
    public static final Item UNI_CHESTPLATE = new ArmorItem(uniArmorMaterial, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());
    public static final Item UNI_LEGGINGS = new ArmorItem(uniArmorMaterial, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());
    public static final Item UNI_BOOTS = new ArmorItem(uniArmorMaterial, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());

    // Tools
    public static final ToolItem UNI_SWORD = new SwordItem(UniToolMaterial.INSTANCE, 100, 100f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());
    public static final ToolItem UNI_SHOVEL = new ShovelItem(UniToolMaterial.INSTANCE, 6, 100f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());
    public static final ToolItem UNI_PICKAXE = new CustomPickaxeItem(UniToolMaterial.INSTANCE, 6, 100f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());
    public static final ToolItem UNI_AXE = new CustomAxeItem(UniToolMaterial.INSTANCE, 120f, 60f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());
    public static final ToolItem UNI_HOE = new CustomHoeItem(UniToolMaterial.INSTANCE, 6, 100f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof());

    public static void registerItems() {

        // Items
        RegistryHelper.registerItem(UNI_DUST, "uni_dust");

        // Food
        RegistryHelper.registerItem(CHOCOLATE, "chocolate");
        RegistryHelper.registerItem(CANDY_CANE, "candy_cane");
        RegistryHelper.registerItem(CANDY_CORN, "candy_corn");
        RegistryHelper.registerItem(CARAMEL, "caramel");
        RegistryHelper.registerItem(KIT_KAT, "kit_kat");
        RegistryHelper.registerItem(LOLLIPOP, "lollipop");
        RegistryHelper.registerItem(M_AND_M, "m_and_m");
        RegistryHelper.registerItem(SWEDISH_FISH, "swedish_fish");
        RegistryHelper.registerItem(SOUR_PATCH_KIDS, "sour_patch_kid_candy");
        RegistryHelper.registerItem(TWIX, "twix");
        RegistryHelper.registerItem(WHOPPERS, "whoppers");

        // Armor
        RegistryHelper.registerItem(UNI_HELMET, "uni_helmet");
        RegistryHelper.registerItem(UNI_CHESTPLATE, "uni_chestplate");
        RegistryHelper.registerItem(UNI_LEGGINGS, "uni_leggings");
        RegistryHelper.registerItem(UNI_BOOTS, "uni_boots");

        // Tools
        RegistryHelper.registerItem(UNI_SWORD, "uni_sword");
        RegistryHelper.registerItem(UNI_SHOVEL, "uni_shovel");
        RegistryHelper.registerItem(UNI_PICKAXE, "uni_pickaxe");
        RegistryHelper.registerItem(UNI_AXE, "uni_axe");
        RegistryHelper.registerItem(UNI_HOE, "uni_hoe");

        // Block Items

    }

    private static FoodComponent newFoodComponent(int hunger, boolean alwaysEdible) {
        FoodComponent.Builder builder = new FoodComponent.Builder().hunger(hunger);
        if (alwaysEdible) {
            builder = builder.alwaysEdible();
        }
        return builder.build();
    }

    private static Item newFoodItem(int hunger, boolean alwaysEdible) {
        return new Item(new FabricItemSettings().group(ItemGroup.FOOD).fireproof().food(newFoodComponent(hunger, alwaysEdible)));
    }

}
