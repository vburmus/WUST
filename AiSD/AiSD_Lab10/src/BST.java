import java.util.*;

public class BST {

    Node root;

    public BST(Node root)
    {
        this.root = root;
    }

    public HashMap<Node, String> getCodesMap(){
        HashMap<Node, String> codesMap = new HashMap<>();
        recurrentCodingElem(root, "", codesMap);
        return codesMap;
    }
    private void recurrentCodingElem(Node node, String s, HashMap<Node, String> codes) {
        if (node != null) {
            if (node.getRight() != null)
                recurrentCodingElem(node.getRight(), s+"1", codes);
            if (node.getLeft() != null)
                recurrentCodingElem(node.getLeft(), s+"0", codes);
            if (node.getLeft() == null && node.getRight() == null)
                codes.put(node, s);
        }
    }
    public void showCodingNumbers(){
        HashMap<Node, String> map = this.getCodesMap();
        List<Map.Entry<Node, String>> toSort = new ArrayList<>(map.entrySet());
        toSort.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Node, String> e : toSort) {
            System.out.println(e.getKey() + "\t" + e.getValue());
        }
    }
    public String coding(String s) throws InvalidTreeException {
        StringBuilder sb = new StringBuilder();
        HashMap<Node, String> nodeStringHashMap = this.getCodesMap();
        HashMap<String, String> codesMap = new HashMap<>();

        for (Map.Entry<Node,String> entry : nodeStringHashMap.entrySet())
            codesMap.put(entry.getKey().getValue(), entry.getValue());

        for (int i=0; i<s.length(); i++){
            if (codesMap.containsKey(Character.toString(s.charAt(i))))
                sb.append(codesMap.get(Character.toString(s.charAt(i))));
            else
                throw new InvalidTreeException();
        }
        return sb.toString();
    }
     public static ArrayList<Node> wystapienia(String s) {
        ArrayList<Node> result = new ArrayList<>();
        TreeMap<String,Integer> numberOfElems = new TreeMap<>();
        for(int i =0; i < s.length(); i++){
            String letter = String.valueOf(s.charAt(i));
            if(numberOfElems.containsKey(letter)){
                int count  = 1 + numberOfElems.get(letter);
                numberOfElems.remove(letter);
                numberOfElems.put(letter,count);

            }else{
                numberOfElems.put(letter,1);
            }
        }
        String[] arrayOfChars =  numberOfElems.keySet().toArray(new String[numberOfElems.size()]);
        for(int i = 0; i < numberOfElems.size(); i++){
            Node node = new Node(arrayOfChars[i], numberOfElems.get(arrayOfChars[i]),"A");
            result.add(node);
        }

        return result;
    }
    public static BST huffmansTree(String s) throws IllegalArgumentException {
        PriorityQueue<Node> queue = new PriorityQueue<>(new ComparatorTree());
        queue.addAll(wystapienia(s));
        while (queue.size()>1) {
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            Node n = new Node(n1.getFrequency() + n2.getFrequency());
            n.setLeft(n1);
            n.setRight(n2);
            queue.add(n);
        }
        if (queue.peek()!=null) {
            return new BST(queue.poll());
        }
        else
            throw new IllegalArgumentException();
    }
    public static void morseCode () {
        HashMap<String,String> map = new HashMap<>();
        map.put("B","-...");
        map.put("u","..-");
        map.put("r",".-.");
        map.put("m","--");
        map.put("u","..-");
        map.put("s","...");
        map.put("V","...-");
        map.put("o","---");
        map.put("l",".-..");
        map.put("o","---");
        map.put("d","-.--");
        map.put("y","-.--");
        map.put("m","--");
        map.put("y","-...");
        map.put("r",".-.");

    }
}
