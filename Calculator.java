public class Calculator {
    private long result;

    public long getResult() {
        return result;
    }

    public long add(long a, long b) {
        result = a + b;
        return result;
    }

    public long add(long a) {
        return result +=a;
    }

    public long sub(long a, long b){
        result = a - b;
        return result;
    }

    public long sub(long a){
        result -= a;
        return result;
    }
    public long mul(long a, long b){
       result = a * b;
       return result;
    }
    public long mul(long a){
        result *= a;
        return result;
    }

    public long div(long a, long b) {
        if (b ==0) {
            throw new ArithmeticException();
        }
        result = a / b;
        return result;
    }
    public long div(long a) {
        if (a==0) {
            throw new ArithmeticException();
        }
        result /= a;
        return result;
    }
}
