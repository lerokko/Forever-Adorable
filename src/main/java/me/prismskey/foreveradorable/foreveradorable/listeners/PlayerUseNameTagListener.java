package me.prismskey.foreveradorable.foreveradorable.listeners;

import me.prismskey.foreveradorable.foreveradorable.ForeverAdorable;
import me.prismskey.foreveradorable.foreveradorable.events.PlayerUseNameTagEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Breedable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerUseNameTagListener implements Listener {

	public PlayerUseNameTagListener() {
		Bukkit.getServer().getPluginManager().registerEvents(this, ForeverAdorable.instance);
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerUseNameTag(PlayerUseNameTagEvent event) {

		if(event.getTarget() instanceof Ageable) {
			Breedable ageable = (Breedable) event.getTarget();

			if(event.getNameTag().getItemMeta().getDisplayName().toLowerCase().contains("baby") && !ageable.isAdult()) {
				ageable.setAgeLock(true);
				event.getPlayer().sendMessage(ChatColor.BLUE + "Target Animal will remain a baby until name is changed.");

			} else if(!event.getNameTag().getItemMeta().getDisplayName().toLowerCase().contains("baby") && ageable.getAgeLock()) {
				ageable.setAgeLock(false);
				event.getPlayer().sendMessage(ChatColor.BLUE + "Target Animal will now age as normal.");
			}
		}
	}
}
