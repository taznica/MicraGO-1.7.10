package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCube extends EntityThrowable {

    public EntityCube(World world) {
        super(world);
    }

    public EntityCube(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public EntityCube(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if(movingObjectPosition.entityHit == null) {
            return;
        }

        if(worldObj.isRemote){
            return;
        }

        Entity target = movingObjectPosition.entityHit;
//        target.entityDropItem()

        for(int i = 0; i < 20; i++) {
            worldObj.spawnParticle("magicCrit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        target.setDead();
        this.setDead();
    }



}
