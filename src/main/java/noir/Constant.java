package noir;

public class Constant implements Expression{
    private final boolean value;

    public Constant(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return value;
    }
}
