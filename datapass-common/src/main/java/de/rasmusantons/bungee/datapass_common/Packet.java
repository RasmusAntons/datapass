package de.rasmusantons.bungee.datapass_common;

import de.rasmusantons.bungee.datapass_common_api.PacketType;

import java.io.*;

public class Packet implements Serializable {
	private PacketType type;
	private Serializable data;

	public Packet(PacketType type, Serializable data) {
		this.type = type;
		this.data = data;
	}

	public PacketType getType() {
		return type;
	}

	public Object getData() {
		return data;
	}

	public byte[] toBytes() {
		try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			 ObjectOutputStream objectStream = new ObjectOutputStream(byteStream)) {
			objectStream.writeObject(this);
			return byteStream.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static Packet fromBytes(byte[] bytes) {
		try (ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
			 ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
			return (Packet) objectStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
