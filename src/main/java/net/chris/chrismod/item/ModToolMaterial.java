package net.chris.chrismod.item;

import net.chris.chrismod.tags.ModTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterial {
    public static final ToolMaterial RUBY = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL,
            850, 7f, 2.5f, 12, ModTags.Items.RUBY_REPAIR);

    public static final ToolMaterial SAPPHIRE = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_SAPPHIRE_TOOL,
            1150, 7.5f, 2.75f, 14, ModTags.Items.SAPPHIRE_REPAIR);

    public static final ToolMaterial STEEL = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            550, 6.5f, 2.25f, 12, ModTags.Items.STEEL_REPAIR);

}
