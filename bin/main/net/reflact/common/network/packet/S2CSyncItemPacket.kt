package net.reflact.common.network.packet

import net.reflact.common.item.CustomItem

data class S2CSyncItemPacket(val item: CustomItem, val slotId: Int) : ReflactPacket
