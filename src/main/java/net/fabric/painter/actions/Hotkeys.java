package net.fabric.painter.actions;

import org.lwjgl.glfw.GLFW;

import net.fabric.painter.Painter;
import net.fabric.painter.gui.GuiBase;
import net.fabric.painter.gui.GuiScreen;
import net.fabric.painter.instructions.InstructionBlock;
import net.fabric.painter.instructions.Point;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

public class Hotkeys 
{
	private static KeyBinding startstop;
	private static KeyBinding openGUI;
	
	private static KeyBinding right;
	private static KeyBinding left;
	private static KeyBinding up;
	private static KeyBinding down;
	
	public static int row = 0;
	public static int col = 0;
	
	public static boolean toggle = false;
//	private ArrayList<String> orientations = new ArrayList<String>();
	
	public Hotkeys()
	{
		startstop = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Start Painting",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_I,
				"Painter"
				));
			
		openGUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Stop Painting",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_O,
				"Painter"
				));
		
		right = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"increments col by 1",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_RIGHT,
				"Painter"
				));
		
		left = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"decrement col by 1",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_LEFT,
				"Painter"
				));
		
		up = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"decrements row by 1",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_UP,
				"Painter"
				));
		
		down = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"increments row by 1",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_DOWN,
				"Painter"
				));
		
	}
	public static boolean getToggle()
	{
		return toggle;
	}

	private void updateOrientation(MinecraftClient client)
	{
		if (Queue.instMan != null)
		{
//			Perform.doInstruction(new InstructionBlock(Queue.instMan.getColorAtPoint(new Point(col,row)).item, new Point(col, row), InstructionBlock.NO_CLICK));
			Perform.doInstruction(new InstructionBlock(null, new Point(col, row), InstructionBlock.NO_CLICK));
			client.player.sendMessage(Text.literal(Queue.instMan.getColorAtPoint(new Point(col,row)).toString()), true);
		}
			
		else
		{
			Perform.doInstruction(new InstructionBlock(null, new Point(col, row), InstructionBlock.NO_CLICK));
		}
			
	}
	
	public void listen()
	{
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			
			while(left.wasPressed())
			{
				col--;
				if (col < 0)
				{
					col = 31;
				}

				updateOrientation(client);
				
			}
			while(right.wasPressed())
			{
				col++;
				if (col > 31)
				{
					col = 0;
				}

				updateOrientation(client);
			}
			while(up.wasPressed())
			{
				row--;
				if (row < 0)
				{
					row = 31;
				}

				updateOrientation(client);
			}
			while(down.wasPressed())
			{
				row++;
				if (row > 31)
				{
					row = 0;
				}

				updateOrientation(client);
			}
			
			while(startstop.wasPressed())
			{
				toggle = !toggle;
				if (toggle)
				{
					client.player.sendMessage(Text.literal("started"), false);
					Queue.position = Painter.mc.player.getPos();
				}
				else
				{
					client.player.sendMessage(Text.literal("stopped"), false);
					Queue.position = null;
					Queue.instMan.nullSponge();
				}
				
//				orientations.clear();
//				client.player.sendMessage(Text.literal("cleared"), false);
			}
			while(openGUI.wasPressed())
			{
//				// open gui
				Painter.mc.getInstance().setScreen(new GuiScreen(new GuiBase()));
			}
		});
	}
}
