package exec;

public abstract class OperatorNOT extends Gatter{

    public OperatorNOT(boolean a, boolean b) {
        super(a, b);
    }

    public boolean[] ausgabe(boolean a, boolean b) {
        return new boolean[]{!a, !b};
    }
}
