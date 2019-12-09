 import java.util.*;

 public class CarFleet{  
    
    public static void main(String[] args) {
        System.out.println(carFleet(15, new int[] {2,1}, new int[] {5,16}));
    }
    
    private static int carFleet(int target, int[] position, int[] speed) {
        if(position.length <= 1)
            return position.length;
        HashMap<Integer, Integer> positionAndSpeedMap = new HashMap<>();
        int carfleet = 0;
        boolean addCarFleet = true;
        double timeToReachTarget;
        for (int i = 0; i < position.length; i++) {
            positionAndSpeedMap.put(position[i], speed[i]);
        }

        sort(position, 0, position.length - 1);

        for (int i = position.length - 1; i >= 0; i--) {
            if(i == 0){
                carfleet++;
                break;
            }
            if(positionAndSpeedMap.get(position[i]) >= positionAndSpeedMap.get(position[i - 1])){
                carfleet++;
                continue;
            }
            else if( ((double)(target - position[i]) / positionAndSpeedMap.get(position[i]) ) >= ( (double)(target - position[i - 1]) / positionAndSpeedMap.get(position[i - 1]) ) ){
                
                timeToReachTarget = (double)(target - position[i]) / positionAndSpeedMap.get(position[i]);
                while(i > 0 && timeToReachTarget >= ( (double)(target - position[i - 1]) / positionAndSpeedMap.get(position[i - 1]) )){
                    if(addCarFleet){
                        carfleet++;
                        addCarFleet = false;
                    }
                    i--;
                }
                addCarFleet = true;
            }
            else{
                carfleet++;
            }
        }
        return carfleet;
    }
    
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int lowPointer = (low-1); // index of smaller element
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot)
            {
                lowPointer++;
                int temp = arr[lowPointer];
                arr[lowPointer] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[lowPointer+1];
        arr[lowPointer+1] = arr[high];
        arr[high] = temp;

        return lowPointer+1;
    }
    static void sort(int arr[], int low, int high) {
        if (low < high)
        {
            int part = partition(arr, low, high);
            sort(arr, low, part - 1);
            sort(arr, part + 1, high);
        }
    }
 }