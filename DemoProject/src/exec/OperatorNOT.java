package exec;

public abstract class OperatorNOT extends Gatter {

    // public boolean[] ausgabe(boolean a, boolean b) {
    //    return new boolean[]{!a, !b};
    // }
   /*
    public boolean ausgabe(boolean a, boolean b){
        if (a = true){
            a= false;
        }
        if (a = false) {
            a = true;

        }
        if (b = true){
            b= false;
        }
        if (b = false) {
            b = true;
        }
        return ausgabe (a, b);
    }
}
 */
    public boolean ausgabe(boolean a, boolean b) {
        return ausgabe (!a, !b);
    }
}
