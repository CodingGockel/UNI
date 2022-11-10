def test(n):
    if(n==3):
        return 1
    return test(n-1)+(n-2)


for i in range(3,20):
    print("n: {0} \t F: {1}".format(i,test(i)))