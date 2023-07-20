package net.fabric.painter.color;

import net.fabric.painter.Painter;
import net.minecraft.item.Item;
import net.minecraft.item.Items;


public class Colors
{	
	public static final Color[] colorArr = {
	// Color (String name, int lightness, Item item, int r, int g, int b)
			new Color("ink_sac", 1, Items.INK_SAC, 0x191919),
			new Color("ink_sac", 0, Items.INK_SAC, 0x151515),
			new Color("ink_sac", -1, Items.INK_SAC, 0x111111),
			new Color("ink_sac", -2, Items.INK_SAC, 0x0D0D0D),
			
			new Color("red_dye", 1, Items.RED_DYE, 0xFF0000),
			new Color("red_dye", 0, Items.RED_DYE, 0xDC0000),
			new Color("red_dye", -1, Items.RED_DYE, 0xB40000),
			new Color("red_dye", -2, Items.RED_DYE, 0x870000),
			
			new Color("green_dye", 1, Items.GREEN_DYE, 0x667F33),
			new Color("green_dye", 0, Items.GREEN_DYE, 0x586D2C),
			new Color("green_dye", -1, Items.GREEN_DYE, 0x485924),
			new Color("green_dye", -2, Items.GREEN_DYE, 0x36431B),
			
			new Color("cocoa_beans", 1, Items.COCOA_BEANS, 0x664C33),
			new Color("cocoa_beans", 0, Items.COCOA_BEANS, 0x58412C),
			new Color("cocoa_beans", -1, Items.COCOA_BEANS, 0x483524),
			new Color("cocoa_beans", -2, Items.COCOA_BEANS, 0x36281B),
			
			new Color("lapis_lazuli", 1, Items.LAPIS_LAZULI, 0x334CB2),
			new Color("lapis_lazuli", 0, Items.LAPIS_LAZULI, 0x2C4199),
			new Color("lapis_lazuli", -1, Items.LAPIS_LAZULI, 0x24357D),
			new Color("lapis_lazuli", -2, Items.LAPIS_LAZULI, 0x1B285E),
			
			new Color("purple_dye", 1, Items.PURPLE_DYE, 0x7F3FB2),
			new Color("purple_dye", 0, Items.PURPLE_DYE, 0x6D3699),
			new Color("purple_dye", -1, Items.PURPLE_DYE, 0x592C7D),
			new Color("purple_dye", -2, Items.PURPLE_DYE, 0x43215E),
			
			new Color("cyan_dye", 1, Items.CYAN_DYE, 0x4C7F99),
			new Color("cyan_dye", 0, Items.CYAN_DYE, 0x416D84),
			new Color("cyan_dye", -1, Items.CYAN_DYE, 0x35596C),
			new Color("cyan_dye", -2, Items.CYAN_DYE, 0x284351),
			
			new Color("light_gray_dye", 1, Items.LIGHT_GRAY_DYE, 0xA7A7A7),
			new Color("light_gray_dye", 0, Items.LIGHT_GRAY_DYE, 0x909090),
			new Color("light_gray_dye", -1, Items.LIGHT_GRAY_DYE, 0x757575),
			new Color("light_gray_dye", -2, Items.LIGHT_GRAY_DYE, 0x585858),
			
			new Color("gray_dye", 1, Items.GRAY_DYE, 0xA4A8B8),
			new Color("gray_dye", 0, Items.GRAY_DYE, 0x8D909E),
			new Color("gray_dye", -1, Items.GRAY_DYE, 0x737681),
			new Color("gray_dye", -2, Items.GRAY_DYE, 0x565861),
			
			new Color("pink_dye", 1, Items.PINK_DYE, 0xF27FA5),
			new Color("pink_dye", 0, Items.PINK_DYE, 0xD06D8E),
			new Color("pink_dye", -1, Items.PINK_DYE, 0xAA5974),
			new Color("pink_dye", -2, Items.PINK_DYE, 0x804357),
			
			new Color("lime_dye", 1, Items.LIME_DYE, 0x7FCC19),
			new Color("lime_dye", 0, Items.LIME_DYE, 0x6DB015),
			new Color("lime_dye", -1, Items.LIME_DYE, 0x599011),
			new Color("lime_dye", -2, Items.LIME_DYE, 0x436C0D),
			
			new Color("yellow_dye", 1, Items.YELLOW_DYE, 0xE5E533),
			new Color("yellow_dye", 0, Items.YELLOW_DYE, 0xC5C52C),
			new Color("yellow_dye", -1, Items.YELLOW_DYE, 0xA1A124),
			new Color("yellow_dye", -2, Items.YELLOW_DYE, 0x79791B),
			
			new Color("light_blue_dye", 1, Items.LIGHT_BLUE_DYE, 0x6699D8),
			new Color("light_blue_dye", 0, Items.LIGHT_BLUE_DYE, 0x5884BA),
			new Color("light_blue_dye", -1, Items.LIGHT_BLUE_DYE, 0x486C98),
			new Color("light_blue_dye", -2, Items.LIGHT_BLUE_DYE, 0x365172),
			
			new Color("magenta_dye", 1, Items.MAGENTA_DYE, 0xB24CD8),
			new Color("magenta_dye", 0, Items.MAGENTA_DYE, 0x9941BA),
			new Color("magenta_dye", -1, Items.MAGENTA_DYE, 0x7D3598),
			new Color("magenta_dye", -2, Items.MAGENTA_DYE, 0x5E2872),
			
			new Color("orange_dye", 1, Items.ORANGE_DYE, 0xD87F33),
			new Color("orange_dye", 0, Items.ORANGE_DYE, 0xB86D2C),
			new Color("orange_dye", -1, Items.ORANGE_DYE, 0x965924),
			new Color("orange_dye", -2, Items.ORANGE_DYE, 0x71431B),
			
			new Color("bone_meal", 1, Items.BONE_MEAL, 0xFFFCF5),
			new Color("bone_meal", 0, Items.BONE_MEAL, 0xDCD9D3),
			new Color("bone_meal", -1, Items.BONE_MEAL, 0xB4B1AC),
			new Color("bone_meal", -2, Items.BONE_MEAL, 0x878581),
			
			new Color("pumpkin_seeds", 1, Items.PUMPKIN_SEEDS, 0xF7E9A3),
			new Color("pumpkin_seeds", 0, Items.PUMPKIN_SEEDS, 0xD5C98C),
			new Color("pumpkin_seeds", -1, Items.PUMPKIN_SEEDS, 0xAEA473),
			new Color("pumpkin_seeds", -2, Items.PUMPKIN_SEEDS, 0x807B56),
			
			new Color("melon_seeds", 1, Items.MELON_SEEDS, 0x956D4D),
			new Color("melon_seeds", 0, Items.MELON_SEEDS, 0x825E42),
			new Color("melon_seeds", -1, Items.MELON_SEEDS, 0x6A4C36),
			new Color("melon_seeds", -2, Items.MELON_SEEDS, 0x4F3928),
			
			new Color("flint", 1, Items.FLINT, 0x4C4C4C),
			new Color("flint", 0, Items.FLINT, 0x414141),
			new Color("flint", -1, Items.FLINT, 0x353535),
			new Color("flint", -2, Items.FLINT, 0x282828),
			
			new Color("gunpowder", 1, Items.GUNPOWDER, 0x979797),
			new Color("gunpowder", 0, Items.GUNPOWDER, 0x828282),
			new Color("gunpowder", -1, Items.GUNPOWDER, 0x6B6B6B),
			new Color("gunpowder", -2, Items.GUNPOWDER, 0x505050),
			
			new Color("nether_wart", 1, Items.NETHER_WART, 0x6F0200),
			new Color("nether_wart", 0, Items.NETHER_WART, 0x5F0100),
			new Color("nether_wart", -1, Items.NETHER_WART, 0x4E0100),
			new Color("nether_wart", -2, Items.NETHER_WART, 0x3A0100),
			
			new Color("prismarine_crystals", 1, Items.PRISMARINE_CRYSTALS, 0x5BD8D5),
			new Color("prismarine_crystals", 0, Items.PRISMARINE_CRYSTALS, 0x4EBAB5),
			new Color("prismarine_crystals", -1, Items.PRISMARINE_CRYSTALS, 0x3F9896),
			new Color("prismarine_crystals", -2, Items.PRISMARINE_CRYSTALS, 0x2F7270),
			
			new Color("grass", 1, Items.GRASS, 0x7DB037),
			new Color("grass", 0, Items.GRASS, 0x6C972F),
			new Color("grass", -1, Items.GRASS, 0x587C27),
			new Color("grass", -2, Items.GRASS, 0x425D1D),
			
			new Color("gold_nugget", 1, Items.GOLD_NUGGET, 0xF7EB4D),
			new Color("gold_nugget", 0, Items.GOLD_NUGGET, 0xD4CB42),
			new Color("gold_nugget", -1, Items.GOLD_NUGGET, 0xAEA635),
			new Color("gold_nugget", -2, Items.GOLD_NUGGET, 0x827D28),
			
			new Color("cobweb", 1, Items.COBWEB, 0xC5C5C5),
			new Color("cobweb", 0, Items.COBWEB, 0xA9A9AB),
			new Color("cobweb", -1, Items.COBWEB, 0x8A8A8A),
			new Color("cobweb", -2, Items.COBWEB, 0x686869),
			
			new Color("ice", 1, Items.ICE, 0x9E9EFF),
			new Color("ice", 0, Items.ICE, 0x8888DC),
			new Color("ice", -1, Items.ICE, 0x8A8A8C),
			new Color("ice", -2, Items.ICE, 0x535387),
			
			new Color("oak_leaves", 1, Items.OAK_LEAVES, 0x007B00),
			new Color("oak_leaves", 0, Items.OAK_LEAVES, 0x006900),
			new Color("oak_leaves", -1, Items.OAK_LEAVES, 0x6F6FB4),
			new Color("oak_leaves", -2, Items.OAK_LEAVES, 0x004000),
			
			new Color("snow", 1, Items.SNOW, 0xFCFCFC),
			new Color("snow", 0, Items.SNOW, 0xD9D9D9),
			new Color("snow", -1, Items.SNOW, 0xB2B2B2),
			new Color("snow", -2, Items.SNOW, 0x858585),
			
			new Color("ghast_tear", 1, Items.GHAST_TEAR, 0x6C6B6B),
			new Color("ghast_tear", 0, Items.GHAST_TEAR, 0xD9D9DC),
			new Color("ghast_tear", -1, Items.GHAST_TEAR, 0xB2B2B4),
			new Color("ghast_tear", -2, Items.GHAST_TEAR, 0x3A3A3B),
			
			new Color("lapis_block", 1, Items.LAPIS_BLOCK, 0x3F3FFF),
			new Color("lapis_block", 0, Items.LAPIS_BLOCK, 0x3636DC),
			new Color("lapis_block", -1, Items.LAPIS_BLOCK, 0x2C2CB4),
			new Color("lapis_block", -2, Items.LAPIS_BLOCK, 0x3A3A3B),
			
			new Color("dark_oak_log", 1, Items.DARK_OAK_LOG, 0x8D7648),
			new Color("dark_oak_log", 0, Items.DARK_OAK_LOG, 0x3636D9),
			new Color("dark_oak_log", -1, Items.DARK_OAK_LOG, 0x2C2CB2),
			new Color("dark_oak_log", -2, Items.DARK_OAK_LOG, 0x212187),
			
			new Color("brick", 1, Items.BRICK, 0x973233),
			new Color("brick", 0, Items.BRICK, 0x7A653E),
			new Color("brick", -1, Items.BRICK, 0x6B2424),
			new Color("brick", -2, Items.BRICK, 0x501B1B),
			
			new Color("lapis_ore", 1, Items.LAPIS_ORE, 0x497EFF),
			new Color("lapis_ore", 0, Items.LAPIS_ORE, 0x3E6DDC),
			new Color("lapis_ore", -1, Items.LAPIS_ORE, 0x3359B4),
			new Color("lapis_ore", -2, Items.LAPIS_ORE, 0x274287),
			
			new Color("emerald", 1, Items.EMERALD, 0x00D63A),
			new Color("emerald", 0, Items.EMERALD, 0x00B932),
			new Color("emerald", -1, Items.EMERALD, 0x009727),
			new Color("emerald", -2, Items.EMERALD, 0x274287),
			
			new Color("birch_wood", 1, Items.BIRCH_WOOD, 0x7F5531),
			new Color("birch_wood", 0, Items.BIRCH_WOOD, 0x6E492A),
			new Color("birch_wood", -1, Items.BIRCH_WOOD, 0x5A3B22),
			new Color("birch_wood", -2, Items.BIRCH_WOOD, 0x00711E),
			
			new Color("egg", 1, Items.EGG, 0x7F5531),
			new Color("egg", 0, Items.EGG, 0x6E492A),
			new Color("egg", -1, Items.EGG, 0x917B71),
			new Color("egg", -2, Items.EGG, 0x6D5C55),
			
			new Color("magma_cream", 1, Items.MAGMA_CREAM, 0x9D5124),
			new Color("magma_cream", 0, Items.MAGMA_CREAM, 0x87451F),
			new Color("magma_cream", -1, Items.MAGMA_CREAM, 0x917B71),
			new Color("magma_cream", -2, Items.MAGMA_CREAM, 0x532A13),
			
			new Color("beetroot", 1, Items.BEETROOT, 0x9D5124),
			new Color("beetroot", 0, Items.BEETROOT, 0x87451F),
			new Color("beetroot", -1, Items.BEETROOT, 0x683C4C),
			new Color("beetroot", -2, Items.BEETROOT, 0x532A13),
			
			new Color("mycelium", 1, Items.MYCELIUM, 0x93566B),
			new Color("mycelium", 0, Items.MYCELIUM, 0x7E4A5D),
			new Color("mycelium", -1, Items.MYCELIUM, 0x683C4C),
			new Color("mycelium", -2, Items.MYCELIUM, 0x3A3849),
			
			new Color("glowstone_dust", 1, Items.GLOWSTONE_DUST, 0xB88324),
			new Color("glowstone_dust", 0, Items.GLOWSTONE_DUST, 0x5F5C77),
			new Color("glowstone_dust", -1, Items.GLOWSTONE_DUST, 0x4E4B61),
			new Color("glowstone_dust", -2, Items.GLOWSTONE_DUST, 0x614513),
			
			new Color("slime_ball", 1, Items.SLIME_BALL, 0x667435),
			new Color("slime_ball", 0, Items.SLIME_BALL, 0x57632D),
			new Color("slime_ball", -1, Items.SLIME_BALL, 0x475125),
			new Color("slime_ball", -2, Items.SLIME_BALL, 0x353C1C),
			
			new Color("spider_eye", 1, Items.SPIDER_EYE, 0x9E4C4D),
			new Color("spider_eye", 0, Items.SPIDER_EYE, 0x884143),
			new Color("spider_eye", -1, Items.SPIDER_EYE, 0x6F3537),
			new Color("spider_eye", -2, Items.SPIDER_EYE, 0x353C1C),
			
			new Color("soul sand", 1, Items.SOUL_SAND, 0x382823),
			new Color("soul sand", 0, Items.SOUL_SAND, 0x30231E),
			new Color("soul sand", -1, Items.SOUL_SAND, 0x271C18),
			new Color("soul sand", -2, Items.SOUL_SAND, 0x1E1512),
			
			new Color("brown_mushroom", 1, Items.BROWN_MUSHROOM, 0x856A62),
			new Color("brown_mushroom", 0, Items.BROWN_MUSHROOM, 0x735B54),
			new Color("brown_mushroom", -1, Items.BROWN_MUSHROOM, 0x271C18),
			new Color("brown_mushroom", -2, Items.BROWN_MUSHROOM, 0x463733),
			
			new Color("iron_nugget", 1, Items.IRON_NUGGET, 0x856A62),
			new Color("iron_nugget", 0, Items.IRON_NUGGET, 0x4A4E4F),
			new Color("iron_nugget", -1, Items.IRON_NUGGET, 0x3C3F40),
			new Color("iron_nugget", -2, Items.IRON_NUGGET, 0x463733),
			
			new Color("chorus_fruit", 1, Items.CHORUS_FRUIT, 0x794858),
			new Color("chorus_fruit", 0, Items.CHORUS_FRUIT, 0x683D4B),
			new Color("chorus_fruit", -1, Items.CHORUS_FRUIT, 0x55323E),
			new Color("chorus_fruit", -2, Items.CHORUS_FRUIT, 0x2D2F30),
			
			new Color("purpur_block", 1, Items.PURPUR_BLOCK, 0x4B3D5B),
			new Color("purpur_block", 0, Items.PURPUR_BLOCK, 0x40344E),
			new Color("purpur_block", -1, Items.PURPUR_BLOCK, 0x342A40),
			new Color("purpur_block", -2, Items.PURPUR_BLOCK, 0x3F262E),
			
			new Color("podzol", 1, Items.PODZOL, 0x4B3D5C),
			new Color("podzol", 0, Items.PODZOL, 0x40344F),
			new Color("podzol", -1, Items.PODZOL, 0x342318),
			new Color("podzol", -2, Items.PODZOL, 0x271A12),
			
			new Color("poisonous_potato", 1, Items.POISONOUS_POTATO, 0x4B5129),
			new Color("poisonous_potato", 0, Items.POISONOUS_POTATO, 0x402A1E),
			new Color("poisonous_potato", -1, Items.POISONOUS_POTATO, 0x342318),
			new Color("poisonous_potato", -2, Items.POISONOUS_POTATO, 0x271A12),
			
			new Color("apple", 1, Items.APPLE, 0x4B512A),
			new Color("apple", 0, Items.APPLE, 0x793227),
			new Color("apple", -1, Items.APPLE, 0x632920),
			new Color("apple", -2, Items.APPLE, 0x4A1F18),
			
			new Color("charcoal", 1, Items.CHARCOAL, 0x251610),
			new Color("charcoal", 0, Items.CHARCOAL, 0x1F120D),
			new Color("charcoal", -1, Items.CHARCOAL, 0x632920),
			new Color("charcoal", -2, Items.CHARCOAL, 0x4A1F18),
			
			new Color("crimson_nylium", 1, Items.CRIMSON_NYLIUM, 0x251610),
			new Color("crimson_nylium", 0, Items.CRIMSON_NYLIUM, 0xA1282A),
			new Color("crimson_nylium", -1, Items.CRIMSON_NYLIUM, 0x1A0F0B),
			new Color("crimson_nylium", -2, Items.CRIMSON_NYLIUM, 0x130B08),
			
			new Color("crimson_stem", 1, Items.CRIMSON_STEM, 0xBB2F31),
			new Color("crimson_stem", 0, Items.CRIMSON_STEM, 0xA1282A),
			new Color("crimson_stem", -1, Items.CRIMSON_STEM, 0x672B44),
			new Color("crimson_stem", -2, Items.CRIMSON_STEM, 0x631919),
			
			new Color("crimson_hyphae", 1, Items.CRIMSON_HYPHAE, 0x5B191D),
			new Color("crimson_hyphae", 0, Items.CRIMSON_HYPHAE, 0x7D3553),
			new Color("crimson_hyphae", -1, Items.CRIMSON_HYPHAE, 0x672B43),
			new Color("crimson_hyphae", -2, Items.CRIMSON_HYPHAE, 0x4D2133),
			
			new Color("warped_nylium", 1, Items.WARPED_NYLIUM, 0x5B191D),
			new Color("warped_nylium", 0, Items.WARPED_NYLIUM, 0x4E1519),
			new Color("warped_nylium", -1, Items.WARPED_NYLIUM, 0x0F575E),
			new Color("warped_nylium", -2, Items.WARPED_NYLIUM, 0x2F0D0F),
			
			new Color("warped_stem", 1, Items.WARPED_STEM, 0x167D86),
			new Color("warped_stem", 0, Items.WARPED_STEM, 0x126B73),
			new Color("warped_stem", -1, Items.WARPED_STEM, 0x0F575D),
			new Color("warped_stem", -2, Items.WARPED_STEM, 0x0B4146),
			
			new Color("warped_hyphae", 1, Items.WARPED_HYPHAE, 0x552B3E),
			new Color("warped_hyphae", 0, Items.WARPED_HYPHAE, 0x492535),
			new Color("warped_hyphae", -1, Items.WARPED_HYPHAE, 0x3B1F2A),
			new Color("warped_hyphae", -2, Items.WARPED_HYPHAE, 0x2C1720),
			
			new Color("warped_wart_block", 1, Items.WARPED_WART_BLOCK, 0x14B285),
			new Color("warped_wart_block", 0, Items.WARPED_WART_BLOCK, 0x119972),
			new Color("warped_wart_block", -1, Items.WARPED_WART_BLOCK, 0x0E7D5D),
			new Color("warped_wart_block", -2, Items.WARPED_WART_BLOCK, 0x0A5E46),
			
			new Color("cobbled_deepslate", 1, Items.COBBLED_DEEPSLATE, 0x636364),
			new Color("cobbled_deepslate", 0, Items.COBBLED_DEEPSLATE, 0x555556),
			new Color("cobbled_deepslate", -1, Items.COBBLED_DEEPSLATE, 0x454546),
			new Color("cobbled_deepslate", -2, Items.COBBLED_DEEPSLATE, 0x333334),
			
			new Color("raw_iron", 1, Items.RAW_IRON, 0xD5AD93),
			new Color("raw_iron", 0, Items.RAW_IRON, 0xB8947E),
			new Color("raw_iron", -1, Items.RAW_IRON, 0x967A67),
			new Color("raw_iron", -2, Items.RAW_IRON, 0x715B4D),
			
			new Color("glow_lichen", 1, Items.GLOW_LICHEN, 0x7DA596),
			new Color("glow_lichen", 0, Items.GLOW_LICHEN, 0x6C8E81),
			new Color("glow_lichen", -1, Items.GLOW_LICHEN, 0x587469),
			new Color("glow_lichen", -2, Items.GLOW_LICHEN, 0x42574F),
	};
	
	public static final Item COAL = Items.COAL;
	public static final Item FEATHER = Items.FEATHER;
	
	/*
	 * get the color object by name, returns null if not found, ignores case
	 */
	public static Color getColorByName(String name)
	{
		for (int i = 0; i < colorArr.length; i++)
		{
			if (colorArr[i].name.equalsIgnoreCase(name))
				return colorArr[i];
		}
		
		return null;
	}
	
	/*
	 * Converts the given rgb values to the closest dye
	 */
	public static Color RGBToColor(int r, int g, int b)
	{
		// get euclidean distance from given color and all colors in the array
		// keep track of the closest one and use that
		
		double minDiff = Integer.MAX_VALUE;
		int minIndex = 0;
		
		for (int i = 0; i < colorArr.length; i++)
		{
			double diff = Math.sqrt(
					Math.pow(Math.abs(colorArr[i].r) - Math.abs(r), 2) +
					Math.pow(Math.abs(colorArr[i].g) - Math.abs(g), 2) +
					Math.pow(Math.abs(colorArr[i].b) - Math.abs(b), 2)
				);
				
			if (diff < minDiff)
			{
				minDiff = diff;
				minIndex = i;
			}
		}
		
		
		
		return colorArr[minIndex];
	}
	
	public static Color HexToColor(int hex)
	{
		int r = hex >>> 16 & 255;
		int g = hex >>> 8 & 255;
		int b = hex >>> 0 & 255;
		
		return RGBToColor(r,g,b);
	}
	
	
	public static Color fromString(String s)
	{
		if (s.length() < 3)
			return null;
		
		int lightness = Integer.parseInt(s.substring(s.length() - 1)) - 2;
		String name = s.substring(0, s.length() - 1);
		
		for (int i = 0; i < colorArr.length; i++)
		{
			if (colorArr[i].name.equalsIgnoreCase(name) && colorArr[i].lightness == lightness)
				return colorArr[i];
		}
		
		return null;
	}
}