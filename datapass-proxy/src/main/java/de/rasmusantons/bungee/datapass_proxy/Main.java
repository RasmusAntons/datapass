package de.rasmusantons.bungee.datapass_proxy;

import de.rasmusantons.bungee.datapass_proxy_api.DataPass;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin implements Listener {
	@Override
	public void onEnable() {
		DataPass.setDataSender(new DataSenderI());
		this.getProxy().registerChannel("DataPass");
		getProxy().getPluginManager().registerListener(this, new DataReceiver(this));
	}
}
