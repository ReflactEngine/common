package net.reflact.common.network.packet

import net.reflact.common.network.packet.ReflactPacket
import java.io.DataInput
import java.io.DataOutput

class DamageIndicatorPacket : ReflactPacket {
    var entityId: Int = 0
    var amount: Double = 0.0
    var isCritical: Boolean = false

    constructor()

    constructor(entityId: Int, amount: Double, isCritical: Boolean) {
        this.entityId = entityId
        this.amount = amount
        this.isCritical = isCritical
    }

    override fun encode(output: DataOutput) {
        output.writeInt(entityId)
        output.writeDouble(amount)
        output.writeBoolean(isCritical)
    }

    override fun decode(input: DataInput) {
        entityId = input.readInt()
        amount = input.readDouble()
        isCritical = input.readBoolean()
    }
}
