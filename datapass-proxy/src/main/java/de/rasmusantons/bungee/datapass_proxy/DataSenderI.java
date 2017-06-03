package de.rasmusantons.bungee.datapass_proxy;

import de.rasmusantons.bungee.datapass_common.Packet;
import de.rasmusantons.bungee.datapass_proxy_api.DataSender;
import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassEvent;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

public class DataSenderI implements DataSender {
	@Override
	public void sendData(DataPassEvent dataEvent) {
		dataEvent.getServer().sendData("DataPass", new Packet(dataEvent.getType(), dataEvent.getData()).toBytes());
	}

	@Override
	public void broadcastData(DataPassEvent dataEvent) {
		for (ServerInfo server : ProxyServer.getInstance().getServers().values()) {
			if (server.getPlayers().size() > 0)
				server.sendData("DataPass", new Packet(dataEvent.getType(), dataEvent.getData()).toBytes());
		}
	}

	@Override
	public void broadcastDataToOthers(DataPassEvent dataEvent) {
		for (ServerInfo server : ProxyServer.getInstance().getServers().values()) {
			if (server.getPlayers().size() > 0 && !server.equals(dataEvent.getServer()))
				server.sendData("DataPass", new Packet(dataEvent.getType(), dataEvent.getData()).toBytes());
		}
	}
}
