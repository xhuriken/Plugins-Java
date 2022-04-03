package fr.xhuriken.imokia.Listeners;

import java.util.Arrays;

import javax.swing.text.html.parser.Entity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;





public class ImokiaListener implements Listener{
    
	
	//ITEMS
    public static ItemStack dynamite;
    
    //ARMURE FARM
    public static ItemStack CasqueT;  
    public static ItemStack PlastronT;
    public static ItemStack JambesT;
    public static ItemStack BottesT;
    
    public ImokiaListener() {
    	
    	
    						//-----ITEM DIVERS-----//
    	
    	//--------//
    	//DYNAMITE//
    	//--------//
    	
        dynamite = new ItemStack(Material.STICK, 1);
        ItemMeta dynaM = dynamite.getItemMeta();
        dynaM.setLore(Arrays.asList("§eElle sert à exploser dans tout les claims"));
        dynaM.setDisplayName("§cDynamite");
        dynamite.setItemMeta(dynaM);
        
        
 
        //--------------//
        //CRAFT DYNAMITE//
        //--------------//

        
        
        ShapedRecipe dynacraft = new ShapedRecipe(dynamite);
        
        dynacraft.shape(" T "," P "," S "); 
        dynacraft.setIngredient('T', Material.STRING);
        dynacraft.setIngredient('S', Material.STICK);
        dynacraft.setIngredient('P', Material.SULPHUR);
        Bukkit.getServer().addRecipe(dynacraft);
        
        
        
        					//-----ARMURE-----//
        
        
        //--------------//
        //ARMURE DE FARM//
        //--------------//

       
        //CASQUE DE FARM//
        
        	CasqueT = new ItemStack(Material.LEATHER_HELMET, 1);
        	ItemMeta CTM = CasqueT.getItemMeta();
        	CTM.setDisplayName("§eCasque de §l§5Farm");
        	CTM.setLore(Arrays.asList("§dNight §1Vision","§2Protection §l2"));
        	CTM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        	CTM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	CasqueT.setItemMeta(CTM);
        
        //CRAFT CASQUE FARM//
        
        	ShapedRecipe CTC = new ShapedRecipe(CasqueT);
        	
        	CTC.shape("aaa","a a","   ");
        	CTC.setIngredient('a', Material.REDSTONE);
        	Bukkit.getServer().addRecipe(CTC);
        
        	
        	
        	
        	
        //PLASTRON DE FARM//
        
        	PlastronT = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        	ItemMeta PTM = PlastronT.getItemMeta();
        	PTM.setDisplayName("§ePlastron de §l§5Farm");
        	PTM.setLore(Arrays.asList("§dJump §1Boost §2§l3","§2Protection §l2"));
        	PTM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        	PTM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	PlastronT.setItemMeta(PTM);
        	
        	
        	
        //CRAFT PLASTRON FARM//
            
        	ShapedRecipe PTC = new ShapedRecipe(PlastronT);
        	
        	PTC.shape("a a","aaa","aaa"); 
        	PTC.setIngredient('a', Material.REDSTONE);
        	Bukkit.getServer().addRecipe(PTC);
        
        	
        	
        //JAMBIERE DE FARM//
            
        	JambesT = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        	ItemMeta JTM = JambesT.getItemMeta();
        	JTM.setDisplayName("§eJambière de §l§5Farm");
        	JTM.setLore(Arrays.asList("§dJump §1Boost §2§l3","§2Protection §l2"));
        	JTM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        	JTM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	JambesT.setItemMeta(JTM);
        	
        	
        //CRAFT JAMBIERE FARM
        	
        	ShapedRecipe JTC = new ShapedRecipe(JambesT);
        	
        	JTC.shape("aaa","a a","a a");
        	JTC.setIngredient('a', Material.REDSTONE);
        	Bukkit.getServer().addRecipe(JTC);
        	
        	
        //BOTTES DE FARM
        	
        	BottesT = new ItemStack(Material.LEATHER_BOOTS, 1);
        	ItemMeta BTM = BottesT.getItemMeta();
        	BTM.setDisplayName("§eBottes de §l§5Farm");
        	BTM.setLore(Arrays.asList("§dAnnule les §1déga de §2§l3chute!","§2Protection §l2"));
        	BTM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        	BTM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        	BottesT.setItemMeta(BTM);
        	
        	
        	
        	ShapedRecipe BTC = new ShapedRecipe(BottesT);
        	
        	BTC.shape("   ","a a","a a");
        	BTC.setIngredient('a', Material.REDSTONE);
        	Bukkit.getServer().addRecipe(BTC);
        
        
        
    }

  /*  @EventHandler
    public void onClick(PlayerInteractEvent e) {
    	
    	
           
    		Player player = (Player) e.getPlayer();
            
    		if(e.getItem() == null) return;
            
            	if(e.getItem().getItemMeta().getDisplayName().equals(dynamite.getItemMeta().getDisplayName())) {
                
            	
            		Location TNT = player.getLocation();
            		player.getWorld().spawnEntity(TNT, EntityType.PRIMED_TNT);
            		if(player.getItemInHand().getAmount() > 1)
            			  player.getItemInHand().setAmount(player.getItemInHand().getAmount()-1);
            			else
            				player.setItemInHand(null);
    
            	
            	
            	}
            	
            	
  }
    

   @EventHandler
    public void onMove(PlayerMoveEvent eMove) {
    	
    	Player player = (Player) eMove.getPlayer();

    	if(player.getEquipment().getHelmet().getItemMeta().getDisplayName().equals("§eCasque de §l§5Farm")) {
    		
    		player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 500, 5));
    		
    		
    	}
    	if(player.getEquipment().getChestplate().getItemMeta().getDisplayName().equals("§ePlastron de §l§5Farm")) {
    		
    		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 3));
    		
    		
    	}
    	if(player.getEquipment().getLeggings().getItemMeta().getDisplayName().equals("§eJambière de §l§5Farm")) {
	
    		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 5));
		
	
    	}

    	
    }
    
    @EventHandler
    public void onDamage(EntityDamageEvent eDamage) {
    	
    	
    	Player player = (Player) eDamage.getEntity();
    	if(player.getLastDamageCause().getCause() == DamageCause.CONTACT) {
    		
    		if(player.getEquipment().getBoots().getItemMeta().getDisplayName().equals("§eBottes de §l§5Farm")) {
        		
        		eDamage.setCancelled(true);
        		
        	}
    		
    		
    	}
    	
    	
    }*/
    
    
      

        



}