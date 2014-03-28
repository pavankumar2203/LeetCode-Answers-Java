public class Solution {
    public void nextPermutation(int[] num) {
        /*
            i=num.length-1
            while i>0:
                if num[i]>num[i-1]:
                    break
                i--
            if i==0:
                reverse num
                return
            k=i
            for j=i..num.length-1:
                if num[j]>num[i-1] && num[j]<=num[k]:
                    k=j
            if(i!=0):
                swap num[k] and num[i-1]
                reverse num[i..end]
            else:
                reverse num
                
            O(n) O(1)
        */
        
        int i = num.length - 1;
        while(i > 0) {
            if(num[i] > num[i - 1]) {
                break;
            }
            i--;
        }
        if(i == 0) {
            reverse(num, 0, num.length - 1);
            return;
        }
        int k = i;
        for(int j = i; j <= num.length - 1; j++) {
            if(num[j] > num[i - 1] && num[j] <= num[k]) {
                k = j;
            }
        }
        swap(num, k, i - 1);
        reverse(num, i, num.length - 1);
    }
    private static void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
    private static void reverse(int[] num, int i, int j) {
        for(int k = i; k <= (i + j) / 2; k++) {
            swap(num, k, i + j - k);
        }
    }
}
