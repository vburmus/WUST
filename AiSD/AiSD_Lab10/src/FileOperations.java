import java.io.*;

public class FileOperations {
    public static void insertToFile(String str) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/TextFiles/OutputSzyfr.txt"))) {
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readFromFile(String name){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            while((line = br.readLine())!=null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
