class FirstBadVersion: 
    def firstBadVersion(self, n):
        notFound = n
        minCheckerVersion = 1
        maxCheckerVersion = n
        
        while maxCheckerVersion - minCheckerVersion > 1:
            if isBadVersion(n):
                if not isBadVersion(n - 1):
                    return n
                maxCheckerVersion = n
                n = (n + minCheckerVersion)//2
            else:
                if isBadVersion(n + 1):
                    return n + 1
                minCheckerVersion = n
                n = (n + maxCheckerVersion)//2
        
        if isBadVersion(minCheckerVersion):
            return minCheckerVersion
        if not isBadVersion(minCheckerVersion) and isBadVersion(maxCheckerVersion):
            return maxCheckerVersion
        return notFound