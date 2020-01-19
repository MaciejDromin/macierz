import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static int size;
    public static void main(String[] args){
        drawMenu();
    }

    private static void drawMenu(){
        System.out.println("Witaj w programie do liczenia macierzy!");
        System.out.println("Jak duża jest twoja macierz?");
        for(int i = 2;i<=10;i++){
            System.out.println(i+"x"+i+" "+"["+i+"]");
        }
        System.out.println("Stworzone przez Macieja Lisowskiego");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            size = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Macierz macierz = new Macierz(size);
        for(int i = 0;i<size;i++){
            ArrayList ar = new ArrayList(5);
            for(int j = 0;j<size+1;j++){
                System.out.println("Podaj "+(j+1)+" parametr "+(i+1)+" rzędu");
                BufferedReader param = new BufferedReader(new InputStreamReader(System.in));
                try {
                    ar.add(j,Float.parseFloat(param.readLine()));
                } catch (Exception e){
                }
            }
            macierz.setRow(i, ar);
        }
        macierz.printMacierz();
        macierz.obliczenie();
        macierz.printMacierz();
    }
}
