import java.util.HashSet;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
            brute force O(n^2)
            
            for HashSet in Java, insert and lookup are both O(1)
            so we can scan the list twice, 1st time to build set,
            and 2nd time to check if target - elem exists
            
            O(n) algo:
            if target is even and numbers has two target/2:
                return the indices of them
            else:
                foreach number n in numbers:
                    if not target is even and n==target/2:
                        put n in set
            
            foreach n in numbers:
                if set has target-n:
                    return the indices of them
                    
            when returning the indices make sure they are 1 based 
            and the first one is smaller
        */
        
        int firstIndex = -1;
        int secondIndex = -1;
        
        if(target % 2 == 0) {
            boolean isFirst = true;
            for(int i = 0; i < numbers.length; i++) {
                if(numbers[i] == target / 2) {
                    if(isFirst) {
                        firstIndex = i;
                        isFirst = false;
                    }
                    else {
                        secondIndex = i;
                        return new int[]{firstIndex + 1, secondIndex + 1};
                    }
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < numbers.length; i++) {
            set.add(numbers[i]);
        }
        if(target % 2 == 0) {
            set.remove(target / 2);
        }
        
        for(int i = 0; i < numbers.length; i++) {
            if(set.contains(target - numbers[i])) {
                firstIndex = i;
                break;
            }
        }
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] + numbers[firstIndex] == target) {
                secondIndex = i;
                break;
            }
        }
        
        if(firstIndex > secondIndex) {
            int t = firstIndex;
            firstIndex = secondIndex;
            secondIndex = t;
        }
        
        return new int[]{firstIndex + 1, secondIndex + 1};
    }
}

// actual implentation scans list 4 times
