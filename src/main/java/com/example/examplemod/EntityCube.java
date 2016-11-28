package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
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
    protected void entityInit() {
        this.dataWatcher.addObject(8, (byte) 0);
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

    public void setMeta(byte meta) {
        dataWatcher.updateObject(8, meta);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        if(tagCompound.hasKey("meta")) {
            dataWatcher.updateObject(8, tagCompound.getByte("meta"));
        }
        else {
            dataWatcher.updateObject(8, (byte) 0);
        }
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setByte("meta", dataWatcher.getWatchableObjectByte(8));
    }

}
