package com.example;

import com.example.items.VillagerWandItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item VILLAGER_WAND = new VillagerWandItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("modid", "villager_wand"), VILLAGER_WAND);
    }
}
