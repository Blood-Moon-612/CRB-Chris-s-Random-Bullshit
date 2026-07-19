package net.chris.chrismod.item;

import net.chris.chrismod.ChrisSRandomBullshit;
import net.chris.chrismod.tags.ModTags;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> RUBY_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "ruby"));
    public static final ResourceKey<EquipmentAsset> SAPPHIRE_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "sapphire"));
    public static final ResourceKey<EquipmentAsset> STEEL_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(ChrisSRandomBullshit.MOD_ID, "steel"));


    public  static  final ArmorMaterial STEEL_ARMOR_MATERIAL = new ArmorMaterial(20,
            ArmorMaterials.makeDefense(2, 5 ,6, 3 , 6),
            12 , SoundEvents.ARMOR_EQUIP_IRON, 0, 0, ModTags.Items.STEEL_REPAIR, STEEL_KEY);

    public  static  final ArmorMaterial RUBY_ARMOR_MATERIAL = new ArmorMaterial(25,
            ArmorMaterials.makeDefense(3, 5 ,6, 3 , 8),
            12 , SoundEvents.ARMOR_EQUIP_IRON, 0, 0, ModTags.Items.RUBY_REPAIR, RUBY_KEY);


    public  static  final ArmorMaterial SAPPHIRE_ARMOR_MATERIAL= new ArmorMaterial(30,
            ArmorMaterials.makeDefense(3, 6 ,7, 3, 10),
            14, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0, ModTags.Items.SAPPHIRE_REPAIR, SAPPHIRE_KEY);
    // the hard coded limit is 30 defense
}
