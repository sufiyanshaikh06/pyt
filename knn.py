import pandas as pd
import matplotlib.pyplot as plt

from sklearn.neighbors import KNeighborsClassifier


url = "https://raw.githubusercontent.com/mwaskom/seaborn-data/master/iris.csv"
data = pd.read_csv(url)

X = data[
    [
        "sepal_length",
        "sepal_width",
        "petal_length",
        "petal_width",
    ]
]

y = data["species"]

knn = KNeighborsClassifier(n_neighbors=5)
knn.fit(X, y)

test = [[5.1, 3.5, 1.4, 0.2]]
result = knn.predict(test)

print("Test Data:", test)
print("Predicted Class:", result[0])

for category, color in [
    ("setosa", "red"),
    ("versicolor", "green"),
    ("virginica", "blue"),
]:
    points = data[data["species"] == category]

    plt.scatter(
        points["petal_length"],
        points["petal_width"],
        color=color,
        label=category,
    )

plt.scatter(
    1.4,
    0.2,
    color="black",
    marker="*",
    s=200,
    label="Test Data",
)

plt.xlabel("Petal Length")
plt.ylabel("Petal Width")
plt.title("K-NN Classification - Iris Dataset")
plt.legend()
plt.grid()
plt.show()
