package me.prismskey.foreveradorable.foreveradorable;

import me.prismskey.foreveradorable.foreveradorable.listeners.PlayerInteractListener;
import me.prismskey.foreveradorable.foreveradorable.listeners.PlayerUseNameTagListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForeverAdorable extends JavaPlugin {

	public static ForeverAdorable instance;

	@Override
	public void onEnable() {
		instance = this;
		registerEventListeners();
	}

	private void registerEventListeners() {
		new PlayerInteractListener();
		new PlayerUseNameTagListener();
	}

}
