package net.fabric.painter.actions;

import org.lwjgl.glfw.GLFW;

import net.fabric.painter.Painter;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

public class Hotkeys 
{
	private static KeyBinding startstop;
	private static KeyBinding show;
	private static KeyBinding fromFile;
	private static boolean toggle = false;
	
	public Hotkeys()
	{
		startstop = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Start Painting",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_I,
				"Painter"
				));
			
		show = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Stop Painting",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_O,
				"Painter"
				));
		
		fromFile = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Load instructions from file",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_P,
				"Painter"
				));
	}
	public static boolean getToggle()
	{
		return toggle;
	}
	public void listen()
	{
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			
			while(startstop.wasPressed())
			{
				toggle = !toggle;
				if (toggle)
				{
					client.player.sendMessage(Text.literal("started"), false);
				}
				else
				{
					client.player.sendMessage(Text.literal("stopped"), false);
				}
			}
			while(show.wasPressed())
			{
				String str = "Y" + Float.toString(client.player.getYaw()) + ", P" + Float.toString(client.player.getPitch());
				client.player.sendMessage(Text.literal(str), false);
			}
			while(fromFile.wasPressed())
			{
				client.player.sendMessage(Text.literal("fromFile hotkey was pressed"), false);
			}
		});
	}
}
