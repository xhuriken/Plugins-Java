package fr.xhuriken.admin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xhuriken.admin.Main;
 
public class msgCommand implements CommandExecutor {
 
    Main plugin;
    
    public msgCommand(Main main) {
        plugin = main;
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player && args.length > 0){
            if(Bukkit.getOfflinePlayer(args[0]).getPlayer() != null){
                Player messager = (Player) sender;
                Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                plugin.mM.setReplyTarget(messager, reciever);
                args[0] = "";
                String message = "";
                for(int i = 0; i < args.length; i++){
                    message += "" + args[i];
                }
                messager.sendMessage("§6Envoyé à >§e " + reciever.getName() + " §6: §5" + message);
                reciever.sendMessage("§6Reçu de <§e " + messager.getName() + " §6: §5" + message);
                return true;
            } else {
                sender.sendMessage("§cCe joueur n'est pas connecté(e) !");
                return true;
            }
            
        }
        return false;
    }
 
}