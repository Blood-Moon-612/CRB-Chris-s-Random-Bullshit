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


            }
        };
    }

    @Override
    public String getName() {
        return "CRB Recipes";
    }
}
