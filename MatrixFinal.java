import java.util.*;

public final class MatrixFinal{
    int[][] ImmutableMatrix;
    Scanner user_input = new Scanner(System.in);
    Random random = new Random();
    MatrixFinal(){ this.ImmutableMatrix = new int[0][0]; }
    MatrixFinal(int a, int b){ this.ImmutableMatrix = new int[a][b];}
    MatrixFinal(int[][] matrix) { this.ImmutableMatrix = matrix; }

    public void ImmutableFillTheMatrix(int a, int b){
        for(int columns = 0; columns < a; columns++){
            for(int rows = 0; rows < b; rows++) {
                System.out.println("Елемент [" + (columns+1) + "][" + (rows+1) + "]: ");
                ImmutableMatrix[columns][rows] = user_input.nextInt();
            }
        }
    }

    public void ImmutableAutoFillTheMatrix(int a, int b){
        System.out.println("Задайте інтервал генерації чисел (через кому): ");
        String interval = user_input.nextLine();
        String[] bounds = interval.split(",");
        int min = Integer.parseInt(bounds[0]);
        int max = Integer.parseInt(bounds[1]);
        int diff = max - min;
        for(int columns = 0; columns < a; columns++){
            for(int rows = 0; rows < b; rows++) {
                ImmutableMatrix[columns][rows] = random.nextInt(diff+1);
                ImmutableMatrix[columns][rows]+=min;
            }
        }
    }
    public static void ImmutableIdentityMatrix(int size){
        int[][] ImmutableIdentityMatrix;
        ImmutableIdentityMatrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j)
                    ImmutableIdentityMatrix[i][j] = 1;
                else{
                    ImmutableIdentityMatrix[i][j] = 0;
                }
            }
        }
        System.out.println("Матриця має наступний вигляд: ");
        for(int columns = 0; columns < size; columns++){
            for(int rows = 0; rows < size; rows++) {
                System.out.print(ImmutableIdentityMatrix[columns][rows] + "\t");
            }
            System.out.println();
        }
    }
    public void ImmutableShowTheMatrix(int[][] immutableMatrix, int i, int j){
        System.out.println("Матриця має наступний вигляд: ");
        for(int columns = 0; columns < i; columns++){
            for(int rows = 0; rows < j; rows++) {
                System.out.print(immutableMatrix[columns][rows] + "\t");
            }
            System.out.println();
        }
    }
    public void ImmutableGetRow(int[][] immutableMatrix, int j){
        System.out.print("Введіть номер рядка: ");
        int RowNum = user_input.nextInt();
        System.out.println("Рядок має наступний вигляд: ");
        for(int row = 0; row < j; row++){
            System.out.print(immutableMatrix[RowNum-1][row] + " ");
        }
        System.out.println("");
    }
    public void ImmutableGetColumn(int[][] immutableMatrix, int i){
        System.out.print("Введіть номер стовпчика: ");
        int ColumnNum = user_input.nextInt();
        System.out.println("Стовпчик має наступний вигляд: ");
        for(int column = 0; column < i; column++){
            System.out.println(immutableMatrix[column][ColumnNum-1]);
        }
    }
    public void ImmutableGetElement(int[][] immutableMatrix){
        System.out.print("Введіть першу координату елементу: ");
        int i = user_input.nextInt();
        System.out.print("Введіть другу координату елементу: ");
        int j = user_input.nextInt();
        System.out.println("Елемент [" + i + "][" + j + "]: " );
        System.out.println(immutableMatrix[i-1][j-1]);
    }
    public void ImmutableReturnMatrixSize(int i, int j){
        System.out.println("Розмірність поточної матриці: " + i + " x " + j);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixFinal that = (MatrixFinal) o;
        return Arrays.equals(ImmutableMatrix, that.ImmutableMatrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ImmutableMatrix);
    }

    public void ImmutableMatrixInversion(float[][] ImmutableMatrix, int size) {
        double temp;
        float[][] E = new float [size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                E[i][j] = 0f;
                if (i == j)
                    E[i][j] = 1f;
            }
        for (int k = 0; k < size; k++) {
            temp = ImmutableMatrix[k][k];
            for (int j = 0; j < size; j++) {
                ImmutableMatrix[k][j] /= temp;
                E[k][j] /= temp;
            }
            for (int i = k + 1; i < size; i++) {
                temp = ImmutableMatrix[i][k];
                for (int j = 0; j < size; j++) {
                    ImmutableMatrix[i][j] -= ImmutableMatrix[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }
        for (int k = size - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                temp = ImmutableMatrix[i][k];
                for (int j = 0; j < size; j++) {
                    ImmutableMatrix[i][j] -= ImmutableMatrix[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ImmutableMatrix[i][j] = E[i][j];
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