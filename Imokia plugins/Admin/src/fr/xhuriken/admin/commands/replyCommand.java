package fr.xhuriken.admin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xhuriken.admin.Main;
 
public class replyCommand implements CommandExecutor {
 
    Main plugin;
    
    public replyCommand(Main main) {
        plugin = main;
    
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player messager = (Player) sender;
            if(plugin.mM.getReplyTarget(messager) == null){
                messager.sendMessage("§cVous n'avez personne à qui repondre !");
                return true;
            }
            Player reciever = plugin.mM.getReplyTarget(messager);
            String message = "";
            for(int i = 0; i < args.length; i++){
                message += "" + args[i];
            }
            messager.sendMessage("§6Envoyé à >§e " + reciever.getName() + " §6: §5" + message);
            reciever.sendMessage("§6Reçu de <§e " + messager.getName() + " §6: §5" + message);
            return true;
        }
        return false;
    }
 
}