public class Searcher { // linear search
    public int search(int[] arr, int target){
        for (int i = 0; i < arr.length; i++){
            if (target == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
