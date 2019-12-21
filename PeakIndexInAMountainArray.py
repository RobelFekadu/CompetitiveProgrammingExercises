class PeakIndexInAMountainArray:
    def peakIndexInMountainArray(self, A: List[int]):
        max = A[0]
        
        for i in range(1, len(A) - 1):
            if A[i] > max and A[i] > A[i + 1]:
                return i
            max = A[i]
            
        return len(A) - 1
            