package net.fabric.painter.fileio;

import java.util.ArrayList;
import java.util.HashMap;

import net.fabric.painter.color.Color;
import net.fabric.painter.instructions.Point;

public class ReturnBody
{
	public Color[][] colors;
	public HashMap<Color, ArrayList<Point>> colorMap;
	
	ReturnBody(Color[][] colors, HashMap<Color, ArrayList<Point>> colorMap)
	{
		this.colors = colors;
		this.colorMap = colorMap;
	}
	
	ReturnBody()
	{
		this.colors = new Color[32][32];
		this.colorMap = new HashMap<Color, ArrayList<Point>>();
	}
}