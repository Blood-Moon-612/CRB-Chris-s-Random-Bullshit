package net.chris.chrismod.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public class MortarItem extends Item {
    public MortarItem(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemStack stack) {
        // 1. Create a copy of the incoming mortar item stack
        ItemStack remainder = stack.copy();

        // 2. Add 1 damage point to it
        remainder.setDamageValue(remainder.getDamageValue() + 2);

        // 3. If it breaks, return null (empty template)
        if (remainder.getDamageValue() >= remainder.getMaxDamage()) {
            return null; // Null represents ItemStack.EMPTY in ItemStackTemplate format
        }

        // 4. Convert the non-empty item stack safely back into a Template
        return ItemStackTemplate.fromNonEmptyStack(remainder);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display,
                                Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("tooltip.chrismod.mortar.shift_down"));
        }else {
            builder.accept(Component.translatable("tooltip.chrismod.mortar"));
        }

        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
