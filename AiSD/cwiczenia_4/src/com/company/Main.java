package com.company;

import java.time.LocalDate;

public class Main {
    static class Data{
        int dzien;
        int miesiac;
        int rok;
        //KONSTRUKTOR DOMYSLNY

        public Data(){
            dzien = 30;
            miesiac = 10;
            rok = 2021;

        }
        //KOONSTRUKOR PRZECIAZONY
        public Data(int dzien, int miesiac,int rok){
            this.dzien = dzien;
            this.miesiac = miesiac;
            this.rok = rok;
        }
        //_________________________________________
        public int getDzien(){
            return dzien;
        }
        public int getMiesiac(){
            return miesiac;
        }
        public int getRok(){
            return rok;
        }
        //_________________________________________

        public void setDzien(int dzien) {
            this.dzien = dzien;
        }

        public void setMiesiac(int miesiac) {
            this.miesiac = miesiac;
        }

        public void setRok(int rok) {
            this.rok = rok;
        }

        //_________________________________________\
        //METODY
        public void wyswietlDate(){
            System.out.println("Data - " + getDzien() + "." + getMiesiac() + "." + getRok());
        }
        public void ustawDate(int dzien,int miesiac, int rok){
            this.dzien = dzien;
            this.miesiac = miesiac;
            this.rok = rok;

        }
        public boolean RokPrzestepny(){
            if(rok % 4 ==0 )
                return true;
            else
                return false;
        }

        public String czyRokPrzestepny(){
            if(RokPrzestepny()==true)
                return "Rok jest przestepny";
            else
                return "Rok nie jest przestepny";
        }
        public void exit(){
            System.exit(1);
        }
        public int poprawna(){

            int c = 0;
            if (rok > 0) {
                if(miesiac>0 && miesiac<12){
                    if (dzien<Miesiac() && dzien>0){
                             c = 1;
                        return 1;
                    }
                    else
                        c=0;
                        exit();
                        return 0;
                }
                else
                    c=0;
                    exit();
                    return 0;
            }
            else {
                c=0;
                exit();
                return  0;
            }



        }
        public String czyDataPoprawna() {
            if(poprawna()==1)
                return "Data jest poprawna";
            else
                return  "Data nie jest poprawna";


        }
        public int Miesiac(){
           int ilosc = 0;
            switch(miesiac){
                case 1,3,5,7,8,10,12:
                        ilosc = 31;
                        break;
                case 2:
                    if(RokPrzestepny()==true) ilosc = 29;
                    else ilosc = 28;
                     break;
                default:
                    ilosc = 30;
                      break;
            }
            return ilosc;
        }
        public String ileDniMaMiesiac(){
            if(Miesiac()==31)
                return "Miesiac ma " + Miesiac() + "dzien";
            else
                return "Miesiac ma " + Miesiac() + " dni";

        }

        public int doKonca(){
            int sum = 0;
            int numer = miesiac-1;
            int n = 12-miesiac;
            for(int i = 1; i<=n+1; i++){
                this.miesiac = numer+i;
                sum = sum +Miesiac();
            }
            return sum;
        };
        public int ktoryDzienRoku(){
           int ilosc_dni = 0;
                if (RokPrzestepny()==true) ilosc_dni = 366;
                else ilosc_dni=365;
                ilosc_dni = ilosc_dni-doKonca()+dzien;
                return ilosc_dni;
        }

    }

    public static void main(String[] args) {
        Data data_domyslna = new Data();
        Data data1 = new Data(10,20,2222);
        Data data2 = new Data(30,10,2);
        Data data3 = new Data(2,2,2021);
        Data data4 = new Data(15,9,1999);
        Data data5 = new Data(7,10,2004);

        data4.ustawDate(15,31,2000);
        data4.wyswietlDate();
        System.out.println(data4.czyDataPoprawna());
        System.out.println(data4.czyRokPrzestepny());
        System.out.println(data4.ileDniMaMiesiac());
        System.out.println(data4.ktoryDzienRoku() + " dzien roku!");


    }
}
