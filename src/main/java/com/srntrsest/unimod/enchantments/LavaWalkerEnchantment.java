package com.srntrsest.unimod.enchantments;

import java.util.Iterator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.World;

public class LavaWalkerEnchantment extends Enchantment {
    public LavaWalkerEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
    }

    @Override
    public int getMinPower(int level) {
        return level * 10;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    public static void freezeLava(LivingEntity entity, World world, BlockPos blockPos, int level) {
        if (entity.isOnGround()) {
            BlockState blockState = Blocks.OBSIDIAN.getDefaultState();
            float f = (float) Math.min(16, 2 + level);
            Mutable mutable = new Mutable();
            Iterator var7 = BlockPos.iterate(blockPos.add((double)(-f), -1.0D, (double)(-f)), blockPos.add((double)f, -1.0D, (double)f)).iterator();

            while(var7.hasNext()) {
                BlockPos blockPos2 = (BlockPos)var7.next();
                if (blockPos2.isWithinDistance(entity.getPos(), (double)f)) {
                    mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
                    BlockState blockState2 = world.getBlockState(mutable);
                    if (blockState2.isAir()) {
                        BlockState blockState3 = world.getBlockState(blockPos2);
                        if (blockState3.getMaterial() == Material.LAVA && (Integer)blockState3.get(FluidBlock.LEVEL) == 0 && blockState.canPlaceAt(world, blockPos2) && world.canPlace(blockState, blockPos2, ShapeContext.absent())) {
                            world.setBlockState(blockPos2, blockState);
                            world.getBlockTickScheduler().schedule(blockPos2, Blocks.OBSIDIAN, MathHelper.nextInt(entity.getRandom(), 60, 120));
                        }
                    }
                }
            }

        }
    }

}
