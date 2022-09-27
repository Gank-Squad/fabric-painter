package net.fabric.painter.actions.inventory;

import net.fabric.painter.Painter;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;

public class ShiftInv 
{
	// move index1 to the spot of index2 & vice versa
	public static void swap(int index1, int index2)
	{
		if (Painter.mc.player.getInventory().getStack(index1) != ItemStack.EMPTY)
		{
			// pick up item in index1
			Painter.mc.interactionManager.clickSlot(Painter.mc.player.playerScreenHandler.syncId, index1, 0, SlotActionType.PICKUP, Painter.mc.player);
			
			boolean move = Painter.mc.player.getInventory().getStack(index2) == ItemStack.EMPTY;
			
			// move it to target spot / pick up index2
			Painter.mc.interactionManager.clickSlot(Painter.mc.player.playerScreenHandler.syncId, index2, 0, SlotActionType.PICKUP, Painter.mc.player);
			
			if (move)
			{
				// if there was an item in index2 move it to where index1 was
				Painter.mc.interactionManager.clickSlot(Painter.mc.player.playerScreenHandler.syncId, index1, 0, SlotActionType.PICKUP, Painter.mc.player);
			}
		}
		else if (Painter.mc.player.getInventory().getStack(index2) != ItemStack.EMPTY)
		{
			// pick up index2
			Painter.mc.interactionManager.clickSlot(Painter.mc.player.playerScreenHandler.syncId, index2, 0, SlotActionType.PICKUP, Painter.mc.player);
			
			boolean move = Painter.mc.player.getInventory().getStack(index1) == ItemStack.EMPTY;
			
			// place index2 on index1
			Painter.mc.interactionManager.clickSlot(Painter.mc.player.playerScreenHandler.syncId, index1, 0, SlotActionType.PICKUP, Painter.mc.player);
			
			if (move)
			{
				// if there was an item in index1 move it to where index2 was
				Painter.mc.interactionManager.clickSlot(Painter.mc.player.playerScreenHandler.syncId, index2, 0, SlotActionType.PICKUP, Painter.mc.player);
			}
		}
		
		
		Painter.LOGGER.info("swapped");
	}
	
	
	
}
