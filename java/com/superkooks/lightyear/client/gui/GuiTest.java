package com.superkooks.lightyear.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiTest extends GuiScreen {
	int guiWidth = 148;
	int guiHeight = 80;
	Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation("ly", "textures/gui/testGui.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		super.drawScreen(x, y, ticks);
	}
}
