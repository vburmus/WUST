import java.util.ArrayList;

public class Node {

    private String value;
    private ArrayList<Integer> lines;
    private String color;
    private Node left;
    private Node right;
    private Node parent;

    public Node(String value, int n) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.lines = new ArrayList<>();
        this.lines.add(n);
        this.color = "R";
    }

    public String getValue() {
        return value;
    }

    public ArrayList<Integer> getLines() {
        return lines;
    }

    public String getColor() {
        return color;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getParent() {
        return parent;
    }

    public void setLines(ArrayList<Integer> lines) {
        this.lines = lines;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void show() {
        int size = this.getLines().size();
        System.out.print(this.getValue() + " - ");
        for (int i = 0; i < size - 1; i++)
            System.out.print(this.getLines().get(i) + ",");

        System.out.println(this.getLines().get(size - 1));

    }
}

