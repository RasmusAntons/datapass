package de.rasmusantons.bungee.datapass_proxy;

import de.rasmusantons.bungee.datapass_common.Packet;
import de.rasmusantons.bungee.datapass_common_api.models.PlayerInfo;
import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassEvent;
import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassPlayerListEvent;
import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassStringEvent;
import net.md_5.bungee.api.config.ServerInfo;

import java.util.ArrayList;

public class DataPassEventFactory {
	public static DataPassEvent fromPacket(ServerInfo server, Packet packet) {
		switch (packet.getType()) {
			case STRING:
				return new DataPassStringEvent(server, (String) packet.getData());
			case PLAYER_LIST:
				return new DataPassPlayerListEvent(server, (ArrayList<PlayerInfo>) packet.getData());
			default:
				throw new AssertionError("invalid PacketType: " + packet.getType().toString());
		}
	}
}
