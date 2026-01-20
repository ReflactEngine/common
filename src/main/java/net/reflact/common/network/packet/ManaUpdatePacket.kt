package net.reflact.common.network.packet

import java.io.DataInput
import java.io.DataOutput

class ManaUpdatePacket : ReflactPacket {
    var currentMana: Double = 0.0
    var maxMana: Double = 0.0

    constructor() // No-arg constructor for reflection/decoding

    constructor(currentMana: Double, maxMana: Double) {
        this.currentMana = currentMana
        this.maxMana = maxMana
    }

    override fun encode(output: DataOutput) {
        output.writeDouble(currentMana)
        output.writeDouble(maxMana)
    }

    override fun decode(input: DataInput) {
        currentMana = input.readDouble()
        maxMana = input.readDouble()
    }
}
