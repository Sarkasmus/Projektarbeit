package exec;

public abstract class Gatter {

    private boolean a;
    private boolean b;

    public Gatter(boolean a, boolean b) {
        this.a = a;
        this.b = b;
    }
    public abstract boolean ausgabe();
}