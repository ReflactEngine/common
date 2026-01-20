package net.reflact.common.attribute

object RpgAttributes {
    @JvmField val HEALTH = Attribute("health", 20.0, 1.0, 100000.0)
    @JvmField val HEALTH_REGEN = Attribute("health_regen", 1.0)
    @JvmField val MANA = Attribute("mana", 100.0)
    @JvmField val MANA_REGEN = Attribute("mana_regen", 5.0)
    @JvmField val ATTACK_DAMAGE = Attribute("attack_damage", 1.0)
    @JvmField val ATTACK_SPEED = Attribute("attack_speed", 4.0)
    @JvmField val WALK_SPEED = Attribute("walk_speed", 0.1)
    @JvmField val DEFENSE = Attribute("defense", 0.0)

    // Main Stats (Skill Points)
    @JvmField val STRENGTH = Attribute("strength", 0.0)       // Earth Dmg, Defense?
    @JvmField val DEXTERITY = Attribute("dexterity", 0.0)     // Thunder Dmg, Crit
    @JvmField val INTELLIGENCE = Attribute("intelligence", 0.0) // Water Dmg, Mana Cost
    @JvmField val AGILITY = Attribute("agility", 0.0)         // Air Dmg, Dodge
    // Defense is already defined, used for Fire Dmg / Health Regen in Wynn logic usually, or separate

    // Damages
    @JvmField val DAMAGE_BONUS = Attribute("damage_bonus", 0.0) // %
    @JvmField val SPELL_DAMAGE = Attribute("spell_damage", 0.0) // %
    @JvmField val SPELL_DAMAGE_RAW = Attribute("spell_damage_raw", 0.0)
    @JvmField val MELEE_DAMAGE = Attribute("melee_damage", 0.0) // %
    @JvmField val MELEE_DAMAGE_RAW = Attribute("melee_damage_raw", 0.0)

    @JvmField val EARTH_DAMAGE = Attribute("earth_damage", 0.0)
    @JvmField val THUNDER_DAMAGE = Attribute("thunder_damage", 0.0)
    @JvmField val WATER_DAMAGE = Attribute("water_damage", 0.0)
    @JvmField val FIRE_DAMAGE = Attribute("fire_damage", 0.0)
    @JvmField val AIR_DAMAGE = Attribute("air_damage", 0.0)

    // Sustain
    @JvmField val HEALTH_REGEN_PERCENT = Attribute("health_regen_percent", 0.0)
    @JvmField val MANA_STEAL = Attribute("mana_steal", 0.0) // /3s
    @JvmField val LIFE_STEAL = Attribute("life_steal", 0.0) // /3s

    // Misc
    @JvmField val EXPLODING = Attribute("exploding", 0.0)
    @JvmField val SOUL_POINT_REGEN = Attribute("soul_point_regen", 0.0)
    @JvmField val LOOT_BONUS = Attribute("loot_bonus", 0.0)
    @JvmField val XP_BONUS = Attribute("xp_bonus", 0.0)
    @JvmField val CRIT_CHANCE = Attribute("crit_chance", 0.0)
    @JvmField val CRIT_DAMAGE = Attribute("crit_damage", 0.0)
    @JvmField val THORNS = Attribute("thorns", 0.0)
    @JvmField val REFLECTION = Attribute("reflection", 0.0)

    fun registerAll() {
        AttributeRegistry.register(HEALTH)
        AttributeRegistry.register(HEALTH_REGEN)
        AttributeRegistry.register(MANA)
        AttributeRegistry.register(MANA_REGEN)
        AttributeRegistry.register(ATTACK_DAMAGE)
        AttributeRegistry.register(ATTACK_SPEED)
        AttributeRegistry.register(WALK_SPEED)
        AttributeRegistry.register(DEFENSE)

        AttributeRegistry.register(STRENGTH)
        AttributeRegistry.register(DEXTERITY)
        AttributeRegistry.register(INTELLIGENCE)
        AttributeRegistry.register(AGILITY)

        AttributeRegistry.register(DAMAGE_BONUS)
        AttributeRegistry.register(SPELL_DAMAGE)
        AttributeRegistry.register(SPELL_DAMAGE_RAW)
        AttributeRegistry.register(MELEE_DAMAGE)
        AttributeRegistry.register(MELEE_DAMAGE_RAW)

        AttributeRegistry.register(EARTH_DAMAGE)
        AttributeRegistry.register(THUNDER_DAMAGE)
        AttributeRegistry.register(WATER_DAMAGE)
        AttributeRegistry.register(FIRE_DAMAGE)
        AttributeRegistry.register(AIR_DAMAGE)

        AttributeRegistry.register(HEALTH_REGEN_PERCENT)
        AttributeRegistry.register(MANA_STEAL)
        AttributeRegistry.register(LIFE_STEAL)

        AttributeRegistry.register(EXPLODING)
        AttributeRegistry.register(SOUL_POINT_REGEN)
        AttributeRegistry.register(LOOT_BONUS)
        AttributeRegistry.register(XP_BONUS)
        AttributeRegistry.register(CRIT_CHANCE)
        AttributeRegistry.register(CRIT_DAMAGE)
        AttributeRegistry.register(THORNS)
        AttributeRegistry.register(REFLECTION)
    }
}
