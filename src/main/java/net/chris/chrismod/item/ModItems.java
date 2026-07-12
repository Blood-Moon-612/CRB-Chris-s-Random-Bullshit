package net.chris.chrismod.item;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", Item::new);
    public static final Item FLUORITE = registerItem("fluorite", Item::new);
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", Item::new);
    public static final Item SAPPHIRE = registerItem("sapphire", Item::new);
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", Item::new);
    public static final Item SILLY = registerItem("silly", Item::new);


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
