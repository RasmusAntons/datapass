package de.rasmusantons.bungee.datapass_bukkit_api.events;

import de.rasmusantons.bungee.datapass_common_api.PacketType;
import de.rasmusantons.bungee.datapass_common_api.models.PlayerInfo;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;

/**
 * Data event class that holds a list of player information.
 */
public class DataPassPlayerListEvent extends DataPassEvent {
	private static final PacketType TYPE = PacketType.PLAYER_LIST;
	private static final HandlerList handlers = new HandlerList();

	private ArrayList<PlayerInfo> data;

	/**
	 * Constructor.
	 * @param data the player list that is stored in this event
	 */
	public DataPassPlayerListEvent(ArrayList<PlayerInfo> data) {
		super(TYPE);
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

	/**
	 * Used by bukkit to access the handlers that listen for this event class.
	 * @return List of handlers listening for this event class
	 */
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	/**
	 * Used by bukkit to access the handlers that listen for this event class.
	 * @return List of handlers listening for this event class
	 */
	public static HandlerList getHandlerList() {
		return handlers;
	}
}
