package com.superkooks.lightyear.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.superkooks.lightyear.Lightyear;
import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCentrifuge extends BlockContainer {

    private final Random rand = new Random();
	
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
    public void breakBlock(World world, int x, int y, int z, Block block, int par6)
    {
        if (world.isRemote) return;
 
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
 
        TileEntity teRaw = world.getTileEntity(x, y, z);
 
        if (teRaw != null && teRaw instanceof TileEntityCentrifuge)
        {
            TileEntityCentrifuge te = (TileEntityCentrifuge) teRaw;
 
            for (int i = 0; i < te.getSizeInventory(); i++)
            {
                ItemStack stack = te.getStackInSlot(i);
 
                if (stack != null) drops.add(stack.copy());
            }
        }
 
        for (int i = 0;i < drops.size();i++)
        {
            EntityItem item = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, (ItemStack) drops.get(i));
            item.setVelocity((rand.nextDouble() - 0.5) * 0.25, rand.nextDouble() * 0.5 * 0.25, (rand.nextDouble() - 0.5) * 0.25);
            world.spawnEntityInWorld(item);
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int state) {
		return new TileEntityCentrifuge();
	}
}
	