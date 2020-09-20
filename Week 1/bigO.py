class bigO:
    def stringPerm(self, str, prefix):
        if(len(str) == 0):
            print(prefix)
        else:
            for i in range(0, len(str)):
                rem = str[0:i] + str[i+1:]
                self.stringPerm(rem, prefix+str[i])

    def fibb(self, n):
        if n <= 0:
            return 0
        elif n == 1:
            return 1
        else:
            return self.fibb(n-1) + self.fibb(n-2)


bigO = bigO()
bigO.stringPerm("test", "un")
print(bigO.fibb(5))
