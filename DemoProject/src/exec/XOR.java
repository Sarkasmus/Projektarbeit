package exec;

public class XOR extends Gatter {

    public boolean getAusgabe(){

        return getA() ^ getB();
    }

    public String toString() {
        return "XOR{" + getA() + "," + getB() + "," + getAusgabe() + "}";
    }

}
