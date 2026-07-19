package net.chris.chrismod.tags;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_RUBY_TOOL = createTag("needs_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = createTag("incorrect_for_ruby_tool");

        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = createTag("needs_sapphire_tool");
        public static final TagKey<Block> INCORRECT_FOR_SAPPHIRE_TOOL = createTag("incorrect_for_sapphire_tool");

        public static final TagKey<Block> NEEDS_STEEL_TOOL = createTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTag("incorrect_for_steel_tool");


        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> RUBY_REPAIR = createTag("ruby_repair");
        public static final TagKey<Item> SAPPHIRE_REPAIR = createTag("sapphire_repair");
        public static final TagKey<Item> STEEL_REPAIR = createTag("steel_repair");



        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name));

        }
    }
}