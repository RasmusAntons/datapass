package de.rasmusantons.bungee.datapass_bukkit_api.events;

import de.rasmusantons.bungee.datapass_common_api.PacketType;
import org.bukkit.event.HandlerList;

/**
 * Data event class that holds a string.
 */
public class DataPassStringEvent extends DataPassEvent {
	private static final PacketType TYPE = PacketType.STRING;
	private static final HandlerList handlers = new HandlerList();

	private String data;

	/**
	 * Constructor.
	 * @param data the string that is stored in this event
	 */
	public DataPassStringEvent(String data) {
		super(TYPE);
		this.data = data;
	}

	/**
	 * Returns the string this event holds.
	 * @return the string this event holds
	 */
	@Override
	public String getData() {
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
