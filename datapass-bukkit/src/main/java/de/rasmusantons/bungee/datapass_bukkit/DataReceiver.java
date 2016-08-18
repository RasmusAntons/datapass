package de.rasmusantons.bungee.datapass_bukkit;

import de.rasmusantons.bungee.datapass_bukkit_api.events.DataPassEvent;
import de.rasmusantons.bungee.datapass_common.Packet;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class DataReceiver implements PluginMessageListener {
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
		if (!channel.equals("DataPass"))
			return;
		Packet packet = Packet.fromBytes(bytes);
		DataPassEvent dataEvent = DataPassEventFactory.fromPacket(packet);
		Bukkit.getServer().getPluginManager().callEvent(dataEvent);
	}
}
