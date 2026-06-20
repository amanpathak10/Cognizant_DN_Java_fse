public class FinancialForecastingExample {
    // Recursive future value: FV = principal * (1+rate)^n implemented recursively
    static double futureValueRecursive(double principal, double rate, int periods){
        if(periods==0) return principal;
        return futureValueRecursive(principal, rate, periods-1) * (1+rate);
    }

    // Optimized iterative version
    static double futureValueIterative(double principal, double rate, int periods){
        double fv = principal;
        for(int i=0;i<periods;i++) fv *= (1+rate);
        return fv;
    }

    public static void main(String[] args){
        double p = 1000; double r = 0.05; int n = 10;
        System.out.println("Recursive FV: " + futureValueRecursive(p,r,n));
        System.out.println("Iterative FV: " + futureValueIterative(p,r,n));
        System.out.println("Recursive time complexity: O(n). Use iterative or exponentiation for optimization.");
    }
}
