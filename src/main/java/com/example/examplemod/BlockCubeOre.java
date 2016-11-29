package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockCubeOre extends Block {
    public BlockCubeOre(){
        super(Material.rock);
        setBlockName(ExampleMod.MODID + "_blockCubeOre");
        setBlockTextureName(ExampleMod.MODID + ":blockCubeOre");
        setCreativeTab(ExampleMod.tabGo);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
    {
        if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
        {
            return MathHelper.getRandomIntegerInRange(rand, 0, 2);
        }

        return 0;
    }
}
