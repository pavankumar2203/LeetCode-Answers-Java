public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        
        /*
            O(n^2) O(n^2)
        */
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return result;
        
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(1);
        result.add(last);
        for(int i = 1; i < numRows; i++) {
            last = result.get(result.size() - 1);
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for(int j = 0; j < last.size() - 1; j++) {
                list.add(last.get(j) + last.get(j + 1));
            }
            list.add(1);
            result.add(list);
        }
        
        return result;
    }
}
