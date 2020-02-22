import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
 * and deserialize(s), which deserializes the string back into the tree.
 *
 * For example, given the following Node class
 *
 * class Node:
 *     def __init__(self, val, left=None, right=None):
 *         self.val = val
 *         self.left = left
 *         self.right = right
 * The following test should pass:
 *
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

public class SerializeDeserializeTreeMedium {

    static String SENTINEL = "#";
    static String WORD_SENTINEL = "$";

    void serializeHelper(Node root, StringBuilder builder) {
        if(root == null) {
            builder.append(SENTINEL);
        } else {
            builder.append(root.val);
            builder.append(WORD_SENTINEL);
            serializeHelper(root.left, builder);
            serializeHelper(root.right, builder);
        }
        return;
    }

    String serialize(Node root) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(root, builder);
        return builder.toString();
    }

    Node deserializeHelper(Queue<String> someStack) {
        if(someStack.size() <= 0) {
            return null;
        }
        String c = someStack.poll();
        if(String.valueOf(c).equals(SENTINEL)) {
            return null;
        } else {
            Node anode = new Node(Integer.parseInt(c));
            anode.left = deserializeHelper(someStack);
            anode.right = deserializeHelper(someStack);
            return anode;
        }
    }

    Node deserialize(String serializedTress) {
        Queue<String> newStack = new LinkedList<>();
//        for(int i=strarr.length-1; i>=0; i--) {
//            newStack.push(strarr[i]);
//        }
        StringBuilder localBuilder = new StringBuilder();
        for(int i=0; i<serializedTress.length(); i++) {
            if(String.valueOf(serializedTress.charAt(i)).equals(WORD_SENTINEL)) {
                ((LinkedList<String>) newStack).add(localBuilder.toString());
                localBuilder = new StringBuilder();

            } else if(String.valueOf(serializedTress.charAt(i)).equals(SENTINEL)) {
                ((LinkedList<String>) newStack).add(SENTINEL);
                localBuilder = new StringBuilder();
            } else {
                localBuilder.append(serializedTress.charAt(i));
            }
        }
        return deserializeHelper(newStack);
    }

    void printTree(Node root) {
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(11111);
        Node left = new Node(7);
        Node leftLeft = new Node(9);
        root.left = left;
        root.left.left = new Node(33242);
        root.left.left.left = leftLeft;

        Node right = new Node(8);
        Node rightLeft = new Node(4);
        root.right = right;
        root.right.left = rightLeft;
        SerializeDeserializeTreeMedium s = new SerializeDeserializeTreeMedium();
        s.printTree(root);
        String serial = s.serialize(root);
        System.out.println("\n" + serial);
        Node after = s.deserialize(serial);

        s.printTree(s.deserialize(s.serialize(after)));

    }
}

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
