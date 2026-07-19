package net.chris.chrismod.datagen;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.chris.chrismod.item.ModArmorMaterials;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;

    public ModEquipmentAssetProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");

    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        consumer.accept(ModArmorMaterials.RUBY_KEY,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "ruby"))
                        .build());

        consumer.accept(ModArmorMaterials.SAPPHIRE_KEY,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "sapphire"))
                        .build());

        consumer.accept(ModArmorMaterials.STEEL_KEY,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "steel"))
                        .build());
    }


    @Override
    public CompletableFuture<?> run(final CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap<>();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + id);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.pathProvider::json, equipmentAssets);
    }

    @Override
    public String getName() {
        return "Chris Mod Equipment Asset Finished";
    }
}
