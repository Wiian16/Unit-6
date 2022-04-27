package Project;

public class Term {
    private int coefficient;
    private int exponet;
    
    public Term(int coefficient, int exponet){
        this.coefficient = coefficient;
        this.exponet = exponet;
    }
    
    public int getExponet() {
        return exponet;
    }
    
    public int getCoefficient() {
        return coefficient;
    }
    
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
    
    public String toString(){
        String str;
        if(exponet == 1)
            str = coefficient + "x";
        else if(exponet == 0)
            str = coefficient + "";
        else
            str = coefficient + "x^" + exponet;
        return str;
    }
}