package fr.xhuriken.admin.commands;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class tpaCommand implements CommandExecutor {

	public static Player demandeur;
	
	public static boolean isStillValid;

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		demandeur = (Player) sender;
		
		if(label.equalsIgnoreCase("tpa") && sender instanceof Player) {
					
			
			if(args.length == 1) {
				
				Player receveur = Bukkit.getServer().getPlayer(args[0]);
				
				if(receveur == null) {
					
					demandeur.sendMessage("§cJoueur introuvable !");
					
				}else {
					
					isStillValid = true;
					
				Timer delai = new Timer();
				delai.schedule(new TimerTask() {
					
					@Override
					public void run() {
						
						demandeur.sendMessage("§cDemande de téléportation annulée !");
						receveur.sendMessage("§cDemande de téléportation annulée !");
						
						isStillValid = false;
						
						return;
						
					}
				}, 60000);
				
				demandeur.sendMessage("§cVous venez d'envoyer une requête de téléportation à §e" + receveur.getDisplayName() + "§c !");
				
				demandeur.sendMessage("§cIl/elle a §e60 sec §cpour accepter !");
				
				
				receveur.sendMessage("§e" + demandeur.getDisplayName() + " §cvous à envoyer une requête de téléportation !");
				
				receveur.sendMessage("§cFaite §e/tpyes §cou §e/tpaccept §cpour accepter !");
				
				receveur.sendMessage("§cVous avez §e60 sec§c !");
				
				}
				
			}else {
				
				demandeur.sendMessage("§cLa commande est : §f/tpa <pseudo> §c!");
				
			}
			
		}
		
		return false;
	}

}
