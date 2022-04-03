package fr.xhuriken.admin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.xhuriken.admin.commands.FreezeCommand;
import fr.xhuriken.admin.commands.UnfreezeCommand;
import fr.xhuriken.admin.commands.VoteCommand;
import fr.xhuriken.admin.commands.msgCommand;
import fr.xhuriken.admin.commands.replyCommand;
import fr.xhuriken.admin.commands.tpaCommand;
import fr.xhuriken.admin.commands.tpacceptCommand;
import fr.xhuriken.admin.commands.tpyesCommand;
import fr.xhuriken.admin.listeners.PlayerListener;
import static fr.xhuriken.admin.commands.tpaCommand.isStillValid;


public class Main extends JavaPlugin {

    public static ArrayList<Player> frozen = new ArrayList<Player>();
    public static ArrayList<Player> joinplayer = new ArrayList<Player>(); 
    public static String prefixfreeze = "§4[§l§eImokia§r§3Freeze§4]§r ";
    public static String prefixvote = "§4[§l§eImokia§r§3Vote§4]§r ";



    public messageManager mM;
    
    @Override
    public void onEnable(){
        System.out.println("[ImokiaAdmin] Actif !");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("freeze").setExecutor(new FreezeCommand());
        getCommand("unfreeze").setExecutor(new UnfreezeCommand());
        getCommand("vote").setExecutor(new VoteCommand());
        getCommand("msg").setExecutor(new msgCommand(this));
        getCommand("r").setExecutor(new replyCommand(this));
        getCommand("tpa").setExecutor(new tpaCommand());
        getCommand("tpaccept").setExecutor(new tpacceptCommand());
        getCommand("tpyes").setExecutor(new tpyesCommand());
        
        isStillValid = false;
        
        mM = new messageManager(this);
        
        

    }



    

    @Override
    public void onDisable(){

        getLogger().info("[ImokiaAdmin] Desactive !");

    }


}