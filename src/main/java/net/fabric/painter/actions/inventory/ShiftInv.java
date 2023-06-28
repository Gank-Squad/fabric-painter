package net.fabric.painter.actions.inventory;

import net.fabric.painter.Painter;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;

public class ShiftInv 
{
	
	/*
	 * Takes the item you want in your active hand as a parameter
	 * searches inventory for that item, if it finds it, it moves it to the current main hand slot
	 * or, if the item is in the hotbar, it swaps to that slot instead of moving item
	 */
	public static boolean setItemInActiveHand(Item item)
	{
		int index = Painter.mc.player.getInventory().indexOf(item.getDefaultStack());
		
		// not in inventory
		if (index == -1)
			return false;
		
		// already selected, do nothing
		if (index == Painter.mc.player.getInventory().selectedSlot)
			return true;
		
		// swap active hand
		if (index < 9)
		{
			// item is in hotbar, so change active slot to that
			Painter.mc.player.getInventory().selectedSlot = index;
			return true;
		}
		
		//otherwise, swap slots
		Painter.mc.interactionManager.pickFromInventory(index);
		
		return true;
	}
}
