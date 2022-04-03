package fr.xhuriken.admin.commands;

import static fr.xhuriken.admin.commands.tpaCommand.demandeur;
import static fr.xhuriken.admin.commands.tpaCommand.isStillValid;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpacceptCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(label.equalsIgnoreCase("tpaccept") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(args.length >= 1) {
				
				player.sendMessage("§cLa commande est : §f/tpaccept §c!");

				
			}else {

				
				if(isStillValid == true) {
				
					Timer delaitp = new Timer();
					delaitp.schedule(new TimerTask() {
						
						@Override
						public void run() {
							

							demandeur.teleport(player.getLocation());
							
							demandeur.sendMessage("§cVous avez été téléporté(e) sur§e " + player.getDisplayName() + "§c ! ");
							player.sendMessage("§e" + demandeur.getDisplayName() + "§c vient de se téléporter sur vous !");
							
							isStillValid = false;
							
							
							return;
							
						}
					}, 3000);
				
				
					demandeur.sendMessage("§csterfoula");
					player.sendMessage("serfoula aussi");
					
				}else {
					
					player.sendMessage("§cAucune requête en attente !");
					
				}
			}
			
		}
		
		return false;
	}

}
