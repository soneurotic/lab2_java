import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Виберіть один з варіантів: ");
        System.out.println("1 - запустити програму");
        System.out.println("0 - вийти з програми");
        Scanner user_input = new Scanner(System.in);
        int MainProg = user_input.nextInt();
        while(MainProg != 0) {
            System.out.println("Виберіть один з варіантів: ");
            System.out.println("1 - створити пусту матрицю");
            System.out.println("2 - створити матрицю заданого розміру");
            System.out.println("3 - створити одиничну матрицю (згідно варіанту завдання лабораторної)");
            System.out.println("0 - завершити програму");
            int answer_1 = user_input.nextInt();
            if (answer_1 == 1) {
                Matrix matrix = new Matrix();
                System.out.println("Пусту матрицю успішно створено.");
            } else if (answer_1 == 2) {
                String sleep = user_input.nextLine();
                System.out.println("Задайте розмір матриці через кому (стовпчики х рядки): ");
                String answer_2 = user_input.nextLine();
                String[] matrix_size = answer_2.split(",");
                int i = Integer.parseInt(matrix_size[0]);
                int j = Integer.parseInt(matrix_size[1]);
                Matrix matrix = new Matrix(i, j);
                System.out.println("Оберіть варіант заповнення матриці:");
                System.out.println("1 - вручну");
                System.out.println("2 - автоматично");
                int filling = user_input.nextInt();
                if (filling == 1) {
                    matrix.FillTheMatrix(i, j);
                    System.out.println("Матрицю успішно створено.");
                } else if (filling == 2) {
                    matrix.AutoFillTheMatrix(i, j);
                    System.out.println("Матрицю успішно створено.");
                }
                System.out.println("Виберіть один з варіантів: ");
                System.out.println("1 - перейти до меню взаємодії з матрицею");
                System.out.println("0 - повернутися назад");
                int ChooseVar = user_input.nextInt();

                while(ChooseVar != 0) {
                    if(i == j) {
                        System.out.println("Виберіть один з варіантів: ");
                        System.out.println("1 - переглянути матрицю");
                        System.out.println("2 - вивести заданий рядок");
                        System.out.println("3 - вивести заданий стовпець");
                        System.out.println("4 - вивести заданий елемент");
                        System.out.println("5 - повернути розмірність матриці");
                        System.out.println("6 - створити копію матриці");
                        System.out.println("7 - повернути обернену матрицю");
                        System.out.println("0 - повернутися назад");
                        int WorkWithMatrixVars = user_input.nextInt();

                        if (WorkWithMatrixVars == 1) {
                            matrix.ShowTheMatrix(matrix.matrix, i, j);
                        } else if (WorkWithMatrixVars == 2) {
                            matrix.GetRow(matrix.matrix, j);
                        } else if (WorkWithMatrixVars == 3) {
                            matrix.GetColumn(matrix.matrix, i);
                        } else if (WorkWithMatrixVars == 4) {
                            matrix.GetElement(matrix.matrix);
                        } else if (WorkWithMatrixVars == 5) {
                            matrix.ReturnMatrixSize(i, j);
                        } else if (WorkWithMatrixVars == 6) {
                            Matrix MatrixCopy = new Matrix(matrix.matrix);
                            MatrixCopy.ShowTheMatrix(MatrixCopy.matrix, i, j);
                        } else if (WorkWithMatrixVars == 7) {
                            float[][] FloatMatrix = new float[i][j];
                            for (int a = 0; a < i; a++) {
                                for (int b = 0; b < j; b++) {
                                    FloatMatrix[a][b] = (float) matrix.matrix[a][b];
                                }
                            }
                            System.out.println("Обернена матриця має наступний вигляд: ");
                            matrix.MatrixInversion(FloatMatrix, i);
                        } else if (WorkWithMatrixVars == 0) {
                            ChooseVar = 0;
                        }
                    } else if(i != j){
                        System.out.println("Виберіть один з варіантів: ");
                        System.out.println("1 - переглянути матрицю");
                        System.out.println("2 - вивести заданий рядок");
                        System.out.println("3 - вивести заданий стовпець");
                        System.out.println("4 - вивести заданий елемент");
                        System.out.println("5 - повернути розмірність матриці матриці");
                        System.out.println("6 - створити копію матриці");
                        System.out.println("0 - повернутися назад");
                        int WorkWithMatrixVars = user_input.nextInt();
                        if (WorkWithMatrixVars == 1) {
                            matrix.ShowTheMatrix(matrix.matrix, i, j);
                        } else if (WorkWithMatrixVars == 2) {
                            matrix.GetRow(matrix.matrix, j);
                        } else if (WorkWithMatrixVars == 3) {
                            matrix.GetColumn(matrix.matrix, i);
                        } else if (WorkWithMatrixVars == 4) {
                            matrix.GetElement(matrix.matrix);
                        } else if (WorkWithMatrixVars == 5) {
                            matrix.ReturnMatrixSize(i, j);
                        } else if (WorkWithMatrixVars == 6) {
                            Matrix MatrixCopy = new Matrix(matrix.matrix);
                            MatrixCopy.ShowTheMatrix(MatrixCopy.matrix, i, j);
                        } else if (WorkWithMatrixVars == 0) {
                            ChooseVar = 0;
                        }
                    }
                }
            } else if (answer_1 == 3) {
                System.out.println("Задайте розмір одиничної матриці: ");
                int size = user_input.nextInt();
                Matrix.IdentityMatrix(size);
            } else if (answer_1 == 0) {
                MainProg = 0;
            }
        }
        System.out.print("Програму завершено.");
    }
}