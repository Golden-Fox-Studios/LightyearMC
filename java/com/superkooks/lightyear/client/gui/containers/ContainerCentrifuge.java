package com.superkooks.lightyear.client.gui.containers;

import com.superkooks.lightyear.tiles.TileEntityCentrifuge;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCentrifuge extends Container {
	private TileEntityCentrifuge tileEntity;

	private int slotID = 0;
	
	private int lastProgress = 0;	
	
	public ContainerCentrifuge(EntityPlayer player, TileEntityCentrifuge tileEntity) {
		this.tileEntity = tileEntity;
		//Storage
        for (int i = 0; i < 2; i++)
        {
            addSlotToContainer(new Slot(tileEntity, slotID++, 44 + i, 17));
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
	
	public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastProgress != this.tileEntity.progress)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.progress);
            }
        }
    }
        
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_)
    {
        if (p_75137_1_ == 0)
        {
            this.tileEntity.progress = p_75137_2_;
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