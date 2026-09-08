import pandas as pd
import matplotlib.pyplot as plt

from sklearn.preprocessing import LabelEncoder
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.metrics import accuracy_score


data = pd.read_csv("play_tennis.csv")
data = data.loc[:, ~data.columns.str.contains("^Unnamed")]
data = data.dropna()

encoder = LabelEncoder()

for column in data.columns:
    data[column] = encoder.fit_transform(data[column])

X = data[["Outlook", "Temperature", "Humidity", "Wind"]]
y = data["Play"]

model = DecisionTreeClassifier(criterion="entropy")
model.fit(X, y)

y_pred = model.predict(X)

print("Accuracy:", accuracy_score(y, y_pred))

print("\nPredicted Values:")
print(y_pred)

print("\nPrediction Verification:")
print(y_pred == y)

result = pd.DataFrame({
    "Actual": y,
    "Predicted": y_pred,
})

print("\nActual vs Predicted:")
print(result)

plt.figure(figsize=(12, 8))

plot_tree(
    model,
    feature_names=X.columns,
    class_names=["No", "Yes"],
    filled=True,
    rounded=True,
)

plt.show()
