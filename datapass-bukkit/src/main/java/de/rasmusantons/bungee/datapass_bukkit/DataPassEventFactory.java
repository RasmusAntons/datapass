package de.rasmusantons.bungee.datapass_bukkit;

import de.rasmusantons.bungee.datapass_bukkit_api.events.DataPassEvent;
import de.rasmusantons.bungee.datapass_bukkit_api.events.DataPassPlayerListEvent;
import de.rasmusantons.bungee.datapass_bukkit_api.events.DataPassStringEvent;
import de.rasmusantons.bungee.datapass_common.Packet;
import de.rasmusantons.bungee.datapass_common_api.models.PlayerInfo;

import java.util.ArrayList;

public class DataPassEventFactory {
	public static DataPassEvent fromPacket(Packet packet) {
		switch(packet.getType()) {
			case STRING:
				return new DataPassStringEvent((String) packet.getData());
			case PLAYER_LIST:
				return new DataPassPlayerListEvent((ArrayList<PlayerInfo>) packet.getData());
			default:
				throw new AssertionError("invalid PacketType: " + packet.getType().toString());
		}
	}
}
