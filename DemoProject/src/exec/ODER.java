package exec;

public  class ODER extends Gatter {

    public boolean getAusgabe(){

        return getA() || getB();
    }

    public String toString() {
        return "ODER{" + getA() + "," + getB() + "," + getAusgabe() + "}";
    }

}