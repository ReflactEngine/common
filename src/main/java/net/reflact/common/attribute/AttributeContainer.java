package net.reflact.common.attribute;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AttributeContainer {
    private final Map<String, List<AttributeModifier>> modifiers = new ConcurrentHashMap<>();

    public void addModifier(Attribute attribute, AttributeModifier modifier) {
        modifiers.computeIfAbsent(attribute.id(), k -> new ArrayList<>()).add(modifier);
    }

    public void removeModifier(Attribute attribute, String modifierId) {
        if (modifiers.containsKey(attribute.id())) {
            modifiers.get(attribute.id()).removeIf(mod -> mod.getId().equals(modifierId));
        }
    }

    public void clearModifiersByPrefix(String prefix) {
        for (List<AttributeModifier> mods : modifiers.values()) {
            mods.removeIf(mod -> mod.getId().startsWith(prefix));
        }
    }

    public double getValue(Attribute attribute) {
        if (attribute == null) return 0;
        
        double base = attribute.baseValue();
        List<AttributeModifier> mods = modifiers.getOrDefault(attribute.id(), Collections.emptyList());

        double addNumber = 0;
        double addScalar = 0;
        double multiplyScalar = 1;

        for (AttributeModifier mod : mods) {
            switch (mod.getOperation()) {
                case ADD_NUMBER -> addNumber += mod.getValue();
                case ADD_SCALAR -> addScalar += mod.getValue();
                case MULTIPLY_SCALAR -> multiplyScalar *= mod.getValue();
            }
        }

        double value = (base + addNumber) * (1 + addScalar) * multiplyScalar;
        return Math.min(Math.max(value, attribute.minValue()), attribute.maxValue());
    }
}
