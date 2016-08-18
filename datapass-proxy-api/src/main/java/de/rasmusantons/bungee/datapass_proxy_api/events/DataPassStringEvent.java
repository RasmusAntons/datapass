package de.rasmusantons.bungee.datapass_proxy_api.events;

import de.rasmusantons.bungee.datapass_common_api.PacketType;
import net.md_5.bungee.api.config.ServerInfo;

/**
 * Data event class that holds a string.
 */
public class DataPassStringEvent extends DataPassEvent {
	private static final PacketType TYPE = PacketType.STRING;

	private String data;

	/**
	 * Constructor.
	 * @param data the string that is stored in this event
	 * @param server Server info ot the server this event is from/to
	 */
	public DataPassStringEvent(ServerInfo server, String data) {
		super(TYPE, server);
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
}
