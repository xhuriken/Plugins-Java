package fr.xhuriken.imokiashop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xhuriken.imokiashop.Permissions;
import fr.xhuriken.imokiashop.ShopMoneyManager;
import static fr.xhuriken.imokiashop.Main.prefixeco;


public class CommandsEco implements CommandExecutor {
	public String help = "/eco <add|set|remove> <player> <amount>";

	@SuppressWarnings("static-access")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("eco")) {
			Player Donner = (Player) sender; 
			if(Donner.hasPermission(new Permissions().EcoUse)){
				
			
			if(args.length == 3) {

				Player target = Bukkit.getPlayer(args[1]);

				switch(args[0].toLowerCase()) {

					case "give":
						ShopMoneyManager.set(target.getUniqueId(), ShopMoneyManager.get(target.getUniqueId()) + Integer.valueOf(args[2]));
						Donner.sendMessage(prefixeco +"§cVous venez d'ajouter §b" + Integer.valueOf(args[2]) + "$ §cà §e" + target.getDisplayName() +"§c ! Il/elle a maintenant §b" + ShopMoneyManager.get(target.getUniqueId()) + "$ !");
						break;

					case "set": 	
						ShopMoneyManager.set(target.getUniqueId(), Integer.valueOf(args[2]));
						Donner.sendMessage(prefixeco +"§e"+  target.getDisplayName() +"§c à maintenant §b" + Integer.valueOf(args[2]) + "$ §c!");
						
						break;

					case "remove":
						if(Integer.valueOf(args[2]) <= ShopMoneyManager.get(target.getUniqueId()))
						{
							ShopMoneyManager.set(target.getUniqueId(), ShopMoneyManager.get(target.getUniqueId()) - Integer.valueOf(args[2]));
							Donner.sendMessage(prefixeco +"§e" + target.getDisplayName() +  "§c a perdu §b" + Integer.valueOf(args[2]) + "$ §c! Il/elle a maintenant §b" + ShopMoneyManager.get(target.getUniqueId()) + "$ !");
						}
						else
						{
							
							Donner.sendMessage(prefixeco +"§e"+  target.getDisplayName() +"§cà §b" + ShopMoneyManager.get(target.getUniqueId()) + "§c! Vous ne pouvez pas lui en retirer d'avantage !");
						}
						break;
					default:
						sender.sendMessage(prefixeco +"La commande est: " + help);
						break;

				}
return true;

			}else {
				sender.sendMessage(prefixeco +"La commande est: " + help);
return false;
			}

		}else {
			Donner.sendMessage("§cVous n'avez pas les permissions !");
		return false;
		}

	}
		return false;
	}
}

