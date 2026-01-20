package net.reflact.common.attribute

import java.util.concurrent.ConcurrentHashMap

class AttributeContainer {
    private val modifiers: MutableMap<String, MutableList<AttributeModifier>> = ConcurrentHashMap()

    fun addModifier(attribute: Attribute, modifier: AttributeModifier) {
        modifiers.computeIfAbsent(attribute.id) { ArrayList() }.add(modifier)
    }

    fun removeModifier(attribute: Attribute, modifierId: String) {
        if (modifiers.containsKey(attribute.id)) {
            modifiers[attribute.id]?.removeIf { it.id == modifierId }
        }
    }

    fun clearModifiersByPrefix(prefix: String) {
        for (mods in modifiers.values) {
            mods.removeIf { it.id.startsWith(prefix) }
        }
    }

    fun getValue(attribute: Attribute?): Double {
        if (attribute == null) return 0.0

        val base = attribute.baseValue
        val mods = modifiers.getOrDefault(attribute.id, emptyList())

        var addNumber = 0.0
        var addScalar = 0.0
        var multiplyScalar = 1.0

        for (mod in mods) {
            when (mod.operation) {
                AttributeModifier.Operation.ADD_NUMBER -> addNumber += mod.value
                AttributeModifier.Operation.ADD_SCALAR -> addScalar += mod.value
                AttributeModifier.Operation.MULTIPLY_SCALAR -> multiplyScalar *= mod.value
            }
        }

        val value = (base + addNumber) * (1 + addScalar) * multiplyScalar
        return value.coerceIn(attribute.minValue, attribute.maxValue)
    }
}
