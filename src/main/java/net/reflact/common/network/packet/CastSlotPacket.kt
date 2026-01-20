package net.reflact.common.network.packet

import java.io.DataInput
import java.io.DataOutput

class CastSlotPacket : ReflactPacket {
    var slotIndex: Int = 0

    constructor()

    constructor(slotIndex: Int) {
        this.slotIndex = slotIndex
    }

    override fun encode(output: DataOutput) {
        output.writeInt(slotIndex)
    }

    override fun decode(input: DataInput) {
        slotIndex = input.readInt()
    }
}
