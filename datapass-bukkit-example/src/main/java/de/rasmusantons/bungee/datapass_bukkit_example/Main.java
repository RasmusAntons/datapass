package de.rasmusantons.bungee.datapass_bukkit_example;

import de.rasmusantons.bungee.datapass_bukkit_api.DataPass;
import de.rasmusantons.bungee.datapass_bukkit_api.events.DataPassStringEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		String message = String.format("[%s] %s", event.getPlayer().getName(), event.getMessage());
		DataPass.getDataSender().sendData(new DataPassStringEvent(message));
	}

	@EventHandler
	public void onDataPassString(DataPassStringEvent event) {
		getServer().broadcastMessage(event.getData());
	}
}
