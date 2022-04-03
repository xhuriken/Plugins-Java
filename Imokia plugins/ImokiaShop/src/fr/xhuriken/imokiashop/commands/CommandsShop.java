package fr.xhuriken.imokiashop.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class CommandsShop implements CommandExecutor{

	
	public static Inventory shopMenu = Bukkit.createInventory(null, 54, "§eImokia§bShop");
	public static Inventory shopMenuBlocks = Bukkit.createInventory(null, 54, "§eImokia§bShop§4 > §bBlocks");
	public static Inventory shopMenuLoots = Bukkit.createInventory(null, 54, "§eImokia§bShop§4 > §bLoots");
	public static Inventory shopMenuNourritures = Bukkit.createInventory(null, 54, "§eImokia§bShop§4 > §bNourritures");
	public static Inventory shopMenuMinerais = Bukkit.createInventory(null, 54, "§eImokia§bShop§4 > §bMinerais");

	public void creation(Inventory inv, Integer i, String name, String texte, String soustexte, org.bukkit.Material material, int a, byte b) {
		ItemStack objet = new ItemStack(material, a , (byte)b);
		ItemMeta meta = objet.getItemMeta();
		meta.setDisplayName("§4"+name);
		meta.setLore(Arrays.asList(texte ,soustexte));
		objet.setItemMeta(meta);
		inv.setItem(i, objet);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
	
		
		if(sender instanceof Player) {
			
			if(cmd.getName().equalsIgnoreCase("shop")) {
				Player player = (Player) sender;
				
				
				
				
				
				ItemStack Vide = new ItemStack(Material.STAINED_GLASS_PANE);
				ItemMeta VideM = Vide.getItemMeta();
				VideM.setDisplayName(" ");
				VideM.setLore(Arrays.asList(" "));
				
				
				//menu

				Vide.setItemMeta(VideM);
				for(int i = 0; i <= 53; i++) {
					shopMenu.setItem(i, Vide);
					}

				creation(shopMenu, 20, "Blocks","Tu trouveras ici,","Tout les blocks principaux !", Material.GRASS, 1, (byte)0);
				creation(shopMenu, 21, "Loots","Tu trouveras ici,","Tout les loots des monstres disponibles !", Material.SPIDER_EYE, 1, (byte)0);
				creation(shopMenu, 22, "Nourritures","Tu trouveras ici,","Toute la nourriture essentielle !", Material.COOKED_BEEF, 1, (byte)0);
				creation(shopMenu, 23, "Divers","Tu trouveras ici,","Plein de chose diverses !", Material.BED, 1, (byte)0);
				creation(shopMenu, 24, "Minerais","Tu trouveras ici,","Tout les minerais !", Material.DIAMOND, 1, (byte)0);
				creation(shopMenu, 30, "Potions","Tu trouveras ici,","Toute les Potions !", Material.BREWING_STAND_ITEM, 1, (byte)0);
				creation(shopMenu, 31, "Redstones","Tu trouveras ici,","Tout pour faire de la redstones !", Material.REDSTONE, 1, (byte)0);
				creation(shopMenu, 32, "Spawners","Tu trouveras ici,","Tout les spawners!", Material.MOB_SPAWNER, 1, (byte)0);
				creation(shopMenu, 40, "Culture","Tu trouveras ici,","Toute les cultures!", Material.WHEAT, 1, (byte)0);
				
				
				player.openInventory(shopMenu);
				
				
				//block

				Vide.setItemMeta(VideM);
				for(int i = 0; i <= 53; i++) {
					shopMenuBlocks.setItem(i, Vide);
					}
				
				
				
				creation(shopMenuBlocks, 10, "De l'herbes","Tu en veux?","§eSeulement à §b1$ !", Material.GRASS, 1, (byte)0);
				creation(shopMenuBlocks, 11, "De la terres","Tu en veux?","§eSeulement à §b1$ !", Material.DIRT, 1, (byte)0);
				creation(shopMenuBlocks, 12, "Du sables des âmes","Tu en veux?","§eSeulement à §b1$ !", Material.SOUL_SAND, 1, (byte)0);
				creation(shopMenuBlocks, 13, "De la pierres","Tu en veux?","§eSeulement à §b1$ !", Material.COBBLESTONE, 1, (byte)0);
				creation(shopMenuBlocks, 14, "De la roches","Tu en veux?","§eSeulement à §b1$ !", Material.STONE, 1, (byte)0);
				creation(shopMenuBlocks, 15, "Du granites","Tu en veux?","§eSeulement à §b1$ !", Material.STONE, 1, (byte)1);
				creation(shopMenuBlocks, 16, "De la diorites","Tu en veux?","§eSeulement à §b1$ !", Material.STONE, 1, (byte)3);
				creation(shopMenuBlocks, 19, "De l'andesites","Tu en veux?","§eSeulement à §b1$ !", Material.STONE, 1, (byte)5);
				creation(shopMenuBlocks, 20, "Du bois de chênes","Tu en veux?","§eSeulement à §b1$ !", Material.LOG, 1, (byte)0);
				creation(shopMenuBlocks, 21, "Du bois de chênes noire","Tu en veux?","§eSeulement à §b1$ !", Material.LOG, 1, (byte)1);
				creation(shopMenuBlocks, 22, "Du bois de sapin","Tu en veux?","§eSeulement à §b1$ !", Material.LOG_2, 1, (byte)1);
				creation(shopMenuBlocks, 23, "Du bois de bouleau","Tu en veux?","§eSeulement à §b1$ !", Material.LOG, 1, (byte)2);
				creation(shopMenuBlocks, 24, "Du bois de jungle","Tu en veux?","§eSeulement à §b1$ !", Material.LOG, 1, (byte)3);
				creation(shopMenuBlocks, 25, "Du bois d'acacia","Tu en veux?","§eSeulement à §b1$ !", Material.LOG_2, 1, (byte)0);
				creation(shopMenuBlocks, 28, "De la glace","Tu en veux?","§eSeulement à §b1$ !", Material.ICE, 1, (byte)0);
				creation(shopMenuBlocks, 29, "Du la galce compacte","Tu en veux?","§eSeulement à §b1$ !", Material.PACKED_ICE, 1, (byte)0);
				creation(shopMenuBlocks, 30, "Du sable","Tu en veux?","§eSeulement à §b1$ !", Material.SAND, 1, (byte)0);
				creation(shopMenuBlocks, 31, "De l'argile","Tu en veux?","§eSeulement à §b1$ !", Material.CLAY, 1, (byte)0);
				creation(shopMenuBlocks, 32, "Du grès","Tu en veux?","§eSeulement à §b1$ !", Material.SANDSTONE, 1, (byte)0);
				creation(shopMenuBlocks, 32, "Du gravier","Tu en veux?","§eSeulement à §b1$ !", Material.GRAVEL, 1, (byte)0);
				creation(shopMenuBlocks, 33, "De l'obsidiene","Tu en veux?","§eSeulement à §b1$ !", Material.OBSIDIAN, 1, (byte)0);
				creation(shopMenuBlocks, 34, "De la tèrres cuites","Tu en veux?","§eSeulement à §b1$ !", Material.STAINED_CLAY, 1, (byte)0);
				
				//loots
				Vide.setItemMeta(VideM);
				for(int i = 0; i <= 53; i++) {
					shopMenuLoots.setItem(i, Vide);
					}
				
				
				creation(shopMenuLoots, 20, "Des flèches","Une envie d'acquisition?","§eSeulement à §b1$ !", Material.ARROW, 1, (byte)0);
				creation(shopMenuLoots, 21, "Des os","Une envie d'acquisition?","§eSeulement à §b1$ !", Material.BONE, 1, (byte)0);
				creation(shopMenuLoots, 22, "Des baton de blaze","Une envie d'acquisition?","§eSeulement à §b1$ !", Material.BLAZE_ROD, 1, (byte)0);
				creation(shopMenuLoots, 23, "Des ender perles","Une envie d'acquisition?","§eSeulement à §b1$ !", Material.ENDER_PEARL, 1, (byte)0);
				creation(shopMenuLoots, 24, "Des boulles de slime","Tu en veux?","§eSeulement à §b1$ !", Material.SLIME_BALL, 1, (byte)0);
				creation(shopMenuLoots, 29, "Du cuirs","Tu en veux?","§eSeulement à §b1$ !", Material.LEATHER, 1, (byte)0);
				creation(shopMenuLoots, 30, "Des yeux d'araignées","Tu en veux?","§eSeulement à §b1$ !", Material.SPIDER_EYE, 1, (byte)0);
				creation(shopMenuLoots, 31, "De la ficelles","Tu en veux?","§eSeulement à §b1$ !", Material.STRING, 1, (byte)0);
				creation(shopMenuLoots, 32, "De la poudres à canon","Tu en veux?","§eSeulement à §b1$ !", Material.SULPHUR, 1, (byte)0);
				creation(shopMenuLoots, 33, "De la viandes de zombies","Tu en veux?","§eSeulement à §b1$ !", Material.ROTTEN_FLESH, 1, (byte)0);
				
				//nourritures
				Vide.setItemMeta(VideM);
				for(int i = 0; i <= 53; i++) {
					shopMenuNourritures.setItem(i, Vide);
					}
				
				creation(shopMenuNourritures, 10, "Steaks cuits","Tu en veux?","§eSeulement à §b1$ !", Material.COOKED_BEEF, 1, (byte)0);
				creation(shopMenuNourritures, 11, "Cochons cuits","Tu en veux?","§eSeulement à §b1$ !", Material.GRILLED_PORK, 1, (byte)0);
				creation(shopMenuNourritures, 12, "Poulets cuits","Tu en veux?","§eSeulement à §b1$ !", Material.COOKED_CHICKEN, 1, (byte)0);
				creation(shopMenuNourritures, 13, "Moutons cuits","Tu en veux?","§eSeulement à §b1$ !", Material.COOKED_MUTTON, 1, (byte)0);
				creation(shopMenuNourritures, 14, "Lapins cuits","Tu en veux?","§eSeulement à §b1$ !", Material.COOKED_RABBIT, 1, (byte)0);
				creation(shopMenuNourritures, 15, "Poissons cuits","Tu en veux?","§eSeulement à §b1$ !", Material.COOKED_FISH, 1, (byte)0);
				creation(shopMenuNourritures, 16, "Saumon cuits","Tu en veux?","§eSeulement à §b1$ !", Material.COOKED_FISH, 1, (byte)1);
				creation(shopMenuNourritures, 19, "Pains","Tu en veux?","§eSeulement à §b1$ !", Material.BREAD, 1, (byte)0);
				creation(shopMenuNourritures, 20, "Pommes","Tu en veux?","§eSeulement à §b1$ !", Material.APPLE, 1, (byte)0);
				creation(shopMenuNourritures, 21, "Cookies","Tu en veux?","§eSeulement à §b1$ !", Material.COOKIE, 1, (byte)0);
				creation(shopMenuNourritures, 22, "Gateaux","Tu en veux?","§eSeulement à §b1$ !", Material.CAKE, 1, (byte)0);
				creation(shopMenuNourritures, 23, "Cookies","Tu en veux?","§eSeulement à §b1$ !", Material.COOKIE, 1, (byte)0);
				creation(shopMenuNourritures, 24, "Steaks","Tu en veux?","§eSeulement à §b1$ !", Material.RAW_BEEF, 1, (byte)0);
				creation(shopMenuNourritures, 25, "Cochons","Tu en veux?","§eSeulement à §b1$ !", Material.PORK, 1, (byte)0);
				creation(shopMenuNourritures, 28, "Poulets","Tu en veux","§eSeulement à §b1$ !", Material.RAW_CHICKEN, 1, (byte)0);
				creation(shopMenuNourritures, 29, "Moutons","Tu en veut?","§eSeulement à §b1$ !", Material.MUTTON, 1, (byte)0);
				creation(shopMenuNourritures, 30, "Lapins","Tu en veut?","§eSeulement à §b1$ !", Material.RABBIT, 1, (byte)0);
				creation(shopMenuNourritures, 31, "Poissons","Tu en veut?","§eSeulement à §b1$ !", Material.RAW_FISH, 1, (byte)0);
				creation(shopMenuNourritures, 32, "Saumons","Tu en veut?","§eSeulement à §b1$ !", Material.RAW_FISH, 1, (byte)1);
				creation(shopMenuNourritures, 33, "Poissons pas bon !","Tu en veut?","§eSeulement à §b1$ !", Material.RAW_FISH, 1, (byte)3);
				creation(shopMenuNourritures, 34, "Melons","Tu en veut?","§eSeulement à §b1$ !", Material.MELON, 1, (byte)0);
				
				
				creation(shopMenuMinerais, 1, "Redstones","Tu en veux?","§eSeulement à §b1$ !", Material.REDSTONE, 1, (byte)0);
				creation(shopMenuMinerais, 2, "Charbons","Tu en veux?","§eSeulement à §b1$ !", Material.COAL, 1, (byte)0);
				creation(shopMenuMinerais, 3, "Lapis Lazuli","Tu en veux?","§eSeulement à §b1$ !", Material.BED, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Fers","Tu en veux?","§eSeulement à §b1$ !", Material.IRON_INGOT, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Ors","Tu en veux?","§eSeulement à §b1$ !", Material.GOLD_INGOT, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Diamands","Tu en veux?","§eSeulement à §b1$ !", Material.DIAMOND, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Emeraudes","Tu en veux?","§eSeulement à §b1$ !", Material.EMERALD, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Quartz","Tu en veux?","§eSeulement à §b1$ !", Material.QUARTZ, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Blocks de Redstones","Tu en veux?","§eSeulement à §b1$ !", Material.REDSTONE_BLOCK, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Blocks de Charbons","Tu en veux?","§eSeulement à §b1$ !", Material.COAL_BLOCK, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Blocks de Lapis Lazuli","Tu en veux?","§eSeulement à §b1$ !", Material.LAPIS_BLOCK, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Blocks de Fers","Tu en veux?","§eSeulement à §b1$ !", Material.IRON_BLOCK, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Blocks d'Ors","Tu en veux?","§eSeulement à §b1$ !", Material.GOLD_BLOCK, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Blocks de Diamands","Tu en veux?","§eSeulement à §b1$ !", Material.DIAMOND_BLOCK, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Blocks  d'Emeraude","Tu en veux?","§eSeulement à §b1$ !", Material.EMERALD_BLOCK, 1, (byte)0);
				creation(shopMenuMinerais, 4, "Block de Quartz","Tu en veux?","§eSeulement à §b1$ !", Material.QUARTZ_BLOCK, 1, (byte)0);
				
				
				
				
			}
					
			
			
		}
		
		
		
		
		
		
		
		
		return false;
		
	}
	



}