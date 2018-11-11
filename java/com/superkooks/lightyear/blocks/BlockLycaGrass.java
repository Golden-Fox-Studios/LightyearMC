package com.superkooks.lightyear.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockLycaGrass extends Block {
	private IIcon topIcon;
	private IIcon sideIcon;
	private IIcon bottomIcon;
	
	public BlockLycaGrass(Material material) {
		super(material);
	}
	
	@Override
    public void registerBlockIcons(IIconRegister reg)
    {
        sideIcon = reg.registerIcon("ly:blockLycaGrass");
        topIcon = reg.registerIcon("ly:blockLycaGrass_top");
        bottomIcon = reg.registerIcon("ly:blockLycaGrass_bottom");
    }
 
    @Override
    public IIcon getIcon(int side, int meta)
    {
    	if (side == 1) return topIcon;
    	if (side == 0) return bottomIcon;
        return sideIcon;
    }
}
