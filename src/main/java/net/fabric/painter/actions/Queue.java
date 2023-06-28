package net.fabric.painter.actions;

import java.util.ArrayList;

import net.fabric.painter.Painter;
import net.fabric.painter.fileio.ReturnBody;
import net.fabric.painter.instructions.InstructionBlock;
import net.fabric.painter.instructions.InstructionManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;

public class Queue 
{
	private static int counter = 0;
	private static int delay = 7;
	public static int step = 0;
	public static ArrayList<InstructionBlock> instructions = null;
	
	public static InstructionManager instMan = null;
	
//	public static ReturnBody panelInstructions = null;
	
	public static void startCounter()
	{
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (Hotkeys.getToggle() && instMan == null)
			{
				client.player.sendMessage(Text.literal("Instructions missing, load instructions before trying to begin"), false);
				Hotkeys.toggle = false;
			}
			else if (instMan == null)
			{
				return;
			}
			else
			{
//				try
//				{
//					Painter.mc.player.setYaw((float)  Positions.getOrientation(Hotkeys.row, Hotkeys.col, Positions.NORTH).yaw);
//					Painter.mc.player.setPitch((float)Positions.getOrientation(Hotkeys.row, Hotkeys.col, Positions.NORTH).pitch);	
//				}
//				catch (NullPointerException e)
//				{
//					System.out.println("nullptr");
//				}
//				catch(Exception e)
//				{
//					System.out.println("some other error");
//				}

				if (Painter.mc == null || Painter.mc.player == null || Painter.mc.player.getInventory() == null)
					return;
				
				if (instMan == null)
					return;
				
				if (instructions == null)
				{
					instructions = instMan.getNextStep(Painter.mc.player.getInventory());
				}
				
				if (instructions == null)
				{
					return;
				}
				
				if (Hotkeys.toggle == false)
					return;
//				if (Hotkeys.toggle == true)
//					return;
				counter++;
				counter = counter % delay;
				
				if (counter == 0)
				{
					if (step >= instructions.size())
					{
						step = 0;
						instructions = instMan.getNextStep(Painter.mc.player.getInventory());
					}
					
					// have run out of instructions
					if (instructions == null)
					{
						client.player.sendMessage(Text.literal("No more instructions"), false);
						Hotkeys.toggle = false;
						instMan = null;
						return;
					}
					
					Perform.doInstruction(instructions.get(step));
					
					step++;
				}
			}
				
	
		});
	}
	
}
