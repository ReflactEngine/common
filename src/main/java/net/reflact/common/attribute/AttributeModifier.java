package net.reflact.common.attribute;

public class AttributeModifier {
    private final String id;
    private final double value;
    private final Operation operation;

    public AttributeModifier(String id, double value, Operation operation) {
        this.id = id;
        this.value = value;
        this.operation = operation;
    }

    public String getId() { return id; }
    public double getValue() { return value; }
    public Operation getOperation() { return operation; }

    public enum Operation {
        ADD_NUMBER,
        ADD_SCALAR,
        MULTIPLY_SCALAR
    }
}
