package com.superkooks.lightyear.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.superkooks.lightyear.Lightyear;
import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCentrifuge extends BlockContainer {

    private final Random rand = new Random();
    
    private IIcon frontIcon;
    private IIcon sideIcon;
	
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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
            int d = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            switch (d)
            {
            case 0:
                    world.setBlockMetadataWithNotify(x, y, z, 2, 2);
                    break;
            case 1:
                    world.setBlockMetadataWithNotify(x, y, z, 3, 2);
                    break;
            case 2:
                    world.setBlockMetadataWithNotify(x, y, z, 0, 2);
                    break;
            case 3:
                    world.setBlockMetadataWithNotify(x, y, z, 1, 2);
                    break;
            }
    }
	
	@Override
    public void registerBlockIcons(IIconRegister reg)
    {
        sideIcon = reg.registerIcon("ly:blockCentrifuge_side");
        frontIcon = reg.registerIcon("ly:blockCentrifuge_front");
    }
 
    @Override
    public IIcon getIcon(int side, int meta)
    {
    	if (side == 1) return frontIcon;
        return sideIcon;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int state) {
		return new TileEntityCentrifuge();
	}
}
	