class XInterval:
    def __init__(self, left, right, interval):
        self.left = left
        self.right = right
        self.interval = interval
        self.arr = self.calculate()  # Call the calculate method to initialize arr

    def calculate(self):
        self.delX = (self.right - self.left) / self.interval
        arr = []
        for i in range(self.interval + 1):  # Include the right endpoint
            arr.append(self.left + self.delX * i)
        return arr

    def __str__(self):
        return str(self.arr)

def upperSum(func, xInterval):
    fx = []
    for i in xInterval.arr:
        fx.append(func(i))
    sum = 0
    for i in range(0,len(fx)-1):
        sum += max(fx[i],fx[i+1])*xInterval.delX
    return sum

def lowerSum(func, xInterval):
    fx = []
    for i in xInterval.arr:
        fx.append(func(i))
    sum = 0
    for i in range(0,len(fx)-1):
        sum += min(fx[i],fx[i+1])*xInterval.delX
    return sum

def midSum(func, xInterval):
    fx = []
    for i in range(0,len(xInterval.arr)-1):
        fx.append(func((xInterval.arr[i]+xInterval.arr[i+1])/2))
    sum = 0
    for i in fx:
        sum += i*xInterval.delX
    return sum

def f(x):
    return 1-x*x

def printArr(arr2d):
    print(f"{'Interval':<10} {'Lower Sum':<20} {'Middle Sum':<20} {'Upper Sum':<20}")
    for row in arr2d:
        print(f"{row[0]:<10} {row[1]:<20} {row[2]:<20} {row[3]:<20}")

def main():
    interval = [2,4,16,50,100,1000]
    left = 0
    right = 1
    res = []
    print("f(x) = {} left = {} right = {} \n========================".format("1-x^2",left,right))
    for i in interval:
        xInterval = XInterval(left,right,i)
        tempArr = [i,lowerSum(f,xInterval),midSum(f,xInterval),upperSum(f,xInterval)]
        res.append(tempArr)

    printArr(res)

main()
