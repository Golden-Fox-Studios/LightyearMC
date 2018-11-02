package com.superkooks.lightyear.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockStratomiteOre extends Block {

	public BlockStratomiteOre(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 4);
	}
}
