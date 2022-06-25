package me.skunky.soulinfusion.loader;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Soulinfusion implements ModInitializer {
    public static final String MOD_ID = "soulinfusion";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);
    public static final ItemGroup SOUL_INFUSION = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "soul-infusion"), () -> new ItemStack(Items.ENDER_EYE));

    @Override
    public void onInitialize() {
        itemLoader.init();
        blockLoader.init();
    }
}
