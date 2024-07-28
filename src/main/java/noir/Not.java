package src.main.java.noir;

public class Not implements Expression {
    private final Expression operand;

    public Not(Expression operand) {
        this.operand = operand;
    }

    @Override
    public boolean evaluate() {
        return !operand.evaluate();
    }
}
