package me.srgantmoomoo.GOSHAmod.module;

import java.util.ArrayList;
import java.util.List;

import me.srgantmoomoo.GOSHAmod.Main;
import me.srgantmoomoo.GOSHAmod.module.modules.moomodules.ClickGuiInt;
import me.srgantmoomoo.GOSHAmod.module.modules.moomodules.Sprint;
import me.srgantmoomoo.GOSHAmod.ui.TabGui;

public class ModuleManager {

	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		this.modules.add(new TabGui());
		this.modules.add(new Sprint());
		this.modules.add(new ClickGuiInt());
		
	}
	
	public Module getModule (String name) {
		for (Module m : this.modules ) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public static List<Module> getModulesByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Main.moduleManager.modules ) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	}
}
