public class KCloset{
    int[][] kClosest(int[][] points, int K) {
        int[][] minDistancePoints = new int[K][2];
        int[][] toBeSortedPoints = new int[points.length][3];

        for(int i = 0; i < points.length; i++){
            toBeSortedPoints[i] = new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], points[i][0], points[i][1]};
        }

        sort(toBeSortedPoints, 0, toBeSortedPoints.length - 1);

        for (int i = 0; i < K; i++){
            minDistancePoints[i] = new int[] {toBeSortedPoints[i][1], toBeSortedPoints[i][2]};
        }
        return minDistancePoints;
    }
    static int partition(int arr[][], int low, int high) {
        int pivot = arr[high][0];
        int lowPointer = (low-1);
        for (int j = low; j < high; j++)
        {
            if (arr[j][0] < pivot)
            {
                lowPointer++;
                int[] temp = arr[lowPointer];
                arr[lowPointer] = arr[j];
                arr[j] = temp;
            }
        }

        int[] temp = arr[lowPointer+1];
        arr[lowPointer+1] = arr[high];
        arr[high] = temp;

        return lowPointer+1;
    }
    static void sort(int arr[][], int low, int high) {
        if (low < high)
        {
            int part = partition(arr, low, high);
            sort(arr, low, part - 1);
            sort(arr, part + 1, high);
        }
    }
}