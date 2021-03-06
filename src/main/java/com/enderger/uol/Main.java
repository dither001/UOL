package com.enderger.uol;

//Imports
import com.enderger.uol.init.RecipeInit;
import com.enderger.uol.proxy.CommonProxy;
import com.enderger.uol.tabs.UolTab;
import com.enderger.uol.util.Reference;
import com.enderger.uol.util.compat.OreDictionaryCompat;
import com.enderger.uol.util.handelers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
    public static final CreativeTabs uoltab = new UolTab("uoltab");

    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.otherRegistries();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        RecipeInit.init();
        OreDictionaryCompat.registerOres();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}
}
