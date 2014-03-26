public class Solution {
    public int[] plusOne(int[] digits) {
        /*
            carrier=1
            for i=digits.length-1..0:
                result[i+1]=digits[i]+carrier
                carrier=result[i+1]/10
                result[i+1]%=10
            if carrier>0:
                result[0]=carrier
        */
        
        int[] result = new int[digits.length+1];
        int carrier = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            result[i + 1] = digits[i] + carrier;
            carrier = result[i + 1] / 10;
            result[i + 1] %= 10;
        }
        
        if(carrier > 0) {
            result[0] = carrier;
        }
        else {
            result = Arrays.copyOfRange(result, 1, result.length);
        }
        
        return result;
    }
}
