class bigO:
    def stringPerm(self, str, prefix):
        if(len(str) == 0):
            print(prefix)
        else:
            for i in range(0, len(str)):
                rem = str[0:i] + str[i+1:]
                self.stringPerm(rem, prefix+str[i])


bigO = bigO()
bigO.stringPerm("test", "t")
