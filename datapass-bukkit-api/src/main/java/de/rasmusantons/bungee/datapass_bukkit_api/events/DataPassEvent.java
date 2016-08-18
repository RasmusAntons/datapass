package de.rasmusantons.bungee.datapass_bukkit_api.events;

import de.rasmusantons.bungee.datapass_common_api.PacketType;
import org.bukkit.event.Event;

import java.io.Serializable;

/**
 * Base event class for data events that stores data type and the data itself.
 * All data events need to extend this.
 * For every PacketType there should be a seperate data event class.
 * <p />
 * Data event classes have to keep track of their own handlers and implement the methods
 * <code>public HandlerList getHandlers()</code>
 * and
 * <code>public static HandlerList getHandlerList()</code>
 * This can be done with the following code:
 * <pre><code>
 *  private static final HandlerList handlers = new HandlerList();
 *
 * {@literal @}Override
 *  public HandlerList getHandlers() {
 *      return handlers;
 *  }
 *
 *  public static HandlerList getHandlerList() {
 *      return handlers;
 *  }
 * </code></pre>
 */
public abstract class DataPassEvent extends Event {
	private PacketType type;

	/**
	 * Constructor.
	 * @param type Enum entry representing the data type stored in this event
	 */
	public DataPassEvent(PacketType type) {
		this.type = type;
	}

	/**
	 * Returns the type of this event.
	 * @return Enum entry representing the data type stored in this event
	 */
	public final PacketType getType() {
		return type;
	}

	/**
	 * Returns the object this event holds.
	 * Extending classes should return an object of the class they hold.
	 * @return the object this event holds
	 */
	public abstract Serializable getData();
}
