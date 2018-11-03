package com.superkooks.lightyear.tiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCentrifuge extends TileEntity {
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) 
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
    }
    
    @Override
    public void writeToNBT(NBTTagCompound var1) {
    	
    }
    
    @Override
    public void readFromNBT(NBTTagCompound var1) {
    	
    }
}
