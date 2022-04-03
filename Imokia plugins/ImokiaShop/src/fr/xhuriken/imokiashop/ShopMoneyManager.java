package fr.xhuriken.imokiashop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

public class ShopMoneyManager {

	public static File configFile;
	public static YamlConfiguration config;

	public ShopMoneyManager(Main m) throws Exception {

		configFile = new File(m.getDataFolder().getAbsolutePath()+"/money.yml");
		if(!configFile.exists()) {
			configFile.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(configFile));
			bw.write("money:");
			bw.flush();
			bw.close();
		}
		config = YamlConfiguration.loadConfiguration(configFile);

	}

	public static void set(UUID uuid, int amount) {
		config.set("money."+uuid, amount);
		try {
			config.save(configFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static int get(UUID uuid) {
		return config.getInt("money."+uuid);
	}

}