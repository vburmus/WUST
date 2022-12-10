import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main4 {

    public static  void main(String[] args) throws IOException {
        Random generator = new Random();
        int m = 3;
        int n = 3;
        int[][] tab = new int[m][n];
        for(int i = 0; i<m;i++){
            for(int j = 0; j<m;j++){
                tab[i][j] = generator.nextInt(10);
            }
        }
        for(int i = 0; i<m;i++){
            for(int j = 0; j<m;j++){
              System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }

            try ( DataOutputStream write = new DataOutputStream(new FileOutputStream("new.bin"))) {

                for(int i = 0; i<m;i++){
                    for(int j = 0; j<m;j++){
                        int a = tab[i][j];
                       write.write(String.valueOf(a).getBytes() );
                    }

                }
            }catch (IOException e){
                e.printStackTrace();
            }

        try ( DataInputStream read = new DataInputStream(new FileInputStream("new.bin"))) {
            for(int i = 0; i<m;i++){
                for(int j = 0; j<m;j++){
                    System.out.print(read.read());
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }

