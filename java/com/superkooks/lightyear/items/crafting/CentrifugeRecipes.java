package com.superkooks.lightyear.items.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.superkooks.lightyear.Lightyear;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CentrifugeRecipes {
	public static final CentrifugeRecipes centrifugeBase = new CentrifugeRecipes();
    private Map<ItemStack[], ItemStack> centrifugeList = new HashMap<ItemStack[], ItemStack>();
    
    private CentrifugeRecipes() {
    	this.addSparkSilverDust();
    }
    
    private void addSparkSilverDust() {
    	ItemStack[] input = new ItemStack[2];
    	input[0] = new ItemStack(Lightyear.itemPalladium);
    	input[1] = new ItemStack(Items.redstone);
    	centrifugeList.put(input, new ItemStack(Lightyear.itemSparksilverDust));
    }
    
    public ItemStack getCentrifugingResult(ItemStack[] input) {
    	Iterator<Entry<ItemStack[], ItemStack>> iterator = this.centrifugeList.entrySet().iterator();
    	Entry<ItemStack[], ItemStack> entry;
    	
        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry<ItemStack[], ItemStack>)iterator.next();
        }
        while (!this.func_151397_a(input, (ItemStack[])entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    private boolean func_151397_a(ItemStack[] recipeInputToMatch, ItemStack[] recipeInput)
    {
    	if (recipeInputToMatch[0].getItem() == recipeInput[0].getItem() && (recipeInputToMatch[0].getItemDamage() == 32767 || recipeInput[0].getItemDamage() == recipeInputToMatch[0].getItemDamage()) ) {
    		return recipeInputToMatch[1].getItem() == recipeInput[1].getItem() && (recipeInputToMatch[1].getItemDamage() == 32767 || recipeInput[1].getItemDamage() == recipeInputToMatch[1].getItemDamage());
    	}
    	return false;
    }
}
