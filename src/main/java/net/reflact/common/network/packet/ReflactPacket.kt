package net.reflact.common.network.packet

import java.io.DataInput
import java.io.DataOutput

interface ReflactPacket {
    fun encode(output: DataOutput)
    fun decode(input: DataInput)
}
