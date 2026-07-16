package net.chris.chrismod.registries;

import net.chris.chrismod.block.ModBlocks;
import net.chris.chrismod.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelValueEvents;

public class ModFuels {
    public static void registerFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.LIGNITE, 800);
            builder.add(ModBlocks.COMPRESSED_LEAVES, 400);

        });
    }
}
