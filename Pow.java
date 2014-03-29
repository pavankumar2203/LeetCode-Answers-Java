public class Solution {
    public double pow(double x, int n) {
        /*
            if n is odd x^n = (x^(n/2))^2*x 
            else x^n = (x^(n/2))^2
            
            O(log(n)) muplications
        */
        if(n == 0) {
            return 1;
        }
        else if(n == 1) {
            return x;
        }
        else if(n == -1) {
            return 1 / x;
        }
        
        double p = pow(x, n/2);
        
        if(n % 2 == 0) {
            return p * p;
        }
        else {
            return p * p * pow(x, n%2);
        }
    }
}
