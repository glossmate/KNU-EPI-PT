import graphviz

class TreeNode:

    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


def visualize_binary_tree(root):
    dot = graphviz.Digraph()
    dot.node(str(root.key))

    def add_nodes_edges(node):
        if node.left:
            dot.node(str(node.left.key))
            dot.edge(str(node.key), str(node.left.key))
            add_nodes_edges(node.left)
        if node.right:
            dot.node(str(node.right.key))
            dot.edge(str(node.key), str(node.right.key))
            add_nodes_edges(node.right)

    add_nodes_edges(root)
    dot.render('binary_tree', view=True, format='png')


# Preorder : V-L-R
def dfs(i, arr):
    root = TreeNode(arr[i])
    if root.key[:4] == 'Null':
        return root, i
    left_tree, next_i = dfs(i + 1, arr)
    right_tree, next_i = dfs(next_i + 1, arr)
    root.left = left_tree
    root.right = right_tree
    return root, next_i


input_array = ['H', 'B', 'F', 'Null0', 'Null1', 'E', 'A', 'Null2', 'Null3', 'Null4', 'C', 'Null5', 'D', 'Null6', 'G',
               'I','Null7', 'Null8', 'Null9']
tree, _ = dfs(0, input_array)
visualize_binary_tree(tree)
