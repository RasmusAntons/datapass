package de.rasmusantons.bungee.datapass_proxy;

import de.rasmusantons.bungee.datapass_common.Packet;
import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassEvent;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class DataReceiver implements Listener {
	private Plugin plugin;

	public DataReceiver(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPluginMessage(PluginMessageEvent event) {
		if (!(event.getTag().equals("DataPass") && event.getSender() instanceof Server))
			return;
		Packet packet = Packet.fromBytes(event.getData());
		DataPassEvent dataEvent = DataPassEventFactory.fromPacket(((Server) event.getSender()).getInfo(), packet);
		plugin.getProxy().getPluginManager().callEvent(dataEvent);
	}
}
