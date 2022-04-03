package fr.xhuriken.imokia;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

public class CustomEvent implements Listener {

	private PluginManager pluginManager;
	public static List<Material> ARMORS = new ArrayList<>();
	static {
		ARMORS.add(Material.LEATHER_HELMET);
		ARMORS.add(Material.LEATHER_CHESTPLATE);
		ARMORS.add(Material.LEATHER_LEGGINGS);
		ARMORS.add(Material.LEATHER_BOOTS);
		
		ARMORS.add(Material.IRON_HELMET);
		ARMORS.add(Material.IRON_CHESTPLATE);
		ARMORS.add(Material.IRON_LEGGINGS);
		ARMORS.add(Material.IRON_BOOTS);
		
		ARMORS.add(Material.GOLD_HELMET);
		ARMORS.add(Material.GOLD_CHESTPLATE);
		ARMORS.add(Material.GOLD_LEGGINGS);
		ARMORS.add(Material.GOLD_BOOTS);
		
		ARMORS.add(Material.DIAMOND_HELMET);
		ARMORS.add(Material.DIAMOND_CHESTPLATE);
		ARMORS.add(Material.DIAMOND_LEGGINGS);
		ARMORS.add(Material.DIAMOND_BOOTS);
	}
	
	public CustomEvent(PluginManager pluginManager) {this.pluginManager = pluginManager;}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		if(ARMORS.contains(event.getCurrentItem().getType())) {
			if(event.getSlotType() == SlotType.ARMOR)
				this.pluginManager.callEvent(new PlayerArmorEquipEvent(event.getWhoClicked(), event.getCurrentItem()));
			if(event.getSlotType() == SlotType.CONTAINER)
				this.pluginManager.callEvent(new PlayerArmorUnequipEvent(event.getWhoClicked(), event.getCurrentItem()));
		}
		
	}
	
	public static class PlayerArmorEquipEvent extends Event {
		private HumanEntity entity;
		private ItemStack item;
		public PlayerArmorEquipEvent(HumanEntity entity, ItemStack it) {
			this.entity = entity;
			this.item = it;
		}
		public HumanEntity getWhoEquipped() {return entity;}
		public Inventory getInventory() {return entity.getInventory();}
		public ItemStack getItem() {return item;}
		public static HandlerList HANDLER_LIST = new HandlerList();
		@Override public HandlerList getHandlers() {return HANDLER_LIST;}
	}
	public static class PlayerArmorUnequipEvent extends Event {
		private HumanEntity entity;
		private ItemStack item;
		public PlayerArmorUnequipEvent(HumanEntity entity, ItemStack it) {
			this.entity = entity;
			this.item = it;
		}
		public HumanEntity getWhoEquipped() {return entity;}
		public Inventory getInventory() {return entity.getInventory();}
		public ItemStack getItem() {return item;}
		public static HandlerList HANDLER_LIST = new HandlerList();
		@Override public HandlerList getHandlers() {return HANDLER_LIST;}
	}
	
}
