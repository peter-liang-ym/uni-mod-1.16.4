package com.srntrsest.unimod.mixin;

import com.srntrsest.unimod.registry.ModItems;
import net.minecraft.enchantment.FrostWalkerEnchantment;
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
        if (!world.isClient) {

            ItemStack helmetStack = getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chestplateStack = getEquippedStack(EquipmentSlot.CHEST);
            ItemStack leggingsStack = getEquippedStack(EquipmentSlot.LEGS);
            ItemStack bootsStack = getEquippedStack(EquipmentSlot.FEET);

            int duration = 20;

            if (helmetStack.getItem().equals(ModItems.UNI_HELMET)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, duration, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, duration));
                addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, duration, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, duration, 100));
            }
            if (chestplateStack.getItem().equals(ModItems.UNI_CHESTPLATE)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, duration, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, duration, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, duration, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, duration, 100));
            }
            if (leggingsStack.getItem().equals(ModItems.UNI_LEGGINGS)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, duration, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, duration, 100));
                addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, duration, 9));
                addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, duration, 100));
            }
            if (bootsStack.getItem().equals(ModItems.UNI_BOOTS)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, duration, 4));
                addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, duration, 1));
                addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, duration, 4));
                addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, duration));
            }
        }
    }

}
