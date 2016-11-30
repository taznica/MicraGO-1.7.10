package com.example.examplemod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemCube extends Item {

    private IIcon[] iIcon = new IIcon[3];

    public ItemCube() {
        super();
        setUnlocalizedName(ExampleMod.MODID + "_itemCube");
        setTextureName(ExampleMod.MODID + ":itemCube");
        setCreativeTab(ExampleMod.tabGo);
        setHasSubtypes(true);
        setMaxDamage(3);
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

    public IIcon getIconForEntity(EntityCube entityCube) {
        // アイテムと同じアイコンを使う
        // 別のテクスチャを使う場合はregisterIconsで登録したアイコンを返す
        return getIconFromDamage(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIconRegister) {
        for(int i = 0; i < 3; i++) {
            this.iIcon[i] = iIconRegister.registerIcon(this.getIconString()+ "_i");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return iIcon[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for(int i = 0; i < 3; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "_" + itemStack.getItemDamage();
    }
}
