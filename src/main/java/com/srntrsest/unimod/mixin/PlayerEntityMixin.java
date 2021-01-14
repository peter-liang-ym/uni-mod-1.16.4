package com.srntrsest.unimod.mixin;

import com.srntrsest.unimod.registry.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method="tick")
    private void tick(CallbackInfo info) {
        if (world.isClient) {

            ItemStack helmetStack = getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chestplateStack = getEquippedStack(EquipmentSlot.CHEST);
            ItemStack leggingsStack = getEquippedStack(EquipmentSlot.LEGS);
            ItemStack bootsStack = getEquippedStack(EquipmentSlot.FEET);

            if (helmetStack.getItem().equals(ModItems.UNI_HELMET)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20));
                addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 20, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20, 100));
            }
            if (chestplateStack.getItem().equals(ModItems.UNI_CHESTPLATE)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20, 100));
            }
            if (leggingsStack.getItem().equals(ModItems.UNI_LEGGINGS)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 20, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20, 9));
                addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20, 100));
            }
            if (bootsStack.getItem().equals(ModItems.UNI_BOOTS)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 4));
                addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, 2));
                addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20, 4));
                addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 20));
            }
        }
    }

}
