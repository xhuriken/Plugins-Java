package fr.xhuriken.admin.commands;


import fr.xhuriken.admin.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.xhuriken.admin.Main.frozen;
import static fr.xhuriken.admin.Main.prefixfreeze;


public class UnfreezeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("unfreeze") && sender instanceof Player){

            Player player = (Player) sender;

            if(player.hasPermission(new Permissions().FreezeUse)){

                if(args.length == 1){

                    Player po = Bukkit.getServer().getPlayer(args[0]);

                    if(po == null){

                        player.sendMessage(prefixfreeze + "§5Joueur §lIntrouvable§r§5 !");

                        return true;

                    }else{

                        po.sendMessage(prefixfreeze + "§5Vous avez été §b§lunfreeze§r §5par §e" + player.getName() + "§5 !");
                        frozen.remove(po);
                        player.sendMessage(prefixfreeze + "§5" + args[0] + " à été §b§lUnFreeze§r§5 !");
                        return true;



                    }

                }

            }

        }

        return true;
    }

}