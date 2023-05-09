import math

def sortDic(dic):
    newDic={}
    arr=[]
    for i in dic:
        arr.append(dic[i])
    arr.sort()
    for i in arr:
        for e in dic.keys():
            if dic[e]==i:
                newDic[e]=i
                del(dic[e])
                break
    return newDic

def getDic(n):
    dic={}
    s=n
    s=s.lower()
    while(s!=""):
        a=s[0]
        count=s.count(a)
        s=s.replace(a,"")
        dic[a]= count
    return sortDic(dic)

def getDicAsArray(dic,z):
    letters=[]
    indizies=[]
    for e in dic:
        letters.append(e)
        indizies.append(dic[e])
    if(z==1):
        return letters
    else:
        return indizies

def makeDic(letters, indizies):
    dic={}
    for i in range(len(letters)):
        dic[letters[i]]=indizies[i]
    return dic 

def makeCode(dic):
    while len(dic)>1:
        letters=getDicAsArray(dic,1)
        indizies=getDicAsArray(dic,0)
        letters[0]=letters[0]+letters[1]
        indizies[0]=indizies[0]+indizies[1]
        letters.pop(1)
        indizies.pop(1)
        dic=makeDic(letters,indizies)
        dic=sortDic(dic)
        print("{0}\t{1}\t{2}".format(letters,indizies,dic))
    return dic

def main(n):
    dic=getDic(n)
    max=len(n)
    print(dic)
    print(makeCode(dic))
    
main("Hjhhhhhhhellooo")           
    
