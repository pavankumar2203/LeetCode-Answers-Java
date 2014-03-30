import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        /*
            the kth row is Ck0 Ck1 Ck2 ... Ckk
            Cmn = m!/(n!(m-n)!)
            Cm(n+1)=Cmn*(m-n)/(n+1)
            
            cache i!
            
            O(n) O(n)
        */
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(rowIndex < 0) return list;
        list.add(1);
        if(rowIndex == 0) return list;
        
        long c = rowIndex;
        for(int i = 1; i <= rowIndex - 1; i++) {
            list.add((int)c);
            c = c*(rowIndex-i)/(i+1);
        }
        list.add(1);
        
        return list;
    }
}
