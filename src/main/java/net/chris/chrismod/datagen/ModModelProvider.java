package net.chris.chrismod.datagen;

import net.chris.chrismod.block.ModBlocks;
import net.chris.chrismod.item.ModArmorMaterials;
import net.chris.chrismod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider{
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_FLUORITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RUBY_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.SAPPHIRE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.FLUORITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_FLUORITE_ORE);

        blockModelGenerators.createTrivialCube(ModBlocks.MAGIC_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.GAMBLING_BLOCK);

        blockModelGenerators.createTrivialCube(ModBlocks.COMPRESSED_LEAVES);

        blockModelGenerators.family(ModBlocks.RUBY_BLOCK)
                .stairs(ModBlocks.RUBY_STAIRS)
                .slab(ModBlocks.RUBY_SLAB)
                .button(ModBlocks.RUBY_BUTTON)
                .pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE)
                .fence(ModBlocks.RUBY_FENCE)
                .fenceGate(ModBlocks.RUBY_FENCE_GATE)
                .wall(ModBlocks.RUBY_WALL);

        blockModelGenerators.createDoor(ModBlocks.RUBY_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.RUBY_TRAPDOOR);

        blockModelGenerators.family(ModBlocks.SAPPHIRE_BLOCK)
                .stairs(ModBlocks.SAPPHIRE_STAIRS)
                .slab(ModBlocks.SAPPHIRE_SLAB)
                .button(ModBlocks.SAPPHIRE_BUTTON)
                .pressurePlate(ModBlocks.SAPPHIRE_PRESSURE_PLATE)
                .fence(ModBlocks.SAPPHIRE_FENCE)
                .fenceGate(ModBlocks.SAPPHIRE_FENCE_GATE)
                .wall(ModBlocks.SAPPHIRE_WALL);

        blockModelGenerators.createDoor(ModBlocks.SAPPHIRE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.SAPPHIRE_TRAPDOOR);

        blockModelGenerators.family(ModBlocks.FLUORITE_BLOCK)
                .stairs(ModBlocks.FLUORITE_STAIRS)
                .slab(ModBlocks.FLUORITE_SLAB)
                .button(ModBlocks.FLUORITE_BUTTON)
                .pressurePlate(ModBlocks.FLUORITE_PRESSURE_PLATE)
                .fence(ModBlocks.FLUORITE_FENCE)
                .fenceGate(ModBlocks.FLUORITE_FENCE_GATE)
                .wall(ModBlocks.FLUORITE_WALL);

        blockModelGenerators.createDoor(ModBlocks.FLUORITE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.FLUORITE_TRAPDOOR);


    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.RUBY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_FLUORITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SAPPHIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_SAPPHIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COPPER_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLD_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STEEL_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CAST_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COPPER_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLD_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STEEL_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.SILLY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.YOUR_DID_IT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MORTAR, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_MORTAR, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUBY_MORTAR, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.STONE_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUBY_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.STRAWBERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEER, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.LIGNITE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.RUBY_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUBY_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUBY_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUBY_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUBY_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
      //  itemModelGenerators.generateSpear(ModItems.RUBY_SPEAR);

        itemModelGenerators.generateFlatItem(ModItems.SAPPHIRE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SAPPHIRE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SAPPHIRE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SAPPHIRE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SAPPHIRE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        //  itemModelGenerators.generateSpear(ModItems.SAPPHIRE_SPEAR);


        itemModelGenerators.generateTrimmableItem(ModItems.RUBY_HELMET, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.RUBY_CHESTPLATE, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.RUBY_LEGGINGS, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.RUBY_BOOTS, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerators.generateTrimmableItem(ModItems.SAPPHIRE_HELMET, ModArmorMaterials.SAPPHIRE_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.SAPPHIRE_CHESTPLATE, ModArmorMaterials.SAPPHIRE_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.SAPPHIRE_LEGGINGS, ModArmorMaterials.SAPPHIRE_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.SAPPHIRE_BOOTS, ModArmorMaterials.SAPPHIRE_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);



    }
}
