package com.example.examplemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class GetItemEventHandler {

    @SubscribeEvent
    public void onGetItem(PlayerEvent.ItemPickupEvent event) {
        EntityPlayer player = event.player;
        EntityItem entityItem = event.pickedUp;
        Item item = entityItem.getEntityItem().getItem();
//
//        EntityItem entityItemCube = new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, new ItemStack(ExampleMod.itemCube, 1));
//
        Item itemCube = new ItemCube();

        if(item != itemCube) {
            return;
        }

        player.triggerAchievement(MicraGoAchievementsManager.gotchaSheep);
    }
}
