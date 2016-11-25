package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabGo extends CreativeTabs {
    public TabGo(String tabName) {
        super(tabName);
    }

    @Override
    public Item getTabIconItem() {
        return ExampleMod.itemCube;
    }
}
