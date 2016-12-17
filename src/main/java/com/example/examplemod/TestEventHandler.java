package com.example.examplemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class TestEventHandler {

    @SubscribeEvent
    public void onTest(PlayerInteractEvent event) {

        EntityPlayer player = event.entityPlayer;
        PlayerInteractEvent.Action action = event.action;
        int x = event.x;
        int y = event.y;
        int z = event.z;

        if(event.world.isRemote) {
            return;
        }

        if(action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if(event.world.getBlock(x, y, z) != Blocks.stone) {
            return;
        }

        player.triggerAchievement(MicraGoAchievementsManager.gotchaSheep);


    }
}
