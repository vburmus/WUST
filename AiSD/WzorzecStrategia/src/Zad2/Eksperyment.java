package Zad2;

public class Eksperyment {


    public static void tryCatchTest() {
            try {
                int[] array = new int[3];
                int num = array[4] ;
            } catch (ArrayIndexOutOfBoundsException e) {
                e.getStackTrace();
            }
        }
    public static void throwTest() throws ArrayIndexOutOfBoundsException {
        int[] array = new int[3];
        int num = array[4] ;
    }

    public static void tryCatchTest2(){
        try {
            int num = 4/0 ;
        } catch (ArithmeticException e) {

        }
    }
    public static void throwTest2() throws ArithmeticException {

        int num = 4/0 ;

    }
    public static void main(String[] args)  {
        long time1= 0;
        long time2= 0;

        for(int num = 10;num<=10000;num*=10) {
            for (int i = 0; i < num; i++) {
                long startThrow = System.nanoTime();
                try {
                    throwTest();
                } catch (ArrayIndexOutOfBoundsException e) {

                    long finishThrow = System.nanoTime();
                    time1+=finishThrow-startThrow;
                }

            }
            System.out.println("Throws ------" + num + "---" + (time1));
            time1=0;
            for (int j = 0; j < num; j++) {
                long startTryCatch = System.nanoTime();

                tryCatchTest();

                long finishTryCatch = System.nanoTime();
                time1+=finishTryCatch-startTryCatch;
            }
            System.out.println("Try Catch ---" + num + "---" + (time1) + "\n");
        }




        for(int num = 10;num<=10000;num*=10) {
            for (int i = 0; i < num; i++) {
                long startThrow = System.nanoTime();
                try {
                    throwTest2();
                } catch (ArithmeticException e) {

                }
                long finishThrow = System.nanoTime();
                time2+=finishThrow-startThrow;
            }
            System.out.println("Throws2 ------" + num + "---" + time2);
            time2=0;
            for (int j = 0; j < num; j++) {
                long startTryCatch = System.nanoTime();

                tryCatchTest2();
                long finishTryCatch = System.nanoTime();
                time2+=finishTryCatch-startTryCatch;

            }
            System.out.println("Try Catch2 ---" + num + "---" + time2 + "\n");
        }
    }
}
