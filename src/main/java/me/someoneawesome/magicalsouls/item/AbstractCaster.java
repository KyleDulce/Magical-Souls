package me.someoneawesome.magicalsouls.item;

import me.someoneawesome.magicalsouls.actions.SpellAction;
import me.someoneawesome.magicalsouls.constants.NetworkConstants;
import me.someoneawesome.magicalsouls.networking.ServerPacketManager;
import me.someoneawesome.magicalsouls.stats.SpellStats;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractCaster extends GenericMagicalItem {
    public static final Logger LOGGER = LoggerFactory.getLogger("magical-souls");

    protected final int baseInventorySize;
    protected final SpellStats baseStats;

    public AbstractCaster(String itemId, int baseInventorySize, SpellStats baseStats) {
        super(itemId, new Settings().maxCount(1).fireproof());
        this.baseInventorySize = baseInventorySize;
        this.baseStats = baseStats;
    }

    public abstract boolean canCastSpell(SpellAction spellAction);

    @Override
    public void initialize() {
        super.initialize();
        ServerPacketManager.receiveFromClient(NetworkConstants.KEYBIND_SPELL_INV_OPEN_PACKET, this::onInvOpen);
    }

    public void castSpell() {

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack handStack = user.getStackInHand(hand);
        try {
            if(world.isClient) {
                return TypedActionResult.pass(handStack);
            }
            if(hand == Hand.OFF_HAND) {
                return TypedActionResult.pass(handStack);
            }
            castSpell();
        } catch (Exception e) {
            return TypedActionResult.fail(handStack);
        }
        return TypedActionResult.success(handStack);
    }

    private void onInvOpen(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        if(player.getStackInHand(Hand.MAIN_HAND).getItem() != this) {
            LOGGER.info("failed - item");
            return;
        }

        LOGGER.info("success - item");
        player.sendMessage(Text.literal("Test"));
    }
}
