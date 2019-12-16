class NthTribonacciNumber:
    def tribonacci(self, n: int):
        return self.getNthtribonacciNum(n, {})
    
    def getNthtribonacciNum(self, n:int, numbersDictionary:dict):
        if(n == 0):
            return 0
        if(n == 1 or n == 2):
            return 1
        if(n in numbersDictionary):
            return numbersDictionary[n]
        
        result = self.getNthtribonacciNum(n-3, numbersDictionary) + self.getNthtribonacciNum(n-2, numbersDictionary) + self.getNthtribonacciNum(n-1, numbersDictionary)
        
        numbersDictionary[n] = result
        
        return result
       
if __name__ == '__main__':
    n = NthTribonacciNumber()
    
    print(n.tribonacci(12))
     
            