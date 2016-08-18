package de.rasmusantons.bungee.datapass_bukkit;

import com.google.common.collect.Iterables;
import de.rasmusantons.bungee.datapass_bukkit_api.DataSender;
import de.rasmusantons.bungee.datapass_bukkit_api.events.DataPassEvent;
import de.rasmusantons.bungee.datapass_common.Packet;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DataSenderI implements DataSender {
	private JavaPlugin plugin;

	public DataSenderI(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void sendData(DataPassEvent dataEvent) {
		Player player = Iterables.getFirst(plugin.getServer().getOnlinePlayers(), null);
		if (player == null)
			throw new RuntimeException("Cannot send data from empty server!");
		player.sendPluginMessage(plugin, "DataPass", new Packet(dataEvent.getType(), dataEvent.getData()).toBytes());
	}
}
