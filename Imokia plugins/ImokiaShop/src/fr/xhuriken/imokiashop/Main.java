package fr.xhuriken.imokiashop;
import org.bukkit.plugin.java.JavaPlugin;

import fr.xhuriken.imokiashop.commands.CommandsEco;
import fr.xhuriken.imokiashop.commands.CommandsMoney;
import fr.xhuriken.imokiashop.commands.CommandsPay;
import fr.xhuriken.imokiashop.commands.CommandsShop;
import fr.xhuriken.imokiashop.listeners.ImokiaShopListeners;

public class Main extends JavaPlugin {

	
	public static String prefixeco = "§4[§l§eImokia§r§3Eco§4]§r ";
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		System.out.print("ImokiaShop starting...");
		
		
		
		
		try {
			new ShopMoneyManager(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServer().getPluginManager().registerEvents(new ImokiaShopListeners(), this);
	
		getCommand("eco").setExecutor(new CommandsEco());
		getCommand("shop").setExecutor(new CommandsShop());
		getCommand("money").setExecutor(new CommandsMoney());
		getCommand("pay").setExecutor(new CommandsPay());
		
		
		
		
		
	
	}
	
	

	
	@Override
	public void onDisable() {
		System.out.print("ImokiaShop stopping...");
	}
	
}
