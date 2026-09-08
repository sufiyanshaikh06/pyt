import pandas as pd
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.metrics import accuracy_score


data = pd.read_csv("student.csv")

print(data.head())
print("Rows and Columns:", data.shape)

X = data[["Age", "StudyHours", "Attendance", "Assignments", "PreviousScore"]]
y = data["Result"]

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42,
)

model = DecisionTreeClassifier(
    criterion="entropy",
    random_state=42,
)

model.fit(X_train, y_train)

y_pred = model.predict(X_test)

print("Accuracy:", accuracy_score(y_test, y_pred))

plt.figure(figsize=(10, 5))

plot_tree(
    model,
    feature_names=X.columns,
    class_names=model.classes_,
    filled=True,
    rounded=True,
)

plt.show()
