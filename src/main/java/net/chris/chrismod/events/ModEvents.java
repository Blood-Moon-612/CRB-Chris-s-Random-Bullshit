package net.chris.chrismod.events;

import net.chris.chrismod.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ModEvents {

    private static int tickCounter = 0;

    public static void registerEvents() {

        ServerTickEvents.END_SERVER_TICK.register(server -> {

            tickCounter++;

            // Run every 5 seconds
            if (tickCounter < 20) {
                return;
            }

            tickCounter = 0;

            for (Player player : server.getPlayerList().getPlayers()) {

                if (player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.RUBY_HELMET)) {
                    player.addEffect(new MobEffectInstance(
                            MobEffects.NIGHT_VISION,
                            40,
                            0,
                            false,
                            false
                    ));
                }

                if (player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.RUBY_CHESTPLATE)) {
                    player.addEffect(new MobEffectInstance(
                            MobEffects.STRENGTH,
                            40,
                            0,
                            false,
                            false
                    ));
                }

                if (player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.RUBY_LEGGINGS)) {
                    player.addEffect(new MobEffectInstance(
                            MobEffects.SPEED,
                            40,
                            0,
                            false,
                            false
                    ));
                }

                if (player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.RUBY_BOOTS)) {
                    player.addEffect(new MobEffectInstance(
                            MobEffects.JUMP_BOOST,
                            40,
                            0,
                            false,
                            false
                    ));
                }

                if (player.getMainHandItem().is(ModItems.RUBY)) {

                    player.addEffect(new MobEffectInstance(
                            MobEffects.FIRE_RESISTANCE,
                            21,
                            0
                    ));

                } else if (player.getOffhandItem().is(ModItems.RUBY)) {

                    player.addEffect(new MobEffectInstance(
                            MobEffects.RESISTANCE,
                            21,
                            0
                    ));

                } else if (player.getInventory().contains(new ItemStack(ModItems.RUBY))) {

                    player.addEffect(new MobEffectInstance(
                            MobEffects.LUCK,
                            21,
                            0
                    ));
                }
            }
        });
    }
}