package com.srntrsest.unimod.armor;

import com.srntrsest.unimod.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CustomArmorMaterial implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {1000, 1000, 1000, 1000};
    private static final int[] PROTECTION_VALUES = new int[] {1000, 1000, 1000, 1000};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 1;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 1000;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.UNI_DUST);
    }

    @Override
    public String getName() {
        return "uni_armor";
    }

    @Override
    public float getToughness() {
        return 1000.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.9f;
    }
}
