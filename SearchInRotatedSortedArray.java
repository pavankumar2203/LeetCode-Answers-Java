public class Solution {
    public int search(int[] A, int target) {
        /*
            begin=0
            end=A.length
            while end>begin:
                mid=(end+begin)/2
                if A[mid]==target:
                    return mid
                if A[begin]<A[mid]:
                    if A[begin]<=target<A[mid]:
                        end=mid
                    else:
                        begin=mid+1
                else:
                    if A[mid]<target<=A[end-1]:
                        begin=mid+1
                    else:
                        end=mid
            return -1
            
            O(n) O(1)
        */
        if(A.length == 0) {
            return -1;
        }
        
        int begin = 0;
        int end = A.length;
        
        while(end > begin) {
            int mid = (begin + end) / 2;
            if(A[mid] == target) {
                return mid;
            }
            if(A[begin] < A[mid]) {
                if(A[begin] <= target && target < A[mid]) {
                    end = mid;
                }
                else {
                    begin = mid + 1;
                }
            }
            else {
                if(A[mid] < target && target <= A[end - 1]) {
                    begin = mid + 1;
                }
                else {
                    end = mid;
                }
            }
        }
        
        return -1;
    }
}
