package net.chris.chrismod.block;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.chris.chrismod.block.custom.GamblingBlock;
import net.chris.chrismod.block.custom.MagicBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            properties -> new Block(properties.strength(4.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            properties -> new Block(properties.strength(5.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
            properties -> new Block(properties.strength(5.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

        public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block RAW_FLUORITE_BLOCK = registerBlock("raw_fluorite_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0,2),properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1,3),properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1, 2),properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0,3),properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2,3),properties.strength(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final Block DEEPSLATE_FLUORITE_ORE = registerBlock("deepslate_fluorite_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1,3),properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            properties -> new MagicBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), Component.translatable("tooltip.chrismod.magic_block"));

    public static final Block GAMBLING_BLOCK = registerBlock("gambling_block",
            properties -> new GamblingBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), Component.translatable("tooltip.chrismod.gambling_block"));

    public static final Block COMPRESSED_LEAVES = registerBlock("compressed_leaves",
            properties -> new Block(properties.strength(1f)
                    .requiresCorrectToolForDrops().sound(SoundType.LEAF_LITTER)));


    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs",
            properties -> new StairBlock(ModBlocks.RUBY_BLOCK.defaultBlockState(),
                    properties.strength(4.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block RUBY_SLAB = registerBlock("ruby_slab",
            properties -> new SlabBlock(properties.strength(4.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block FLUORITE_STAIRS = registerBlock("fluorite_stairs",
            properties -> new StairBlock(ModBlocks.RUBY_BLOCK.defaultBlockState(),
                    properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block FLUORITE_SLAB = registerBlock("fluorite_slab",
            properties -> new SlabBlock(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block SAPPHIRE_STAIRS = registerBlock("sapphire_stairs",
            properties -> new StairBlock(ModBlocks.RUBY_BLOCK.defaultBlockState(),
                    properties.strength(5.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block SAPPHIRE_SLAB = registerBlock("sapphire_slab",
            properties -> new SlabBlock(properties.strength(5.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block RUBY_BUTTON = registerBlock("ruby_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 20,
                    properties.strength(2f).requiresCorrectToolForDrops().noCollision()));

    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON,
                    properties.mapColor(MapColor.COLOR_RED).forceSolidOn().instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .noCollision().strength(2f).pushReaction(PushReaction.DESTROY)));

    public static final Block FLUORITE_BUTTON = registerBlock("fluorite_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 20,
                    properties.strength(1.5f).requiresCorrectToolForDrops().noCollision()));

    public static final Block FLUORITE_PRESSURE_PLATE = registerBlock("fluorite_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON,
                    properties.mapColor(MapColor.COLOR_PURPLE).forceSolidOn().instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .noCollision().strength(1.5f).pushReaction(PushReaction.DESTROY)));

    public static final Block SAPPHIRE_BUTTON = registerBlock("sapphire_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 20,
                    properties.strength(2.5f).requiresCorrectToolForDrops().noCollision()));

    public static final Block SAPPHIRE_PRESSURE_PLATE = registerBlock("sapphire_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON,
                    properties.mapColor(MapColor.COLOR_BLUE).forceSolidOn().instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .noCollision().strength(2.5f).pushReaction(PushReaction.DESTROY)));

    public static final Block RUBY_FENCE = registerBlock("ruby_fence",
            properties -> new FenceBlock(properties.strength(2.5f).requiresCorrectToolForDrops()));

    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA,properties.strength(2.5f).requiresCorrectToolForDrops()));

    public static final Block RUBY_WALL = registerBlock("ruby_wall",
            properties -> new WallBlock(properties.strength(2.5f).requiresCorrectToolForDrops()));

    public static final Block FLUORITE_FENCE = registerBlock("fluorite_fence",
            properties -> new FenceBlock(properties.strength(2f).requiresCorrectToolForDrops()));

    public static final Block FLUORITE_FENCE_GATE = registerBlock("fluorite_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA,properties.strength(2f).requiresCorrectToolForDrops()));

    public static final Block FLUORITE_WALL = registerBlock("fluorite_wall",
            properties -> new WallBlock(properties.strength(2f).requiresCorrectToolForDrops()));

    public static final Block SAPPHIRE_FENCE = registerBlock("sapphire_fence",
            properties -> new FenceBlock(properties.strength(3f).requiresCorrectToolForDrops()));

    public static final Block SAPPHIRE_FENCE_GATE = registerBlock("sapphire_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA,properties.strength(3f).requiresCorrectToolForDrops()));

    public static final Block SAPPHIRE_WALL = registerBlock("sapphire_wall",
            properties -> new WallBlock(properties.strength(3f)
                    .requiresCorrectToolForDrops()));

    public static final Block RUBY_DOOR = registerBlock("ruby_door",
            properties -> new DoorBlock(BlockSetType.IRON,properties.strength(2.5f)
                    .requiresCorrectToolForDrops().noOcclusion()));

    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON,properties.strength(2.5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final Block FLUORITE_DOOR = registerBlock("fluorite_door",
            properties -> new DoorBlock(BlockSetType.IRON,properties.strength(2f)
                    .requiresCorrectToolForDrops().noOcclusion()));

    public static final Block FLUORITE_TRAPDOOR = registerBlock("fluorite_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON,properties.strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final Block SAPPHIRE_DOOR = registerBlock("sapphire_door",
            properties -> new DoorBlock(BlockSetType.IRON,properties.strength(3f)
                    .requiresCorrectToolForDrops().noOcclusion()));

    public static final Block SAPPHIRE_TRAPDOOR = registerBlock("sapphire_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON,properties.strength(3f).requiresCorrectToolForDrops().noOcclusion()));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, Component... tooltips) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name))));
        registerBlockItem(name, toRegister, tooltips);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block, Component... tooltips) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name)))) {
                    @Override
                    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                       for(var component : tooltips) {
                           builder.accept(component);
                       }

                        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                    }
                });
    }

  private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name)))));
    }

    public static void registerModBlocks(){
        ChrisSRandomBullshit.LOGGER.info("Registering Mod Blocks for " + ChrisSRandomBullshit.MOD_ID);
    }
}
