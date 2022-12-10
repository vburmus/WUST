import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RBT {

    Node root;

    public RBT ()
    {
        this.root = null;
    }

    private Node search(Node node, String value) {
        if (node == null || value.equals(node.getValue()))
            return node;
        if (value.compareTo(node.getValue()) < 0)
            return search(node.getLeft(), value);
        return search(node.getRight(), value);
    }
    public Node find(String value) {
        return search(root, value);
    }
    private void rotateLeft(Node node) {
        Node right = node.getRight(); // prawe dziecko elementu
        node.setRight(right.getLeft());

        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }

        right.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = right;
        }
        else if (node.getValue().equals(node.getParent().getLeft().getValue())) {
            node.getParent().setLeft(right);
        }
        else {
            node.getParent().setRight(right);
        }
        right.setLeft(node);
        node.setParent(right);
    }
    private void rotateRight(Node node) {
        Node left = node.getLeft();
        node.setLeft(left.getRight());

        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }

        left.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = left;
        }
        else if (node.getValue().equals(node.getParent().getRight().getValue())) {
            node.getParent().setRight(left);
        }
        else {
            node.getParent().setLeft(left);
        }
        left.setRight(node);
        node.setParent(left);
    }

    private void renew(Node node) {
        Node uncle;
        //dopóki rodzic czerwony naprawiamy
        while (node.getParent().getColor().equals("R")) {
            if (node.getParent().getParent().getRight() != null && node.getParent().getValue().equals(node.getParent().getParent().getRight().getValue())) {
                uncle = node.getParent().getParent().getLeft();
                //jezeli wujek czerwony przekolorowujemy
                if (uncle != null && uncle.getColor().equals("R")) {
                    uncle.setColor("B");
                    node.getParent().setColor("B");
                    node.getParent().getParent().setColor("R");
                    node = node.getParent().getParent();
                }
                // natychmiast jezeli wujek czarny
                else {
                    //jezeli element jest lewym dzieckiem rodzica wtedy wykonujemy rotacje w prawo i przechodzimy do nastepnego przypadku
                    if (node.getParent().getLeft() != null && node.getValue().equals(node.getParent().getLeft().getValue())) {
                        node = node.getParent();
                        rotateRight(node);
                    }
                    // na koniec - jezeli element jest prawym dzieckiem rodzica wtedy wykonujemy rotacje w lewo i przekolorowujemy rodzica i dziadka
                    node.getParent().setColor("B");
                    node.getParent().getParent().setColor("R");
                    rotateLeft(node.getParent().getParent());
                }
            }
            else {
                //rodzic elementu jest lewym dzieckiem dziadka
                uncle = node.getParent().getParent().getRight();
                //jezeli wujek czerwony przekolorowujemy
                if (uncle != null && uncle.getColor().equals("R")) {
                    uncle.setColor("B");
                    node.getParent().setColor("B");
                    node.getParent().getParent().setColor("R");
                    node = node.getParent().getParent();
                }
                else {
                    //jezeli element jest prawym dzieckiem rodzica wtedy wykonujemy rotacje w lewo i przechodzimy do nastepnego przypadku
                    if (node.getParent().getRight() != null && node.getValue().equals(node.getParent().getRight().getValue())) {
                        node = node.getParent();
                        rotateLeft(node);
                    }
                    // na koniec jezeli element jest lewym dzieckiem rodzica - rotacja w prawo i przekolorowanie rodzica i dziadka
                    node.getParent().setColor("B");
                    node.getParent().getParent().setColor("R");
                    rotateRight(node.getParent().getParent());
                }
            }
            if (node.getValue().equals(root.getValue()))
                break;
        }
        //jezeli mamy przypadek z korzeniem - robimy go czarnym
        root.setColor("B");
    }

    public void insert(String word, int position) {
        Node newNode = new Node(word, position);
        Node y = null;
        Node x = this.root;

        while (x!=null) {
            y = x;
            if (newNode.getValue().compareTo(x.getValue()) < 0)
                x = x.getLeft();
            else
                x = x.getRight();
        }

        newNode.setParent(y);
        if (y == null)
            root = newNode;
        else if (newNode.getValue().compareTo(y.getValue()) < 0)
            y.setLeft(newNode);
        else if (newNode.getValue().compareTo(y.getValue()) > 0)
            y.setRight(newNode);

        if (newNode.getParent() == null) {
            newNode.setColor("B");
            return;
        }
        if (newNode.getParent().getParent() == null)
            return;

        renew(newNode);
    }

    private void inorder(Node node) {
        if (node.getLeft() != null)
        {
            inorder(node.getLeft());
        }

        node.show();

        if (node.getRight() != null)
        {
            inorder(node.getRight());
        }
    }

    private void levelorder(Node node)  {
        if (node != null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                n.show();
                if (n.getLeft() != null)
                    queue.add(n.getLeft());
                if (n.getRight() != null)
                    queue.add(n.getRight());
            }
        }
    }

    public void levelOrder() {
        System.out.println("Drzewo wszerz: ");
        levelorder(root);
        System.out.println();
    }

    public void showWords () {
        System.out.println("Skorowidz:");
        inorder(root);
    }

    private Node minimum(Node node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    private void repairDelete(Node node) {
        Node brother;
        while (node != null && !node.getValue().equals(root.getValue()) && node.getColor().equals("B")) {
            // jezeli node jest lewym dzieckiem rodzica
            if (node.getValue().equals(node.getParent().getLeft().getValue())) {
                brother = node.getParent().getRight();
                // jezeli brat czerwony wtedy wykonujemy przekolorowanie brata,rodzica i rotacje w lewo
                if (brother.getColor().equals("R")) {
                    brother.setColor("B");
                    node.getParent().setColor("R");
                    rotateLeft(node.getParent());
                    brother = node.getParent().getRight();
                }
                // jezeli obydwoje dzieci brata są czarne wtedy przekolorujemy brata oraz przesuwamy token wyzej
                if (brother.getLeft().getColor().equals("B") && brother.getRight().getColor().equals("B")) {
                    brother.setColor("R");
                    node = node.getParent();
                }
                else {
                    // jezeli prawe dziecko brata czarne oraz lewe czerwone wtedy przekolorujemy lewe dziecko brata, brata,wykonujemy rotacje w prawo
                    if (brother.getRight().getColor().equals("B")) {
                        brother.setColor("R");
                        brother.getLeft().setColor("B");
                        rotateRight(brother);
                        brother = node.getRight().getParent();
                    }
                    // na koniec, jezeli  prawe dziecko brata czerwone oraz lewe czarne wtedy zamieniamy kolor  brata na kolor rodzica, przekolorujemy kolor prawego dziecka brata oraz robimy rotacje w lewo
                    brother.setColor(node.getParent().getColor());
                    node.getParent().setColor("B");
                    brother.getRight().setColor("B");
                    rotateLeft(node.getParent());
                    node = root;
                }
            }
            // jezeli node jest prawym dzieckiem rodzica
            else if (node.getValue().equals(node.getParent().getRight().getValue())) {
                    brother = node.getParent().getLeft();
            // jezeli brat czerwony wtedy wykonujemy przekolorowanie brata,rodzica i rotacje w prawo
                if (brother.getColor().equals("R")) {
                        brother.setColor("B");
                        node.getParent().setColor("R");
                        rotateRight(node.getParent());
                        brother = node.getParent().getLeft();
                    }
                // jezeli obydwoje dzieci brata są czarne wtedy przekolorujemy brata oraz przesuwamy token wyzej
                    if (brother.getRight().getColor().equals("B") && brother.getLeft().getColor().equals("B")) {
                        brother.setColor("R");
                        node = node.getParent();
                    }
                    else {
                        // jezeli lewe dziecko brata czarne oraz prawe czerwone wtedy przekolorujemy prawe dziecko brata, brata,wykonujemy rotacje w lewo
                        if (brother.getLeft().getColor().equals("B")) {
                            brother.getRight().setColor("B");
                            brother.setColor("R");
                            rotateLeft(brother);
                            brother = node.getLeft().getParent();
                        }
                        // na koniec, jezeli  lewe dziecko brata czerwone oraz prawe czarne wtedy zamieniamy kolor  brata na kolor rodzica, przekolorujemy kolor lewego dziecka brata oraz robimy rotacje w prawo
                        brother.setColor(node.getParent().getColor());
                        node.getParent().setColor("B");
                        brother.getLeft().setColor("B");
                        rotateRight(node.getParent());
                        node = root;
                    }
                }
            }
        if (node != null)
            node.setColor("B");
    }
    //wysukiwania nastepnika
    private Node successor(Node node) {
        if (node.getRight() != null) {
            return minimum(node.getRight());
        }

        Node parent = node.getParent();
        while (parent!=null && node.getValue().equals(parent.getRight().getValue())) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    private void swap(Node firstSwapNode, Node secondSwapNode) {
        String firstSwapNodeValue = firstSwapNode.getValue();
        String secondSwapNodeValue = secondSwapNode.getValue();
        ArrayList<Integer> firstSwapNodeLines = firstSwapNode.getLines();
        ArrayList<Integer> secondSwapNodeLines = secondSwapNode.getLines();

        firstSwapNode.setValue(secondSwapNodeValue);
        secondSwapNode.setValue(firstSwapNodeValue);
        firstSwapNode.setLines(secondSwapNodeLines);
        secondSwapNode.setLines(firstSwapNodeLines);
    }

    public void delete(String value) {
        Node foundedNode = this.search(root, value);
        Node childOfMain;
        Node mainNode;
        if (foundedNode == null) {
            System.out.println("Nie ma wyrazu!");
            return;
        }
        else {
            // jezeli element jest liściem ustalamy
            if (foundedNode.getLeft() == null || foundedNode.getRight() == null) {
                mainNode = foundedNode;
            }
            // jezeli element nie jest liściem wtedy zamieniamy następnikiem(successor)
            else {
                mainNode = successor(foundedNode);
            }
            // ustawiamy CHILD na lewe dziecko elementu
            if (mainNode.getLeft()!=null) {
                childOfMain = mainNode.getLeft();
            }
            else {
                childOfMain = mainNode.getRight();
            }
            if (childOfMain!=null) {
                // przestawiamy rodzica
                childOfMain.setParent(mainNode.getParent());
            }
            if (mainNode.getParent() == null) {
                this.root = childOfMain;
            }
            else {
                if (mainNode.getValue().equals(mainNode.getParent().getLeft().getValue())) {
                    mainNode.getParent().setLeft(childOfMain);
                }
                else {
                    mainNode.getParent().setRight(childOfMain);
                }
            }
            // zamiana następnikiem
            if (!mainNode.getValue().equals(foundedNode.getValue())) {
                swap(foundedNode, mainNode);
            }
        }
        // jeżeli USUNELI węzeł czarny WTEDY naprawiamy drzewo
        if (mainNode.getColor().equals("B"))
            repairDelete(childOfMain);
    }
}
