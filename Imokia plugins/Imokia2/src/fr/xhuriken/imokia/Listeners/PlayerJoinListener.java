package fr.xhuriken.imokia.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener{
	

@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent e) {
		
		Player player = (Player) e.getPlayer();
		
		PlayerData playerData = new PlayerData(player.getUniqueId().toString()); 
		
		PlayerData playerDB = PlayerData.getPlayer(player.getUniqueId().toString());
		
		playerDB.getGrade();
		
	}

}
