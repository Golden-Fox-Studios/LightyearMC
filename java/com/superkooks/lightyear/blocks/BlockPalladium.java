package com.superkooks.lightyear.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPalladium extends Block {

	public BlockPalladium(Material material) {
		super(material);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
}
