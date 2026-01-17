package net.reflact.common.network.packet;

public sealed interface ReflactPacket permits CastSpellPacket, ManaUpdatePacket, S2CSyncItemPacket {
    // Marker interface for all Reflact packets
}
