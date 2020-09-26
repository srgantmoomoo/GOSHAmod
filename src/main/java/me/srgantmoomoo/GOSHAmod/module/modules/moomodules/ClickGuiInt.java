package me.srgantmoomoo.GOSHAmod.module.modules.moomodules;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Category;
import me.srgantmoomoo.GOSHAmod.module.Module;

public class ClickGuiInt extends Module {

	public ClickGuiInt() {
		super("clickGui", "clicky clacky suck my assy", Category.MODULES);
		this.setKey(Keyboard.KEY_G);
	}

}
