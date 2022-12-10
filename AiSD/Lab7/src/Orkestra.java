public class Orkestra {
    static Instrument[] orkestra = new Instrument[20];
    static  int n;

    public static void main(String[] args) {
        n = 11;

        System.out.println("--------------------------------------------------------------------------------------------------------");

        orkestra[0] = new InstrumentDety("trąbka", 1);
        orkestra[1] = new InstrumentDety("róg", 1);
        orkestra[2] = new InstrumentDety("puzon",3);
        orkestra[3] = new InstrumentDety("klarnet", 1);
        orkestra[4] = new InstrumentDety("tuba",4);
        orkestra[5] = new InstrumentDety();
        orkestra[6] = new InstrumentSmyczkowy("skrzypce",4);
        orkestra[7] = new InstrumentSmyczkowy("altówka",1);
        orkestra[8] = new InstrumentSmyczkowy("wiolonczela",3);
        orkestra[9] = new InstrumentSmyczkowy("kontrabas",2);
        orkestra[10] = new InstrumentSmyczkowy();
        //wyświetl wszystkie instrumenty w kolejności występowania
        // w tablicy (wykorzystaj metodę toString());
        for(int i = 0; i < n; i++)
            System.out.println(orkestra[i].toString());

        System.out.println("--------------------------------------------------------------------------------------------------------");

        //wyświetl dźwięki wydane przez wszystkie instrumenty;
        for(int i = 0; i < n; i++)
            orkestra[i].graj();

        System.out.println("--------------------------------------------------------------------------------------------------------");

        //sprawdź, których instrumentów jest najwięcej –
        //wyświetl informację czy jest to instrument dęty czy
        //smyczkowy wraz z numerem pozycji, na której znajduje się on w tablicy
        int maxInstrumentow = 0;
        int index = 0;
        String typInstrumentu = "";
        for(int i = 0;i < n;i++){
            if( orkestra[i] instanceof InstrumentDety && ((InstrumentDety) orkestra[i]).getLt()>maxInstrumentow){
                maxInstrumentow = ((InstrumentDety) orkestra[i]).getLt();
                index = i;
                typInstrumentu = "dęty";
            }
            if( orkestra[i] instanceof InstrumentSmyczkowy && ((InstrumentSmyczkowy) orkestra[i]).getLs()>maxInstrumentow){
                maxInstrumentow = ((InstrumentSmyczkowy) orkestra[i]).getLs();
                index = i;
                typInstrumentu = "smyczkowy";
            }
        }
        System.out.println("Najwięcej instrumentów: " + orkestra[index].getNazwa() + ". Liczba instrumentów: "+ maxInstrumentow + ". Instrument jest " + typInstrumentu + ". Numer pozycji: " + index + ".");

        System.out.println("--------------------------------------------------------------------------------------------------------");

        //wyświetl same instrumenty dęte
        for(int i = 0;i < n;i++){
            if( orkestra[i] instanceof InstrumentDety){
              System.out.println(orkestra[i].toString());
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");

        //wyświetl same instrumenty dęte
        for(int i = 0;i < n;i++){
            if( orkestra[i] instanceof InstrumentSmyczkowy){
                System.out.println(orkestra[i].toString());
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");

        //wyświetl same instrumenty smyczkowe
        int ileKontrabasów = 0;
        for(int i = 0;i < n;i++){
            if( orkestra[i] instanceof InstrumentSmyczkowy && ((InstrumentSmyczkowy) orkestra[i]).jestKontrabasem()){
                ileKontrabasów = ((InstrumentSmyczkowy) orkestra[i]).getLs();
            }
        }
        System.out.println("Kontrabasów - " + ileKontrabasów + ".");
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }
}
