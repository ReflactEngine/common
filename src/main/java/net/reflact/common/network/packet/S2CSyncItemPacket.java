package net.reflact.common.network.packet;

import net.reflact.common.item.CustomItem;

public record S2CSyncItemPacket(CustomItem item, int slotId) implements ReflactPacket {}
