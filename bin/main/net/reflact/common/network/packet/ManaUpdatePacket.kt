package net.reflact.common.network.packet

data class ManaUpdatePacket(val currentMana: Double, val maxMana: Double) : ReflactPacket
