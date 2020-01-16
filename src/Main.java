import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static int size;
    public static void main(String[] args){
        drawMenu();
        //System.out.println(Integer.compare(1,4));
    }

    private static void drawMenu(){
        System.out.println("Witaj w programie do liczenia macierzy!");
        System.out.println("Jak duża jest twoja macierz?");
        System.out.println("2x2 [2]");
        System.out.println("3x3 [3]");
        System.out.println("4x4 [4]");
        System.out.println("5x5 [5]");
        System.out.println("6x6 [6]");
        System.out.println("7x7 [7]");
        System.out.println("8x8 [8]");
        System.out.println("9x9 [9]");
        System.out.println("10x10 [10]");
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
                    ar.add(j,Integer.parseInt(param.readLine()));
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
