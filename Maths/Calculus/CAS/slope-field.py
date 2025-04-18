import numpy as np
import matplotlib.pyplot as plt

# Define the differential equation dy/dx = f(x, y)
def f(x, y):
    return y - x  # Example: dy/dx = x - y

# Create a grid of points
x = np.linspace(-5, 5, 20)
y = np.linspace(-5, 5, 20)
X, Y = np.meshgrid(x, y)

# Calculate the slope (dy/dx) at each point on the grid
U = 1  # dx is set to 1 for all points
V = f(X, Y)  # dy/dx at each point

# Normalize the slopes to make the field visually clearer
N = np.sqrt(U**2 + V**2)
U2, V2 = U / N, V / N  # Normalize the vectors

# Plotting the slope field using quiver
plt.quiver(X, Y, U2, V2, angles="xy")
#plt.title(r"Slope Field for $\frac{dy}{dx} = x - y$")
plt.xlabel('x')
plt.ylabel('y')
plt.xlim([-5, 5])
plt.ylim([-5, 5])
plt.grid(True)
plt.show()