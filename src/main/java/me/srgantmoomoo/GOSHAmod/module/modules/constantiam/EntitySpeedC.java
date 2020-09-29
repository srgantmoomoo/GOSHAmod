package me.srgantmoomoo.GOSHAmod.module.modules.constantiam;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.GOSHAmod.module.Category;
import me.srgantmoomoo.GOSHAmod.module.Module;

public class EntitySpeedC extends Module {

	public EntitySpeedC() {
		super ("EntitySpeed", "makes u go faster on any entity", "(con)", Category.CONSTANTIAM);
		this.setKey(Keyboard.KEY_NONE);
	 }

}
