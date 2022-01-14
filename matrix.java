package matrix;

public class Matrix {

    private double[][] matrix;
    private int m;
    private int n;

    public Matrix(int m, int n) {
        double[][] matrix = new double[m][n];
        this.matrix = matrix;
        this.m = m;
        this.n = n;
    }

    public Matrix(double[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public void displayMatrix() {
        for (int r = 0; r < this.m; r++) {
            System.out.print("|");
            for (int c = 0; c < this.n; c++) {
                System.out.print(this.matrix[r][c] + " ");
            }
            System.out.println("|");
        }
    }

    public int getColumns() {
        return (this.n);
    }

    public int getRows() {
        return (this.m);
    }

    public void loadMatrix(double[][] matrix) {
        // this.matrix = new double[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public double[][] getMatrix() {
        //double[][] matrix = this.matrix;
        return this.matrix;
    }

    public Matrix addMatrix(Matrix b) {
        Matrix A = this;
        Matrix sum = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum.matrix[i][j] = A.matrix[i][j] + b.matrix[i][j];
            }
        }
        return sum;
    }

    public Matrix subtractMatrix(Matrix b) {
        Matrix A = this;
        Matrix difference = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                difference.matrix[i][j] = A.matrix[i][j] - b.matrix[i][j];
            }
        }
        return difference;
    }

    public Matrix multiplyMatrix(Matrix b) {
        Matrix A = this;
        Matrix multiplication = new Matrix(A.m, b.n);
        for (int i = 0; i < multiplication.m; i++) {
            for (int j = 0; j < multiplication.n; j++) {
                for (int k = 0; k < A.n; k++) {
                    multiplication.matrix[i][j] += (A.matrix[i][k] * b.matrix[k][j]);
                }
            }
        }

        return multiplication;
    }

    public Matrix inverseMatrix() {
        Matrix A = this;
        Matrix inverse = new Matrix(this.m, this.n);
        double a = A.matrix[0][0];
        double b = A.matrix[0][1];
        double c = A.matrix[1][0];
        double d = A.matrix[1][1];
        double det = 1 / ((a * d) - (c * b));
        double[][] adjugate = {{d, a}, {c * -1, b * -1}};
        double[][] inversearr = new double[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                inversearr[i][j] = adjugate[i][j] * det;
            }
        }
        inverse.loadMatrix(inversearr);
        return inverse;
    }

    public Matrix stretchMatrix(double k, boolean horizontal) {
        Matrix A = this;
        double q, w;
        if (horizontal == true) {
            q = k;
            w = 1;
        } else {
            q = 1;
            w = k;
        }
        double[][] barr = {{q, 0}, {0, w}};
        Matrix b = new Matrix(barr);
        Matrix stretch = new Matrix(A.m, b.n);
        for (int i = 0; i < stretch.m; i++) {
            for (int j = 0; j < stretch.n; j++) {
                for (int l = 0; l < A.n; l++) {
                    stretch.matrix[i][j] += (A.matrix[i][l] * b.matrix[l][j]);
                }
            }
        }
        return stretch;
    }

    public Matrix ShearMatrix(double k, boolean horizontal) {
        Matrix A = this;
        double q, w;
        if (horizontal == true) {
            q = 1;
            w = k;
        } else {
            q = k;
            w = 1;
        }
        double[][] sheararr = {{q, 0}, {0, w}};
        Matrix b = new Matrix(sheararr);
        Matrix shear = new Matrix(A.m, b.n);
        for (int i = 0; i < shear.m; i++) {
            for (int j = 0; j < shear.n; j++) {
                for (int l = 0; l < A.n; l++) {
                    shear.matrix[i][j] += (A.matrix[i][l] * b.matrix[l][j]);
                }
            }
        }

        return shear;
    }

    public Matrix rotateMatrix(double theta) {
        Matrix A = this;
        Matrix inverse = new Matrix(this.m, this.n);
        double a = A.matrix[0][0];
        double b = A.matrix[0][1];
        double c = A.matrix[1][0];
        double d = A.matrix[1][1];

        double e = 0;
        double f = 0;
        double g = 0;
        double h = 0;

        if (theta == 90) {
            e = c;
            f = a;
            g = b;
            h = d;
        } else if (theta == 180) {
            e = d;
            f = c;
            g = a;
            h = b;
        } else if (theta == 270) {
            e = b;
            f = d;
            g = c;
            h = a;
        } else if (theta == 360) {
            e = a;
            f = b;
            g = c;
            h = d;
        } else {
            System.out.println("choose different theta");
        }
        Matrix rotated = new Matrix(2, 2);
        double[][] rotate = {{e, f}, {g, h}};
        rotated.loadMatrix(rotate);
        return rotated;
    }
}
