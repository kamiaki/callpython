import sys
from numpy import *

def func(a,b):
    return (a+b)

if __name__ == '__main__':
    a = []
    for i in range(1, len(sys.argv)):
        a.append((sys.argv[i]))
    print(a)
    print(eye(int(a[0])))
    print(func(a[0],a[1]))
    print(func(int(a[0]),int(a[1])))
    print(a[2])
