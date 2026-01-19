package net.reflact.common.attribute;

public class RpgAttributes {
    public static final Attribute HEALTH = new Attribute("health", 20.0, 1.0, 100000.0);
    public static final Attribute HEALTH_REGEN = new Attribute("health_regen", 1.0);
    public static final Attribute MANA = new Attribute("mana", 100.0);
    public static final Attribute MANA_REGEN = new Attribute("mana_regen", 5.0);
    public static final Attribute ATTACK_DAMAGE = new Attribute("attack_damage", 1.0);
    public static final Attribute ATTACK_SPEED = new Attribute("attack_speed", 4.0);
    public static final Attribute WALK_SPEED = new Attribute("walk_speed", 0.1);
    public static final Attribute DEFENSE = new Attribute("defense", 0.0);
    
    // Main Stats (Skill Points)
    public static final Attribute STRENGTH = new Attribute("strength", 0.0);       // Earth Dmg, Defense?
    public static final Attribute DEXTERITY = new Attribute("dexterity", 0.0);     // Thunder Dmg, Crit
    public static final Attribute INTELLIGENCE = new Attribute("intelligence", 0.0); // Water Dmg, Mana Cost
    public static final Attribute AGILITY = new Attribute("agility", 0.0);         // Air Dmg, Dodge
    // Defense is already defined, used for Fire Dmg / Health Regen in Wynn logic usually, or separate
    
    // Damages
    public static final Attribute DAMAGE_BONUS = new Attribute("damage_bonus", 0.0); // %
    public static final Attribute SPELL_DAMAGE = new Attribute("spell_damage", 0.0); // %
    public static final Attribute SPELL_DAMAGE_RAW = new Attribute("spell_damage_raw", 0.0);
    public static final Attribute MELEE_DAMAGE = new Attribute("melee_damage", 0.0); // %
    public static final Attribute MELEE_DAMAGE_RAW = new Attribute("melee_damage_raw", 0.0);
    
    public static final Attribute EARTH_DAMAGE = new Attribute("earth_damage", 0.0);
    public static final Attribute THUNDER_DAMAGE = new Attribute("thunder_damage", 0.0);
    public static final Attribute WATER_DAMAGE = new Attribute("water_damage", 0.0);
    public static final Attribute FIRE_DAMAGE = new Attribute("fire_damage", 0.0);
    public static final Attribute AIR_DAMAGE = new Attribute("air_damage", 0.0);

    // Sustain
    public static final Attribute HEALTH_REGEN_PERCENT = new Attribute("health_regen_percent", 0.0);
    public static final Attribute MANA_STEAL = new Attribute("mana_steal", 0.0); // /3s
    public static final Attribute LIFE_STEAL = new Attribute("life_steal", 0.0); // /3s
    
    // Misc
    public static final Attribute EXPLODING = new Attribute("exploding", 0.0);
    public static final Attribute SOUL_POINT_REGEN = new Attribute("soul_point_regen", 0.0);
    public static final Attribute LOOT_BONUS = new Attribute("loot_bonus", 0.0);
    public static final Attribute XP_BONUS = new Attribute("xp_bonus", 0.0);
    public static final Attribute CRIT_CHANCE = new Attribute("crit_chance", 0.0);
    public static final Attribute CRIT_DAMAGE = new Attribute("crit_damage", 0.0);
    public static final Attribute THORNS = new Attribute("thorns", 0.0);
    public static final Attribute REFLECTION = new Attribute("reflection", 0.0);

    public static void registerAll() {
        AttributeRegistry.register(HEALTH);
        AttributeRegistry.register(HEALTH_REGEN);
        AttributeRegistry.register(MANA);
        AttributeRegistry.register(MANA_REGEN);
        AttributeRegistry.register(ATTACK_DAMAGE);
        AttributeRegistry.register(ATTACK_SPEED);
        AttributeRegistry.register(WALK_SPEED);
        AttributeRegistry.register(DEFENSE);
        
        AttributeRegistry.register(STRENGTH);
        AttributeRegistry.register(DEXTERITY);
        AttributeRegistry.register(INTELLIGENCE);
        AttributeRegistry.register(AGILITY);
        
        AttributeRegistry.register(DAMAGE_BONUS);
        AttributeRegistry.register(SPELL_DAMAGE);
        AttributeRegistry.register(SPELL_DAMAGE_RAW);
        AttributeRegistry.register(MELEE_DAMAGE);
        AttributeRegistry.register(MELEE_DAMAGE_RAW);
        
        AttributeRegistry.register(EARTH_DAMAGE);
        AttributeRegistry.register(THUNDER_DAMAGE);
        AttributeRegistry.register(WATER_DAMAGE);
        AttributeRegistry.register(FIRE_DAMAGE);
        AttributeRegistry.register(AIR_DAMAGE);
        
        AttributeRegistry.register(HEALTH_REGEN_PERCENT);
        AttributeRegistry.register(MANA_STEAL);
        AttributeRegistry.register(LIFE_STEAL);
        
        AttributeRegistry.register(EXPLODING);
        AttributeRegistry.register(SOUL_POINT_REGEN);
        AttributeRegistry.register(LOOT_BONUS);
        AttributeRegistry.register(XP_BONUS);
        AttributeRegistry.register(CRIT_CHANCE);
        AttributeRegistry.register(CRIT_DAMAGE);
        AttributeRegistry.register(THORNS);
        AttributeRegistry.register(REFLECTION);
    }
}
