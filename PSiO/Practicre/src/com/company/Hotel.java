package com.company;

public class Hotel {


        Pokoj [] hotel;
    //konstruktor
    public Hotel(int ilePokojow) {
        hotel = new Pokoj[ilePokojow];



        for (int i =0; i < hotel.length;i++){
            if(czyWolny(i)==true) return i+1;
        }
            return -1;
        }

        public void zameldowanie(osoba osoba ){
            hotel[blizszyPokuj()].osoba = osoba;
        }
        public void wymeldowanie(){
            hotel[blizszyPokuj()].osoba = null;
        }




    public class Pokoj{

        public osoba osoba;
        public int ilePokojow;
        //konstruktor
        public Pokoj(int ilePokojow){
            this.ilePokojow = ilePokojow;

        }
    }
    public class osoba{
        private String imie;
        private String nazwisko;
        //Konstruktor
        private osoba(String imie,String nazwisko){
            this.imie = imie;
            this.nazwisko = nazwisko;
        }
        //Metody
        //getters
        public String getNazwisko() {
            return nazwisko;
        }

        public String getImie() {
            return imie;
        }
        //setters

        public void setImie(String imie) {
            this.imie = imie;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

    }


    public void main(String[] args) {
        Hotel hotel = new Hotel(5);
        osoba osoba1 = new osoba("Janusz", "Jacek");
        System.out.println(hotel.blizszyPokuj());
        hotel.zameldowanie(osoba1);

    }
}
