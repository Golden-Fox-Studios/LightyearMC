package com.superkooks.lightyear.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

public class WeaponShockBaton extends Item
{
    public WeaponShockBaton()
    {
        setMaxStackSize(1);
        setMaxDamage(6);
    }
    
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase wielder) {
        Vec3 look = wielder.getLookVec().normalize();
        double knockback = 0.5;
        target.addVelocity(look.xCoord*knockback, look.yCoord*knockback, look.zCoord*knockback);

        return true;
    }
}