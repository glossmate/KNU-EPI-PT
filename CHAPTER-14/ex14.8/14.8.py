# -*- coding: utf-8 -*-
"""
Created on Thu May 25 19:49:02 2023

@author: hanjaesung
"""

import graphviz


class TreeNode:

    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


def insert(root, key):
    if root is None:
        return TreeNode(key)
    else:
        if key < root.key:
            root.left = insert(root.left, key)
        else:
            root.right = insert(root.right, key)
    return root


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

def min_depth_tree(root, l, r):
    if r < l:
        return None
    mid = (l + r) // 2
    root = insert(root, keys[mid])
    root_left = root_right = None
    root_left = min_depth_tree(root_left, l, mid - 1)
    root_right = min_depth_tree(root_right, mid + 1, r)
    root.left = root_left
    root.right = root_right
    return root

# keys : level-order-traversal result
def tree_visualize(arr):
    root = None
    root1 = None
    global keys
    keys = arr   # level - order - traversal
    for key in keys:
        root1 = insert(root1, key)
    keys.sort() # sorted key list => skewed binary tree
    for key in keys:
        root = insert(root, key)

    visualize_binary_tree(root1)
    visualize_binary_tree(root)

    root2 = None
    print(sorted(keys))
    root2 = min_depth_tree(root2, 0, len(keys) - 1)
    visualize_binary_tree(root2)

# Example usage:
keys = None
 # tree_visualize([5, 3, 7, 2, 4, 6, 8])

# tree_visualize([40,30,50,25,35,45,60])
# tree_visualize([8, 3, 10, 1, 6, 14, 4, 7, 13])
tree_visualize([4, 2, 8, 3, 7, 9, 5])