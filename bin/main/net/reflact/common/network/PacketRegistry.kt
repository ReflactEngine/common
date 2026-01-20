package net.reflact.common.network

import net.reflact.common.network.packet.*

object PacketRegistry {
    private val REGISTRY = HashMap<String, Class<out ReflactPacket>>()

    init {
        REGISTRY["cast_spell"] = CastSpellPacket::class.java
        REGISTRY["mana_update"] = ManaUpdatePacket::class.java
        REGISTRY["sync_item"] = S2CSyncItemPacket::class.java
        REGISTRY["cast_slot"] = CastSlotPacket::class.java
        REGISTRY["map_data"] = MapDataPacket::class.java
    }

    fun get(id: String): Class<out ReflactPacket>? {
        return REGISTRY[id]
    }

    fun getId(clazz: Class<out ReflactPacket>): String? {
        for ((key, value) in REGISTRY) {
            if (value == clazz) return key
        }
        return null
    }
}
