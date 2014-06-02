public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A.length==0) return 1;
        Arrays.sort(A);
        int i = Arrays.binarySearch(A, 1);
        if(i<0) return 1;
        int dup=0;
        for(int j=i+1; j<A.length; j++) {
            if(A[j]==A[j-1]) dup++;
            if(A[j]!=j-i+1-dup) return j-i+1-dup;
        }
        return A.length-i+1-dup;
    }
}
