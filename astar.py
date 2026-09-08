import heapq

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


def a_star(start, goal):
    queue = [(h[start], 0, start, [start])]
    best = {start: 0}

    while queue:
        f, g, node, path = heapq.heappop(queue)

        if node == goal:
            return path, g

        for next_node, cost in graph[node]:
            new_g = g + cost

            if next_node not in best or new_g < best[next_node]:
                best[next_node] = new_g
                new_f = new_g + h[next_node]
                heapq.heappush(
                    queue,
                    (new_f, new_g, next_node, path + [next_node]),
                )


path, cost = a_star("A", "G")

print("A* Search")
print("Path:", " -> ".join(path))
print("Cost:", cost)
