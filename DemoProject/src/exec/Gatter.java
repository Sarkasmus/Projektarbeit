package exec;

public class Gatter {

    private boolean aBoolean;
    private boolean bBoolean;
    private boolean inv;


    private int a;
    private int b;


    public boolean getABoolean() {

        return aBoolean;
    }

    public boolean getBBoolean() {

        return bBoolean;
    }

    public boolean getInv() {

        return !inv;
    }

    public boolean getAusgabeBoolean() {

        return false;
    }

    public int getA(){
        if(a==0){
            setABoolean(false);
        }
        else
            setABoolean(true);
        return aBoolean ? 1:0;
    }

    public int getB(){
        if(b==0){
            setBBoolean(false);
        }
        else
            setBBoolean(true);
        return bBoolean ? 1:0;

    }

    public int getAusgabe(){
        return getAusgabeBoolean() ? 1:0;
    }

    public int getInvtoint(){
        return inv ? 1:0;
    }

    public void setABoolean(boolean aBoolean) {

        this.aBoolean = aBoolean;
    }


    public void setBBoolean(boolean bBoolean) {

        this.bBoolean = bBoolean;
    }

    public void setInv(boolean inv) {
        this.inv = inv;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }




}