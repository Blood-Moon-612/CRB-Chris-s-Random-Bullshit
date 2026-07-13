package net.chris.chrismod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import org.jspecify.annotations.Nullable;

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
}
