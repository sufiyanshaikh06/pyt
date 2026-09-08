import matplotlib.pyplot as plt
from sklearn.neighbors import KNeighborsClassifier


X = [
    [5.0, 50],
    [5.2, 55],
    [5.4, 60],
    [5.6, 65],
    [5.8, 70],
    [6.0, 80],
    [6.2, 85],
    [6.4, 90],
]

y = [
    "Underweight",
    "Underweight",
    "Normal",
    "Normal",
    "Normal",
    "Overweight",
    "Overweight",
    "Overweight",
]

knn = KNeighborsClassifier(n_neighbors=3)
knn.fit(X, y)

test = [[5.5, 63]]
result = knn.predict(test)

print("Test Data:", test)
print("Predicted Class:", result[0])

for category, color in [
    ("Underweight", "blue"),
    ("Normal", "green"),
    ("Overweight", "red"),
]:
    points = [X[i] for i in range(len(X)) if y[i] == category]

    plt.scatter(
        [point[0] for point in points],
        [point[1] for point in points],
        color=color,
        label=category,
    )

plt.scatter(
    5.5,
    63,
    color="black",
    marker="*",
    s=200,
    label="Test Data",
)

plt.xlabel("Height")
plt.ylabel("Weight")
plt.title("K-NN Classification")
plt.legend()
plt.grid()
plt.show()
