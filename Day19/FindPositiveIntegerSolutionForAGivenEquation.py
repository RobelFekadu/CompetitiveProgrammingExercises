class FindPositiveIntegerSolutionForAGivenEquation:
    def findSolution(self, customfunction: 'CustomFunction', z: int) -> List[List[int]]:
        XYPairs = []
        Max = 1000
        Min = 1
        val = 500
        
        for i in range(1, 1001):
            while Max - Min > 1:
                if customfunction.f(i,val) == z:
                    XYPairs.append([i,val])
                    break
                elif customfunction.f(i,val) < z:
                    Min = val
                    val = (val + Max) // 2
                else:
                    Max = val
                    val = (val + Min) // 2
            if customfunction.f(i,Min) == z:
                XYPairs.append([i,Min])
            if customfunction.f(i,Max) == z:
                XYPairs.append([i,Max])
            Max = 1000
            Min = 1
            val = 500
        
        return XYPairs 
    