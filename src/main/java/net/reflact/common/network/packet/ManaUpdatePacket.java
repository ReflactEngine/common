package net.reflact.common.network.packet;

public record ManaUpdatePacket(double currentMana, double maxMana) implements ReflactPacket {}
