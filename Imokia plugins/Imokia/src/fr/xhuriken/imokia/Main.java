package fr.xhuriken.imokia;

import org.bukkit.plugin.java.JavaPlugin;

import fr.xhuriken.imokia.Listeners.ImokiaListener;
import fr.xhuriken.imokia.commands.Commands;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		System.out.print("[Imokia] starting...");
		getServer().getPluginManager().registerEvents(new ImokiaListener(), this);
		getCommand("ping").setExecutor(new Commands());
			
	}

	@Override
	public void onDisable() {
		System.out.print("[Imokia] stopping...");
		
	}
	
}