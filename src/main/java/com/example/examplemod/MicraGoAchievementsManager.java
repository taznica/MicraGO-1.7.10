package com.example.examplemod;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MicraGoAchievementsManager {

    public static Achievement gotchaSheep = (new Achievement("gotchaSheep", "You gotcha sheep!", 1, 1, new ItemStack(Items.spawn_egg), null)).registerStat();
    public static Achievement gotchaCow = (new Achievement("gotchaCow", "You gotcha cow!", 1, 2, new ItemStack(Items.spawn_egg), null)).registerStat();

    public static Achievement[] achievementsList = new Achievement[]{
            gotchaSheep,
            gotchaCow
    };

    public static AchievementPage achievementPageMicraGo = new AchievementPage("MicraGo", achievementsList);


    public void init() {}
}
