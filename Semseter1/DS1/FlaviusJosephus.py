def test(n,r,o):
    k,z,d=0,[i for i in range (1,n+1)],0
    while(len(z)>o):
        y=0
        for i in range (0,len(z)):
            k+=1
            if(k==r):
                z.remove(z[i-y])
                y+=1
                k=0
        d+=1
    print(d)
    return z
def test2(n):
    if(n==1):
        return 1
    elif(n%2==0):
        return 2*test2(n//2)-1
    else:
        return 2*test2(n//2)+1
def test3(n,k):
    if n==1:
        return 1
    return (test3(n-1,k)+k-1)% n+1
    
print(test(30,10,15))