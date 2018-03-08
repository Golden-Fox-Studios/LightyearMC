package com.superkooks.lightyear;

import java.lang.reflect.Field;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "ly", name = "Lightyear", version = "0.1")
public class Lightyear {
	// Items
	public static Item itemEmptySyringe;
	public static Item itemLeviathanSyringe;
	public static Item itemTalariaSyringe;
	
	// Blocks

	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		// Item/Block Init and registering
		// Config Handling
		
		// Items
		itemEmptySyringe = new ItemEmptySyringe().setUnlocalizedName("EmptySyringe")
				.setTextureName("ly:itemEmptySyringe");
		itemLeviathanSyringe = new ItemLeviathanSyringe().setUnlocalizedName("LeviathanSyringe")
				.setTextureName("ly:itemLeviathanSyringe");
		itemTalariaSyringe = new ItemTalariaSyringe().setUnlocalizedName("TalariaSyringe")
				.setTextureName("ly:itemTalariaSyringe");
		
		// Blocks
		
		GameRegistry.registerItem(itemEmptySyringe,
				itemEmptySyringe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemLeviathanSyringe,
				itemLeviathanSyringe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTalariaSyringe,
				itemTalariaSyringe.getUnlocalizedName().substring(5));
		
	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
		// Proxy, TileEntity, Entity, GUI and Packet Registering
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		
	}
}
