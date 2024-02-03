import java.io.File;
import java.io.FileNotFoundException;

public class ComplexMatrix {
    private final ComplexNumber[][] matrix;

    public ComplexMatrix(int m, int n) {
        matrix = new ComplexNumber[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new ComplexNumber();
            }
        }
    }

    public ComplexMatrix(int m) {
        matrix = new ComplexNumber[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = new ComplexNumber();
            }
        }
    }

    public void PrintMatrix() {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j].print();
            }
            System.out.println();
        }
    }

    public void SetElement(int x, int y, ComplexNumber element) throws IndexOutOfBoundsException {
        if (x < 0 || x > matrix.length || y < 0 || y > matrix[0].length) {
            throw new IndexOutOfBoundsException("Invalid matrix indexes");
        }
        matrix[x][y] = new ComplexNumber(element);
    }

    public ComplexNumber GetElement(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x > matrix.length || y < 0 || y > matrix[0].length) {
            throw new IndexOutOfBoundsException("Invalid matrix indexes");
        }
        return new ComplexNumber(matrix[x][y]);
    }

    public ComplexMatrix AdditionMatrix(ComplexMatrix current) throws IllegalArgumentException {
        if (matrix.length != current.matrix.length || matrix[0].length != current.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        ComplexMatrix tmp = new ComplexMatrix(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                tmp.matrix[i][j] = new ComplexNumber(matrix[i][j].addition(current.matrix[i][j]));
            }
        }
        return tmp;
    }

    public ComplexMatrix SubtractionMatrix(ComplexMatrix current) throws IllegalArgumentException {
        if (matrix.length != current.matrix.length || matrix[0].length != current.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        ComplexMatrix tmp = new ComplexMatrix(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                tmp.matrix[i][j] = new ComplexNumber(matrix[i][j].subtraction(current.matrix[i][j]));
            }
        }
        return tmp;
    }

    public ComplexMatrix MultiplicationMatrix(ComplexMatrix current) throws IllegalArgumentException {
        if (matrix[0].length != current.matrix.length) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }
        ComplexMatrix tmp = new ComplexMatrix(matrix.length, current.matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < current.matrix[0].length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    tmp.matrix[i][j] = tmp.matrix[i][j].addition(matrix[i][k].multiplication(current.matrix[k][j]));
                }
            }
        }
        return tmp;
    }

    public ComplexMatrix MatrixTransposition() {
        ComplexMatrix transposed = new ComplexMatrix(matrix[0].length, matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed.matrix[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
