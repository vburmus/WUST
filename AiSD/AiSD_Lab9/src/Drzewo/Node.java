package Drzewo;

public class Node {


    private String value;
    private Node left;
    private Node right;


    public Node (String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public String getValue()
    {
        return value;
    }

    public Node getLeft()
    {
        return left;
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }
}
