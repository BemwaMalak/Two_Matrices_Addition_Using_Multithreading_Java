public class AdditionThread extends Thread{
    int[][] matrix1;
    int[][] matrix2;
    int[][] resultMatrix;
    int rowIndex;
    int numberOfColumns;
    AdditionThread (int[][] matrix1, int[][] matrix2, int[][] resultMatrix, int rowIndex, int numberOfColumns){
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.rowIndex = rowIndex;
        this.resultMatrix = resultMatrix;
        this.numberOfColumns = numberOfColumns;
    }
    @Override
    public void run(){
        for(int i = 0; i < numberOfColumns; i++){
            resultMatrix[rowIndex][i] = matrix1[rowIndex][i] + matrix2[rowIndex][i];
        }
    }

}
