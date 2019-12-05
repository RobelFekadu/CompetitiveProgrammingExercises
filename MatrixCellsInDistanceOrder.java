import java.util.*;

public class MatrixCellsInDistanceOrder{ 
    public static void main(String[] args) {
        MatrixCellsInDistanceOrder matrixCellsInDistanceOrder = new MatrixCellsInDistanceOrder();
        int[][] test = matrixCellsInDistanceOrder.allCellsDistOrder(1, 2, 0, 0);
        for(int i = 0; i < test.length; i++){
            System.out.println(test[i][0] + " " + test[i][1]);
        }
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] finalList = new int[R * C][2];
        ArrayList<ArrayList<Integer>> toBeSorted = new ArrayList<>();
        ArrayList<Integer> tempArray;
        int tempDis, index;

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                tempArray = new ArrayList<>();
                tempDis = Math.abs(r0 - r) + Math.abs(c0 - c);
                tempArray.add(tempDis);
                tempArray.add(r);
                tempArray.add(c);
                toBeSorted.add(tempArray);
            }
        }

        ArrayList<Integer> num;
        boolean thereIsAchange = false;
        for(int i = 0; i < toBeSorted.size() - 1; i++){
            index = i + 1;
            num = toBeSorted.get(i + 1);
            for (int j = i + 1; j > 0; j--){
                if(num.get(0) < toBeSorted.get(j - 1).get(0)){
                    index--;
                    thereIsAchange = true;
                }
                else
                    break;
            }
            if(thereIsAchange){
                num = toBeSorted.get(i + 1);
                toBeSorted.remove(i + 1);
                toBeSorted.add(index, num);
            }
        }

        for (int i = 0; i < finalList.length; i++){
            finalList[i] = new int[]{toBeSorted.get(i).get(1), toBeSorted.get(i).get(2)};
        }

        return finalList;
    }
}