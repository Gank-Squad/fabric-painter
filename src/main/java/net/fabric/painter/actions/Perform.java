package net.fabric.painter.actions;

import net.fabric.painter.Painter;
import net.fabric.painter.actions.inventory.ShiftInv;
import net.fabric.painter.instructions.InstructionBlock;

public class Perform 
{
	public static boolean attack()
	{
		if (Painter.mc.targetedEntity != null)
		{
			Painter.mc.interactionManager.attackEntity(Painter.mc.player, Painter.mc.targetedEntity);
			return true;
		}
		
		return false;
	}
	
	/*
	 * Start using the item the player is holding on the targeted entity. 
	 * Returns true if interacts with entity, false otherwise
	 */
	public static boolean startUse()
	{
		// this one swings hand like punching, client side only
//		Painter.mc.player.swingHand(Painter.mc.player.getActiveHand());
		
		// doesn't appear to do anything
//		Painter.mc.player.interact(Painter.mc.player, Painter.mc.player.getActiveHand());
		
		// doesn't appear to do anything
//		Painter.mc.interactionManager.interactItem(Painter.mc.player, Painter.mc.player.getActiveHand());
		
		// gets entity I'm looking at
//		Painter.LOGGER.info(Painter.mc.targetedEntity.getName().toString());
		
		// client side interaction
//		Painter.mc.player.interact(Painter.mc.targetedEntity, Painter.mc.player.getActiveHand());
		
		if (Painter.mc.targetedEntity != null && Painter.mc.player != null)
		{
			Painter.mc.interactionManager.interactEntity(Painter.mc.player, Painter.mc.targetedEntity, Painter.mc.player.getActiveHand());
			return true;
		}
		
		return false;
	}
	
	public static boolean stopUse()
	{
		if (Painter.mc.player == null)
			return false;
		
		Painter.mc.interactionManager.stopUsingItem(Painter.mc.player);
		
		return true;
	}
	
	public static void doInstruction(InstructionBlock instruction)
	{
		// order: swap item, change yaw/pitch, click
		
		// null checks
		if (instruction == null)
			return;
		
		if (instruction.item != null)
			ShiftInv.setItemInActiveHand(instruction.item);
		
		if (instruction.point != null)
		{
			Painter.mc.player.setYaw((float)  Positions.getOrientation(instruction.point.y, instruction.point.x, Positions.getPlayerCardinality()).yaw);
			Painter.mc.player.setPitch((float)Positions.getOrientation(instruction.point.y, instruction.point.x, Positions.getPlayerCardinality()).pitch);
		}
		
		switch (instruction.clickType)
		{
		case InstructionBlock.LEFT_CLICK:
			attack();
			break;
		case InstructionBlock.RIGHT_CLICK:
			startUse();
			break;
		}
	}
}
