import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Fisher_Yates_Array_Shuffling {

    static ArrayList<Integer> list = new ArrayList();
    static int[] targetConf = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    static ArrayList<Integer[][]> puzzles = new ArrayList(); 

    static Integer[] fisherYatesShuffling(Integer[] arr, int n) {
        Integer[] a = new Integer[n];
        int[] ind = new int[n];
        for (int i = 0; i < n; i++) {
            ind[i] = 0;
        }
        int index;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            do {
                index = rand.nextInt(n);
            } while (ind[index] != 0);

            ind[index] = 1;
            a[i] = arr[index];
        }
        return a;
    }

    public static Integer[] generate() {
        int n = 9;
        Integer[] a = new Integer[n];
        int[] res = new int[n];
        Integer[] resObj;
        for (int i = 0; i < n; i++) {

            a[i] = new Integer(i);
        }

        resObj = fisherYatesShuffling(a, n);
        return resObj;
    }
    
    public static int check(Integer[] resObj){
      ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(resObj));
        list.remove(new Integer(0));
        Integer[] invCntArray = list.toArray(new Integer[list.size() - 1]);
        return (getInvCount(invCntArray, 8)%2);
    }
    
    public static ArrayList validatedPuzzlesGenerator(int num){
         ArrayList<Integer[]> puzzles = new ArrayList();
         int count = 0;
         while(count<num){
            Integer[] temp = generate();
            if(check(temp) == 1)
               continue;
            else{
               count++;
               puzzles.add(temp);
            }
         }
         return puzzles;
    }
    
    static int getInvCount(Integer arr[], int n) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

}
