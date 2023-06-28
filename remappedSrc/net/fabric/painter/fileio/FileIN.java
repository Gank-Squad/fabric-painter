package net.fabric.painter.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIN 
{
	public static ArrayList<InstBlock> fromFile()
	{
		ArrayList<InstBlock> ret = new ArrayList<InstBlock>();
		
		File directoryPath = new File(System.getProperty("user.dir"));
		String list[] = directoryPath.list();
		String path = "";
		for (int i = 0; i < list.length; i++)
		{
			if (list[i].toLowerCase().endsWith(".mcpaint"))
			{
				path = list[i];
			}
		}
		
		if (path.isEmpty())
			return ret;
		
		// iterate through file and append each thing to ret
		
		InputStream is = null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			return ret;
		}
		
		try (Scanner sc = new Scanner(is, StandardCharsets.UTF_8.name()))
		{
			while (sc.hasNextLine())
			{
				ret.add(strToInstBlock(sc.nextLine()));
			}
		}
		
		return ret;
		
		
	}
	
	private static InstBlock strToInstBlock(String str)
	{
		int[] ints = {0,0};
		String[] str2 = str.split(" ");
		boolean click = false;
		try
		{
			ints[0] = Integer.parseInt(str2[0]);
			ints[1] = Integer.parseInt(str2[1]);
			click = str2[2].equals("r");
		}
		finally
		{
			
		}
		
		return new InstBlock(ints[0],ints[1], click);
	}
	
}
