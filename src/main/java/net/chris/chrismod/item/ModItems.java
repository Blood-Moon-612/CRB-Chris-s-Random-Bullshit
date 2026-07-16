package net.chris.chrismod.item;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.chris.chrismod.food.ModFoods;
import net.chris.chrismod.item.custom.ChiselItem;
import net.chris.chrismod.item.custom.HammerItem;
import net.chris.chrismod.item.custom.MortarItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", Item::new);
    public static final Item FLUORITE = registerItem("fluorite", Item::new);
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", Item::new);
    public static final Item SAPPHIRE = registerItem("sapphire", Item::new);
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", Item::new);
    public static final Item CAST_IRON = registerItem("cast_iron", Item::new);
    public static final Item STEEL_INGOT = registerItem("steel_ingot", Item::new);
    public static final Item STEEL_DUST = registerItem("steel_dust", Item::new);
    public static final Item COPPER_DUST = registerItem("copper_dust", Item::new);
    public static final Item GOLD_DUST = registerItem("gold_dust", Item::new);
    public static final Item IRON_DUST = registerItem("iron_dust", Item::new);
    public static final Item IRON_PLATE = registerItem("iron_plate", Item::new);
    public static final Item COPPER_PLATE = registerItem("copper_plate", Item::new);
    public static final Item GOLD_PLATE = registerItem("gold_plate", Item::new);
    public static final Item STEEL_PLATE = registerItem("steel_plate", Item::new);
    public static final Item YOUR_DID_IT = registerItem("your_did_it", Item::new);

    public static final Item LIGNITE = registerItem("lignite", properties -> new Item(properties.stacksTo(63)));


    public static final Item SILLY = registerItem("silly", Item::new);

    public static final Item CHISEL= registerItem("chisel", properties -> new ChiselItem(properties.durability(4)));
    public static final Item MORTAR = registerItem("mortar", properties -> new MortarItem(properties.durability(32)));
    public static final Item IRON_MORTAR = registerItem("iron_mortar", properties -> new MortarItem(properties.durability(64)));
    public static final Item RUBY_MORTAR = registerItem("ruby_mortar", properties -> new MortarItem(properties.durability(96)));
    public static final Item STONE_HAMMER = registerItem("stone_hammer", properties -> new HammerItem(properties.durability(64)));
    public static final Item IRON_HAMMER = registerItem("iron_hammer", properties -> new HammerItem(properties.durability(128)));
    public static final Item RUBY_HAMMER  = registerItem("ruby_hammer", properties -> new HammerItem(properties.durability(192)));


    public static final Item STRAWBERRY = registerItem("strawberry", properties -> new Item(properties
            .food(ModFoods.STRAWBERRY, ModFoods.STRAWBERRY_CONSUMABLE)){
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.chrismod.strawberry"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });

    public static final Item BEER = registerItem("beer", properties -> new Item(properties
            .food(ModFoods.BEER, ModFoods.BEER_CONSUMABLE)) {
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.chrismod.beer"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, name)))));
    }

    public static void registerModItems() {
        ChrisSRandomBullshit.LOGGER.info("Registering Mod Items for " + ChrisSRandomBullshit.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(RUBY);
            output.accept(FLUORITE);
            output.accept(RAW_FLUORITE);
            output.accept(SAPPHIRE);
            output.accept(RAW_SAPPHIRE);
         });
    }
}
