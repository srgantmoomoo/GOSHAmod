package me.srgantmoomoo.GOSHAmod.module.modules.goshamods;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Category;
import me.srgantmoomoo.GOSHAmod.module.Module;

public class SprintG extends Module{
	
	public SprintG() {
		super ("Sprint", "sprints when holding w", "", Category.GOSHA);
		this.setKey(Keyboard.KEY_NONE);
	 }

}
