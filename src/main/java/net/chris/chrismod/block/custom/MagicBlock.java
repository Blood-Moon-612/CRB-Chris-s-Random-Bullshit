package net.chris.chrismod.block.custom;

import net.chris.chrismod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    private static final Map<Item, Item> TRANSFORM_MAP = Map.of(
            Items.QUARTZ, ModItems.IRON_DUST,
            ModItems.IRON_DUST, Items.QUARTZ
    );

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.addParticle(ParticleTypes.CRIT, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);
        //level.playLocalSound is only for you
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, 2f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        // Add Effect to player, please add one more effect here :pray:
        if (entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 300));
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 5));
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 5));
        }

        //Change Item(s) to other Items
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.tickCount % 40 != 0) {
                return;
            }
            //   if (isValidItem(itemEntity.getItem())) {
            //      itemEntity.setItem(new ItemStack(Items.QUARTZ, itemEntity.getItem().getCount()));


            ItemStack currentStack = itemEntity.getItem();
            Item inputItem = currentStack.getItem();

            if (TRANSFORM_MAP.containsKey(inputItem)) {
                Item resultItem = TRANSFORM_MAP.get(inputItem);
                itemEntity.setItem(new ItemStack(resultItem, currentStack.getCount()));

                level.addParticle(
                        ParticleTypes.CRIT,
                        pos.getX() + 0.5,
                        pos.getY() + 1,
                        pos.getZ() + 0.5,
                        0, 1, 0
                );

                level.playSound(
                        null, // Play for everyone nearby
                        pos,
                        SoundEvents.AMETHYST_BLOCK_RESONATE,
                        SoundSource.BLOCKS,
                        2f,
                        1f
                );
            }
        }


        super.stepOn(level, pos, onState, entity);
    }
}

// private boolean isValidItem(ItemStack item) {
//      return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
 //   }
//  }

