package fr.xhuriken.admin.listeners;

import static fr.xhuriken.admin.Main.frozen;
import static fr.xhuriken.admin.Main.joinplayer;
import static fr.xhuriken.admin.Main.prefixfreeze;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;


public class PlayerListener implements Listener {
	
	
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        Player player = e.getPlayer();
        if(frozen.contains(player)) {

            e.setTo(e.getFrom());
            player.sendMessage(prefixfreeze + "§5 Un §bBonhomme de neige §l§9ne bouge pas§r §5!");

        }



        }
    @EventHandler
    public void onDamage(EntityDamageEvent d){

        Entity entite = d.getEntity();
        if(entite instanceof Player && frozen.contains(entite)){

            d.setCancelled(true);

        }

    }
    
    @EventHandler
    void onJoin(PlayerJoinEvent join) {
    	join.setJoinMessage(null);
    	
    	Player player = (Player) join.getPlayer();
    	
    	if(joinplayer.contains(player)) {
    		
        	join.setJoinMessage("§g>§r §e" + player.getDisplayName() + "§5 vien de rejoindre le serveur !");
        	join.setJoinMessage(null);
    		
    	}else{
    		
    		
    	    Bukkit.broadcastMessage("§g>§r §e" + player.getDisplayName() + "§5 vien de rejoindre le serveur pour la §lpremière foit §r§5!");
    	    Bukkit.broadcastMessage("§g>§r §5Dite 'Bienvenue ' à §e" + player.getDisplayName() + "§5 !");
    		
    	    join.setJoinMessage(null);
    	    
    	    joinplayer.add(player);
    	}
    	

    	
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent eDeath) {
    	
    	if(eDeath.getEntity().getKiller() instanceof Player) {
    		
    		Player killer = eDeath.getEntity().getKiller();
    		
    		Player player = eDeath.getEntity();
    		
    		eDeath.setDeathMessage(null);
    		Bukkit.broadcastMessage("§e" + player.getDisplayName() + "§c à été tué(e) par§e " + killer.getDisplayName() + "§c !");
    		
    	}
    	
    }
    
}
