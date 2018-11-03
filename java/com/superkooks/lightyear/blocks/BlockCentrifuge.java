package com.superkooks.lightyear.blocks;

import com.superkooks.lightyear.Lightyear;
import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCentrifuge extends BlockContainer {

	public BlockCentrifuge(Material material) {
		super(material);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			entityPlayer.openGui(Lightyear.instance, 0, world, x, y, z);
		}
		
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int state) {
		return new TileEntityCentrifuge();
	}
}
	