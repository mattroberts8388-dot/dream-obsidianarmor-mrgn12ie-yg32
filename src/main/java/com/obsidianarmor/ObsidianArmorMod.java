package com.obsidianarmor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ObsidianArmorMod implements ModInitializer {
    public static final String MOD_ID = "obsidianarmor";

    public static final Item OBSIDIAN_INGOT = new Item(new Item.Settings());

    public static final Item OBSIDIAN_HELMET =
            new ObsidianArmorItem(ObsidianArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item OBSIDIAN_CHESTPLATE =
            new ObsidianArmorItem(ObsidianArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item OBSIDIAN_LEGGINGS =
            new ObsidianArmorItem(ObsidianArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item OBSIDIAN_BOOTS =
            new ObsidianArmorItem(ObsidianArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    @Override
    public void onInitialize() {
        register("obsidian_ingot", OBSIDIAN_INGOT);
        register("obsidian_helmet", OBSIDIAN_HELMET);
        register("obsidian_chestplate", OBSIDIAN_CHESTPLATE);
        register("obsidian_leggings", OBSIDIAN_LEGGINGS);
        register("obsidian_boots", OBSIDIAN_BOOTS);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.NETHERITE_INGOT, OBSIDIAN_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(OBSIDIAN_HELMET);
            entries.add(OBSIDIAN_CHESTPLATE);
            entries.add(OBSIDIAN_LEGGINGS);
            entries.add(OBSIDIAN_BOOTS);
        });
    }

    private static void register(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }
}