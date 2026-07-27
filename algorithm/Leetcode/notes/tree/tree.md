# Tree

A graph is called a tree iff it has no circuits and is connected.

## Binary Tree

A binary tree is a tree where every node has at most two children.

### Terminology

```shell
        A (depth = 0)
       / \
      B   C (depth = 1)
     / \
    D   E
```

* Root : A
* Parent : B is parent of D
* Child : D is child of B
* Leaf : C D E
* Sibling : A sibling is simply another node that has the same parent. (B and C are siblings, with parent A)
* Height : Longest path from a node down to a leaf
* Depth or Level: Distance from the root to the node
* Ancestor : An ancestor is any node on the path from the root to a node.
* Descendant : Every node connected below to a given node

### Types of binary tree

- Full binary tree : 0 children or 2 children

```shell
      A
     / \
    B   C
       / \
      D   E
```

- Complete binary tree : Filled left to right

```shell
      A
     / \
    B   C
   / \  /
  D  E F
```

- Perfect binary tree : Every level completely filled

```shell
        A
      /   \
     B     C
    / \   / \
   D  E  F  G
```

- Balanced binary tree : For every node
    |height(left) - height(right)| <= 1

Balanced tree guarantee, Height = O(log n)