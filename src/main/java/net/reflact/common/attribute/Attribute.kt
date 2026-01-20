package net.reflact.common.attribute

data class Attribute(
    val id: String,
    val baseValue: Double,
    val minValue: Double = Double.MIN_VALUE,
    val maxValue: Double = Double.MAX_VALUE
)
