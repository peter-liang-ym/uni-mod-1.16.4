package com.srntrsest.unimod;

import com.srntrsest.unimod.fluids.CaramelFluid;
import com.srntrsest.unimod.helpers.IdentifierHelper;
import com.srntrsest.unimod.helpers.RegistryHelper;
import com.srntrsest.unimod.registry.ModBlocks;
import com.srntrsest.unimod.registry.ModEnchantments;
import com.srntrsest.unimod.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.biome.modification.BiomeSelectionContextImpl;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class UniMod implements ModInitializer {

    public static final String MOD_ID = "unimod";

    public static final ItemGroup UNI_ITEM_GROUP = FabricItemGroupBuilder
            .create(IdentifierHelper.createId("general"))
            .icon(() -> new ItemStack(ModItems.UNI_DUST))
            .appendItems(stacks -> {

            })
            .build();

    public static FlowableFluid STILL_CARAMEL;
    public static FlowableFluid FLOWING_CARAMEL;
    public static Block CARAMEL;
    public static Item CARAMEL_BUCKET;
    public static LakeFeature CARAMEL_LAKE;

    // Uni Ore Generation
    private static ConfiguredFeature<?, ?> UNI_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            ModBlocks.UNI_ORE.getDefaultState(),
            9
    )).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
            0, 0, 64
    ))).spreadHorizontally().repeat(20);


    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModEnchantments.registerEnchantments();

        RegistryKey<ConfiguredFeature<?, ?>> uniOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, IdentifierHelper.createId("uni_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, uniOreOverworld.getValue(), UNI_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, uniOreOverworld);

        STILL_CARAMEL = Registry.register(Registry.FLUID, IdentifierHelper.createId("still_caramel"), new CaramelFluid.Still());
        FLOWING_CARAMEL = Registry.register(Registry.FLUID, IdentifierHelper.createId("flowing_caramel"), new CaramelFluid.Flowing());
        CARAMEL_BUCKET = Registry.register(Registry.ITEM, IdentifierHelper.createId("caramel_bucket"), new BucketItem(STILL_CARAMEL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
        CARAMEL = Registry.register(Registry.BLOCK, IdentifierHelper.createId("still_caramel"), new FluidBlock(STILL_CARAMEL, FabricBlockSettings.copy(Blocks.WATER)){});
//        CARAMEL_LAKE = Registry.register(Registry.FEATURE, IdentifierHelper.createId("caramel_lake"), new LakeFeature(SingleStateFeatureConfig::deserialize));
    }

}
