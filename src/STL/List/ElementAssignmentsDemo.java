package STL.List;


public class ElementAssignmentsDemo {

    public static void main(String[] args) {

        //Primitive array: holding boolean, byte, char, short, long, int, float, double
        int[] x = new int[3];
        //adding char in int array, it can be promoted to int
        x[0] = 'a';
        System.out.println(x[0]);
        byte b = 2;
        x[1] = b;

        long [] charArray = new long[10];
        charArray[0] = 'x';
        System.out.println("Test dung mang long den luu char " + (char)charArray[0]);

        //Object array

        Object[] objArray = new Object[5];
        objArray[0] = new Object();
        objArray[1] = new String();		//String is sub-class of Object


        //Abstract class type arrays

        Number [] daySoNhieuLoai = new Number[5];
        daySoNhieuLoai[0] = new Integer(10);
        daySoNhieuLoai[1] = new Byte("2");
        daySoNhieuLoai[2] = new Float(5.14);

        for (int i= 0; i < daySoNhieuLoai.length; i ++ ){
            System.out.println("Phan tu thu " + i + "co gia tri la "+ daySoNhieuLoai[i] );
        }


        //Interface type arrays

        Runnable[] r = new Runnable[5];			//can hold only those class objects which are implementing this interface
        r[0] = new Thread();
        System.out.println(r[1]);

    }

}
