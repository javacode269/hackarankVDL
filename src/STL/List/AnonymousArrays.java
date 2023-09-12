package STL.List;


public class AnonymousArrays {

    public static void main(String[] args) {

        sum(new int[] {1,2,3});		//can not provide size in anonymous array

        int [] xxxx= {1,2,4,5,6,6,76};
        changeArray(xxxx);
        for (int i: xxxx){
            System.out.println(i);
        }


        int a = 20;
        changeInt(a); // Ham thuc hien viec set gia tri bang 10
        System.out.println("Gia tri cua a sau khi chay ham set ve 10: " + a);


        Integer AInteger =new  Integer(10);

        changeIntWrapper(AInteger); // Ham thuc hien viec set gia tri bang 10
        System.out.println("Gia tri cua a sau khi chay ham set ve 10: " + AInteger);

    }

    private static void sum(int[] is) {
        int total = 0;
        for(int e: is) {
            total = total+ e;
        }
        System.out.println(total);

    }

    //Pass by value
    public static  void changeArray (int arr[]){
        for(int i=0; i < arr.length; i++){
            arr[i] = 1;
        }
    }

    //Pass by value
    public  static void changeInt (int a ){
        a = 10;
    }



    //Pass by reference
    public  static void changeIntWrapper (Integer a ){
        a = 10;
    }
}
