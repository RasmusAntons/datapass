package de.rasmusantons.bungee.datapass_bukkit;

import de.rasmusantons.bungee.datapass_bukkit_api.DataPass;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		DataPass.setDataSender(new DataSenderI(this));
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "DataPass");
		this.getServer().getMessenger().registerIncomingPluginChannel(this, "DataPass", new DataReceiver());
	}
}
