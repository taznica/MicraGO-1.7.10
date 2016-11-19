package com.example.examplemod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    public static final ItemCube itemCube = new ItemCube();

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerItem(itemCube, "itemCube");
        EntityRegistry.registerModEntity(EntityCube.class, "monsterball", EntityRegistry.findGlobalUniqueEntityId(), this, 10, 10, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityCube.class, new RenderCube(itemCube));
    }
}
