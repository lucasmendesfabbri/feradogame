package br.com.hype_mc.pvp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import br.com.hype_mc.pvp.Hype;

public class PlayerJoin implements Listener{

	private Hype instance;

	public PlayerJoin(Hype instance) {
		this.instance=instance;
		Bukkit.getPluginManager().registerEvents(this, this.instance);
	}
	
	
	
}
