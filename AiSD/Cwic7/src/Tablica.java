public class Tablica {
    Pracownik[] pracowniki;
    public Tablica(int n){
        this.pracowniki = new Pracownik[n];
    }
    public int indexWolnego(){

        for (int i = 0; i < pracowniki.length;i++){
            if(pracowniki[i]==null) return i;
        }
        return -1;
    }
    public void zwolnienie(String nazwisko) {
        for (int i = 0; i < pracowniki.length; i++) {
            if (nazwisko.equals(pracowniki[i].getNazwisko())) {
                pracowniki[i] = null;
            }
        }
    }
    public void zatrudnienie(Pracownik os) {
        if(os instanceof Robotnicy)
        pracowniki[indexWolnego()] = new Robotnicy(os.getNazwisko(), os.getEtat(), ((Robotnicy)os).getLiczbaGodzin(), ((Robotnicy)os).getStawka());

        if(os instanceof  Urzednicy)
        pracowniki[indexWolnego()] = new Urzednicy(os.getNazwisko(),((Urzednicy) os).getPlacaPodstawowa(),os.getEtat(),((Urzednicy)os).getPremia());
    }
    public void ileZatrudnionychRobotnikow() {
        int count = 0;
        for (int i = 0; i < pracowniki.length; i++) {
            if (pracowniki[i] instanceof Robotnicy) {
                count++;
            }
        }
    }
        public void sumaWyplatRobotnikow(){
            int sum = 0;
            for (int i = 0; i < pracowniki.length; i++) {
                if (pracowniki[i] instanceof Robotnicy) {
                    sum+= pracowniki[i].wyplata();
                }
            }
        }
        public void sumaWyplatUrzednikow() {
            int sum = 0;
            for (int i = 0; i < pracowniki.length; i++) {
                if (pracowniki[i] instanceof Urzednicy) {
                    sum+= pracowniki[i].wyplata();
                }
            }
        }
    public void ileZatrudnionychUrzednikow(){
        int count = 0;
        for(int i = 0; i< pracowniki.length;i++){
            if(pracowniki[i] instanceof Urzednicy){
                count++;
            }
        }
    }
    public  void wydruk() {
        for (int i = 0; i < pracowniki.length; i++) {
            if(pracowniki[i]!=null)
            System.out.println(pracowniki[i].getNazwisko() + "  " + pracowniki[i].toString());
        }
    }
    public  void wydrukListyPlac() {
        for (int i = 0; i < pracowniki.length; i++) {
            if(pracowniki[i]!=null){

                if(pracowniki[i] instanceof Robotnicy)
                    System.out.println(pracowniki[i].getNazwisko() + " jest pracownikiem "+ pracowniki[i].getEtat() + " "+  (pracowniki[i]).wyplata());
                if(pracowniki[i] instanceof Urzednicy)
                    System.out.println(pracowniki[i].getNazwisko() + " jest urzednikiem "+ pracowniki[i].getEtat() + " "+ pracowniki[i].wyplata());

            }}
    }
    }

