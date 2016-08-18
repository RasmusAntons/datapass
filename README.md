# DataPass

DataPass allows bungeecord proxy plugins and bukkit plugins to exchange data more conveniently.
This is currently work in progress and I'll probably change the api a bit until version 1.0.

## Features

One side can send a (serializable) java object. The other side will then receive an event that can be processed by normal (either bungee or bukkit) event handlers.

## How it works

DataPass uses the [Plugin Messaging Channel](https://www.spigotmc.org/wiki/bukkit-bungee-plugin-messaging-channel/) to send the serialized data.

## Binaries (v0.0)

* The Bukkit plugin: [datapass-bukkit](http://spigot.rasmusantons.de/files/datapass-bukkit-0.0-jar-with-dependencies.jar)
* The Bungee Proxy plugin: [datapass-proxy](http://spigot.rasmusantons.de/files/datapass-proxy-0.0-jar-with-dependencies.jar)

## Using the api

### Bukkit

#### Sending Data

Create a new DataPassEvent containing your data:

```java
DataPassEvent dataEvent = new DataPassStringEvent("This is a String!");
```

Send the data to the bungee proxy by calling

```java
DataPass.getDataSender().sendData(dataEvent);
```

#### Receiving Data

Register a new EventHandler:

```java
@EventHandler
public void onStringReceived(DataPassStringEvent event) {
    String data = event.getData();
}
```

### Bungee Proxy

#### Sending Data

Create a new DataPassEvent containing your data and the server it should be sent to:

```java
ServerInfo server = getProxy().getServerInfo("Example");
DataPassEvent dataEvent = new DataPassStringEvent(server, "Another String.");
```

Send the data to the bukkit server by calling

```java
DataPass.getDataSender().sendData(dataEvent);
```

#### Receiving Data

Register a new EventHandler:

```java
@EventHandler
public void onStringReceiver(DataPassStringEvent event) {
    ServerInfo server = event.getServer();
    String data = event.getData()
}
```
