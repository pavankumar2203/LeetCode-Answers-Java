import java.util.*;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if(len%2==0) {
            int m1 = findKth(A, B, len/2-1);
            int m2 = findKth(A, B, len/2);
            return (m1+m2)/2.0;
        }else {
            return findKth(A, B, len/2)*1.0;
        }
    }
    
    //k is 0 based
    private int findKth(int A[], int B[], int k) {
        assert A.length + B.length > k;
        if(A.length < B.length) {
            return findKth(B, A, k);
        }
        if(B.length == 0) return A[k];
        if(k==0) return Math.min(A[0], B[0]);
        if(k==1) {
            if(A.length>1 && B.length>1) {
                return Math.min(Math.min(A[0]+B[0]-Math.min(A[0], B[0]), A[1]), B[1]);
            }
            if(A.length>1) {
                return Math.min(A[0]+B[0]-Math.min(A[0], B[0]), A[1]);
            }
            return A[0]+B[0]-Math.min(A[0], B[0]);
        }
        if(B.length <= k/2) {
            int a = A[k/2];
            int b = B[B.length-1];
            if(b<a) {
                return findKth(A, new int[0], k-B.length);
            } else {
                return findKth(Arrays.copyOfRange(A, k/2, A.length), B, k-k/2);
            }
        } else {
            int a = A[k/2];
            int b = B[k/2];
            if(b<a) {
                return findKth(A, Arrays.copyOfRange(B, k/2, B.length), k-k/2);
            } else {
                return findKth(Arrays.copyOfRange(A, k/2, A.length), B, k-k/2);
            }
        }
    }
}
