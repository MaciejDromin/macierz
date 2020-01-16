import java.util.ArrayList;
import java.util.TreeMap;

public class Macierz {
    private int size;
    private TreeMap<Integer, ArrayList<Integer>> rows;
    public Macierz(int size){
        this.size = size;
        rows = new TreeMap<>();
        for(int i = 0;i<size;i++){
            rows.put(i, new ArrayList<>());
        }
    }

    public void setRow(int row, ArrayList<Integer> list){
        rows.replace(row, list);
    }

    public void obliczenie(){
        int start = 0;
        int good = 1;
        if(rows.get(start).get(0)==0){
            while(rows.get(good).get(0)==0){
                good++;
            }
            ArrayList<Integer> help = rows.get(start);
            ArrayList<Integer> help2 = rows.get(good);
            rows.replace(start, help2);
            rows.replace(good, help);
        }
        for(int i = 0; i<size-1;i++){
            int firstInRow = rows.get(i).get(i);
            //System.out.print(firstInRow);
            for(int j = i+1;j<size;j++){
                int nextInRow = rows.get(j).get(i);
                if(nextInRow!=0){
                    int ws = wspolczynnik(firstInRow, nextInRow);
                    for(int n = i;n<rows.get(i).size();n++){
                        //System.out.print(rows.get(j).get(n));
                        rows.get(j).set(n, rows.get(j).get(n)+(ws*rows.get(i).get(n)));
                        //System.out.print(rows.get(j).get(n));
                        //System.out.println();
                    }
                }
                //System.out.println("");
            }
        }
    }

    private int wspolczynnik(int x, int y){
        int z;
        z = -y/x;
        //int result = y+z*x;
        return z;
    }

    public void printMacierz(){
        for(int i = 0;i<size;i++){
            for(int j = 0;j<rows.get(0).size();j++){
                System.out.print(rows.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
