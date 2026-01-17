package net.reflact.common.network;

import net.reflact.common.network.packet.*;
import java.util.Map;
import java.util.HashMap;

public class PacketRegistry {
    private static final Map<String, Class<? extends ReflactPacket>> REGISTRY = new HashMap<>();

    static {
        REGISTRY.put("cast_spell", CastSpellPacket.class);
        REGISTRY.put("mana_update", ManaUpdatePacket.class);
        REGISTRY.put("sync_item", S2CSyncItemPacket.class);
    }

    public static Class<? extends ReflactPacket> get(String id) {
        return REGISTRY.get(id);
    }
    
    public static String getId(Class<? extends ReflactPacket> clazz) {
        for (var entry : REGISTRY.entrySet()) {
            if (entry.getValue().equals(clazz)) return entry.getKey();
        }
        return null;
    }
}
