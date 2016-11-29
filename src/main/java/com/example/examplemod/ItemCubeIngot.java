package com.example.examplemod;

import net.minecraft.item.Item;

public class ItemCubeIngot extends Item {
    public ItemCubeIngot() {
        super();
        setUnlocalizedName(ExampleMod.MODID + "_itemCubeIngot");
        setTextureName(ExampleMod.MODID + ":itemCubeIngot");
        setCreativeTab(ExampleMod.tabGo);
    }
}
