package net.chris.chrismod.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
        public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();

        public static final Consumable STRAWBERRY_CONSUMABLE = Consumables.defaultFood()
                .consumeSeconds(1).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 100), 0.1f)).build();

        public static final FoodProperties BEER = new FoodProperties.Builder().nutrition(8).saturationModifier(0.75f).alwaysEdible().build();

        public static final Consumable BEER_CONSUMABLE = Consumables.defaultDrink()
                .consumeSeconds(2).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 300), 0.5f))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 100), 0.5f))
                .build();


}
