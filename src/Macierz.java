import java.util.ArrayList;
import java.util.TreeMap;

public class Macierz {
    private int size;
    private TreeMap<Integer, ArrayList<Float>> rows;
    public Macierz(int size){
        this.size = size;
        rows = new TreeMap<>();
        for(int i = 0;i<size;i++){
            rows.put(i, new ArrayList<>());
        }
    }

    public void setRow(int row, ArrayList<Float> list){
        rows.replace(row, list);
    }

    public void obliczenie(){
        int start = 0;
        int good = 1;
        if(rows.get(start).get(0)==0.0||rows.get(good).get(0)==1.0&&rows.get(good).get(0)<rows.get(start).get(0)){
            while(rows.get(good).get(0)==0){
                good++;
            }
            ArrayList<Float> help = rows.get(start);
            ArrayList<Float> help2 = rows.get(good);
            rows.replace(start, help2);
            rows.replace(good, help);
        }
        for(int i = 0; i<size-1;i++){
            float firstInRow = rows.get(i).get(i);
            //System.out.print(firstInRow);
            for(int j = i+1;j<size;j++){
                float nextInRow = rows.get(j).get(i);
                if(nextInRow!=0){
                    float ws = wspolczynnik(firstInRow, nextInRow);
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

    private float wspolczynnik(float x, float y){
        float z;
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
