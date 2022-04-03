/*package fr.xhuriken.imokia.Listeners;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.xhuriken.imokia.Main;

public class PlayerChatListener implements Listener{
	
	
	private Main main;
	
	public PlayerChatListener(Main main) {
		
		this.main = main;
		
	}
	
	
	@EventHandler
	
	public void onPlayerChat(AsyncPlayerChatEvent eChat) {
		
		final Player player = eChat.getPlayer(); 
		
		final UUID uuid = eChat.getPlayer().getUniqueId();
		
		if(main.getPlayerGrades().containsKey(uuid)) {
			
			final String grade = main.getPlayerGrades().get(uuid);
			
			eChat.setFormat("§9"+ grade + "§e " + player.getDisplayName() + " §b> §f" + eChat.getMessage());
			
		}
		
	}

}*/
