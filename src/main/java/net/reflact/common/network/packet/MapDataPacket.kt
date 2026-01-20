package net.reflact.common.network.packet

import java.io.DataInput
import java.io.DataOutput

class MapDataPacket : ReflactPacket {
    var startX: Int = 0
    var startZ: Int = 0
    var width: Int = 0
    var height: Int = 0
    var colors: ByteArray = ByteArray(0)

    constructor()

    constructor(startX: Int, startZ: Int, width: Int, height: Int, colors: ByteArray) {
        this.startX = startX
        this.startZ = startZ
        this.width = width
        this.height = height
        this.colors = colors
    }

    override fun encode(output: DataOutput) {
        output.writeInt(startX)
        output.writeInt(startZ)
        output.writeInt(width)
        output.writeInt(height)
        output.writeInt(colors.size)
        output.write(colors)
    }

    override fun decode(input: DataInput) {
        startX = input.readInt()
        startZ = input.readInt()
        width = input.readInt()
        height = input.readInt()
        val size = input.readInt()
        colors = ByteArray(size)
        input.readFully(colors)
    }
}
