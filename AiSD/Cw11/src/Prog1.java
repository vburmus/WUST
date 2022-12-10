import java.io.*;

public class Prog1 {
    static int arr;

    public static void BiteToBiteCopy(String nazwa1,String nazwa2) {
        try (FileInputStream fis = new FileInputStream(new File(nazwa1));FileOutputStream fos = new FileOutputStream(new File(nazwa2))){
                int line =1;
                while((line = fis.read())!=-1){
                    fos.write(line);
                }

        }catch (FileNotFoundException e){
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void buforowanie(String nazwa1,String nazwa2){
        try(FileInputStream fis = new FileInputStream(new File(nazwa1));FileOutputStream fos = new FileOutputStream(new File(nazwa2))){
            byte[] tab = new byte[512];
            int c =0;
            while((c = fis.read(tab))!=-1){
                fos.write(tab,0,c);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void zapisac (int [][] tab, String plik){
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(plik)))){
            pw.println("Macierz");
            pw.println(tab.length);
            pw.println(tab[0].length);
            for(int i =0; i< tab.length;i++){
                for(int j =0; j< tab[0].length;j++) {
            pw.print(String.format("%4d",tab[i][j]));

                }
                pw.println();
                }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static int[][] readMacierz(String plik){
        int[][] tablica = null;

        int m;
        int n;
        try(BufferedReader br = new BufferedReader(new FileReader(plik))){
            String c ="";
          while((c=br.readLine())!=null) {
              br.read();
           }
        }catch (IOException e){
            e.printStackTrace();
        }
        return tablica;
    }

    public static void main (String[]args){

        BiteToBiteCopy("1.txt","c.ser");
        buforowanie("A.txt","B.txt");
        int[][] tab = new int[2][2];
        tab[0][0] = 1;
        tab[0][1] = 1;
        tab[1][0] = 1;
        tab[1][1] = 1;

        zapisac(tab,"macierz.txt");
    }
}
