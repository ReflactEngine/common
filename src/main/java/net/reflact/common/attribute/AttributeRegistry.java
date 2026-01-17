package net.reflact.common.attribute;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AttributeRegistry {
    private static final Map<String, Attribute> ATTRIBUTES = new HashMap<>();

    public static void register(Attribute attribute) {
        ATTRIBUTES.put(attribute.id(), attribute);
    }

    public static Optional<Attribute> get(String id) {
        return Optional.ofNullable(ATTRIBUTES.get(id));
    }

    public static Collection<Attribute> getAll() {
        return ATTRIBUTES.values();
    }
}
