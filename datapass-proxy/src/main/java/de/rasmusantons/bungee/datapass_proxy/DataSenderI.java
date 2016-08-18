package de.rasmusantons.bungee.datapass_proxy;

import de.rasmusantons.bungee.datapass_common.Packet;
import de.rasmusantons.bungee.datapass_proxy_api.DataSender;
import de.rasmusantons.bungee.datapass_proxy_api.events.DataPassEvent;

public class DataSenderI implements DataSender {
	@Override
	public void sendData(DataPassEvent dataEvent) {
		dataEvent.getServer().sendData("DataPass", new Packet(dataEvent.getType(), dataEvent.getData()).toBytes());
	}
}
