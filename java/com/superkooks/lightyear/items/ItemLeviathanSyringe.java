package com.superkooks.lightyear.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLeviathanSyringe extends Item {
	public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.drink;
    }
	
	public ItemStack onItemRightClick(ItemStack item, World p_77659_2_, EntityPlayer entity) {
        entity.setItemInUse(item, this.getMaxItemUseDuration(item));
        return item;
    }
	
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        return false;
    }
	
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --itemStack.stackSize;
        }

        if (!world.isRemote)
        {
            List list = new ArrayList();
            list.add(new PotionEffect(13, 6000, 0, false));
            list.add(new PotionEffect(16, 6000, 0, false));
            list.add(new PotionEffect(17, 400, 0, false));

            if (list != null)
            {
                Iterator iterator = list.iterator();

                while (iterator.hasNext())
                {
                    PotionEffect potioneffect = (PotionEffect)iterator.next();
                    player.addPotionEffect(new PotionEffect(potioneffect));
                }
            }
        }
        
		return itemStack;
    }
	
	public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 32;
    }
}
