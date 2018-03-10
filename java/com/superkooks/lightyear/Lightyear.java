package com.superkooks.lightyear;

import com.superkooks.lightyear.blocks.BlockPalladiumOre;
import com.superkooks.lightyear.items.ItemEmptySyringe;
import com.superkooks.lightyear.items.ItemLeviathanSyringe;
import com.superkooks.lightyear.items.ItemPalladium;
import com.superkooks.lightyear.items.ItemTalariaSyringe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = "ly", name = "Lightyear", version = "0.1")
public class Lightyear {
	// Items
	public static Item itemEmptySyringe;
	public static Item itemLeviathanSyringe;
	public static Item itemTalariaSyringe;
	
	public static Item itemPalladium;
	
	// Blocks
	public static Block blockPalladiumOre;

	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		// Item/Block Init and registering
		// Config Handling
		
		// Items
		itemEmptySyringe = new ItemEmptySyringe().setUnlocalizedName("EmptySyringe")
				.setTextureName("ly:itemEmptySyringe").setCreativeTab(tabLightyear);
		itemLeviathanSyringe = new ItemLeviathanSyringe().setUnlocalizedName("LeviathanSyringe")
				.setTextureName("ly:itemLeviathanSyringe").setCreativeTab(tabLightyear);
		itemTalariaSyringe = new ItemTalariaSyringe().setUnlocalizedName("TalariaSyringe")
				.setTextureName("ly:itemTalariaSyringe").setCreativeTab(tabLightyear);
		
		itemPalladium = new ItemPalladium().setUnlocalizedName("Palladium")
				.setTextureName("ly:itemPalladium").setCreativeTab(tabLightyear);
		
		// Blocks
		blockPalladiumOre = new BlockPalladiumOre(Material.rock).setBlockName("PalladiumOre")
				.setBlockTextureName("ly:blockPalladiumOre").setCreativeTab(tabLightyear);
		
		// Registering
		// Items
		
		GameRegistry.registerItem(itemEmptySyringe,
				itemEmptySyringe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemLeviathanSyringe,
				itemLeviathanSyringe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTalariaSyringe,
				itemTalariaSyringe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(itemPalladium,
				itemPalladium.getUnlocalizedName().substring(5));
		
		// Blocks
		GameRegistry.registerBlock(blockPalladiumOre,
				blockPalladiumOre.getUnlocalizedName().substring(5));
		
		// Recipes
		
		GameRegistry.addShapelessRecipe(new ItemStack(itemEmptySyringe), new Object[] {
				Items.iron_ingot, Items.glass_bottle
		});

	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
		// Proxy, TileEntity, Entity, GUI and Packet Registering
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		
	}
	
	public static CreativeTabs tabLightyear = new CreativeTabs("tabLightyear") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(itemLeviathanSyringe).getItem();
		}
	};
}
