package com.obsidianarmor;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

import java.util.UUID;

public class ObsidianArmorItem extends ArmorItem {
    private static final UUID[] SLOW_UUIDS = {
            UUID.fromString("a1b2c3d4-0001-4000-8000-000000000001"),
            UUID.fromString("a1b2c3d4-0002-4000-8000-000000000002"),
            UUID.fromString("a1b2c3d4-0003-4000-8000-000000000003"),
            UUID.fromString("a1b2c3d4-0004-4000-8000-000000000004")
    };

    public ObsidianArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (world.isClient()) {
            return;
        }
        if (entity instanceof LivingEntity living) {
            ItemStack equipped = living.getEquippedStack(this.getSlotType());
            if (equipped == stack) {
                // Grant fire resistance while worn, refreshed continuously.
                living.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.FIRE_RESISTANCE, 60, 0, true, false, false));
            }
        }
    }

    public EntityAttributeModifier getSlownessModifier() {
        int index = this.getType().getEquipmentSlot().getEntitySlotId();
        // Each piece slows movement by 5%.
        return new EntityAttributeModifier(
                SLOW_UUIDS[index],
                "Obsidian armor slowness",
                -0.05D,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public EntityAttribute getMovementAttribute() {
        return EntityAttributes.GENERIC_MOVEMENT_SPEED;
    }

    public EquipmentSlot getEquipmentSlot() {
        return this.getType().getEquipmentSlot();
    }
}