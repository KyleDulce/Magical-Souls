package me.someoneawesome.magicalsouls.keybind;

import me.someoneawesome.magicalsouls.common.Initializable;
import me.someoneawesome.magicalsouls.networking.ClientPacketManager;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class PacketedKeyBind extends AbstractKeyBind {

    private Identifier packetId;

    public PacketedKeyBind(int keyCode, InputUtil.Type keyType, String keyBindId, String categoryId, Identifier packetId) {
        super(keyCode, keyType, keyBindId, categoryId);
        this.packetId = packetId;
    }

    @Override
    protected void onPressOnce() {
        ClientPacketManager.sendToServer(packetId);
    }
}
