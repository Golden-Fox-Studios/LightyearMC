package com.superkooks.lightyear;

import com.superkooks.lightyear.blocks.BlockCentrifuge;
import com.superkooks.lightyear.blocks.BlockPalladium;
import com.superkooks.lightyear.blocks.BlockPalladiumOre;
import com.superkooks.lightyear.blocks.BlockStratomiteOre;
import com.superkooks.lightyear.client.gui.GuiHandler;
import com.superkooks.lightyear.items.ItemEmptySyringe;
import com.superkooks.lightyear.items.ItemLeviathanSyringe;
import com.superkooks.lightyear.items.ItemNovite;
import com.superkooks.lightyear.items.ItemPalladiumShard;
import com.superkooks.lightyear.items.ItemReinforcedLeather;
import com.superkooks.lightyear.items.ItemSparksilverDust;
import com.superkooks.lightyear.items.ItemSparksilverIngot;
import com.superkooks.lightyear.items.ItemStratomiteIngot;
import com.superkooks.lightyear.items.ItemTalariaSyringe;
import com.superkooks.lightyear.items.WeaponShockBaton;
import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = "Lightyear", name = "Lightyear", version = "0.1")
public class Lightyear {
	@Instance("Lightyear")
	public static Lightyear instance;
	
	// Items
	public static Item itemEmptySyringe;
	public static Item itemLeviathanSyringe;
	public static Item itemTalariaSyringe;
	
	public static Item itemPalladiumShard;
	public static Item itemNovite;
	public static Item itemReinforcedLeather;
	public static Item itemSparksilverDust;
	public static Item itemSparksilverIngot;
	public static Item itemStratomiteIngot;
	
	// Weapons
	public static Item weaponShockBaton;
	
	// Blocks
	public static Block blockPalladiumOre;
	public static Block blockPalladium;
	public static Block blockStratomiteOre;
	
	// Machines
	public static Block blockCentrifuge;

	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		// Item/Block Init and registering
		// Config Handling
		
		//
		// Items
		itemEmptySyringe = new ItemEmptySyringe().setUnlocalizedName("EmptySyringe")
				.setTextureName("ly:itemEmptySyringe").setCreativeTab(tabLightyear);
		itemLeviathanSyringe = new ItemLeviathanSyringe().setUnlocalizedName("LeviathanSyringe")
				.setTextureName("ly:itemLeviathanSyringe").setCreativeTab(tabLightyear);
		itemTalariaSyringe = new ItemTalariaSyringe().setUnlocalizedName("TalariaSyringe")
				.setTextureName("ly:itemTalariaSyringe").setCreativeTab(tabLightyear);
		
		
		itemPalladiumShard = new ItemPalladiumShard().setUnlocalizedName("PalladiumShard")
				.setTextureName("ly:itemPalladiumShard").setCreativeTab(tabLightyear);
		itemNovite = new ItemNovite().setUnlocalizedName("Novite")
				.setTextureName("ly:itemNovite").setCreativeTab(tabLightyear);
		itemReinforcedLeather = new ItemReinforcedLeather().setUnlocalizedName("ReinforcedLeather")
				.setTextureName("ly:itemReinforcedLeather").setCreativeTab(tabLightyear);
		itemSparksilverDust = new ItemSparksilverDust().setUnlocalizedName("SparksilverDust")
				.setTextureName("ly:itemSparksilverDust").setCreativeTab(tabLightyear);
		itemSparksilverIngot = new ItemSparksilverIngot().setUnlocalizedName("SparksilverIngot")
				.setTextureName("ly:itemSparksilverIngot").setCreativeTab(tabLightyear);
		itemStratomiteIngot = new ItemStratomiteIngot().setUnlocalizedName("StratomiteIngot")
				.setTextureName("ly:itemStratomiteIngot").setCreativeTab(tabLightyear);
		
		// Weapons
		weaponShockBaton = new WeaponShockBaton().setUnlocalizedName("ShockBaton")
				.setTextureName("ly:weaponShockBaton").setCreativeTab(tabLightyear);
		
		//
		// Blocks
		blockPalladiumOre = new BlockPalladiumOre(Material.rock).setBlockName("PalladiumOre")
				.setBlockTextureName("ly:blockPalladiumOre").setCreativeTab(tabLightyear);
		blockPalladium = new BlockPalladium(Material.rock).setBlockName("PalladiumBlock")
				.setBlockTextureName("ly:blockPalladium").setCreativeTab(tabLightyear);
		blockStratomiteOre = new BlockStratomiteOre(Material.rock).setBlockName("StratomiteOre")
				.setBlockTextureName("ly:blockStratomiteOre").setCreativeTab(tabLightyear);
		
		//
		// Machines
		blockCentrifuge = new BlockCentrifuge(Material.rock).setBlockName("Centrifuge")
				.setBlockTextureName("ly:blockCentrifuge").setCreativeTab(tabLightyear);
		
		//
		// Registering
		GameRegistry.registerWorldGenerator(new PalladiumGeneration(), 0);
		
		
		// Items
		GameRegistry.registerItem(itemEmptySyringe,
				itemEmptySyringe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemLeviathanSyringe,
				itemLeviathanSyringe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTalariaSyringe,
				itemTalariaSyringe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(itemPalladiumShard,
				itemPalladiumShard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemNovite,
				itemNovite.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemReinforcedLeather,
				itemReinforcedLeather.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSparksilverDust,
				itemSparksilverDust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSparksilverIngot,
				itemSparksilverIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemStratomiteIngot,
				itemStratomiteIngot.getUnlocalizedName().substring(5));
		
		// Weapons
		GameRegistry.registerItem(weaponShockBaton,
				weaponShockBaton.getUnlocalizedName().substring(5));
		
	
		// Blocks
		GameRegistry.registerBlock(blockPalladiumOre,
				blockPalladiumOre.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPalladium,
				blockPalladium.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStratomiteOre,
				blockStratomiteOre.getUnlocalizedName().substring(5));
		
		// Machines
		GameRegistry.registerBlock(blockCentrifuge,
				blockCentrifuge.getUnlocalizedName().substring(5));
		
		// Tile Entities
		GameRegistry.registerTileEntity(TileEntityCentrifuge.class, "ly:tileEntityCentrifuge");
		
		//
		// Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(itemEmptySyringe), new Object[] {
				Items.iron_ingot, Items.glass_bottle
		});
		GameRegistry.addShapelessRecipe(new ItemStack(itemPalladiumShard, 9), new Object[] {
				Lightyear.blockPalladium
		});
		GameRegistry.addShapedRecipe(new ItemStack(blockPalladium), "XXX", "XXX", "XXX", 'X', itemPalladiumShard);
	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
		// Proxy, TileEntity, Entity, GUI and Packet Registering
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
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
