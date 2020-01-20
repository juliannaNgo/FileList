import java.util.ArrayList;

public class FileTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	long startTime = System.nanoTime();
        ArrayList<Number> listAF1 = new ArrayList<Number>();
        ArrayList<Number> listAF2 = new ArrayList<Number>();
        FileList<Number> listMF1 = new FileList<Number>();
        FileList<Number> listMF2 = new FileList<Number>("cookies.txt");
        
        listAF1.add(1F);
        listAF2.add(1F);
        listMF1.add(1F);
        listMF2.add(1F);
        
        listAF1.add(2.0);
        listAF2.add(2.0);
        listMF1.add(2.0);
        listMF2.add(2.0);
        
        listAF1.add(3);
        listAF2.add(3);
        listMF1.add(3);
        listMF2.add(3);
        
        short i = 4;
        
        listAF1.add(i);
        listAF2.add(i);
        listMF1.add(i);
        listMF2.add(i);
        
        byte b = 5;
        
        listAF1.add(b);
        listAF2.add(b);
        listMF1.add(b);
        listMF2.add(b);
        
        listAF1.add((long)1293805343.23498);
        listAF2.add((long)1293805343.23498);
        listMF1.add((long)1293805343.23498);
        listMF2.add((long)1293805343.23498);
        
        listAF1.add(0, b);
        listAF2.add(0, b);
        listMF1.add(0, b);
        listMF2.add(0, b);
        
        System.out.println(listAF1);
        System.out.println(listMF1);
        listAF2.add(3, 3459);
        listMF2.add(3, 3459);
        
        System.out.println(listAF2);
        System.out.println(listMF2);
        
        
        System.out.println("After removing last element from list");
        listAF1.remove(1F);
        listAF2.remove(1F);
        listMF1.remove(1F);
        listMF2.remove(1F);
        

        System.out.println(listAF1);
        System.out.println(listMF1);
        System.out.println(listAF2);
        System.out.println(listMF2);
        
        System.out.println(listAF1.size());
        System.out.println(listMF1.size());
        System.out.println(listAF2.size());
        System.out.println(listMF2.size());
        
        listAF1.clear();
        listMF1.clear();
        listMF2.clear();
     
        System.out.println("After clearings the lists:");
        System.out.println(listAF1);
        System.out.println(listMF1);
        System.out.println(listMF2);
        long endTime = System.nanoTime() - startTime;
        System.out.println(endTime);
    }

}

