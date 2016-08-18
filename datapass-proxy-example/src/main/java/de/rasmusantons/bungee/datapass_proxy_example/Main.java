package de.rasmusantons.bungee.datapass_proxy_example;

import de.rasmusantons.bungee.datapass_proxy_api.DataPass;
import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassStringEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerListener(this, this);
	}

	@EventHandler
	public void onDataPassString(DataPassStringEvent event) {
		getLogger().info(event.getData());
		DataPass.getDataSender().sendData(new DataPassStringEvent(event.getServer(), "proxy received some data!"));
	}
}
