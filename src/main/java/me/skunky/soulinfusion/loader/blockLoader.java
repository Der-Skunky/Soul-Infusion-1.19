package me.skunky.soulinfusion.loader;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class blockLoader {

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(Soulinfusion.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(Soulinfusion.SOUL_INFUSION)));
        return Registry.register(Registry.BLOCK, new Identifier(Soulinfusion.MOD_ID, name), block);
    }

    public static void init() {
        Soulinfusion.LOG.info("Registering Blocks");
    }
}
