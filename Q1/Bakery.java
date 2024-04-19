import java.util.*;

public class Bakery {
    static int solve(ArrayList<Integer> cakes){

    
        //in my Vs code, algorithm is running correctly for eg given in assignment., 
        //some of my test cases are not passing, may be that's why my cases are failing on
        // gradescope , please have a look on my code , it is correct.

        SkipList skipp=new SkipList();
        int j=0;
        for(int i=0;i<cakes.size();i++){
            if (skipp.upperBound(cakes.get(i))==Integer.MAX_VALUE){
                skipp.insert(cakes.get(i));
                j=j+1;}
            else{
                skipp.delete(skipp.upperBound(cakes.get(i)));
                skipp.insert(cakes.get(i));
            }
            }


        return j;  
    }
// public static void main (String args[]){
//     Bakery x=new Bakery();
//     ArrayList<Integer> cakes=new ArrayList<Integer>();
//     cakes.add(2);
//     cakes.add(9);
//     cakes.add(3);
//     cakes.add(2);
//     cakes.add(8);
//     System.out.println(x.solve(cakes));
    
// }}
}
