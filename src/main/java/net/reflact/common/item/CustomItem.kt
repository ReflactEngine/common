package net.reflact.common.item

import java.util.*

class CustomItem private constructor() {
    var id: String = ""
        private set
    var uuid: UUID? = null
        private set
    var name: String? = null
        private set
    var lore: MutableList<String> = ArrayList()
        private set
    var customModelData: Int = 0
        private set
    var type: ItemType = ItemType.MATERIAL
        private set
    var tier: ItemTier = ItemTier.NORMAL
        private set
    var levelRequirement: Int = 1
        private set
    var attributes: MutableMap<String, Double> = HashMap()
        private set
    var metadata: MutableMap<String, String> = HashMap()
        private set

    fun encode(output: java.io.DataOutput) {
        output.writeUTF(id)
        output.writeBoolean(uuid != null)
        if (uuid != null) {
            output.writeLong(uuid!!.mostSignificantBits)
            output.writeLong(uuid!!.leastSignificantBits)
        }
        output.writeBoolean(name != null)
        if (name != null) output.writeUTF(name!!)
        output.writeInt(lore.size)
        for (line in lore) output.writeUTF(line)
        output.writeInt(customModelData)
        output.writeUTF(type.name)
        output.writeUTF(tier.name)
        output.writeInt(levelRequirement)
        output.writeInt(attributes.size)
        for ((k, v) in attributes) {
            output.writeUTF(k)
            output.writeDouble(v)
        }
        output.writeInt(metadata.size)
        for ((k, v) in metadata) {
            output.writeUTF(k)
            output.writeUTF(v)
        }
    }

    companion object {
        fun decode(input: java.io.DataInput): CustomItem {
            val item = CustomItem()
            item.id = input.readUTF()
            if (input.readBoolean()) {
                item.uuid = UUID(input.readLong(), input.readLong())
            }
            if (input.readBoolean()) {
                item.name = input.readUTF()
            }
            val loreCount = input.readInt()
            for (i in 0 until loreCount) {
                item.lore.add(input.readUTF())
            }
            item.customModelData = input.readInt()
            item.type = try { ItemType.valueOf(input.readUTF()) } catch (e: Exception) { ItemType.MATERIAL }
            item.tier = try { ItemTier.valueOf(input.readUTF()) } catch (e: Exception) { ItemTier.NORMAL }
            item.levelRequirement = input.readInt()
            val attrCount = input.readInt()
            for (i in 0 until attrCount) {
                item.attributes[input.readUTF()] = input.readDouble()
            }
            val metaCount = input.readInt()
            for (i in 0 until metaCount) {
                item.metadata[input.readUTF()] = input.readUTF()
            }
            return item
        }

        fun builder(id: String, type: ItemType, tier: ItemTier): Builder {
            return Builder(id, type, tier)
        }
    }

    /**
     * Creates a new unique instance based on this template.
     * Generates a new UUID.
     */
    fun instantiate(): CustomItem {
        val instance = CustomItem()
        instance.id = this.id
        instance.uuid = UUID.randomUUID()
        instance.name = this.name
        instance.lore = ArrayList(this.lore)
        instance.customModelData = this.customModelData
        instance.type = this.type
        instance.tier = this.tier
        instance.levelRequirement = this.levelRequirement
        instance.attributes = HashMap(this.attributes)
        instance.metadata = HashMap(this.metadata)
        return instance
    }

    fun getAttribute(key: String): Double {
        return attributes.getOrDefault(key, 0.0)
    }

    fun getMeta(key: String): String? {
        return metadata[key]
    }

    // Builder Class
    class Builder(id: String, type: ItemType, tier: ItemTier) {
        private val item: CustomItem = CustomItem()

        init {
            item.id = id
            item.type = type
            item.tier = tier
            // Templates don't need UUIDs usually, but for safety
            item.uuid = null
        }

        fun minLevel(level: Int): Builder {
            item.levelRequirement = level
            return this
        }

        fun name(name: String): Builder {
            item.name = name
            return this
        }

        fun lore(vararg lines: String): Builder {
            Collections.addAll(item.lore, *lines)
            return this
        }

        fun lore(lines: List<String>): Builder {
            item.lore.addAll(lines)
            return this
        }

        fun model(data: Int): Builder {
            item.customModelData = data
            return this
        }

        fun attr(key: String, value: Double): Builder {
            item.attributes[key] = value
            return this
        }

        fun meta(key: String, value: String): Builder {
            item.metadata[key] = value
            return this
        }

        fun build(): CustomItem {
            return item
        }
    }
}
