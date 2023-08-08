package net.fabric.painter.gui.widgets;

import java.awt.image.BufferedImage;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;

public class WImage extends WWidget {
	
	private BufferedImage image;
	
	
	@Override
	public boolean canResize()
	{
		return true;
	}
	
	@Environment(EnvType.CLIENT)
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
	{
		ScreenDrawing.coloredRect(null, 1, 1, 1, 1, 1);
	}
	
	public void setImage(BufferedImage image)
	{
		
	}
}
