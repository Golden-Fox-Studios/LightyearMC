package com.superkooks.lightyear.client.gui;

import org.lwjgl.opengl.GL11;

import com.superkooks.lightyear.client.gui.containers.ContainerCentrifuge;
import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCentrifuge extends GuiContainer {
	private ResourceLocation texture = new ResourceLocation("ly", "textures/gui/guiCentrifuge.png");
	
	private InventoryPlayer inventory;
	private TileEntityCentrifuge te;
	
	public GuiCentrifuge(TileEntityCentrifuge te, EntityPlayer player) {
		super(new ContainerCentrifuge(player, te));
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
        
        int i1 = this.te.getProgressScaled(47);
        this.drawTexturedModalRect(x + 64, y + 40, 176, 36, i1 + 1, 5);
    }
 
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRendererObj.drawString(I18n.format(te.getInventoryName()), (xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(te.getInventoryName())) / 2), 6, 4210752, false);
        fontRendererObj.drawString(I18n.format(inventory.getInventoryName()), 8, ySize - 96 + 2, 4210752);
    }
}
