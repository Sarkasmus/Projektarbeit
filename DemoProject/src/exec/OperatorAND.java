package exec;

public abstract class OperatorAND extends Gatter {

    public OperatorAND(boolean a, boolean b) {
        super(a, b);
    }

    public boolean ausgabe (boolean a, boolean b){
        boolean ResultAND;
        return  a && b;
    }
}
