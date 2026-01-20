package net.reflact.common.network.packet

import net.reflact.common.item.CustomItem
import java.io.DataInput
import java.io.DataOutput

class S2CSyncItemPacket : ReflactPacket {
    var item: CustomItem? = null
    var slotId: Int = 0

    constructor()

    constructor(item: CustomItem, slotId: Int) {
        this.item = item
        this.slotId = slotId
    }

    override fun encode(output: DataOutput) {
        output.writeBoolean(item != null)
        if (item != null) {
            item!!.encode(output)
        }
        output.writeInt(slotId)
    }

    override fun decode(input: DataInput) {
        if (input.readBoolean()) {
            item = CustomItem.decode(input)
        }
        slotId = input.readInt()
    }
}
