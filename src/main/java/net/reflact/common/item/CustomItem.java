package net.reflact.common.item;

import java.util.*;

public class CustomItem {
    private String id;
    private UUID uuid;
    private String name;
    private List<String> lore;
    private int customModelData;
    private ItemType type;
    private ItemTier tier;
    private int levelRequirement;
    private Map<String, Double> attributes;
    private Map<String, String> metadata;

    // Private constructor for Builder/Serialization
    private CustomItem() {
        this.attributes = new HashMap<>();
        this.metadata = new HashMap<>();
        this.lore = new ArrayList<>();
        this.levelRequirement = 1;
    }

    public static Builder builder(String id, ItemType type, ItemTier tier) {
        return new Builder(id, type, tier);
    }

    /**
     * Creates a new unique instance based on this template.
     * Generates a new UUID.
     */
    public CustomItem instantiate() {
        CustomItem instance = new CustomItem();
        instance.id = this.id;
        instance.uuid = UUID.randomUUID();
        instance.name = this.name;
        instance.lore = new ArrayList<>(this.lore);
        instance.customModelData = this.customModelData;
        instance.type = this.type;
        instance.tier = this.tier;
        instance.levelRequirement = this.levelRequirement;
        instance.attributes = new HashMap<>(this.attributes);
        instance.metadata = new HashMap<>(this.metadata);
        return instance;
    }

    public String getId() { return id; }
    public UUID getUuid() { return uuid; }
    public String getName() { return name; }
    public List<String> getLore() { return lore; }
    public int getCustomModelData() { return customModelData; }
    public ItemType getType() { return type; }
    public ItemTier getTier() { return tier; }
    public int getLevelRequirement() { return levelRequirement; }
    public Map<String, Double> getAttributes() { return attributes; }
    public Map<String, String> getMetadata() { return metadata; }

    public Double getAttribute(String key) {
        return attributes.getOrDefault(key, 0.0);
    }
    
    public String getMeta(String key) {
        return metadata.get(key);
    }

    // Builder Class
    public static class Builder {
        private final CustomItem item;

        public Builder(String id, ItemType type, ItemTier tier) {
            this.item = new CustomItem();
            this.item.id = id;
            this.item.type = type;
            this.item.tier = tier;
            // Templates don't need UUIDs usually, but for safety
            this.item.uuid = null; 
        }
        
        public Builder minLevel(int level) {
            item.levelRequirement = level;
            return this;
        }

        public Builder name(String name) {
            item.name = name;
            return this;
        }

        public Builder lore(String... lines) {
            Collections.addAll(item.lore, lines);
            return this;
        }
        
        public Builder lore(List<String> lines) {
            item.lore.addAll(lines);
            return this;
        }

        public Builder model(int data) {
            item.customModelData = data;
            return this;
        }

        public Builder attr(String key, double value) {
            item.attributes.put(key, value);
            return this;
        }

        public Builder meta(String key, String value) {
            item.metadata.put(key, value);
            return this;
        }

        public CustomItem build() {
            return item;
        }
    }
}
