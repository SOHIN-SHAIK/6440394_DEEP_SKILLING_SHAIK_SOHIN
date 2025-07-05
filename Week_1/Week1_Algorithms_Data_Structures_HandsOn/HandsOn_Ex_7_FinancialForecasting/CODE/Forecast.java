public class Forecast {

    public static double futureValue(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;
        return (1 + rate) * futureValue(presentValue, rate, years - 1);
    }

    public static double futureValueMemo(double presentValue, double rate, int years, double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = (1 + rate) * futureValueMemo(presentValue, rate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double present = 10000; 
        double rate = 0.10;      
        int years = 5;

        double result = futureValue(present, rate, years);
        System.out.println("Future Value (Recursive): ₹" + result);

        double[] memo = new double[years + 1];
        double optimized = futureValueMemo(present, rate, years, memo);
        System.out.println("Future Value (Memoized): ₹" + optimized);
    }
}
