package me.srgantmoomoo.GOSHAmod.module.modules.goshamods;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Category;
import me.srgantmoomoo.GOSHAmod.module.Module;

public class Sprint extends Module{
	
	public Sprint() {
		super ("sprint", "Automatically Sprints When Holding W", Category.MODULES);
		this.setKey(Keyboard.KEY_M);
	 }

}
