package net.chris.chrismod.datagen;

import net.chris.chrismod.item.ModItems;
import net.chris.chrismod.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.IRON_DUST);


        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.RUBY_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.RUBY_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.RUBY_SHOVEL);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.RUBY_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.RUBY_HOE);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.SAPPHIRE_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.SAPPHIRE_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.SAPPHIRE_SHOVEL);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.SAPPHIRE_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.SAPPHIRE_HOE);

        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.RUBY_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.RUBY_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.RUBY_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.RUBY_BOOTS);

        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.SAPPHIRE_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.SAPPHIRE_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.SAPPHIRE_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.SAPPHIRE_BOOTS);
    }
}
