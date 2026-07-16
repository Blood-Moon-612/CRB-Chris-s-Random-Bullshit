package net.chris.chrismod.datagen;

import net.chris.chrismod.block.ModBlocks;
import net.chris.chrismod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK);
        dropSelf(ModBlocks.SAPPHIRE_BLOCK);
        dropSelf(ModBlocks.FLUORITE_BLOCK);
        dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK);
        dropSelf(ModBlocks.RAW_FLUORITE_BLOCK);

        dropSelf(ModBlocks.MAGIC_BLOCK);
        dropSelf(ModBlocks.GAMBLING_BLOCK);
        dropSelf(ModBlocks.COMPRESSED_LEAVES);

        dropSelf(ModBlocks.RUBY_STAIRS);
        add(ModBlocks.RUBY_SLAB, this::createSlabItemTable);
        dropSelf(ModBlocks.SAPPHIRE_STAIRS);
        add(ModBlocks.SAPPHIRE_SLAB, this::createSlabItemTable);
        dropSelf(ModBlocks.FLUORITE_STAIRS);
        add(ModBlocks.FLUORITE_SLAB, this::createSlabItemTable);

        dropSelf(ModBlocks.RUBY_BUTTON);
        dropSelf(ModBlocks.RUBY_PRESSURE_PLATE);
        dropSelf(ModBlocks.FLUORITE_BUTTON);
        dropSelf(ModBlocks.FLUORITE_PRESSURE_PLATE);
        dropSelf(ModBlocks.SAPPHIRE_BUTTON);
        dropSelf(ModBlocks.SAPPHIRE_PRESSURE_PLATE);

        dropSelf(ModBlocks.RUBY_FENCE);
        dropSelf(ModBlocks.RUBY_FENCE_GATE);
        dropSelf(ModBlocks.RUBY_WALL);
        dropSelf(ModBlocks.FLUORITE_FENCE);
        dropSelf(ModBlocks.FLUORITE_FENCE_GATE);
        dropSelf(ModBlocks.FLUORITE_WALL);
        dropSelf(ModBlocks.SAPPHIRE_FENCE);
        dropSelf(ModBlocks.SAPPHIRE_FENCE_GATE);
        dropSelf(ModBlocks.SAPPHIRE_WALL);

        dropSelf(ModBlocks.RUBY_TRAPDOOR);
        dropSelf(ModBlocks.FLUORITE_TRAPDOOR);
        dropSelf(ModBlocks.SAPPHIRE_TRAPDOOR);
        add(ModBlocks.RUBY_DOOR, this::createDoorTable);
        add(ModBlocks.FLUORITE_DOOR, this::createDoorTable);
        add(ModBlocks.SAPPHIRE_DOOR, this::createDoorTable);



        add(ModBlocks.RUBY_ORE, createMultipleOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY, 1, 3));
        add(ModBlocks.DEEPSLATE_RUBY_ORE, createMultipleOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY, 2, 3));
        add(ModBlocks.FLUORITE_ORE, createMultipleOreDrops(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE, 1, 2));
        add(ModBlocks.DEEPSLATE_FLUORITE_ORE, createMultipleOreDrops(ModBlocks.DEEPSLATE_FLUORITE_ORE, ModItems.RAW_FLUORITE, 2, 2));
        add(ModBlocks.SAPPHIRE_ORE, createOreDrop(ModBlocks.SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE));
        add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE));

    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))

        );
    }
}
