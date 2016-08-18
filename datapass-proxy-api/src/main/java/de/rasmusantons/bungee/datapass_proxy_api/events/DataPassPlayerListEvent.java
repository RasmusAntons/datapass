package de.rasmusantons.bungee.datapass_proxy_api.events;

import de.rasmusantons.bungee.datapass_common_api.PacketType;
import de.rasmusantons.bungee.datapass_common_api.models.PlayerInfo;
import net.md_5.bungee.api.config.ServerInfo;

import java.util.ArrayList;

/**
 * Data event class that holds a list of player information.
 */
public class DataPassPlayerListEvent extends DataPassEvent {
	private static final PacketType TYPE = PacketType.PLAYER_LIST;

	private ArrayList<PlayerInfo> data;

	/**
	 * Constructor.
	 * @param data the player list that is stored in this event
	 * @param server Server info ot the server this event is from/to
	 */
	public DataPassPlayerListEvent(ServerInfo server, ArrayList<PlayerInfo> data) {
		super(TYPE, server);
		this.data = data;
	}

	/**
	 * Returns the player list this event holds.
	 * @return the player list this event holds
	 */
	@Override
	public ArrayList<PlayerInfo> getData() {
		return data;
	}
}
