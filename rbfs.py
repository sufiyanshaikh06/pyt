graph = {
    "A": [("B", 1), ("C", 2)],
    "B": [("D", 1)],
    "C": [("E", 1)],
    "D": [("G", 10)],
    "E": [("G", 1)],
    "G": [],
}

h = {
    "A": 4,
    "B": 1,
    "C": 2,
    "D": 1,
    "E": 1,
    "G": 0,
}


def rbfs(node, goal, g, path, limit):
    if node == goal:
        return path, g, g

    children = []

    for child, cost in graph[node]:
        new_g = g + cost
        f = new_g + h[child]
        children.append([child, new_g, f])

    if not children:
        return None, float("inf"), float("inf")

    while True:
        children.sort(key=lambda x: x[2])
        best = children[0]

        if best[2] > limit:
            print("Backtracking from", node)
            return None, float("inf"), best[2]

        alternative = children[1][2] if len(children) > 1 else float("inf")

        result, cost, new_f = rbfs(
            best[0],
            goal,
            best[1],
            path + [best[0]],
            min(limit, alternative),
        )

        best[2] = new_f

        if result:
            return result, cost, new_f


path, cost, f = rbfs("A", "G", 0, ["A"], float("inf"))

print("\nRBFS Search")
print("Path:", " -> ".join(path))
print("Cost:", cost)
