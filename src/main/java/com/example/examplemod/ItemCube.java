package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCube extends Item {
    public ItemCube() {
        super();
        setUnlocalizedName(ExampleMod.MODID + "_itemCube");
        setTextureName(ExampleMod.MODID + ":itemCube");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if(!entityPlayer.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }

        world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if(!world.isRemote) {
            EntityCube entityCube = new EntityCube(world, entityPlayer);
            world.spawnEntityInWorld(entityCube);
        }

        return itemStack;
    }
}
