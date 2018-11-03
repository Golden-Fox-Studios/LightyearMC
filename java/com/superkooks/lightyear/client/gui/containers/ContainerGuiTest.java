package com.superkooks.lightyear.client.gui.containers;

import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGuiTest extends Container {
	private TileEntityCentrifuge tileEntity;

	private int slotID = 0;
	
	public ContainerGuiTest(EntityPlayer player, TileEntityCentrifuge tileEntity) {
		this.tileEntity = tileEntity;
		//Storage
        for (int i = 0; i < 2; i++)
        {
            addSlotToContainer(new Slot(tileEntity, slotID++, 44, 17 + i * 18));
            System.out.println(slotID);
        }
 
        //Inventory
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        // Hotbar
        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
    }
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotRaw)
    {
        ItemStack stack = null;
        Slot slot = (Slot)inventorySlots.get(slotRaw);
 
        if (slot != null && slot.getHasStack())
        {
            ItemStack stackInSlot = slot.getStack();
            stack = stackInSlot.copy();
 
            if (slotRaw < 3 * 9)
            {
                if (!mergeItemStack(stackInSlot, 3 * 9, inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(stackInSlot, 0, 3 * 9, false))
            {
                return null;
            }
 
            if (stackInSlot.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return stack;
    }
	
	@Override
    public boolean canInteractWith(EntityPlayer var1)
    {
        return this.tileEntity.isUseableByPlayer(var1);
    }
}	