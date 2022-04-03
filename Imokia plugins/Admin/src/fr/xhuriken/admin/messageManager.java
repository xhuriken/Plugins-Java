package fr.xhuriken.admin;

import java.util.HashMap;

import org.bukkit.entity.Player;
 
public class messageManager {
 
    Main plugin;
    
    HashMap<Player,Player> conversations = new HashMap<Player,Player>();
    
    public messageManager(Main main) {
        plugin = main;
    }
    
    public void setReplyTarget(Player messager, Player reciever){
        conversations.put(messager, reciever);
        conversations.put(reciever, messager);
    }
 
    public Player getReplyTarget(Player messager){
        return conversations.get(messager);
    }
}