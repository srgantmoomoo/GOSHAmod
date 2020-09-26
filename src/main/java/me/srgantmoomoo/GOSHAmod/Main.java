package me.srgantmoomoo.GOSHAmod;

import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Module;
import me.srgantmoomoo.GOSHAmod.module.ModuleManager;
import me.srgantmoomoo.GOSHAmod.proxy.CommonProxy;
import me.srgantmoomoo.GOSHAmod.ui.Hud;
import me.srgantmoomoo.GOSHAmod.ui.TabGui;
import me.srgantmoomoo.GOSHAmod.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

@Mod(modid = Refrence.MOD_ID, name = Refrence.NAME, version = Refrence.VERSION)
public class Main {
	
	public static ModuleManager moduleManager;
	public static Hud hud;
	public static TabGui tabGui;
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Refrence.CLIENT_PROXY_CLASS, serverSide = Refrence.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
		moduleManager = new ModuleManager();
		MinecraftForge.EVENT_BUS.register(instance);
		MinecraftForge.EVENT_BUS.register(new TabGui());
		MinecraftForge.EVENT_BUS.register(new Hud());
		hud = new Hud();
		tabGui = new TabGui();
	}
	
	@EventHandler
	public void PostInit (FMLPostInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public void key(KeyInputEvent e) {
		if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
			return;
		try {
			if(Keyboard.isCreated()) {
				if(Keyboard.getEventKeyState()) {
					int keyCode = Keyboard.getEventKey();
					if(keyCode <= 0)
						return;
					for(Module m : moduleManager.modules) {
						if(m.getKey() == keyCode && keyCode > 0) {
							m.toggle();
						}
					}
				}
			}
		} catch (Exception q) { q.printStackTrace(); }
	}
	
}
