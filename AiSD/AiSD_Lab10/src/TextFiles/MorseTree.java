package TextFiles;
public class MorseTree<E extends Comparable<E>> {

    private Node root;

    public class Node<E>{
        private Node left;
        private Node right;
        private E value;
        private Node(Node left, Node right, E value){
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public Node getLeft() {
            return left;
        }
    }

    public Node getRoot() {
        return root;
    }

    public MorseTree(){
        root = new Node(null, null, ".");
    }
    public void add(String symbol, String code){
        Node current = root;
        for (int i=0; i<code.length(); i++){
            if (code.substring(i, i+1).equals(".")){
                if (current.left == null){
                    current.left = new Node(null, null, null);
                }
                current = current.left;
            }
            else if (code.substring(i, i+1).equals("-")){
                if (current.right == null){
                    current.right = new Node(null, null, null);
                }
                current = current.right;
            }
        }
        current.value = symbol;
    }
    public String decode(String code){
        Node current = root;
        boolean exists = true;
        for (int i=0; (i<code.length() && exists); i++){
            if (code.substring(i, i+1).equals(".")){
                if (current.left == null){
                    exists = false;
                }
                current = current.left;
            }
            else if (code.substring(i, i+1).equals("-")){
                if (current.right == null){
                    exists = false;
                }
                current = current.right;
            }
        }
        if (exists){
            return (String) current.value;
        }
        return null;
    }

}