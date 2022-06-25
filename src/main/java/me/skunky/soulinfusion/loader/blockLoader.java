package me.skunky.soulinfusion.loader;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class blockLoader {

    public static final Block CRYSTAL_ORE = registerBlock("crystal_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4F).requiresTool()));
    public static final Block CRYSTAL_ORE_DEEPSLATE = registerBlock("crystal_ore_deepslate", new Block(FabricBlockSettings.of(Material.STONE).strength(4F).requiresTool()));
    public static final Block CRYSTAL_ORE_NETHERRACK = registerBlock("crystal_ore_netherrack", new Block(FabricBlockSettings.of(Material.STONE).strength(4F).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(Soulinfusion.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(Soulinfusion.SOUL_INFUSION)));
        return Registry.register(Registry.BLOCK, new Identifier(Soulinfusion.MOD_ID, name), block);
    }

    public static void init() {
        Soulinfusion.LOG.info("Registering Blocks");
    }
}
