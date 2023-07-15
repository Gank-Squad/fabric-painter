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
	public static int delay = 7;
	public static int step = 0;
	public static ArrayList<InstructionBlock> instructions = null;
	
	public static InstructionManager instMan = null;
	
//	public static ReturnBody panelInstructions = null;
	
	public static void startCounter()
	{
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (!Hotkeys.getToggle())
			{
				return;
			}
			else if (Hotkeys.getToggle() && instMan == null)
			{
				client.player.sendMessage(Text.literal("Instructions missing, load instructions before trying to begin"), false);
				Hotkeys.toggle = false;
			}
			else
			{
				/*
				 * exit if minecraft isn't initialized,
				 * if player doesn't exist
				 * if inventory doesn't exist
				 * if there is no instruction manager
				 */
				if (Painter.mc == null || Painter.mc.player == null || Painter.mc.player.getInventory() == null || instMan == null)
					return;
				
				/*
				 * if there are no instructions BUT there is an instruction manager,
				 * get the instructions
				 */
				if (instructions == null)
				{
					instructions = instMan.getNextStep(Painter.mc.player.getInventory());
				}
				
				// if there are no more steps, return
				if (instructions == null)
				{
					client.player.sendMessage(Text.literal("No more instructions:3"), false);
					Hotkeys.toggle = false;
					instMan = null;
					return;
				}

				// not really sure why this check is here/needed unless the player tried stopping in the middle of a tick,
				// but I think this would cause an instruction to be skipped
				if (Hotkeys.toggle == false)
					return;

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
