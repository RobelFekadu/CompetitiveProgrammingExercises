public class HindexII {
    public int hIndex(int[] citations) {
        if(citations.length > 0 && citations[citations.length - 1] == 0)
            return 0;
        int max = citations.length - 1;
        int min = 0;
        int mid = (max + min) / 2;

        while (min < max) {
            if(citations[mid] == citations.length - mid)
                return citations.length - mid;
            if(citations[mid] > citations.length - mid){
                if(mid - 1 >= 0 && citations[mid - 1] == citations.length - (mid - 1)){
                    return citations.length - (mid - 1);
                }
                if(mid - 1 >= 0 && citations[mid - 1] < citations.length - (mid - 1)){
                    return citations.length - mid;
                }
                max = mid - 1;
                mid = (max + min) / 2;
            }
            if(citations[mid] < citations.length - mid){
                if(mid + 1 < citations.length && citations[mid + 1] >= citations.length - (mid + 1)){
                    return citations.length - (mid + 1);
                }
                min = mid + 1;
                mid = (max + min) / 2;
            }
        }
        return citations.length;
    }
}