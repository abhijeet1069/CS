import threading

def print_thread_a():
    print("ThreadA")

def print_thread_b():
    print("ThreadB")

thread1 = threading.Thread(target=print_thread_a)
thread2 = threading.Thread(target=print_thread_b)

thread1.start()
thread2.start()

thread1.join()
thread2.join()

print("Main thread done")