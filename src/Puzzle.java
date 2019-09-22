import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Puzzle {

    public int dimension = 3;
    public int COST_NUMBER = 0;

    // Bottom, left, top, right
    int[] row = { 1, 0, -1, 0 };
    int[] col = { 0, -1, 0, 1 };

    public int calculateCost(int[][] initial, int[][] goal) {
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

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isSafe(int x, int y) {
        return (x >= 0 && x < dimension && y >= 0 && y < dimension);
    }

    public void printPath(Node root) {
        if (root == null) {
            return;
        }
        printPath(root.parent);
        printMatrix(root.matrix);
        System.out.println("This is the cost for");
        System.out.println(root.cost);
        System.out.println("*************");

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

    public void solve(int[][] initial, int[][] goal, int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(1000, (a, b) -> (a.cost + a.level) - (b.cost + b.level));
        Node root = new Node(initial, x, y, x, y, 0, null);
        root.cost = manhattanDistance(initial, goal);
        pq.add(root);

        while (!pq.isEmpty()) {
            Node min = pq.poll();
            COST_NUMBER += 1;
            if (min.cost == 0) {
                printPath(min);
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (isSafe(min.x + row[i], min.y + col[i])) {
                    Node child = new Node(min.matrix, min.x, min.y, min.x + row[i], min.y + col[i], min.level + 1, min);
                    child.cost = manhattanDistance(child.matrix, goal);
                    pq.add(child);
                    System.out.println("cHILD");
                    printMatrix(child.matrix);
                    System.out.println("Cost Number");
                    System.out.println(COST_NUMBER);
                    System.out.println("MH Distance");
                    System.out.println(child.cost);

                }
            }
        }
    }
    public static int manhattanDistance (int[][] initial, int[][] goal) {
        int rows = initial.length;
        int columns = initial[0].length;
        int dif = 0;
        int result = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++){
                if(initial[i][j] != 0){
                    dif = 0;
                    dif = Math.abs(initial[i][j] - goal[i][j]);
                    result += dif / rows + dif % columns;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] initial = { {1, 2, 3}, {4, 6, 0}, {7, 5, 8} };
        int[][] goal    = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };

        System.out.println(manhattanDistance(initial,goal));
        System.out.println("*************");


        // White tile coordinate
        int x = 1, y = 2;

        Puzzle puzzle = new Puzzle();
        if (puzzle.isSolvable(initial)) {
            puzzle.solve(initial, goal, x, y);
        }
        else {
            System.out.println("The given initial is impossible to solve");
        }
    }

}