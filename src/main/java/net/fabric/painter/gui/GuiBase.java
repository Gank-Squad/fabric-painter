package net.fabric.painter.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WDynamicLabel;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WLabeledSlider;
import io.github.cottonmc.cotton.gui.widget.WScrollPanel;
import io.github.cottonmc.cotton.gui.widget.WSlider;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import io.github.cottonmc.cotton.gui.widget.data.Axis;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabric.painter.Painter;
import net.fabric.painter.actions.Queue;
import net.fabric.painter.color.Color;
import net.fabric.painter.color.Colors;
import net.fabric.painter.fileio.ReadFromFile;
import net.fabric.painter.instructions.InstructionManager;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
//import io.github.cottonmc.cotton.gui.widget.WToggleButton;


public class GuiBase extends LightweightGuiDescription {
	
	public static WButton process = null;
	
	public static WTextField filePath = null;
	public static WButton loadFile = null;

	public static WButton panelPlus = null;
	public static WButton panelMinus = null;
	public static WButton loadInstructions = null;
	public static int panelNum = 0;
	private static int totalPanels = 0;
	
	public static WGridPanel scrollContents = null;
	public static WScrollPanel scrollPanel = null;
	
	public static String progress = "";
	
	public static WGridPanel root = null;
	
	public GuiBase()
	{
		if (this.root != null)
		{
			reRender();	
//			resetAll();
			return;
		}
		resetAll();
	}
	
	private void reRender()
	{
		// everything should stay the same
//		this.root = new WGridPanel();
		setRootPanel(root);
//	    root.setSize(420, 240);
	}
	
	private void resetScroll()
	{
		// everything should stay the same except for the scroll with dyes
		// redraw everything but reuse all their widgets, except for the scroll ones
		// those need to be redone
	}
	
	private void reset(boolean selected)
	{
		this.root = new WGridPanel();
		setRootPanel(root);
		root.setSize(420, 240);
		
		filePath = new WTextField();
		filePath.setMaxLength(512);
		filePath.setText("C:");
	    root.add(filePath, 1, 1, 7, 1);
		
//		createScrollPanel(root, scroll);
		
		progress = "";
		WDynamicLabel progressLabel = new WDynamicLabel(() -> I18n.translate("%s", progress), -1);
		progressLabel.setColor(0, 0);
		root.add(progressLabel, 11, 1, 5, 2);
		
	    
	    WButton loadImageButton = new WButton();
	    loadImageButton.setLabel(Text.literal("Process"));
	    loadImageButton.setOnClick(() ->{
	    	
			
			// attempt to process image at path
			progress = "working...";
			try
			{
				if (ReadFromFile.getOrCreateInstructions(filePath.getText(), 0) == null)
				{
					throw new Exception("unable to process given path");
				}
				progress += "finished";
			}
			catch (Exception e)
			{
				progress += "failed";
				e.printStackTrace();
			}
			
			// update totalPanels for the incremental selector
			totalPanels = ReadFromFile.getNumberOfPanels(filePath.getText());
			
		});
	    root.add(loadImageButton, 8, 1, 3,2);
	    

	    WLabel disclaimer2 = new WLabel(Text.literal("Load will load instructions, if none exist it will create them"));
	    root.add(disclaimer2, 1,5, 3,3);
	    
	    WLabel panelDisclaimer = new WLabel(Text.literal("the load button for the panel number will"));
	    panelDisclaimer.setVerticalAlignment(VerticalAlignment.BOTTOM);
	    WLabel panelDisclaimer2 = new WLabel(Text.literal("select that panels instructions to paint"));
	    root.add(panelDisclaimer, 6,6);
	    root.add(panelDisclaimer2, 6,7);
	    
	    WLabel processingDisclaimer = new WLabel(Text.literal("All image processing must be done beforehand, will convert image as is"));
	    processingDisclaimer.setVerticalAlignment(VerticalAlignment.BOTTOM);
	    root.add(processingDisclaimer, 1, 2);
	    
	    
	    createSelectedPanel(root, selected);

	    root.validate(this); 
		
	}
	
	// sets everything to the state when first gui is first opened
	private void resetAll()
	{
		reset(true);
	}
	
	private void createSelectedPanel(WGridPanel root, boolean reset)
	{
		if (reset)
		{
			panelNum = 0;
			panelPlus = new WButton();
			panelPlus.setLabel(Text.literal("+"));
			panelPlus.setOnClick(() -> {
				if (panelNum < totalPanels)
					panelNum++;
			});
			
			panelMinus = new WButton();
			panelMinus.setLabel(Text.literal("-"));
			panelMinus.setOnClick(() ->{
				if (panelNum > 0)
					panelNum--;
			});
			
			loadInstructions = new WButton();
			loadInstructions.setLabel(Text.literal("Load"));
			loadInstructions.setOnClick(() ->{
				try
				{
					// setup the instruction manager
					// need to make it throw errors, but thats an issue for later
					Queue.instMan = new InstructionManager(filePath.getText(), panelNum);
//					ReadFromFile.getOrCreateInstructions(filePath.getText(), panelNum);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			});
		}
		
		WDynamicLabel label = new WDynamicLabel(() -> I18n.translate("panel #: %d", panelNum), -1);
		label.setColor(0, 0);
		
	    root.add(label, 1, 6, 5, 2);
	    
		root.add(panelPlus, 1, 7, 1, 1);
		root.add(panelMinus, 2, 7, 1, 1);
		root.add(loadInstructions, 3, 7, 2, 1);
	}
	
	
	
	// these two functions no longer serve a purpose due to inability to update gui
	private void createScrollPanel(WGridPanel root, boolean reset)
	{
		if (reset)
		{
			this.scrollContents = new WGridPanel();
			populateScrollPanelWithSprites(filePath.getText() + "_InstructionSet\\" + panelNum + "c.csv", scrollContents);
			
			scrollPanel = new WScrollPanel(scrollContents);
			
			scrollPanel.setScrollingHorizontally(TriState.FALSE);
		    scrollPanel.setScrollingVertically(TriState.TRUE);
		    scrollPanel.setBackgroundPainter(BackgroundPainter.createColorful(0));
		}
	    
	    root.add(scrollPanel, 1,9,11,3);
	}
	

	private void populateScrollPanelWithSprites(String pathToCountCSV, WGridPanel panel)
	{
		
		File file;
		Scanner reader = null;
		int x = 0;
		int y = 0;
		
		final int width = 10;
		
		try
		{
			file = new File(pathToCountCSV);
			
			reader = new Scanner(file);
			
			
			while (reader.hasNextLine())
			{
				String data = reader.nextLine();

				// ignore any whitespace
				if (data.isBlank())
					continue;
				
				String[] tokens = data.split(",");
				
				if (tokens.length != 2)
					continue;
				
				String dye = tokens[0];
				String count = tokens[1];
				
				if (x == width)
				{
					x = 0;
					y++;
				}
				
				Color dyeColor = Colors.fromString(dye);
				
				String key = dyeColor.item.getTranslationKey();
				key = "minecraft:textures/" + key.replaceAll("[.]", "/").replaceFirst("minecraft/", "") + ".png";
				
				WSprite sprite = new WSprite(new Identifier(key));
				panel.add(sprite, x, y, 1, 1);
				
				
				WLabel label = new WLabel(Text.literal(count), 0x00FF00);
				WLabel superScript = new WLabel(Text.literal("" + dyeColor.lightness), 0);
				
				if (!Painter.mc.player.getInventory().contains(dyeColor.item.getDefaultStack()))
					label.setColor(0xFF0000);
				
				label.setHorizontalAlignment(HorizontalAlignment.RIGHT);
				label.setVerticalAlignment(VerticalAlignment.BOTTOM);
				
				superScript.setHorizontalAlignment(HorizontalAlignment.RIGHT);
				superScript.setVerticalAlignment(VerticalAlignment.TOP);
				
			    panel.add(label, x, y, 1, 1);
			    panel.add(superScript, x, y, 1, 1);
				
			    
			    
				
				x++;
			}
			
			panel.setSize(40, y * 8);
			
		}
		catch(Exception e) { e.printStackTrace(); }
		finally
		{
			if (reader != null)
				reader.close();
		}
		
	}
}
