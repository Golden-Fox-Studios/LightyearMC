package com.superkooks.lightyear.client.gui.containers;

import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerGuiTest extends Container {
	private TileEntityCentrifuge tileEntity;

	@Override
    public boolean canInteractWith(EntityPlayer var1)
    {
        return true;  //this.tileEntity.isUseableByPlayer(var1);
    }
}	