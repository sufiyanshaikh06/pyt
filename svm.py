import pandas as pd
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import (
    accuracy_score,
    confusion_matrix,
    classification_report,
    ConfusionMatrixDisplay,
)


data = pd.read_csv("SVMstudent.csv")

print(data.head())

print("\nMissing Values:")
print(data.isnull().sum())

X = data[
    [
        "StudyHours",
        "Attendance",
        "PreviousMarks",
    ]
]

y = data["Result"]

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42,
    stratify=y,
)

model = SVC(kernel="linear")
model.fit(X_train, y_train)

y_pred = model.predict(X_test)

print("\nAccuracy:", accuracy_score(y_test, y_pred))

cm = confusion_matrix(y_test, y_pred)

print("\nConfusion Matrix:")
print(cm)

print("\nClassification Report:")
print(classification_report(y_test, y_pred))

display = ConfusionMatrixDisplay(
    confusion_matrix=cm,
    display_labels=model.classes_,
)

display.plot(cmap="Blues")
plt.title("Confusion Matrix")
plt.show()
