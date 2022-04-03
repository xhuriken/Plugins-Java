package fr.xhuriken.imokia;



import org.bukkit.plugin.java.JavaPlugin;

import fr.xhuriken.imokia.Listeners.ImokiaListener;
import fr.xhuriken.imokia.Listeners.PlayerJoinListener;
import wtf.listenia.citronDB.api.Database;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		
		System.out.print("[Imokia] starting...");
		
		getServer().getPluginManager().registerEvents(new ImokiaListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

		
	}

	
	

	public static final Database dataBase = new Database()
		.setHost("host")
        .setPort(port)
        .setDbName("joueurs")
        .setUsername("username")
        .setPassword("password")
        .connect();
	
	
	
	
	
	@Override
	public void onDisable() {
		System.out.print("[Imokia] stopping...");
		
	}
	
	
}