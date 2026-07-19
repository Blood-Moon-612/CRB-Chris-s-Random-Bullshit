package net.chris.chrismod;

import net.chris.chrismod.block.ModBlocks;
import net.chris.chrismod.creativemodetab.ModCreativeModeTabs;
import net.chris.chrismod.events.ModEvents;
import net.chris.chrismod.item.ModItems;
import net.chris.chrismod.registries.ModFuels;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChrisSRandomBullshit implements ModInitializer {
	public static final String MOD_ID = "chrismod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFuels.registerFuels();

		ModEvents.registerEvents();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
