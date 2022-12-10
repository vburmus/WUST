import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Oper {
    public static RBT fillingTheTree() {
        RBT tree = new RBT();
        int currentLine = 1;
        try (BufferedReader br = new BufferedReader(new FileReader("src/text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split("[.,?!\\s :;\" ]");
                for (String s : str) {
                    if (Pattern.matches("[AaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż]+", s)) {

                        Node node = tree.find(s.toLowerCase());
                        if (node == null)
                            tree.insert(s.toLowerCase(), currentLine);
                        else
                            node.getLines().add(currentLine);
                    }
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tree;
    }
}