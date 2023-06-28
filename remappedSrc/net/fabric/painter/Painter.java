package net.fabric.painter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.fabric.painter.actions.Hotkeys;
import net.fabric.painter.actions.Queue;

public class Painter implements ModInitializer
{
	public static final String modID = "painter";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(modID);
	
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	
	public static final Hotkeys hotkeys = new Hotkeys();
	
	@Override
	public void onInitialize() {
		LOGGER.info("initializing painter");
		LOGGER.info("a\n a\n a\n a\n a\n a\n \n\n\n\n\n\n\n\n\n\n\n\n\naaaa");
		
		LOGGER.info(mc.getName());
		
		hotkeys.listen();
		Queue.startCounter();
		
		
	}
	
}
