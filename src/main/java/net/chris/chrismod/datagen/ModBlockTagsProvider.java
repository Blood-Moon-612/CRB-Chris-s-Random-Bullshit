package net.chris.chrismod.datagen;

import net.chris.chrismod.block.ModBlocks;
import net.chris.chrismod.item.ModToolMaterial;
import net.chris.chrismod.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.FLUORITE_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.FLUORITE_ORE)
                .add(ModBlocks.RAW_FLUORITE_BLOCK)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_FLUORITE_ORE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.GAMBLING_BLOCK)
                .add(ModBlocks.RUBY_SLAB)
                .add(ModBlocks.RUBY_STAIRS)
                .add(ModBlocks.FLUORITE_SLAB)
                .add(ModBlocks.FLUORITE_STAIRS)
                .add(ModBlocks.SAPPHIRE_STAIRS)
                .add(ModBlocks.SAPPHIRE_SLAB)
                .add(ModBlocks.RUBY_BUTTON)
                .add(ModBlocks.RUBY_PRESSURE_PLATE)
                .add(ModBlocks.FLUORITE_BUTTON)
                .add(ModBlocks.FLUORITE_PRESSURE_PLATE)
                .add(ModBlocks.SAPPHIRE_BUTTON)
                .add(ModBlocks.SAPPHIRE_PRESSURE_PLATE)
                .add(ModBlocks.RUBY_FENCE)
                .add(ModBlocks.RUBY_FENCE_GATE)
                .add(ModBlocks.RUBY_WALL)
                .add(ModBlocks.FLUORITE_FENCE)
                .add(ModBlocks.FLUORITE_FENCE_GATE)
                .add(ModBlocks.FLUORITE_WALL)
                .add(ModBlocks.SAPPHIRE_FENCE)
                .add(ModBlocks.SAPPHIRE_FENCE_GATE)
                .add(ModBlocks.SAPPHIRE_WALL)
                .add(ModBlocks.RUBY_DOOR)
                .add(ModBlocks.RUBY_TRAPDOOR)
                .add(ModBlocks.FLUORITE_DOOR)
                .add(ModBlocks.FLUORITE_TRAPDOOR)
                .add(ModBlocks.SAPPHIRE_DOOR)
                .add(ModBlocks.SAPPHIRE_TRAPDOOR);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.FLUORITE_BLOCK)
                .add(ModBlocks.FLUORITE_ORE)
                .add(ModBlocks.DEEPSLATE_FLUORITE_ORE)
                .add(ModBlocks.RAW_FLUORITE_BLOCK)
                .add(ModBlocks.RUBY_SLAB)
                .add(ModBlocks.RUBY_STAIRS)
                .add(ModBlocks.FLUORITE_SLAB)
                .add(ModBlocks.FLUORITE_STAIRS)
                .add(ModBlocks.RUBY_BUTTON)
                .add(ModBlocks.RUBY_PRESSURE_PLATE)
                .add(ModBlocks.FLUORITE_BUTTON)
                .add(ModBlocks.FLUORITE_PRESSURE_PLATE)
                .add(ModBlocks.RUBY_FENCE)
                .add(ModBlocks.RUBY_FENCE_GATE)
                .add(ModBlocks.RUBY_WALL)
                .add(ModBlocks.FLUORITE_FENCE)
                .add(ModBlocks.FLUORITE_FENCE_GATE)
                .add(ModBlocks.FLUORITE_WALL)
                .add(ModBlocks.RUBY_DOOR)
                .add(ModBlocks.RUBY_TRAPDOOR)
                .add(ModBlocks.FLUORITE_TRAPDOOR)
                .add(ModBlocks.FLUORITE_DOOR);


        valueLookupBuilder(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_STAIRS)
                .add(ModBlocks.SAPPHIRE_SLAB)
                .add(ModBlocks.SAPPHIRE_BUTTON)
                .add(ModBlocks.SAPPHIRE_PRESSURE_PLATE)
                .add(ModBlocks.SAPPHIRE_FENCE)
                .add(ModBlocks.SAPPHIRE_FENCE_GATE)
                .add(ModBlocks.SAPPHIRE_WALL)
                .add(ModBlocks.SAPPHIRE_TRAPDOOR)
                .add(ModBlocks.SAPPHIRE_DOOR);


        valueLookupBuilder(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.OBSIDIAN)
                .add(Blocks.CRYING_OBSIDIAN)
                .add(Blocks.NETHERITE_BLOCK)
                .add(Blocks.RESPAWN_ANCHOR)
                .add(Blocks.ANCIENT_DEBRIS);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(ModTags.Blocks.NEEDS_RUBY_TOOL);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                .addTag(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_SAPPHIRE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        valueLookupBuilder(BlockTags.STAIRS).add(ModBlocks.RUBY_STAIRS).add(ModBlocks.SAPPHIRE_STAIRS).add(ModBlocks.FLUORITE_STAIRS);
        valueLookupBuilder(BlockTags.SLABS).add(ModBlocks.RUBY_SLAB).add(ModBlocks.SAPPHIRE_SLAB).add(ModBlocks.FLUORITE_SLAB);
        valueLookupBuilder(BlockTags.BUTTONS).add(ModBlocks.RUBY_BUTTON).add(ModBlocks.SAPPHIRE_BUTTON).add(ModBlocks.FLUORITE_BUTTON);
        valueLookupBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.RUBY_PRESSURE_PLATE).add(ModBlocks.SAPPHIRE_PRESSURE_PLATE).add(ModBlocks.FLUORITE_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE).add(ModBlocks.SAPPHIRE_FENCE).add(ModBlocks.FLUORITE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE).add(ModBlocks.SAPPHIRE_FENCE_GATE).add(ModBlocks.FLUORITE_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_WALL).add(ModBlocks.SAPPHIRE_WALL).add(ModBlocks.FLUORITE_WALL);

        valueLookupBuilder(BlockTags.DOORS).add(ModBlocks.RUBY_DOOR).add(ModBlocks.FLUORITE_DOOR).add(ModBlocks.SAPPHIRE_DOOR);
        valueLookupBuilder(BlockTags.TRAPDOORS).add(ModBlocks.RUBY_TRAPDOOR).add(ModBlocks.SAPPHIRE_TRAPDOOR).add(ModBlocks.FLUORITE_TRAPDOOR);

    }
}
