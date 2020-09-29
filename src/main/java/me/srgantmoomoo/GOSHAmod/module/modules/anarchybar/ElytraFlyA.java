package me.srgantmoomoo.GOSHAmod.module.modules.anarchybar;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Category;
import me.srgantmoomoo.GOSHAmod.module.Module;

public class ElytraFlyA extends Module {
	
		public ElytraFlyA() {
			super ("ElytraFly", "fly when using elytra", "(.bar)", Category.ANARCHYBAR);
			this.setKey(Keyboard.KEY_NONE);
		 }

	}
