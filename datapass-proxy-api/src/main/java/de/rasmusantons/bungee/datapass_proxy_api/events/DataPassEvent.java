package de.rasmusantons.bungee.datapass_proxy_api.events;

import de.rasmusantons.bungee.datapass_common_api.PacketType;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Event;

import java.io.Serializable;

/**
 * Base event class for data events that stores data type,
 * the server it is from/to and the data itself.
 * All data events need to extend this.
 * For every PacketType there should be a seperate data event class.
 */
public abstract class DataPassEvent extends Event {
	private PacketType type;
	private ServerInfo server;

	/**
	 * Constructor.
	 * @param type Enum entry representing the data type stored in this event
	 * @param server Server info ot the server this event is from/to
	 */
	public DataPassEvent(PacketType type, ServerInfo server) {
		this.type = type;
		this.server = server;
	}

	/**
	 * Returns the type of this event.
	 * @return Enum entry representing the data type stored in this event
	 */
	public final PacketType getType() {
		return type;
	}

	/**
	 * Returns the server this event is from/to.
	 * @return Server info ot the server this event is from/to
	 */
	public final ServerInfo getServer() {
		return server;
	}

	/**
	 * Returns the object this event holds.
	 * Extending classes should return an object of the class they hold.
	 * @return the object this event holds
	 */
	public abstract Serializable getData();
}
