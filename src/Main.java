import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main{

public static void main(String[] args) {
        int[][] goal    = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };

        int n = 10;
        int[] costs = new int[n];
        ArrayList<Integer[]> puzzles = Fisher_Yates_Array_Shuffling.validatedPuzzlesGenerator(n);
        for(int i=0;i<n;i++){
            Integer[] temp = puzzles.get(i);
            int p = Arrays.asList(temp).indexOf(0);
            int xi = p/3;
            int yi = p%3;
            Puzzle solver = new Puzzle();
            int [][] m = solver.makeMatrix(temp);
            costs[i] = solver.solve(m,goal,xi,yi);
            System.out.println(i);
        }
        //System.out.println(costs);
        
    }
}