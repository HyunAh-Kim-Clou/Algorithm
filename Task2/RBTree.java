public class RBTree {
    int key;
    String value;
    Boolean color;  // false: black, true: red
    RBTree left;
    RBTree right;
    RBTree parent;

    RBTree(int k, String v) {
        this.key = k;
        this.value = v;
        this.color = false;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    RBTree(int k, String v, RBTree parent) {
        this.key = k;
        this.value = v;
        this.parent = parent;
        this.color = true;
        this.left = null;
        this.right = null;
    }

    // ?
    void show(RBTree node) {
        String nblock = "";

        if (node.left != null) {
            show(node.left);
            if (node.left.color)
                nblock += "[R]";
            nblock +=  (node.left.key+"("+node.left.value+")");
        } else {
            nblock += "null";
        }

        nblock += " : ";
        if (node.color)
            nblock += "[R]";
        nblock += (node.key+"("+node.value+") : ");

        if (node.right != null) {
            show(node.right);
            if (node.right.color)
                nblock += "[R]";
            nblock +=   (node.right.key+"("+node.right.value+")");
        } else {
            nblock += "null";
        }

        System.out.println(nblock);
    }

    RBTree search(RBTree node, int k) {
        if (node == null) return null;

        System.out.print(" " + node.value);
        if (k < node.key)  return search(left, k);
        else if (k > node.key)  return search(right, k);
        else  return node;
    }

    RBTree doLeftRotation(RBTree h) {
        RBTree x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = true;
        return x;
    }
    RBTree doRightRotation(RBTree h) {
        RBTree x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = true;
        return x;
    }
    RBTree doColorFlip(RBTree h) {
        h.color = true;
        h.left.color = false;
        h.right.color = false;
        return h;
    }

    RBTree insert(RBTree node, int k, String v) {
        if (node == null)  return new RBTree(k, v, node); // leaf
        if (k < node.key)
            node.left = insert(node.left, k, v);
        else if (k > node.key)
            node.right = insert(node.right, k, v);
        else
            node.value = v;
        return node;
    }
}
