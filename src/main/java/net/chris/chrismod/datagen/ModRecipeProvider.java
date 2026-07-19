package net.chris.chrismod.datagen;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.chris.chrismod.ChrisSRandomBullshitDataGenerator;
import net.chris.chrismod.block.ModBlocks;
import net.chris.chrismod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
                List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE,ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                List<ItemLike> FLUORITE_SMELTABLES = List.of(ModItems.RAW_FLUORITE,ModBlocks.FLUORITE_ORE, ModBlocks.DEEPSLATE_FLUORITE_ORE);
                List<ItemLike> RAW_SAPPHIRE_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_SAPPHIRE_BLOCK);
                List<ItemLike> RAW_FLUORITE_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_FLUORITE_BLOCK);
                List<ItemLike> CAST_IRON = List.of(ModItems.CAST_IRON);


                oreSmelting(FLUORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FLUORITE, 0.35f, 160, "fluorite");
                oreBlasting(FLUORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FLUORITE, 0.35f, 80, "fluorite");

                oreSmelting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.RUBY, 0.5f, 180, "ruby");
                oreBlasting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.RUBY, 0.5f, 90, "ruby");

                oreSmelting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.SAPPHIRE, 0.65f, 200, "sapphire");
                oreBlasting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.SAPPHIRE, 0.65f, 100, "sapphire");

                oreSmelting(RAW_SAPPHIRE_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModBlocks.SAPPHIRE_BLOCK, 5.85f, 1800, "sapphire");
                oreBlasting(RAW_SAPPHIRE_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModBlocks.SAPPHIRE_BLOCK, 5.85f, 900, "sapphire");

                oreSmelting(RAW_FLUORITE_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModBlocks.FLUORITE_BLOCK, 3.15f, 1440, "fluorite");
                oreBlasting(RAW_FLUORITE_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModBlocks.FLUORITE_BLOCK, 3.15f, 720, "fluorite");

                oreBlasting(CAST_IRON, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.STEEL_INGOT, 0.75f, 250, "STEEL");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.SAPPHIRE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.FLUORITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_SAPPHIRE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_SAPPHIRE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_FLUORITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_FLUORITE_BLOCK);

                shaped(RecipeCategory.MISC, ModItems.SILLY)
                        .pattern("3 3")
                        .pattern(" 3 ")
                        .pattern("3 3")
                        .define('3', ModItems.RUBY)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("silly")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RUBY, 5)
                        .requires(ModItems.SILLY)
                        .unlockedBy(getHasName(ModItems.SILLY), has(ModItems.SILLY))
                        .group("silly")
                        .save(output, "silly_ruby");


                shaped(RecipeCategory.MISC, ModItems.CAST_IRON)
                        .pattern("III")
                        .pattern("ICI")
                        .pattern("III")
                        .define('I', Items.IRON_INGOT)
                        .define('C', Items.COAL)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("steel")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.CAST_IRON)
                        .pattern("III")
                        .pattern("ICI")
                        .pattern("III")
                        .define('I', Items.IRON_INGOT)
                        .define('C', Items.CHARCOAL)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("steel")
                        .save(output, "cast_iron_from_charcoal");


                shapeless(RecipeCategory.MISC, ModItems.COPPER_DUST, 1)
                        .requires(Items.COPPER_INGOT)
                        .requires(ModItems.MORTAR)
                        .unlockedBy(getHasName(ModItems.MORTAR), has(ModItems.MORTAR))
                        .group("dust")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.IRON_DUST, 1)
                        .requires(Items.IRON_INGOT)
                        .requires(ModItems.MORTAR)
                        .unlockedBy(getHasName(ModItems.MORTAR), has(ModItems.MORTAR))
                        .group("dust")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.GOLD_DUST, 1)
                        .requires(Items.GOLD_INGOT)
                        .requires(ModItems.MORTAR)
                        .unlockedBy(getHasName(ModItems.MORTAR), has(ModItems.MORTAR))
                        .group("dust")
                        .save(output);



                shapeless(RecipeCategory.MISC, ModItems.COPPER_DUST, 1)
                        .requires(Items.COPPER_INGOT)
                        .requires(ModItems.IRON_MORTAR)
                        .unlockedBy(getHasName(ModItems.IRON_MORTAR), has(ModItems.IRON_MORTAR))
                        .group("dust")
                        .save(output, "copper_dust_from_iron_mortar");

                shapeless(RecipeCategory.MISC, ModItems.IRON_DUST, 1)
                        .requires(Items.IRON_INGOT)
                        .requires(ModItems.IRON_MORTAR)
                        .unlockedBy(getHasName(ModItems.IRON_MORTAR), has(ModItems.IRON_MORTAR))
                        .group("dust")
                        .save(output, "iron_dust_from_iron_mortar");

                shapeless(RecipeCategory.MISC, ModItems.GOLD_DUST, 1)
                        .requires(Items.GOLD_INGOT)
                        .requires(ModItems.IRON_MORTAR)
                        .unlockedBy(getHasName(ModItems.IRON_MORTAR), has(ModItems.IRON_MORTAR))
                        .group("dust")
                        .save(output, "gold_dust_from_iron_mortar");



                shapeless(RecipeCategory.MISC, ModItems.COPPER_DUST, 1)
                        .requires(Items.COPPER_INGOT)
                        .requires(ModItems.RUBY_MORTAR)
                        .unlockedBy(getHasName(ModItems.RUBY_MORTAR), has(ModItems.RUBY_MORTAR))
                        .group("dust")
                        .save(output, "copper_dust_from_ruby_mortar");

                shapeless(RecipeCategory.MISC, ModItems.IRON_DUST, 1)
                        .requires(Items.IRON_INGOT)
                        .requires(ModItems.RUBY_MORTAR)
                        .unlockedBy(getHasName(ModItems.RUBY_MORTAR), has(ModItems.RUBY_MORTAR))
                        .group("dust")
                        .save(output, "iron_dust_from_ruby_mortar");

                shapeless(RecipeCategory.MISC, ModItems.GOLD_DUST, 1)
                        .requires(Items.GOLD_INGOT)
                        .requires(ModItems.RUBY_MORTAR)
                        .unlockedBy(getHasName(ModItems.RUBY_MORTAR), has(ModItems.RUBY_MORTAR))
                        .group("dust")
                        .save(output, "gold_dust_from_ruby_mortar");



                shapeless(RecipeCategory.MISC, ModItems.STEEL_DUST, 1)
                        .requires(ModItems.STEEL_INGOT)
                        .requires(ModItems.MORTAR)
                        .unlockedBy(getHasName(ModItems.MORTAR), has(ModItems.MORTAR))
                        .group("dust")
                        .save(output);



                shaped(RecipeCategory.MISC, ModItems.MORTAR)
                        .pattern(" I ")
                        .pattern("SIS")
                        .pattern("SSS")
                        .define('S', Items.STONE_SLAB)
                        .define('I', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.STONE_SLAB), has(Items.STONE_SLAB))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("dust")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.IRON_MORTAR)
                        .pattern(" I ")
                        .pattern("PIP")
                        .pattern("PPP")
                        .define('I', Items.IRON_INGOT)
                        .define('P', ModItems.IRON_PLATE)
                        .unlockedBy(getHasName(ModItems.IRON_PLATE), has(ModItems.IRON_PLATE))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("dust")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.RUBY_MORTAR)
                        .pattern(" R ")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RUBY)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("dust")
                        .save(output);



                shaped(RecipeCategory.MISC, ModItems.SAPPHIRE)
                        .pattern(" F ")
                        .pattern("FSF")
                        .pattern(" F ")
                        .define('S', ModItems.SAPPHIRE)
                        .define('F', ModItems.FLUORITE)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("sapphire")
                        .save(output, "strengthened_sapphire");



                shapeless(RecipeCategory.MISC, ModItems.IRON_PLATE, 1)
                        .requires(Items.IRON_INGOT)
                        .requires(ModItems.STONE_HAMMER)
                        .unlockedBy(getHasName(ModItems.STONE_HAMMER), has(ModItems.STONE_HAMMER))
                        .group("plate")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.IRON_PLATE, 1)
                        .requires(Items.IRON_INGOT)
                        .requires(ModItems.IRON_HAMMER)
                        .unlockedBy(getHasName(ModItems.IRON_HAMMER), has(ModItems.IRON_HAMMER))
                        .group("plate")
                        .save(output, "iron_plate_from_iron_hammer");

                shapeless(RecipeCategory.MISC, ModItems.IRON_PLATE, 1)
                        .requires(Items.IRON_INGOT)
                        .requires(ModItems.RUBY_HAMMER)
                        .unlockedBy(getHasName(ModItems.RUBY_HAMMER), has(ModItems.RUBY_HAMMER))
                        .group("plate")
                        .save(output, "iron_plate_from_ruby_hammer");

                shapeless(RecipeCategory.MISC, ModItems.GOLD_PLATE, 1)
                        .requires(Items.GOLD_INGOT)
                        .requires(ModItems.STONE_HAMMER)
                        .unlockedBy(getHasName(ModItems.STONE_HAMMER), has(ModItems.STONE_HAMMER))
                        .group("plate")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.GOLD_PLATE, 1)
                        .requires(Items.GOLD_INGOT)
                        .requires(ModItems.IRON_HAMMER)
                        .unlockedBy(getHasName(ModItems.IRON_HAMMER), has(ModItems.IRON_HAMMER))
                        .group("plate")
                        .save(output, "gold_plate_from_iron_hammer");

                shapeless(RecipeCategory.MISC, ModItems.GOLD_PLATE, 1)
                        .requires(Items.GOLD_INGOT)
                        .requires(ModItems.RUBY_HAMMER)
                        .unlockedBy(getHasName(ModItems.RUBY_HAMMER), has(ModItems.RUBY_HAMMER))
                        .group("plate")
                        .save(output, "gold_plate_from_ruby_hammer");

                shapeless(RecipeCategory.MISC, ModItems.COPPER_PLATE, 1)
                        .requires(Items.COPPER_INGOT)
                        .requires(ModItems.STONE_HAMMER)
                        .unlockedBy(getHasName(ModItems.STONE_HAMMER), has(ModItems.STONE_HAMMER))
                        .group("plate")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.COPPER_PLATE, 1)
                        .requires(Items.COPPER_INGOT)
                        .requires(ModItems.IRON_HAMMER)
                        .unlockedBy(getHasName(ModItems.IRON_HAMMER), has(ModItems.IRON_HAMMER))
                        .group("plate")
                        .save(output, "copper_plate_from_iron_hammer");

                shapeless(RecipeCategory.MISC, ModItems.COPPER_PLATE, 1)
                        .requires(Items.COPPER_INGOT)
                        .requires(ModItems.RUBY_HAMMER)
                        .unlockedBy(getHasName(ModItems.RUBY_HAMMER), has(ModItems.RUBY_HAMMER))
                        .group("plate")
                        .save(output, "copper_plate_from_ruby_hammer");

                shapeless(RecipeCategory.MISC, ModItems.STEEL_PLATE, 1)
                        .requires(ModItems.STEEL_INGOT)
                        .requires(ModItems.RUBY_HAMMER)
                        .unlockedBy(getHasName(ModItems.RUBY_HAMMER), has(ModItems.RUBY_HAMMER))
                        .group("plate")
                        .save(output, "steel_plate_from_ruby_hammer");




                shaped(RecipeCategory.MISC, ModItems.YOUR_DID_IT)
                        .pattern("H")
                        .pattern("B")
                        .define('H', Items.HEAVY_CORE)
                        .define('B', Items.BREEZE_ROD)
                        .unlockedBy(getHasName(Items.HEAVY_CORE), has(Items.HEAVY_CORE))
                        .group("mace")
                        .save(output, "mace");


                    shapeless(RecipeCategory.MISC, Items.HEAVY_CORE)
                            .requires(ModItems.YOUR_DID_IT)
                        .unlockedBy(getHasName(ModItems.YOUR_DID_IT), has(ModItems.YOUR_DID_IT))
                        .group("mace")
                        .save(output);


                shaped(RecipeCategory.MISC, Items.MACE)
                        .pattern("H")
                        .pattern("H")
                        .pattern("B")
                        .define('H', Items.HEAVY_CORE)
                        .define('B', Items.BREEZE_ROD)
                        .unlockedBy(getHasName(Items.HEAVY_CORE), has(Items.HEAVY_CORE))
                        .group("mace")
                        .save(output, "custom_mace");

                shaped(RecipeCategory.MISC, ModItems.BEER)
                        .pattern("GBG")
                        .pattern("GWG")
                        .pattern("GOG")
                        .define('G', Items.GLASS_PANE)
                        .define('O', Items.POTION)
                        .define('W', Items.WHEAT)
                        .define('B', Items.BROWN_MUSHROOM)
                        .unlockedBy(getHasName(Items.BROWN_MUSHROOM), has(Items.BROWN_MUSHROOM))
                        .group("beer")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.BEER, 9)
                        .pattern("GBG")
                        .pattern("GWG")
                        .pattern("GOG")
                        .define('G', Items.GLASS)
                        .define('O', Items.POTION)
                        .define('W', Items.HAY_BLOCK)
                        .define('B', Items.BROWN_MUSHROOM_BLOCK)
                        .unlockedBy(getHasName(Items.BROWN_MUSHROOM_BLOCK), has(Items.BROWN_MUSHROOM_BLOCK))
                        .group("beer")
                        .save(output, "9_beer_from_blocks");



                stairBuilder(ModBlocks.RUBY_STAIRS, Ingredient.of(ModBlocks.RUBY_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK), has(ModBlocks.RUBY_BLOCK))
                        .group("ruby")
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_SLAB, ModBlocks.RUBY_BLOCK);

                stairBuilder(ModBlocks.SAPPHIRE_STAIRS, Ingredient.of(ModBlocks.SAPPHIRE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK), has(ModBlocks.SAPPHIRE_BLOCK))
                        .group("sapphire")
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_SLAB, ModBlocks.SAPPHIRE_BLOCK);

                stairBuilder(ModBlocks.FLUORITE_STAIRS, Ingredient.of(ModBlocks.FLUORITE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.FLUORITE_BLOCK), has(ModBlocks.FLUORITE_BLOCK))
                        .group("fluorite")
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_SLAB, ModBlocks.FLUORITE_BLOCK);

                buttonBuilder(ModBlocks.RUBY_BUTTON,Ingredient.of(ModItems.RUBY))
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);

                pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE,ModItems.RUBY);

                buttonBuilder(ModBlocks.FLUORITE_BUTTON,Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);

                pressurePlate(ModBlocks.FLUORITE_PRESSURE_PLATE,ModItems.FLUORITE);

                buttonBuilder(ModBlocks.SAPPHIRE_BUTTON,Ingredient.of(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .group("sapphire")
                        .save(output);

                pressurePlate(ModBlocks.SAPPHIRE_PRESSURE_PLATE,ModItems.SAPPHIRE);

                fenceBuilder(ModBlocks.RUBY_FENCE, Ingredient.of(ModItems.RUBY))
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);

                fenceGateBuilder(ModBlocks.RUBY_FENCE_GATE, Ingredient.of(ModItems.RUBY))
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_WALL, ModBlocks.RUBY_BLOCK);

                fenceBuilder(ModBlocks.SAPPHIRE_FENCE, Ingredient.of(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .group("sapphire")
                        .save(output);

                fenceGateBuilder(ModBlocks.SAPPHIRE_FENCE_GATE, Ingredient.of(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .group("sapphire")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_BLOCK);

                fenceBuilder(ModBlocks.FLUORITE_FENCE, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);

                fenceGateBuilder(ModBlocks.FLUORITE_FENCE_GATE, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_WALL, ModBlocks.FLUORITE_BLOCK);

                doorBuilder(ModBlocks.RUBY_DOOR, Ingredient.of(ModItems.RUBY))
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);

                trapdoorBuilder(ModBlocks.RUBY_TRAPDOOR, Ingredient.of(ModItems.RUBY))
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);

                doorBuilder(ModBlocks.FLUORITE_DOOR, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);

                trapdoorBuilder(ModBlocks.FLUORITE_TRAPDOOR, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);

                doorBuilder(ModBlocks.SAPPHIRE_DOOR, Ingredient.of(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .group("sapphire")
                        .save(output);

                trapdoorBuilder(ModBlocks.SAPPHIRE_TRAPDOOR, Ingredient.of(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .group("sapphire")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("S")
                        .define('R', ModItems.RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("ruby")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('R', ModItems.RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("ruby")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL)
                        .pattern("R")
                        .pattern("S")
                        .pattern("S")
                        .define('R', ModItems.RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("ruby")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.RUBY_HOE)
                        .pattern("RR")
                        .pattern(" S")
                        .pattern(" S")
                        .define('R', ModItems.RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("ruby")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.RUBY_AXE)
                        .pattern("RR")
                        .pattern("RS")
                        .pattern(" S")
                        .define('R', ModItems.RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("S")
                        .define('R', ModItems.SAPPHIRE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("sapphire")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('R', ModItems.SAPPHIRE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("sapphire")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SHOVEL)
                        .pattern("R")
                        .pattern("S")
                        .pattern("S")
                        .define('R', ModItems.SAPPHIRE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("sapphire")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_HOE)
                        .pattern("RR")
                        .pattern(" S")
                        .pattern(" S")
                        .define('R', ModItems.SAPPHIRE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("sapphire")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_AXE)
                        .pattern("RR")
                        .pattern("RS")
                        .pattern(" S")
                        .define('R', ModItems.SAPPHIRE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("sapphire")
                        .save(output);


                shaped(RecipeCategory.COMBAT, ModItems.RUBY_HELMET)
                        .pattern("RRR")
                        .pattern("R R")
                        .define('R', ModItems.RUBY)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE)
                        .pattern("R R")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RUBY)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS)
                        .pattern("RRR")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', ModItems.RUBY)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS)
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', ModItems.RUBY)
                        .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                        .group("ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_HELMET)
                        .pattern("RRR")
                        .pattern("R R")
                        .define('R', ModItems.SAPPHIRE)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE_HELMET))
                        .group("sapphire")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_CHESTPLATE)
                        .pattern("R R")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.SAPPHIRE)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE_BOOTS))
                        .group("sapphire")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_LEGGINGS)
                        .pattern("RRR")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', ModItems.SAPPHIRE)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE_BOOTS))
                        .group("sapphire")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_BOOTS)
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', ModItems.SAPPHIRE)
                        .unlockedBy(getHasName(ModItems.SAPPHIRE), has(ModItems.SAPPHIRE))
                        .group("sapphire")
                        .save(output);

            }
        };
    }

    @Override
    public String getName() {
        return "CRB Recipes";
    }
}
