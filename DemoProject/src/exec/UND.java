package exec;

public  class  UND extends Gatter {


    public boolean getAusgabe(){

        return  getA() && getB();
    }
    public String toString() {
        return "UND{ " + "a=" +getA() + ", " + "b=" +getB() + ", " + "c=" +getAusgabe() + " }";
    }
}