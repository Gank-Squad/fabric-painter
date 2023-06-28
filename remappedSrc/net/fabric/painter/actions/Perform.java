package net.fabric.painter.actions;

import net.fabric.painter.Painter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;

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
	
	public static boolean startUse()
	{
		// Painter.mc.interactionManager.interactItem(Painter.mc.player, Painter.mc.player.getActiveHand());
		
		Painter.mc.player.getMainHandStack().useOnEntity(Painter.mc.player, (LivingEntity) Painter.mc.targetedEntity, Painter.mc.player.getActiveHand());
		return false;
	}
	
	public static boolean stopUse()
	{
		Painter.mc.interactionManager.stopUsingItem(Painter.mc.player);
		
		
		return false;
	}
}
