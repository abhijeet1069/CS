def main():
    
    for num in range(2,1000):
        res = poly(num)
        if(not isPrime(res)):
            print(f"{num} {res}")
            

def isPrime(n):
    if n <= 1:
        return False
    if n <= 3:
        return True  # 2 and 3 are primes
    if n % 2 == 0 or n % 3 == 0:
        return False

    # Check for factors up to √n
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6

    return True

def poly(n):
    return 2**(2*n) + 1

main()
