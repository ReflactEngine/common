package net.reflact.common.item

enum class ItemTier(val displayName: String, val color: Int) {
    NORMAL("Normal", 0xFFFFFF),
    UNIQUE("Unique", 0xFFFF55),
    RARE("Rare", 0xFF55FF),
    LEGENDARY("Legendary", 0x55FFFF),
    MYTHIC("Mythic", 0xAA00AA);
}
