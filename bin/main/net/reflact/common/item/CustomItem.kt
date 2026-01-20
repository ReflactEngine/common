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

    companion object {
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
