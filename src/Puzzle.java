import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Puzzle {

    public int dimension = 3;

    // Bottom, left, top, right
    int[] row = { 1, 0, -1, 0 };
    int[] col = { 0, -1, 0, 1 };

    public int calculateMissplacedTiles(int[][] initial, int[][] goal) {
        int count = 0;
        int n = initial.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int calculateCost(Node n, int[][] initial, int[][] goal){
        return n.level + manhattanDistance(initial, goal);
    }

    public boolean isSafe(int x, int y) {
        return (x >= 0 && x < dimension && y >= 0 && y < dimension);
    }

    public void printPath(Node root) {
        if (root == null) {
            return;
        }
        printPath(root.parent);
        System.out.println(root);
    }

    public boolean isSolvable(int[][] matrix) {
        int count = 0;
        List<Integer> array = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                array.add(matrix[i][j]);
            }
        }

        Integer[] anotherArray = new Integer[array.size()];
        array.toArray(anotherArray);

        for (int i = 0; i < anotherArray.length - 1; i++) {
            for (int j = i + 1; j < anotherArray.length; j++) {
                if (anotherArray[i] != 0 && anotherArray[j] != 0 && anotherArray[i] > anotherArray[j]) {
                    count++;
                }
            }
        }

        return count % 2 == 0;
    }

    public int solve(int[][] initial, int[][] goal, int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(1000, (a, b) -> (a.h1 + a.level) - (b.h1 + b.level));
        Node root = new Node(initial, x, y, x, y, 0, null);
        root.h1 = calculateMissplacedTiles(initial, goal);
        pq.add(root);
         
         int finalCost = 0;
         
        while (!pq.isEmpty()) {
            Node min = pq.poll();
            if (min.h1 == 0) {
                printPath(min);
                System.out.println("This is the cost for");
                finalCost = calculateCost(min, initial, goal);
                System.out.println(finalCost);
                System.out.println("*************");
                return finalCost;
            }

            for (int i = 0; i < 4; i++) {
                if (isSafe(min.x + row[i], min.y + col[i])) {
                    Node child = new Node(min.matrix, min.x, min.y, min.x + row[i], min.y + col[i], min.level + 1, min);
                    child.h1 = manhattanDistance(child.matrix, goal);
                    pq.add(child);
                }
            }
        }
        return finalCost;
    }
    public static int manhattanDistance (int[][] initial, int[][] goal) {
        int rows = initial.length;
        int columns = initial[0].length;
//        System.out.println("rows");
//        System.out.println(rows);
//        System.out.println("columns");
//        System.out.println(columns);
        int dif = 0;
        int result = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++){
                if(initial[i][j] != 0 && initial[i][j] != goal[i][j]){
//                    System.out.println("Different tile");
//                    System.out.println(initial[i][j]);
//                    System.out.println("Tile pos");
//                    System.out.println(getPos(i, j));
//                    System.out.println("goal pos");
                    int iTilePos = getPos(i, j);
                    int gTilePos = getTilePos(initial[i][j], iTilePos, goal);
//                    System.out.println(getTilePos(initial[i][j], getPos(i, j), goal));
                    dif = Math.abs(iTilePos - gTilePos);
                    result += dif / rows + dif % columns;

//                    System.out.println("Resutl");
//                    System.out.println(result);
                }
            }
        }

        return result;
    }

    public static int getPos(int xPos, int yPos){
//        System.out.println("xpos");
//        System.out.println(xPos);

        switch (xPos) {
            case 0:
                return(xPos + yPos);
            case 1:
                return(xPos + yPos + 2);
            case 2:
                return(xPos + yPos + 4);
            default:
                return 0;
        }
    }

    public static int getTilePos(int tile, int initTilePos, int[][] goal) {
        int rows = goal.length;
        int columns = goal[0].length;
        int pos = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if (tile == goal[i][j]){
                    pos = getPos(i, j);
                }
            }
        }
        return pos;
    }
    
    public static int[][] makeMatrix(Integer[] arr){
      /*int s = (int) Math.sqrt(arr.length);
      int[][] matrix = new int[s][s];*/
      int[][] matrix = new int[3][3];
      for(int i=0;i<3;i++)
         matrix[i]=Arrays.stream(Arrays.copyOfRange(arr,i*3,i*3+3)).mapToInt(Integer::intValue).toArray();
      return matrix;
    }

    public static void main(String[] args) {
        int[][] i1 = { {1, 2, 3}, {4, 6, 0}, {7, 5, 8} };
        int[][] i2 = { {4, 1, 2}, {7, 6, 3}, {0, 5, 8} };
        int[][] i3 = { {4, 1, 2}, {7, 6, 3}, {5, 8, 0} };

        int[][] goal    = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };

        System.out.println("ManhattanDistance 1");
        System.out.println(manhattanDistance(i1,goal));
        System.out.println("*************");

        System.out.println("ManhattanDistance 2");
        System.out.println(manhattanDistance(i2,goal));
        System.out.println("*************");

        System.out.println("ManhattanDistance 3");
        System.out.println(manhattanDistance(i3,goal));
        System.out.println("*************");

        // White tile coordinate
        int x = 2, y = 0;

        Puzzle puzzle = new Puzzle();
        if (puzzle.isSolvable(i2)) {
            puzzle.solve(i2, goal, x, y);
        }
        else {
            System.out.println("The given initial is impossible to solve");
        }
        
        int n = 100;
        int[] costs = new int[n];
        ArrayList<Integer[]> puzzles = Fisher_Yates_Array_Shuffling.validatedPuzzlesGenerator(n);
        for(int i=0;i<n;i++){
            Integer[] temp = puzzles.get(i);
            int p = Arrays.asList(temp).indexOf(0);
            int xi = p/3;
            int yi = p%3;
            int [][] m = makeMatrix(temp);
            Puzzle solver = new Puzzle();
            costs[i] = solver.solve(m,goal,xi,yi);
            System.out.println(costs[i]);
            
        }
        //System.out.println(costs.toString());
    }

}