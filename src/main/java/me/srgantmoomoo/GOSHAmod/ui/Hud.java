package me.srgantmoomoo.GOSHAmod.ui;
import java.awt.Color;

import me.srgantmoomoo.GOSHAmod.Main;
import me.srgantmoomoo.GOSHAmod.module.Module;
import me.srgantmoomoo.GOSHAmod.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends Gui {
	 
	private Minecraft mc = Minecraft.getMinecraft();
	//private final ResourceLocation bar = new ResourceLocation(Refrence.MOD_ID, resourcePathIn: "eee")
	    
	public int currentTab;
	
		@SubscribeEvent
	    public void renderOverlay(RenderGameOverlayEvent event) {
			
		float hue = (System.currentTimeMillis() % 5000) / 5000f;
		int color = Color.HSBtoRGB(hue, (float) 0.3, 1);
		int color2 = 0xffffB6C1;
		int color3 = 0xfffffacd;
		
		ScaledResolution sr = new ScaledResolution(mc);
	    FontRenderer fr = mc.fontRenderer;
	    
	    
	            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
	    			
	    			fr.drawStringWithShadow(Refrence.NAME, 1, 1, 0xffffff); //0xffffff
	    			fr.drawStringWithShadow(Refrence.VERSION, 51, 1, 0xffb5651d); //0xffffff
	    			int y = 2;
	    			for (Module mod : Main.moduleManager.getModuleList()) {
	    				if (!mod.getName().equalsIgnoreCase("HUD") && mod.isToggled()) {
	    				fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 2, y, 0xffffff);
	    				y += fr.FONT_HEIGHT;
	    	}
	    }
	}
}
	//brown - 0xffb5651d
	//peach - 0xffffc3b1
	//nice yellow - 0xfffffacd
