package me.skunky.soulinfusion.loader;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class itemLoader {
    static final ItemGroup GROUP = Soulinfusion.SOUL_INFUSION;

    public static final Item CRYSTAL = registerItem("crystal", new Item(new FabricItemSettings().group(GROUP)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Soulinfusion.MOD_ID, name), item);
    }

    public static void init() {
        Soulinfusion.LOG.info("Registering Items");
    }
}
