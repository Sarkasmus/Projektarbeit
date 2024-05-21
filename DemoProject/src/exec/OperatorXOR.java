package exec;

abstract class OperatorXOR extends Gatter {

    public OperatorXOR(boolean a, boolean b) {
        super(a, b);
    }

    public boolean ausgabe (boolean a, boolean b){
        boolean ResultXOR;
        return ResultXOR = a ^ b;
    }

}
