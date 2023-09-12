package STL.Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        HashSet hs1 = new HashSet(30, .80f);

        hs.add("Tien");
        hs.add("Giang");
        hs.add("Ly");
        hs.add("Dat");
        hs.add("Ngoc");
        hs.add("Duc");
        Iterator hsIter = hs.iterator();
        while (hsIter.hasNext()){
            System.o ut.println(hsIter.next());
        }

    }
}
