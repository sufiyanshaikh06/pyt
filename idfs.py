graph = {
    "A": ["B", "C"],
    "B": ["D", "E"],
    "C": ["F"],
    "D": [],
    "E": ["F"],
    "F": [],
}


def iterative_dfs(graph, start):
    visited = set()
    stack = [start]

    print("Iterative DFS Traversal:")

    while stack:
        vertex = stack.pop()

        if vertex not in visited:
            visited.add(vertex)
            print(vertex, end=" ")

            for neighbour in reversed(graph[vertex]):
                if neighbour not in visited:
                    stack.append(neighbour)


iterative_dfs(graph, "A")
