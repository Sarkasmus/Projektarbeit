package exec;

public abstract class OperatorNOT extends Gatter{


    public boolean[] ausgabe(boolean a, boolean b) {
        return new boolean[]{!a, !b};
    }
}
