package src.main.java.noir;

public class Implies implements Expression {
    private final Expression premise;
    private final Expression conclusion;

    public Implies(Expression premise, Expression conclusion) {
        this.premise = premise;
        this.conclusion = conclusion;
    }

    @Override
    public boolean evaluate() {
        return !premise.evaluate() || conclusion.evaluate();
    }
}
