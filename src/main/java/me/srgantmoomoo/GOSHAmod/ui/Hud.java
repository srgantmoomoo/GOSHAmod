package me.srgantmoomoo.GOSHAmod.ui;
import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import me.srgantmoomoo.GOSHAmod.Main;
import me.srgantmoomoo.GOSHAmod.module.Module;
import me.srgantmoomoo.GOSHAmod.module.ModuleManager;
import me.srgantmoomoo.GOSHAmod.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends Gui {
	 
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<Module> {
		
		@Override
		public int compare(Module arg0, Module arg1) {
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return 1;
			}
			return 0;
		}
	}
	
	private final ResourceLocation watermark = new ResourceLocation(Refrence.MOD_ID, "textures/watermark.png");
	private final int tex_width = 156, tex_height = 118, logo_width = 10, logo_height = 10;
	    
	public int currentTab;
	
		@SubscribeEvent
	    public void renderOverlay(RenderGameOverlayEvent event) {
			
		Collections.sort(Main.moduleManager.modules, new ModuleComparator());
			
		float hue = (System.currentTimeMillis() % 5000) / 5000f;
		int color = Color.HSBtoRGB(hue, (float) 0.3, 1);
		int color2 = 0xffffB6C1;
		int color3 = 0xfffffacd;
		
		ScaledResolution sr = new ScaledResolution(mc);
	    FontRenderer fr = mc.fontRenderer;
	    
	    		if(event.getType() == RenderGameOverlayEvent.ElementType.BOSSHEALTH) {
	    			mc.renderEngine.bindTexture(watermark);
	    			drawScaledCustomSizeModalRect(-2, -20, 0, 0, 60, 60, 60, 60, 60, 60);
	    		}
	    
	    		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
	    			//Gui.drawRect(52, 0, 77, 10, 0x80000000);
	            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
	    			//fr.drawStringWithShadow("GOSHA", 1, 1, 0xffffff); //0xffffff
	            
	            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
	            	//fr.drawStringWithShadow("mod", 32, 1, 0xff5cb3ff);
	            
	            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
	            	final int[] counter = {1};
	    			fr.drawStringWithShadow(Refrence.VERSION, 56, 1, 0xff5cb3ff); //0xffffff 
	            }
	            
	            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
	    			int y = 2;
	    			final int[] counter = {1};
	    			for (Module mod : Main.moduleManager.getModuleList()) {
	    				if (!mod.getName().equalsIgnoreCase("TabGui") && mod.isToggled()) {
	    				fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName() + mod.getModCat()) - 2, y, rainbow(counter[0] * 300));
	    				fr.drawStringWithShadow(mod.getModCat(), sr.getScaledWidth() - fr.getStringWidth(mod.getModCat()) - 1, y, 0xffa9a9a9);
	    				y += fr.FONT_HEIGHT;
	    				counter[0]++;
	    				}
	    			}
	            }
	   }
	   public static int rainbow(int delay) {
		   double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
		   rainbowState %= -360;
	       return Color.getHSBColor((float) (rainbowState / -360.0f), 0.5f, 1f).getRGB();
	}
}
	//darker blue - 0xff157DEC
	//gosha red - 0xffe60000
	//gosha blue - 0xff5cb3ff
	//brown - 0xffb5651d
	//peach - 0xffffc3b1
	//nice yellow - 0xfffffacd
	//grey - 0xff808080
