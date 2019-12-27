public class DailyTemperatures{
    public int[] dailyTemperatures(int[] T) {
        if(T.length == 0)
            return new int[]{};
        int[] output = new int[T.length];
        output[output.length - 1] = 0;
        int max = T[T.length - 1];
        int count;
        for (int i = T.length - 2; i >= 0; i--){
            if(T[i] < max) {
                count = i + 1;

                while ((count < T.length && T[i] >= T[count])){
                    count++;
                }
                output[i] = count - i;

            }
            else {
                max = T[i];
                output[i] = 0;
            }
        }
        return output;
    }
}