package de.rasmusantons.bungee.datapass_proxy_api;

import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassEvent;

public interface DataSender {
	/**
	 * Send a data event to the bukkit server specified in the event.
	 * @param dataEvent the event
	 */
	void sendData(DataPassEvent dataEvent);
}
