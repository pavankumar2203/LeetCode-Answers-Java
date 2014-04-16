public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int curr = m + n - 1;
        int currA = m - 1;
        int currB = n - 1;
        while(currB >= 0 && currA >= 0) {
            if(A[currA] <= B[currB]) {
                A[curr--] = B[currB--];
            } else {
                A[curr--] = A[currA--];
            }
        }
        while(currB >= 0) {
            A[curr--] = B[currB--];
        }
    }
}
