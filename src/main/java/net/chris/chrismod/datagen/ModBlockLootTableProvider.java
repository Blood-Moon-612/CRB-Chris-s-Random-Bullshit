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
