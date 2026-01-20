package net.reflact.common.attribute

import java.util.Optional

object AttributeRegistry {
    private val ATTRIBUTES = HashMap<String, Attribute>()

    fun register(attribute: Attribute) {
        ATTRIBUTES[attribute.id] = attribute
    }

    fun get(id: String): Optional<Attribute> {
        return Optional.ofNullable(ATTRIBUTES[id])
    }

    fun getAll(): Collection<Attribute> {
        return ATTRIBUTES.values
    }
}
