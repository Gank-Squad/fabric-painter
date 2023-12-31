package net.fabric.painter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabric.painter.actions.Hotkeys;
import net.fabric.painter.actions.Queue;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;

public class Painter implements ModInitializer
{
	public static final String modID = "painter";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(modID);
	
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	
	public static final Hotkeys hotkeys = new Hotkeys();
	
	public static final String path = FabricLoader.getInstance().getConfigDir().toString();
	
	@Override
	public void onInitialize() {
		LOGGER.info("initializing painter");
		LOGGER.info("a\n a\n a\n a\n a\n a\n \n\n\n\n\n\n\n\n\n\n\n\n\naaaa");
		LOGGER.info(path);
		LOGGER.info(mc.getName());
		
		hotkeys.listen();
		Hotkeys.toggle = false;
		Queue.startCounter();
		
		
	}
	
}
