package Info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*strumienie mog? by? bajtowe a znakowe, te? jest podzia? na zapis i odczyt
czyli mamy:
znakowe:        Bajtowe:
reader          InputStrem

writer          OutputStream

?r?d?a utworzone - System.in(generuje strumie? bajtowy), System.out
klasy po?rednicze:
- InputStreamReader (wsp??pracuje z klawiatur? i przechodzi z bajt?w na znaki)
- OutputStreamWriter

Strumienie mo?na ??czy? ([uj?cie]______<-()___________<-()________[?r?d?o])
Strumienie mo?na opakowywa?

jak pracujemy na strumieniach?
- otworzy? strumie?
-Dop?ki s? dane
    czytaj/zapisuj
-Zamknij strumie? (nazwa.close())
(W przypadku strumieni bajtowych pracujemy dop?ki -1)

strumie? odczytu z klawiatiry:
InputStreamReader isr = new InputStreamReader(System.in)

p?tli
enter ctrl+z

int.read(); - 1 znak
int read()
__________________________________________________
Buforowanie Systemowe
BufferedReader
BufferedWriter


*/
public class Info {
    public static void main(String[] args) {
        String s = null;
        try(InputStreamReader isr = new InputStreamReader(System.in)){

        }catch (IOException e){
            e.printStackTrace();
        }
        try(PrintWriter pw = new PrintWriter(System.out)){
            pw.write(s);
        }
    }
}
