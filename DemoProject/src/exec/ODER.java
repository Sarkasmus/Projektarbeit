package exec;

public  class ODER extends Gatter {

    public boolean getAusgabeboolean(){

        return getABoolean() || getBBoolean();
    }

    public String toString() {
        return "ODER{" + getA() + "," + getB() + "," + getAusgabe() + "}";
    }

}