package net.fabric.painter.fileio;

public class InstBlock 
{
	public int index;
	public int color;
	public boolean click;
	public static final boolean clickRight = true;
	public static final boolean clickLeft = false;
	
	public InstBlock(int index, int color, boolean click)
	{
		this.index = index;
		this.color = color;
		this.click = click;
	}
}
