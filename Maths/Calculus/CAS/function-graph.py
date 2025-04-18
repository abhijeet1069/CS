import matplotlib.pyplot as plt
import numpy as np

# Define the range for x values
x = np.linspace(0, 1, 800)  # 400 points from -10 to 10

# Define the function, e.g., f(x) = x^2
y = 1-x**2

# Plotting the function
plt.plot(x, y, label="y = f(x)", color="blue")

# Adding labels and title
plt.xlabel("x")
plt.ylabel("f(x)")
plt.title("Plot of the function y = f(x)")

# Adding a legend
plt.legend()

# Display the plot
plt.grid()
plt.show()