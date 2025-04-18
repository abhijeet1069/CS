package knowJava.designPattern.behavioral;

interface IsEvenStrategy{
    boolean isEven(int num);
}

// Strategy 1
class IsEvenUsingBitwise implements IsEvenStrategy{
    @Override
    public boolean isEven(int num) {
        System.out.println("IsEvenUsingBitwise() called");
        return (num&1) == 0;
    }
}

// Strategy 2
class IsEvenUsingModulus implements IsEvenStrategy{
    @Override
    public boolean isEven(int num) {
        System.out.println("IsEvenUsingModulus() called");
        return (num%2) == 0;
    }
}

//Context class
class Calculate{
    //Default implementation
    private IsEvenStrategy strategy = new IsEvenUsingBitwise();

    public void setStrategy(IsEvenStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkEven(int num){
        return strategy.isEven(num);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        IsEvenStrategy strategy = new IsEvenUsingModulus();
        //IsEvenStrategy strategy1 = new IsEvenUsingBitwise();
        calculate.setStrategy(strategy);
        System.out.println(calculate.checkEven(12));
    }
}