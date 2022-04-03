package fr.xhuriken.imokiashop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xhuriken.imokiashop.ShopMoneyManager;
import static fr.xhuriken.imokiashop.Main.prefixeco;

public class CommandsPay implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(cmd.getName().equalsIgnoreCase("pay")) {
			
			
			Player player = (Player) sender;

			if(args.length == 2){
				
				Player target= Bukkit.getServer().getPlayer(args[0]);
				
				if(Integer.valueOf(args[1]) <= ShopMoneyManager.get(player.getUniqueId())) {
					
					ShopMoneyManager.set(target.getUniqueId(), ShopMoneyManager.get(target.getUniqueId()) + Integer.valueOf(args[1]));
					ShopMoneyManager.set(player.getUniqueId(), ShopMoneyManager.get(player.getUniqueId()) - Integer.valueOf(args[1]));
					
					player.sendMessage(prefixeco + "§cVous venez de donner §b" + Integer.valueOf(args[1]) + "$ §cà §e" + target.getDisplayName() + "§c !");
					target.sendMessage(prefixeco + "§cVous venez de recevoir §b" + Integer.valueOf(args[1]) + "$ §cde §e" + player.getDisplayName() + "§c !");
					
				}else {
					
					player.sendMessage(prefixeco + "§c Vous avez §b" + ShopMoneyManager.get(player.getUniqueId()) + "$ §c! Vous ne pouvez pas donnez plus que vous en avez déjà !");
					
				}
				
				
			}else {
				
				player.sendMessage(prefixeco + "§4[ERREUR]§c La commande est: §f/pay <pseudo> <montant>§c !");
				
			}
			
			
			
		}
		
		
		return false;
	}
	
	

}
