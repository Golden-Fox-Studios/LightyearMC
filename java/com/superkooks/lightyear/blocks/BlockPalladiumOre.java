package com.superkooks.lightyear.blocks;

import java.util.Random;

import com.superkooks.lightyear.Lightyear;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockPalladiumOre extends Block {

	public BlockPalladiumOre(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return Lightyear.itemPalladiumShard;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return rand.nextInt(3) + 1; // Drop at least 1, or up to 3, nextInt is exlusive
	}
	
}
