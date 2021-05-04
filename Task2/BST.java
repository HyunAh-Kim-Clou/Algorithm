public class BST {
    int key;
    String value;
    BST left;
    BST right;

    BST(int k, String v) {
        this.key = k;
        this.value = v;
        this.left = null;
        this.right = null;
    }

    void show(BST node) {
        String tmp = "";

        if (node.left != null) {
            show(node.left);
            tmp += node.left.value;
        }
        tmp += ("["+node.key+" : "+node.value+"]");
        if (node.right != null) {
            show(node.right);
            tmp += node.right.value;
        }
        System.out.println(tmp);
    }

    BST search(BST node, int k) {
        if (node == null) return null;

        System.out.print(" " + node.value);
        if (k < node.key)  return search(left, k);
        else if (k > node.key)  return search(right, k);
        else  return node;
    }

    BST insert(BST node, int k, String v) {
        if (node == null)  return new BST(k, v); // leaf
        if (k < node.key)
            node.left = insert(node.left, k, v);
        else if (k > node.key)
            node.right = insert(node.right, k, v);
        else
            node.value = v;
        return node;
    }
}
