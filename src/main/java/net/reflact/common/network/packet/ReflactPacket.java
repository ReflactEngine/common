package net.reflact.common.network.packet;

public sealed interface ReflactPacket permits CastSpellPacket, ManaUpdatePacket, S2CSyncItemPacket, CastSlotPacket {
    // Marker interface for all Reflact packets
}
