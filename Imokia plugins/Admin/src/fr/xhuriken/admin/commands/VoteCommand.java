package fr.xhuriken.admin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static fr.xhuriken.admin.Main.prefixvote;

public class VoteCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		
		if(label.equalsIgnoreCase("vote") && sender instanceof Player){
			
			Player player = (Player) sender;
			
			player.sendMessage(prefixvote + "§5Tien ! le lien pour §lvoter§r§5 sur le serveur ! ça nous arrange §lBeaucoup§r§5 que tu vote !");
			player.sendMessage("   -Le Lien a rajouter-   ");
			
		}
		
		return false;
	}

}
