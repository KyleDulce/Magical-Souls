package me.someoneawesome.magicalsouls.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class ClientPacketManager {
    public static void sendToServer(Identifier identifier) {
        sendToServer(identifier, PacketByteBufs.empty());
    }


    public static void sendToServer(Identifier identifier, PacketByteBuf packetByteBuf) {
        ClientPlayNetworking.send(identifier, packetByteBuf);
    }

    public static void receiveFromServer(Identifier identifier, ClientPlayNetworking.PlayChannelHandler channelHandler) {
        ClientPlayNetworking.registerGlobalReceiver(identifier, channelHandler);
    }
}
