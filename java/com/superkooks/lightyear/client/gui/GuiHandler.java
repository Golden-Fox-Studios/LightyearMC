package com.superkooks.lightyear.client.gui;

import com.superkooks.lightyear.client.gui.containers.ContainerCentrifuge;
import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		
		switch (ID) {
			case GuiIds.centrifugeId:
				if (tile instanceof TileEntityCentrifuge) {
					return new ContainerCentrifuge(player, (TileEntityCentrifuge) tile);
				}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		
		switch (ID) {
			case GuiIds.centrifugeId:
				if (tile instanceof TileEntityCentrifuge) {
					return new GuiCentrifuge((TileEntityCentrifuge) tile, player);
				}
		}
		
		return null;
	}
}
