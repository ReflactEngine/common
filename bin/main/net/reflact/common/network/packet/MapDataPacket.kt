package net.reflact.common.network.packet

data class MapDataPacket(
    val startX: Int,
    val startZ: Int,
    val width: Int,
    val height: Int,
    val colors: ByteArray
) : ReflactPacket {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MapDataPacket

        if (startX != other.startX) return false
        if (startZ != other.startZ) return false
        if (width != other.width) return false
        if (height != other.height) return false
        if (!colors.contentEquals(other.colors)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = startX
        result = 31 * result + startZ
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + colors.contentHashCode()
        return result
    }
}
