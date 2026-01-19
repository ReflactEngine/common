package net.reflact.common.network.packet;

public record MapDataPacket(int startX, int startZ, int width, int height, byte[] colors) implements ReflactPacket {}
