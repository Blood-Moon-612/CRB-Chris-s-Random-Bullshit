package net.chris.chrismod;

import net.chris.chrismod.datagen.ModBlockLootTableProvider;
import net.chris.chrismod.datagen.ModBlockTagsProvider;
import net.chris.chrismod.datagen.ModModelProvider;
import net.chris.chrismod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ChrisSRandomBullshitDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);

	}
}
