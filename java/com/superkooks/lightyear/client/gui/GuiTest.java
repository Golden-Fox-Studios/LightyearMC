package com.superkooks.lightyear.client.gui;

import org.lwjgl.opengl.GL11;

import com.superkooks.lightyear.client.gui.containers.ContainerGuiTest;
import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiTest extends GuiContainer {
	private ResourceLocation texture = new ResourceLocation("ly", "textures/gui/testGui.png");
	
	private InventoryPlayer inventory;
	private TileEntityCentrifuge te;
	
	public GuiTest(TileEntityCentrifuge te, EntityPlayer player) {
		super(new ContainerGuiTest(player, te));
		inventory = player.inventory;
		this.te = te;
	}
	
	@Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
 
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
 
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
 
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
 
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRendererObj.drawString(I18n.format(te.getInventoryName()), (xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(te.getInventoryName())) / 2), 6, 4210752, false);
        fontRendererObj.drawString(I18n.format(inventory.getInventoryName()), 8, ySize - 96 + 2, 4210752);
    }
}
