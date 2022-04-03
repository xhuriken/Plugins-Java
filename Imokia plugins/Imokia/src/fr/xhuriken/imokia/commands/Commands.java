package fr.xhuriken.imokia.commands;

import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
			if(!(sender instanceof Player)){
				if(label.equalsIgnoreCase("ping")){
					
					if(!sender.hasPermission("imokia.pong")){
						sender.sendMessage("§cVous n'avez pas la permission d'éxecuter cette commande !");
						return false;
						
					}
					else {
						
						int max = 10;
		                int min = 1;
		        		int x = new Random().nextInt(max - min) + min;
		        		
		        		if(x == 3) {
		        			
		        			sender.sendMessage("§4Pong! §5 ET §b§k-§r§5SMAAAAASH§b§k- §r§n|§r §46 / 0!!");
		        			
		        		}else {
	
		        			sender.sendMessage("§4Pong!");
		        		}
		        						
					}
		
			}
				return false;
			}
		
		Player player = (Player) sender;

            
			if(label.equalsIgnoreCase("ping")){
				
				
					if(!player.hasPermission("imokia.pong")){
						player.sendMessage("§cVous n'avez pas la permission d'éxecuter cette commande !");
						return false;	
						
					}
					else {
						
						
						int max = 10;
		                int min = 1;
		        		int x = new Random().nextInt(max - min) + min;
		        		
		        		if(x == 3) {
		        			
		        			player.sendMessage("§4Pong! §5 ET §b§k-§r§5SMAAAAASH§b§k§-");
		        			
		        		}else {
		        			
		        			player.sendMessage("§4Pong!");
		        		}
		        		
					}
            
			}
			
		return false;

	}
}
