package fr.xhuriken.imokiashop.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.xhuriken.imokiashop.commands.CommandsShop;

public class ImokiaShopListeners implements Listener{
	
	
	@EventHandler
    public void onClick(InventoryClickEvent event){
            
		@SuppressWarnings("unused")
        Inventory shop = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack objet = event.getCurrentItem();
        if(objet == null) return;
        if(event.getView().getTitle().equals("§eImokia§bShop")){
            
            if(objet.getType() == Material.GRASS) {
                
                event.setCancelled(true);
                player.closeInventory();

                player.openInventory(CommandsShop.shopMenuBlocks);
                
            }
            if(objet.getType() == Material.STAINED_GLASS_PANE) {
                
            	event.setCancelled(true);

                
            }
            
            if(objet.getType() == Material.SPIDER_EYE) {
                
            	event.setCancelled(true);
            	player.closeInventory();

            	player.openInventory(CommandsShop.shopMenuLoots);
                
            }
            
            if(objet.getType() == Material.COOKED_BEEF) {
                
            	event.setCancelled(true);
            	player.closeInventory();

            	player.openInventory(CommandsShop.shopMenuNourritures);
                
            }
            
            if(objet.getType() == Material.DIAMOND) {
                
            	event.setCancelled(true);
            	player.closeInventory();

            	player.openInventory(CommandsShop.shopMenuMinerais);
                
            }
    
        }else {
        	if(event.getView().getTitle().equals("§eImokia§bShop§4 > §bBlocks")) {
        		
        		event.setCancelled(true);
                player.closeInventory();
                
        	}
        	  if(event.getView().getTitle().equals("§eImokia§bShop§4 > §bLoots")) {
                  
                  event.setCancelled(true);
                  player.closeInventory();
                      
                 }
        	  
        	  if(event.getView().getTitle().equals("§eImokia§bShop§4 > §bNourritures")) {
                  
                  event.setCancelled(true);
                  player.closeInventory();
                      
                 }
        }
        
        
        }

}
