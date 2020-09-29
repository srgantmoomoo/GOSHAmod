package me.srgantmoomoo.GOSHAmod.module.modules.anarchybar;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Category;
import me.srgantmoomoo.GOSHAmod.module.Module;

public class EntitySpeedA extends Module {
	
		public EntitySpeedA() {
			super ("EntitySpeed", "makes u go faster on any entity", "(.bar)", Category.ANARCHYBAR);
			this.setKey(Keyboard.KEY_NONE);
		 }

	}
