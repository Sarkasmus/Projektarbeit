package exec;

public  class  UND extends Gatter {


    public boolean getAusgabeBoolean(){
        getA();
        getB();
        return  getABoolean() && getBBoolean();

    }


    public String toString() {
        return "UND{ " + "a=" +getA() + ", " + "b=" +getB() + ", " + "c=" +getAusgabe() + " }";
    }


}
