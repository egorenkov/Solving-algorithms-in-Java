
import java.util.*;

public class Algorithms {





    public static Pair Solution1(int n){
        if(n <= 2){
            return new Pair(1,n);
        }

        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        while(n > 0){
            if( n % 2 == 0){
                res.add(0,n /2);
                n -= n/2 ;
                count++;
            }else{
                res.add(0,n/2 + 1);
                n -= (int) n / 2 + 1;
                count++;
            }
        }
        Pair pr = new Pair(count , res);
        return pr;
    }

    public static ArrayList<Integer> Solution2(ArrayList<Integer> seq){
        if(seq.size() == 1){
            return seq;
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int el : seq){
            if(!map.containsKey(el)){
                map.put(el,0);
            }
            map.replace(el, map.get(el), map.get(el) + 1) ;
        }

        for(int el : map.keySet()){
            for(int i = 0; i < map.get(el) ; i++){
                res.add(el);
            }
        }
        return res;
    }

    public static double Solution3(ArrayList<Point> arr){
        double res =  Double.POSITIVE_INFINITY;
        for(int i = 0; i < arr.size()-1; i++){
            for(int j = i+1; j < arr.size();j++){
                res = arr.get(i).dist(arr.get(j)) < res ? arr.get(i).dist(arr.get(j)) : res;
            }
        }
        return res;
    }
    public static int Solution4(int n){

        ArrayList<Integer> seq = new ArrayList<>();
        int arr[] = {1,3,4};
        seq.add(1);
        seq.add(2);
        seq.add(1);
        seq.add(1);

        for(int i = 4; i < n;i++){
            int res = Integer.MAX_VALUE;
            for(int el : arr){
                res = Math.min(res, seq.get(i - el) + 1);
            }
            seq.add(res);
        }
        return seq.getLast();
    }
/*
value[i] = min(infinity , value(i - c)) {c = 1,2,3}
 */

    public static int Solution5(int n) {
        if (n == 1) return 0;  // частный случай

        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(0);  // для n = 1 (0 операций)
        seq.add(1);  // для n = 2 (1 операция: 1 × 2)
        seq.add(1);  // для n = 3 (1 операция: 1 × 3)

        for (int i = 3; i <= n; i++) {
            int m = seq.get(i - 1) + 1;  // операция +1
            if (i % 2 == 0) {
                m = Math.min(m, seq.get(i / 2) + 1);
            }
            if (i % 3 == 0) {
                m = Math.min(m, seq.get(i / 3) + 1);
            }
            seq.add(m);
        }
        return seq.getLast();  // индексация с 0
    }

    public static void main(String[] args){
        System.out.println(Solution5(15));

    }

}
class Pair{
    public int n;
    public ArrayList<Integer> arr = new ArrayList<>();

    Pair(int n, ArrayList<Integer> arr){
        this.n = n;
        this.arr = arr;
    }
    Pair(int n, int m ){
        this.n = n;
        this.arr.add(m);
    }

    @Override
    public String toString(){
        String res = "";
        res = res + "count: " + this.n + "\n" + "arr: ";
        for(int el : this.arr){
            res = res + el + " " ;
        }
        return res;
    }

}

class Point{
    public int x;
    public int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double dist(Point other){
        return Math.sqrt((this.x - other.x)*(this.x - other.x) + (this.y - other.y)*(this.y - other.y));
    }

    @Override
    public String toString(){
        return "x: " + this.x + ", y: " + this.y;
    }
}

/*
Theory

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Способ 1: Через Arrays.asList()
List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 5));

// Способ 2: Двойные фигурные скобки (анонимный класс)
List<Integer> list2 = new ArrayList<>() {{
    add(1);
    add(2);
    add(4);
    add(3);
    add(5);
}};

// Способ 3: Поэлементное добавление (Java 10+)
List<Integer> list3 = new ArrayList<>(List.of(1, 2, 4, 3, 5));

 */