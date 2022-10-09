import java.util.*;

public class Matrix {
    int[][] matrix;
    Scanner user_input = new Scanner(System.in);
    Random random = new Random();
    public Matrix(){ this.setMatrix(); }
    public Matrix(int a, int b){
        this.setMatrix(a,b);
    }
    public Matrix(int[][] matrix) { this.setMatrix(matrix); }
    private void setMatrix(){
        this.matrix = new int[0][0];
    }
    private void setMatrix(int a, int b){
        this.matrix = new int[a][b];
    }
    private void setMatrix(int[][] matrix){ this.matrix = matrix; }

    public void FillTheMatrix(int a, int b){
        for(int columns = 0; columns < a; columns++){
            for(int rows = 0; rows < b; rows++) {
                System.out.println("Елемент [" + (columns+1) + "][" + (rows+1) + "]: ");
                matrix[columns][rows] = user_input.nextInt();
            }
        }
    }

    public void AutoFillTheMatrix(int a, int b){
        System.out.println("Задайте інтервал генерації чисел (через кому): ");
        String interval = user_input.nextLine();
        String[] bounds = interval.split(",");
        int min = Integer.parseInt(bounds[0]);
        int max = Integer.parseInt(bounds[1]);
        int diff = max - min;
        for(int columns = 0; columns < a; columns++){
            for(int rows = 0; rows < b; rows++) {
                matrix[columns][rows] = random.nextInt(diff+1);
                matrix[columns][rows]+=min;
            }
        }
    }
    public static void IdentityMatrix(int size){
        int[][] IdentityMatrix;
        IdentityMatrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j)
                    IdentityMatrix[i][j] = 1;
                else{
                    IdentityMatrix[i][j] = 0;
                }
            }
        }
        System.out.println("Матриця має наступний вигляд: ");
        for(int columns = 0; columns < size; columns++){
            for(int rows = 0; rows < size; rows++) {
                System.out.print(IdentityMatrix[columns][rows] + "\t");
            }
            System.out.println();
        }
    }
    public void ShowTheMatrix(int[][] matrix, int i, int j){
        System.out.println("Матриця має наступний вигляд: ");
        for(int columns = 0; columns < i; columns++){
            for(int rows = 0; rows < j; rows++) {
                System.out.print(matrix[columns][rows] + "\t");
            }
            System.out.println();
        }
    }
    public void GetRow(int[][] matrix, int j){
        System.out.print("Введіть номер рядка: ");
        int RowNum = user_input.nextInt();
        System.out.println("Рядок має наступний вигляд: ");
        for(int row = 0; row < j; row++){
            System.out.print(matrix[RowNum-1][row] + " ");
        }
        System.out.println("");
    }
    public void GetColumn(int[][] matrix, int i){
        System.out.print("Введіть номер стовпчика: ");
        int ColumnNum = user_input.nextInt();
        System.out.println("Стовпчик має наступний вигляд: ");
        for(int column = 0; column < i; column++){
            System.out.println(matrix[column][ColumnNum-1]);
        }
    }
    public void GetElement(int[][] matrix){
        System.out.print("Введіть першу координату елементу: ");
        int i = user_input.nextInt();
        System.out.print("Введіть другу координату елементу: ");
        int j = user_input.nextInt();
        System.out.println("Елемент [" + i + "][" + j + "]: " );
        System.out.println(matrix[i-1][j-1]);
    }
    public void ReturnMatrixSize(int i, int j){
        System.out.println("Розмірність поточної матриці: " + i + " x " + j);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    public void MatrixInversion(float[][] matrix, int size) {
        double temp;
        float[][] E = new float [size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                E[i][j] = 0f;
                if (i == j)
                    E[i][j] = 1f;
            }
        for (int k = 0; k < size; k++) {
            temp = matrix[k][k];
            for (int j = 0; j < size; j++) {
                matrix[k][j] /= temp;
                E[k][j] /= temp;
            }
            for (int i = k + 1; i < size; i++) {
                temp = matrix[i][k];
                for (int j = 0; j < size; j++) {
                    matrix[i][j] -= matrix[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }
        for (int k = size - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                temp = matrix[i][k];
                for (int j = 0; j < size; j++) {
                    matrix[i][j] -= matrix[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = E[i][j];
            }
        }

        for(int columns = 0; columns < size; columns++){
            for(int rows = 0; rows < size; rows++) {
                String result = String.format("%.2f", E[columns][rows]);
                System.out.print(result + "\t");
            }
            System.out.println();
        }
    }
}