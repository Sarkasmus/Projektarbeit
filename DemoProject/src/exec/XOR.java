package exec;

public class XOR extends Gatter {

    public boolean getAusgabeboolean(){

        return getABoolean() ^ getBBoolean();
    }

    public String toString() {
        return "XOR{" + getA() + "," + getB() + "," + getAusgabe() + "}";
    }

}