package de.rasmusantons.bungee.datapass_bukkit_api;

import de.rasmusantons.bungee.datapass_bukkit_api.events.DataPassEvent;

public interface DataSender {
	/**
	 * Send a data event to the proxy server.
	 * @param dataEvent the event
	 */
	void sendData(DataPassEvent dataEvent);
}
