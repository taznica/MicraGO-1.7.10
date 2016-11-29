package com.example.examplemod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    public static final CreativeTabs tabGo = new TabGo("tabGo");

    public static final Item itemCube = new ItemCube();

    public static final Block blockCubeOre = new BlockCubeOre();
    public static final Item itemCubeIngot = new ItemCubeIngot();


    @EventHandler
    public void init(FMLInitializationEvent event) {
        registerCube();
        registerMaterials();
    }

    public void registerCube() {
        GameRegistry.registerItem(itemCube, "itemCube");
        EntityRegistry.registerModEntity(EntityCube.class, "entityCube", EntityRegistry.findGlobalUniqueEntityId(), this, 10, 10, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityCube.class, new RenderCube(itemCube));
    }

    public void registerMaterials() {
        GameRegistry.registerBlock(blockCubeOre, "blockCubeOre");
        GameRegistry.registerItem(itemCubeIngot, "itemCubeIngot");
    }
}
