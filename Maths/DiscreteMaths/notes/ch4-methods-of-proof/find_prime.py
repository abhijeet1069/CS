def is_prime(n):
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
    return 2*(n**2) - 5*n + 2

def main():
    for i in range(1,20):
        num = poly(i)
        print(f"n = {i}, isPrime({num}) =  {is_prime(num)}")

main()