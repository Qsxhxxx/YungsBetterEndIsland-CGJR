package com.yungnickyoung.minecraft.betterendisland;

import com.yungnickyoung.minecraft.betterendisland.module.ConfigModule;
import com.yungnickyoung.minecraft.betterendisland.services.Services;
import com.yungnickyoung.minecraft.yungsapi.api.YungAutoRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterEndIslandCommon {
    public static final String MOD_ID = "betterendisland";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ConfigModule CONFIG = new ConfigModule();

    // Mod compatibility flags
    public static volatile boolean betterEnd;
    public static volatile boolean endergetic;
    public static volatile boolean moreDragonEggs;

    // 结构放置标志：本模组放置结构时设为true，跳过StructureTemplateMixin拦截
    public static final ThreadLocal<Boolean> betterendisland$placingOwn = ThreadLocal.withInitial(() -> false);

    public static void init() {
        YungAutoRegister.scanPackageForAnnotations("com.yungnickyoung.minecraft.betterendisland.module");
        Services.MODULES.loadModules();
        betterEnd = Services.PLATFORM.isModLoaded("betterend");
        endergetic = Services.PLATFORM.isModLoaded("endergetic");
        moreDragonEggs = Services.PLATFORM.isModLoaded("moredragoneggs");
    }
}
