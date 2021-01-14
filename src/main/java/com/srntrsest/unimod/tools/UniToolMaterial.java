package com.srntrsest.unimod.tools;

import com.srntrsest.unimod.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class UniToolMaterial implements ToolMaterial {

    public static final UniToolMaterial INSTANCE = new UniToolMaterial();

    @Override
    public int getDurability() {
        return 999999;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 250f;
    }

    @Override
    public float getAttackDamage() {
        return 0f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 999999;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.UNI_DUST);
    }

}
