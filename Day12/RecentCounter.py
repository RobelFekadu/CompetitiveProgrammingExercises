class RecentCounter:
    def __init__(self):
        self.pingsTimeList = []

    def ping(self, t: int):
        if len(self.pingsTimeList) > 0 and t - self.pingsTimeList[0] <= 3000:
            self.pingsTimeList.append(t)
            return len(self.pingsTimeList)
        
        if len(self.pingsTimeList) > 0 and t - self.pingsTimeList[len(self.pingsTimeList) - 1] > 3000:
            self.pingsTimeList = [t]
            return 1
        
        index = 0
        tobeRemoved = []

        for i in range(0,len(self.pingsTimeList)):
            if t - self.pingsTimeList[i] <= 3000:
                self.pingsTimeList = self.pingsTimeList[index:]
                self.pingsTimeList.append(t)
                return len(self.pingsTimeList)
            else:
                index = i + 1
        self.pingsTimeList = self.pingsTimeList[index:] 
        self.pingsTimeList.append(t)
        return 1
    
if __name__ == "__main__":
    recentCounter = RecentCounter()
    print(recentCounter.ping(1))
    print(recentCounter.ping(2))
    print(recentCounter.ping(3))
    print(recentCounter.ping(4))
    print(recentCounter.ping(5))
    print(recentCounter.ping(3006))
    print(recentCounter.ping(3003))
    print(recentCounter.ping(3004))
                    
                