package de.rasmusantons.bungee.datapass_proxy_api;

/**
 * Entry point that allows access to the DataSender object.
 */
public class DataPass {
	public static DataSender dataSender;

	/**
	 * This class should never be instantiated.
	 */
	private DataPass() {

	}

	/**
	 * Used to set the DataSender object.
	 * Only ever called by the datapass-proxy plugin.
	 * @param dataSender DataSender object
	 */
	public static void setDataSender(DataSender dataSender) {
		if (DataPass.dataSender != null)
			throw new UnsupportedOperationException("Cannot redefine singleton de.rasmusantons.bungee.datapass_proxy_api.DataSender");
		DataPass.dataSender = dataSender;
	}

	/**
	 * Allows access to the DataSender object.
	 * Use this to send data from a plugin using the datapass-proxy-api.
	 * @return DataSender object
	 */
	public static DataSender getDataSender() {
		return DataPass.dataSender;
	}
}
