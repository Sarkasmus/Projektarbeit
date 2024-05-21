package exec;

public abstract class OperatorOR extends Gatter {

    public OperatorOR(boolean a, boolean b) {
        super(a, b);
    }

    public boolean ausgabe (boolean a, boolean b){
        boolean ResultOR;
        return ResultOR = a || b;
    }

}
