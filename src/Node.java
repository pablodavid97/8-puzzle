public class Node {

    public Node parent;
    public int[][] matrix;

    // Blank tile cordinates
    public int x, y;

    // Number of misplaced tiles
    public int h1;

    // The number of moves so far
    public int level;

    public Node(int[][] matrix, int x, int y, int newX, int newY, int level, Node parent) {
        this.parent = parent;
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = matrix[i].clone();
        }

        // Swap value
        this.matrix[x][y]       = this.matrix[x][y] + this.matrix[newX][newY];
        this.matrix[newX][newY] = this.matrix[x][y] - this.matrix[newX][newY];
        this.matrix[x][y]       = this.matrix[x][y] - this.matrix[newX][newY];

        this.h1 = Integer.MAX_VALUE;
        this.level = level;
        this.x = newX;
        this.y = newY;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }

        return s;
    }

}