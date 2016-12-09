package com.example.examplemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.ArrayList;

public class EntityDropsEventHandler {

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {

        Entity target = event.entity;
        DamageSource source = event.source;
        ArrayList<EntityItem> items = event.drops;
        Entity player = source.getEntity();

        ItemStack itemStack = new ItemStack(ExampleMod.itemCube, 1);
        EntityItem entityItemCube = new EntityItem(target.worldObj, target.posX, target.posY, target.posZ, itemStack);
        Entity sheep = new EntitySheep(target.worldObj);

        if (player == null) {
            return;
        }

        if(target != sheep) {
            return;
        }

        for (EntityItem entityItem : items) {
            if (entityItem == entityItemCube) {
                ((EntityPlayer)player).triggerAchievement(MicraGoAchievementsManager.gotchaSheep);
            }
        }
    }
}
