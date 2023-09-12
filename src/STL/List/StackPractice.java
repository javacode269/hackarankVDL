package STL.List;



//Co so ly thuyet
//Stack giong vs Vector
//Truy van nhanh

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {

        Stack st = new Stack();
        st.push("Nguyen Viet Tien");
        st.push("Data Engineer");
        st.push("Đại học Bách Khoa K59");
        st.push(27);
        for (Object tt: st){
            System.out.println(tt);
        }
        System.out.println("--------------");
        System.out.println(st);


        List list = new LinkedList();
        list.add("Nguyen Viet Tien");
        list.add("Thai Binh");
        list.add( 200.2f);
        list.add( 26);
        

    }
}
