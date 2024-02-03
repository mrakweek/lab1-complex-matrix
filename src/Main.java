import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        //создание первой матрицы
        System.out.print("Enter the number of rows of the first matrix: ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns of the first matrix: ");
        int n = scanner.nextInt();
        ComplexMatrix mat = new ComplexMatrix(m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat.SetElement(i, j, new ComplexNumber(Math.round(rand.nextDouble(10)*10)/10.0, Math.round(rand.nextDouble(10)*10)/10.0));
            }
        }

        //создание второй матрицы
        System.out.print("Enter the number of rows of the second matrix: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter the number of columns of the second matrix: ");
        int n1 = scanner.nextInt();
        ComplexMatrix mat1 = new ComplexMatrix(m1, n1);

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                mat1.SetElement(i, j, new ComplexNumber(Math.round(rand.nextDouble(10)*10)/10.0, Math.round(rand.nextDouble(10)*10)/10.0));
            }
        }


        mat.PrintMatrix();
        System.out.println();

        //Транспонирование матрицы
        ComplexMatrix TransposedMat = mat.MatrixTransposition();
        System.out.println("Транспонирование матрицы");
        TransposedMat.PrintMatrix(); //вывод транспонированной матрицы
        System.out.println();

        mat1.PrintMatrix();
        System.out.println();

        //сумма матриц
        ComplexMatrix SumMat = mat.AdditionMatrix(mat);
        System.out.println("сумма матриц");
        SumMat.PrintMatrix();
        System.out.println();

        //разность матриц
        ComplexMatrix RazMat = mat.SubtractionMatrix(mat);
        System.out.println("разность матриц");
        RazMat.PrintMatrix();
        System.out.println();


        //умножение матриц
        ComplexMatrix MullMat = mat.MultiplicationMatrix(mat1);
        System.out.println("умножение матриц");
        MullMat.PrintMatrix();
        System.out.println();
    }
}