package me.srgantmoomoo.GOSHAmod.ui;

import java.awt.Color;
import java.util.List;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Category;
import me.srgantmoomoo.GOSHAmod.module.Module;
import me.srgantmoomoo.GOSHAmod.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class TabGui extends Module {
	
	public int currentTab;
	public boolean expanded;
	public boolean Tab;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public TabGui() {
		super ("tabGui", "cloocky clocky", Category.MODULES);
		this.setKey(Keyboard.KEY_NONE);
		toggled = true;
	}
	
	@SubscribeEvent
    public void onRender(RenderGameOverlayEvent event) {
		if (!event.getType().equals(event.getType().TEXT)) {
			return;
		}
		FontRenderer fr = mc.fontRenderer;
		if(Tab) {
			
			//Category category = Category.values()[currentTab];
			//List<Module> modules = ModuleManager.getModulesByCategory(category);
			
			//Module module = modules.get(category.moduleIndex);
			fr.drawStringWithShadow("tab", 1, 10, 0xffffff);
			
			fr.drawStringWithShadow(">", 19, 10, 0xffffffff);
			
			float hue = (System.currentTimeMillis() % 5000) / 5000f;
			int color = Color.HSBtoRGB(hue, (float) 0.3, 1);
			int color2 = 0xffFFB6C1;
			int color3 = 0xfffffacd;
			
			Gui.drawRect(1, 20, 69, 76, 0x80000000);
			Gui.drawRect(2, 22 + currentTab * 14 - 1, 68, 22 + currentTab * 14 + 11, 0xffb5651d);
			//border
			Gui.drawRect(0, 19, 70, 20, 0xffffffff); // top
			Gui.drawRect(0, 77, 70, 76, 0xffffffff); // bottom
			Gui.drawRect(0, 19, 1, 76, 0xffffffff); // left
			Gui.drawRect(69, 20, 70, 76, 0xffffffff); // right
			
			int count = 0;
			for(Category c : Category.values()) {
				if(!c.name.equals("moo render"))
					if(!c.name.equals("moo client"))
				fr.drawStringWithShadow(c.name, 4, 23 + count * 14, 0xffffffff);
			
				count++;
			}
				
		}else {
			fr.drawStringWithShadow("<", 19, 10, 0xffffffff);
			fr.drawStringWithShadow("tab", 1, 10, 0xffffff);
		}
	if(expanded) {
		Category category = Category.values()[currentTab];
		List<Module> modules = ModuleManager.getModulesByCategory(category);
		int count = 0;
		if (modules.size() == 0)
			return;
			Gui.drawRect(72, 20, 140, 20 + modules.size() * 14 , 0x80000000);
			Gui.drawRect(73, 22 + category.moduleIndex * 14 - 1, 139, 22 + category.moduleIndex * 14 + 11, 0xffb5651d);
			
			//border
			Gui.drawRect(71, 19, 141, 20, 0xffffffff); // top
			Gui.drawRect(71, 63, 141, 62, 0xffffffff); // bottom
			Gui.drawRect(71, 19, 72, 62, 0xffffffff); // left
			Gui.drawRect(140, 20, 141, 62, 0xffffffff); // right
			
			count = 0;
			for(Module m : modules) {
				fr.drawStringWithShadow(m.getName(), 4 + 72, 23 + count * 14, -1);
				if(m.toggled) 
					Gui.drawRect(72, 21 + count * 14, 73, 33 + count * 14, 0xffffffff);
				fr.drawStringWithShadow(m.getName(), 4 + 72, 23 + count * 14, -1);
				count++;
					}
				}
			}
		@SubscribeEvent
		public void key(KeyInputEvent e) {

		Category category = Category.values()[currentTab];
		List<Module> modules = ModuleManager.getModulesByCategory(category);
		if(Keyboard.getEventKeyState()) {
			int keyCode = Keyboard.getEventKey();
		
		if(keyCode == Keyboard.KEY_UP) {
			if(expanded) {
				if(category.moduleIndex <= 0) {
					category.moduleIndex = modules.size() - 1;
				}else
					category.moduleIndex--;
			}else {
				if(category.name.equals("moo modules")) {
					if(currentTab >= Category.values().length - 1) {
						currentTab = 3;
						}else
							currentTab = 3;
				}else {
				if(currentTab <= 0) {
					currentTab = Category.values().length - 1;
				}else
					currentTab--;
				}
			}
		}
		
		if(keyCode == Keyboard.KEY_DOWN) {
			Tab = true;
			if (expanded) {
				if(category.moduleIndex >= modules.size() - 1) {
					category.moduleIndex = 0;
					}else
						category.moduleIndex++;
			}else {
				if(category.name.equals("anarchy.bar")) {
					if(currentTab >= Category.values().length - 1) {
						currentTab = 0;
						}else
							currentTab = 0;
				}else {
				if(currentTab >= Category.values().length - 1) {
					currentTab = 0;
					}else
						currentTab++;
				}
			}
		}
		
		if(keyCode == Keyboard.KEY_RIGHT) {
			if(expanded && modules.size() !=0) {
				Module module = modules.get(category.moduleIndex);
				if(!module.getName().equals("tabGui"))
					module.toggle();
			}else {
				expanded = true;
			
	
		}
		}
		
		if(keyCode == Keyboard.KEY_LEFT) {
			expanded = false;
		}
		
		if(keyCode == Keyboard.KEY_RCONTROL) {
			Tab = false;
			expanded = false;
				}
			}
		}
}