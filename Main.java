import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n,m;
        System.out.println("Please Enter your Matrix height and width: ");
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[n][m];
        int[][] resultMatrix = new int[n][m];
        System.out.println("Please Enter your Matrix elements: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix1[i][j] = scanner.nextInt();

                // Initialize result matrix with zeroes
                resultMatrix[i][j] = 0;
            }
        }
        System.out.println("Please Enter your Matrix elements: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix2[i][j] = scanner.nextInt();
            }
        }



        // For each row we can create a thread to sum that row
        // So we will create an array of threads
        Thread[] threads = new Thread[n];
        for(int i = 0; i < n; i++){
            Thread thread = new AdditionThread(matrix1, matrix2, resultMatrix, i, m);
            threads[i] = thread;
        }
        // We will start all threads
        for(int i = 0; i < n; i++){
            threads[i].start();
        }

        // We will wait for all threads to finish
        for(int i = 0; i < n; i++){
            threads[i].join();
        }

        // We will print result matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(String.valueOf(resultMatrix[i][j]) + ' ');
            }
            System.out.println();
        }
    }
}
