package net.reflact.common.attribute

data class AttributeModifier(
    val id: String,
    val value: Double,
    val operation: Operation
) {
    enum class Operation {
        ADD_NUMBER,
        ADD_SCALAR,
        MULTIPLY_SCALAR
    }
}
