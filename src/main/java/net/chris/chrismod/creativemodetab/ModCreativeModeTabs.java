package net.chris.chrismod.creativemodetab;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.chris.chrismod.block.ModBlocks;
import net.chris.chrismod.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab RANDOM_BULLSHIT_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "random_bullshit_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLUORITE))
                    .title(Component.translatable("creativemodetab.chrismod.random_bullshit_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RUBY);
                        output.accept(ModItems.SAPPHIRE);
                        output.accept(ModItems.RAW_SAPPHIRE);
                        output.accept(ModItems.FLUORITE);
                        output.accept(ModItems.RAW_FLUORITE);
                        output.accept(ModItems.COPPER_DUST);
                        output.accept(ModItems.COPPER_PLATE);
                        output.accept(ModItems.IRON_DUST);
                        output.accept(ModItems.IRON_PLATE);
                        output.accept(ModItems.GOLD_DUST);
                        output.accept(ModItems.GOLD_PLATE);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.STEEL_PLATE);
                        output.accept(ModItems.STEEL_DUST);
                        output.accept(ModItems.CAST_IRON);

                        output.accept(ModItems.CHISEL);

                        output.accept(ModItems.MORTAR);
                        output.accept(ModItems.IRON_MORTAR);
                        output.accept(ModItems.RUBY_MORTAR);

                        output.accept(ModItems.STONE_HAMMER);
                        output.accept(ModItems.IRON_HAMMER);
                        output.accept(ModItems.RUBY_HAMMER);

                        output.accept(ModItems.STRAWBERRY);
                        output.accept(ModItems.BEER);

                        output.accept(ModItems.LIGNITE);


                    }).build());
    public static final CreativeModeTab RANDOM_BULLSHIT_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "random_bullshit_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FLUORITE_BLOCK))
                    .title(Component.translatable("creativemodetab.chrismod.random_bullshit_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.RUBY_BLOCK);
                        output.accept(ModBlocks.SAPPHIRE_BLOCK);
                        output.accept(ModBlocks.FLUORITE_BLOCK);
                        output.accept(ModBlocks.RAW_SAPPHIRE_BLOCK);
                        output.accept(ModBlocks.RAW_FLUORITE_BLOCK);

                        output.accept(ModBlocks.RUBY_ORE);
                        output.accept(ModBlocks.SAPPHIRE_ORE);
                        output.accept(ModBlocks.FLUORITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_FLUORITE_ORE);

                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.GAMBLING_BLOCK);
                        output.accept(ModBlocks.COMPRESSED_LEAVES);

                        output.accept(ModBlocks.RUBY_STAIRS);
                        output.accept(ModBlocks.RUBY_SLAB);
                        output.accept(ModBlocks.FLUORITE_STAIRS);
                        output.accept(ModBlocks.FLUORITE_SLAB);
                        output.accept(ModBlocks.SAPPHIRE_STAIRS);
                        output.accept(ModBlocks.SAPPHIRE_SLAB);
                        output.accept(ModBlocks.RUBY_BUTTON);
                        output.accept(ModBlocks.RUBY_PRESSURE_PLATE);
                        output.accept(ModBlocks.FLUORITE_BUTTON);
                        output.accept(ModBlocks.FLUORITE_PRESSURE_PLATE);
                        output.accept(ModBlocks.SAPPHIRE_BUTTON);
                        output.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
                        output.accept(ModBlocks.RUBY_FENCE);
                        output.accept(ModBlocks.RUBY_FENCE_GATE);
                        output.accept(ModBlocks.RUBY_WALL);
                        output.accept(ModBlocks.FLUORITE_FENCE);
                        output.accept(ModBlocks.FLUORITE_FENCE_GATE);
                        output.accept(ModBlocks.FLUORITE_WALL);
                        output.accept(ModBlocks.SAPPHIRE_FENCE);
                        output.accept(ModBlocks.SAPPHIRE_FENCE_GATE);
                        output.accept(ModBlocks.SAPPHIRE_WALL);
                        output.accept(ModBlocks.RUBY_DOOR);
                        output.accept(ModBlocks.RUBY_TRAPDOOR);
                        output.accept(ModBlocks.FLUORITE_DOOR);
                        output.accept(ModBlocks.FLUORITE_TRAPDOOR);
                        output.accept(ModBlocks.SAPPHIRE_DOOR);
                        output.accept(ModBlocks.SAPPHIRE_TRAPDOOR);


                    }).build());

    public static final CreativeModeTab SILLY_ITEMS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "silly_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILLY))
                    .title(Component.translatable("creativemodetab.chrismod.silly_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SILLY);
                        output.accept(ModBlocks.GAMBLING_BLOCK);
                        output.accept(ModItems.YOUR_DID_IT);

                    }).build());


    public static void registerModCreativeModeTabs() {
        ChrisSRandomBullshit.LOGGER.info("Registering Creative Mode Tabs for " + ChrisSRandomBullshit.MOD_ID);
    }
}
