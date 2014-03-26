public class Solution {
    public String addBinary(String a, String b) {
        /*
            carrier=0
            if a.length < b.length:
                return addBinary(b, a)
            for i=0..b.length-1:
                sum=b[b.length-1-i]+a[a.length-1-i]+carrier
                carrier=sum/2
                result.addFirst(sum%2)
            for i=a.length-b.length-1..0:
                sum=a[i]+carrier
                carrier=sum/2
                result.addFirst(sum%2)
            if carrier>0:
                result.addFirst(carrier)
                
            O(n) O(n)
        */
        
        if(a.length() < b.length()) {
            return addBinary(b, a);
        }
        
        StringBuilder sb = new StringBuilder();
        
        int carrier = 0;
        for(int i = 0; i < b.length(); i++) {
            int sum = Integer.parseInt(Character.toString(b.charAt(b.length() - 1 - i))) +
                        Integer.parseInt(Character.toString(a.charAt(a.length() - 1 - i))) + carrier;
            carrier = sum / 2;
            sb.append((new Integer(sum % 2)).toString());
        }
        for(int i = a.length() - b.length() - 1; i >= 0; i--) {
            int sum = Integer.parseInt(Character.toString(a.charAt(i))) + carrier;
            carrier = sum / 2;
            sb.append((new Integer(sum % 2)).toString());
        }
        if(carrier > 0) {
            sb.append((new Integer(carrier)).toString());
        }
        
        sb = sb.reverse();
        
        return sb.toString();
    }
}
