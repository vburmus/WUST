public class Node implements Comparable<Node>{

    private String value;
    private int frequency;
    private String letter;
    private Node left;
    private Node right;

    public Node(String value, int frequency,String letter) {
        this.value = value;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
        this.letter = letter;
    }

    public Node(int frequency) {
        this.value = null;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
        this.letter= null;
    }
    public Node(String val,String Name) {
        this.value = val;
        this.frequency = 0;
        this.letter = Name;
        this.left = null;
        this.right = null;
    }
    public Node(String val) {
        this.value = val;
        this.frequency = 0;
        this.letter = null;
        this.left = null;
        this.right = null;
    }

    public String getValue()
    {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public int nodes() {
        int count = 0;
        count++;
        if (this.getLeft() != null)
            count += this.getLeft().nodes();
        if (this.getRight() != null)
            count += this.getRight().nodes();
        return count;
    }

    public String toString()
    {
        return (this.getValue() + " - " + this.getFrequency());
    }

    @Override
    public int compareTo(Node o)
    {
        return o.getFrequency()-this.getFrequency();
    }
}
