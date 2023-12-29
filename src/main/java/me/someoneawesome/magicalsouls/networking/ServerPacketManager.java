package me.someoneawesome.magicalsouls.networking;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;


public class ServerPacketManager {

    public static void sendToClient(ServerPlayerEntity player, Identifier identifier) {
        sendToClient(player, identifier, PacketByteBufs.empty());
    }


    public static void sendToClient(ServerPlayerEntity player, Identifier identifier, PacketByteBuf packetByteBuf) {
        ServerPlayNetworking.send(player, identifier, packetByteBuf);
    }

    public static void receiveFromClient(Identifier identifier, ServerPlayNetworking.PlayChannelHandler channelHandler) {
        ServerPlayNetworking.registerGlobalReceiver(identifier, channelHandler);
    }
}
