import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static  void czytaj2(){
        int suma =0;

        try(BufferedReader  br = new BufferedReader(new InputStreamReader(System.in))){
            String str;
            String[] wyw;
            while(((str = br.readLine())!=null)&&str.length()!=0){
                String[] input = str.split(" ");
                int num = 0;
                for(int i = 0; i < input.length; i++)
                    suma+= Integer.parseInt(input[i]);

            }
            System.out.println(suma);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
      /* int[][] tablica = new int[3][3];
        String str;
        try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            while(((str = br.readLine())!=null)&&str.length()!=0){
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        czytaj2();
    }
}
