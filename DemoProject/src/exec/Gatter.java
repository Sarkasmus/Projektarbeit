package exec;

public class Gatter {

    private boolean a;
    private boolean b;
    private boolean inv;

    public boolean getA() {

        return a;
    }

    public boolean getB() {

        return b;
    }

    public boolean getInv() {

        return !inv;
    }

    public boolean getAusgabe() {

        return false;
    }

    public void setA(boolean a) {

        this.a = a;
    }

    public void setB(boolean b) {

        this.b = b;
    }

    public void setInv(boolean inv) {
        this.inv = inv;
    }
}