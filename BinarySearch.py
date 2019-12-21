class BinarySearch:
    def search(self, nums: List[int], target: int):
        minIndex = 0
        maxIndex = len(nums) - 1
        searchIndex = len(nums) // 2
        
        while maxIndex - minIndex > 1:    
            if nums[searchIndex] == target:
                return searchIndex
            if nums[searchIndex] > target:
                maxIndex = searchIndex - 1
                searchIndex = (searchIndex - 1 + minIndex) // 2
            elif nums[searchIndex] < target:
                minIndex = searchIndex + 1
                searchIndex = (searchIndex + 1 + maxIndex) // 2
        if nums[minIndex] == target:
            return minIndex
        if nums[maxIndex] == target:
            return maxIndex
        return -1
                