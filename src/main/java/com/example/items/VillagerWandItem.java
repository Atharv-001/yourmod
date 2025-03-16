package com.villager_wand_mod.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class VillagerWandItem extends Item {
    public VillagerWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return ActionResult.PASS; // Prevent block placement behavior
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            // Perform ray tracing to get the target position
            HitResult hitResult = player.raycast(50, 0, false);
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                Vec3d targetPos = hitResult.getPos();

                // Spawn 3 instant-exploding TNT at the exact position
                for (int i = 0; i < 3; i++) {
                    TntEntity tnt = new TntEntity(EntityType.TNT, world);
                    tnt.setPosition(targetPos.x + (i * 0.2), targetPos.y, targetPos.z + (i * 0.2));
                    tnt.setFuse(0); 
                    world.spawnEntity(tnt);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
