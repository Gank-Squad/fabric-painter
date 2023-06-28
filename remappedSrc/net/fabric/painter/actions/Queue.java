package net.fabric.painter.actions;

import java.util.ArrayList;

import net.fabric.painter.Painter;
import net.fabric.painter.actions.inventory.ShiftInv;
import net.fabric.painter.fileio.FileIN;
import net.fabric.painter.fileio.InstBlock;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class Queue 
{
	private static int counter = 0;
	private static int delay = 6;
	public static int step = 0;
	private static boolean toggle = false;
	public static ArrayList<InstBlock> instructions = null;
	
	public static void startCounter()
	{
		instructions = new ArrayList<InstBlock>();
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (Hotkeys.getToggle() && instructions != null)
			{
				counter++;
				counter = counter % delay;
				
				if (counter == 0)
				{
					toggle = !toggle;
					Painter.LOGGER.info(Integer.toString(step));
					// ShiftInv.swap(36, 16);
					// Painter.mc.player.isRiding();
					if (toggle)
					{
						Perform.startUse();
					}
					else
					{
						Perform.stopUse();
					}
					
					step++;
				}
			}
				
	
		});
	}
	
}
