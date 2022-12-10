import TextFiles.MorseTree;

public class Main {
 public Node poszuk(Node node, String name){
     if(name.equals(node.)){
         return poszuk(node.getLeft(),name);
     }

 }
    public static void main(String[] args) throws IllegalArgumentException,InvalidTreeException{

        String text = FileOperations.readFromFile("src/TextFiles/InsertSzyfr.txt");

        BST tree = BST.huffmansTree(text);
        tree.showCodingNumbers();
        FileOperations.insertToFile(tree.coding(text));
        MorseTree map = new MorseTree();
        map.add(".","-...");
        map.add("B","-...");
        map.add("u","..-");
        map.add("r",".-.");
        map.add("m","--");
        map.add("u","..-");
        map.add("s","...");
        map.add("V","...-");
        map.add("o","---");
        map.add("l",".-..");
        map.add("o","---");
        map.add("d","-.--");
        map.add("y","-.--");
        map.add("m","--");
        map.add("y","-...");
        map.add("r",".-.");
        String ns = "BurmusVolodymyr";
        for(int i = 0; i < ns.length(); i++){
            if(ns.charAt())
        }
    }
}
