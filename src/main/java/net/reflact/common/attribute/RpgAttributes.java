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
    public static final Attribute STRENGTH = new Attribute("strength", 0.0);
    public static final Attribute INTELLIGENCE = new Attribute("intelligence", 0.0);

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
        AttributeRegistry.register(INTELLIGENCE);
    }
}
