package fr.xhuriken.imokiashop.commands;

import static fr.xhuriken.imokiashop.Main.prefixeco;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xhuriken.imokiashop.ShopMoneyManager;

public class CommandsMoney implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("money")) {
			
			
			Player Joueur = (Player) sender; 

			
			Joueur.sendMessage(prefixeco +"§eVous avez §l: §r§b" + ShopMoneyManager.get(Joueur.getUniqueId())  + "$ §e!");
			
		}
		return false;
	}

}
