package me.skunky.soulinfusion.loader;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class itemLoader {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Soulinfusion.MOD_ID, name), item);
    }

    public static void init() {
        Soulinfusion.LOG.info("Registering Items");
    }
}
