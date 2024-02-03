public class ComplexNumber {
    private double a;
    private double i;

    public ComplexNumber(){
        a = 0;
        i = 0;
    }

    public ComplexNumber(double a, double i){
        this.a = a;
        this.i = i;
    }

    public ComplexNumber(ComplexNumber x){
        a = x.a;
        i = x.i;
    }

    public void SetReal(double a){
        this.a = a;
    }

    public void SetImaginary(double i){
        this.i = i;
    }

    public double GetReal(){
        return a;
    }

    public double GetImaginary(){
        return i;
    }

    public ComplexNumber addition(ComplexNumber current){
        return new ComplexNumber(a + current.a, i + current.i);
    }

    public ComplexNumber subtraction(ComplexNumber current){
        return new ComplexNumber(a - current.a, i - current.i);
    }

    public ComplexNumber multiplication(ComplexNumber current){
        return new ComplexNumber(a * current.a - i * current.i, i * current.a + a * current.i);
    }

    public void print(){
        if (i > 0){
            System.out.print(Math.round(a*10)/10.0 + "+" + Math.round(i*10)/10.0 + "i ");
        }
        else{
            System.out.print(Math.round(a*10)/10.0 + "-" + (-Math.round(i*10)/10.0) + "i ");
        }
    }
}
