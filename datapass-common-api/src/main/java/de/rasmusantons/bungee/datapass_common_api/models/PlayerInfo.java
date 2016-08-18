package de.rasmusantons.bungee.datapass_common_api.models;

import java.io.Serializable;
import java.util.UUID;

/**
 * This class stores the information of a player.
 * This can be used inside an ArrayList to get a serializable player list.
 */
public class PlayerInfo implements Serializable {
	private UUID id;
	private String name;

	/**
	 * Constructor.
	 * @param id the UUID of the player
	 * @param name the player's name
	 */
	public PlayerInfo(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Returns the UUID of the player
	 * @return UUID of the player
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Returns the player's name
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}
}
