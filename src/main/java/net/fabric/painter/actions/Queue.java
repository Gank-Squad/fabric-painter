package net.fabric.painter.actions;

import java.util.ArrayList;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm;

import net.fabric.painter.Painter;
import net.fabric.painter.color.Colors;
import net.fabric.painter.fileio.ReturnBody;
import net.fabric.painter.instructions.InstructionBlock;
import net.fabric.painter.instructions.InstructionManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class Queue 
{
	private static int counter = 3;
	public static int delay = 8;
	public static int step = 0;
	public static ArrayList<InstructionBlock> instructions = null;
	
	public static Vec3d position = null;
	private static boolean longDelay = false;
	
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
			else if (Painter.mc == null || Painter.mc.player == null || Painter.mc.player.getInventory() == null || instMan == null)
			{
				return;
			}
			else if (Painter.mc.player.getVehicle() == null)
			{
				client.player.sendMessage(Text.literal("not sitting, sit at easel before trying to paint"), false);
				Hotkeys.toggle = false;
			}
			else if (!Painter.mc.player.getPos().equals(position) && Painter.mc.player.getPos() != null)
			{
				client.player.sendMessage(Text.literal("no longer in same position, stopping"), false);
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
				counter = counter % (longDelay ? (int)(delay * 3) : delay);
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
					
					
					// make the delay longer if changing dyes
					// reasoning is that messing this up could potentially require a very large chunk of the painting
					// to be repainted
					if (instructions.size() > 1)
					{
						longDelay = true;
					}
					else
					{
						longDelay = false;
					}
					
//					Perform.doInstruction(instructions.get(step));
					Perform.doMoveInstruction(instructions.get(step));
					
					if (instructions.get(step).isNoClick())
						step++;
					
				}
				// basically wait a tick and do the 2nd half of an action
				else if (counter == 2)
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
					
					if (instructions.size() > 1)
					{
						longDelay = true;
					}
					else
					{
						longDelay = false;
					}
					
//					Perform.doInstruction(instructions.get(step));
					Perform.doClickInstruction(instructions.get(step));
					
					if (!instructions.get(step).isNoClick())
						step++;
				}
			}
		});
	}
	
}
