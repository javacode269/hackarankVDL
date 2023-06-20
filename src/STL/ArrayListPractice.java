package STL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListPractice {


    public static void main(String[] args) {


        ArrayList<String> dsTenHocSinh = new ArrayList<>(10);
        dsTenHocSinh.add("Tien");
        dsTenHocSinh.add("Duong");
        dsTenHocSinh.add("Huong");
        dsTenHocSinh.add("Tien");
        dsTenHocSinh.add("Boi");
        dsTenHocSinh.add("Bang");

        for (String ten: dsTenHocSinh){
            System.out.println(ten);
        }
        System.out.println("==========================");
        System.out.println("==========================");

        //Them phan tu vao dau day
        dsTenHocSinh.add(0, "FirstName");
        System.out.println("Danh sach ten hoc Sinh sau khi them phan tu vao dau day: ");
        for (String ten: dsTenHocSinh){
            System.out.println(ten);
        }

        //Xoa phan tu thu 5 phan tu vao dau day
        int vitri = 5;
        String phanTuBiXoa = dsTenHocSinh.remove(3);

        System.out.println("Danh sach ten hoc Sinh sau khi xoa phan tu vao dau day: ");
        for (String ten: dsTenHocSinh){
            System.out.println(ten);
        }
        System.out.println("Phan tu bi xoa la : " + phanTuBiXoa);

        System.out.println("==========================");
        System.out.println("==========================");

        dsTenHocSinh.sort(Comparator.naturalOrder());
        System.out.println("Danh sach ten hoc Sinh sau duoc sap xep la: ");
        for (String ten: dsTenHocSinh){
            System.out.println(ten);
        }

        System.out.println("==========================");
        System.out.println("==========================");

        dsTenHocSinh.sort(new Comparator<String>() {
            @Override
            //By default: Ascending sort
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("Danh sach ten hoc Sinh sau duoc sap xep la: ");
        for (String ten: dsTenHocSinh){
            System.out.println(ten);
        }


        //Write a Java program to shuffle elements in a array list
        Collections.shuffle(dsTenHocSinh);
        System.out.println("Danh sach ten hoc Sinh sau khi duoc shuffle sap xep la: ");
        for (String ten: dsTenHocSinh){
            System.out.println(ten);
        }

        // Write a Java program to increase the size of an array list
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("Danh sach ten hoc Sinh sau khi duoc shuffle sap xep la: ");
        for (String ten: dsTenHocSinh){
            System.out.println(ten);
        }
        System.out.println("Size of array : " + dsTenHocSinh.size());
        dsTenHocSinh.ensureCapacity(2);
        System.out.println("Size of array after ensureCapacity : " + dsTenHocSinh.size());


        ArrayList<Integer> stt = new ArrayList<>();
        stt.add(1);stt.add(2);stt.add(4);
        stt.add(5);stt.add(3);stt.add(4);
        //Write a Java program to reverse elements in a array list
        System.out.println("Danh sach STT TRUOC khi duoc reverse sap xep la: ");
        for (Integer s: stt){
            System.out.print(s + "; ");
        }
        System.out.println("");
        Collections.sort(stt, Collections.reverseOrder());
        System.out.println("Danh sach STT SAU khi duoc reverse sap xep la: ");
        for (Integer s: stt){
            System.out.print(s + "; ");
        }

        System.out.println("-------------------");
        System.out.println("-------------------");
        System.out.println("-------------------");
        System.out.println("-------------------");

        //Driver-code for function compareTwoArrayList
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("Hello");
        arr1.add("Worlds");
        arr1.add("!!");

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("!!");
        arr2.add("Hello");
        arr2.add("Worlds");
        if (compareTwoArrayList(arr1,arr2)){
            System.out.println("2 array bang nhau!!");
        } else {
            System.out.println("2 array khong bang nhau!!");
        }
    }

    //Write a Java program to compare two array lists
    //2 ArrayList equal if every element in arr1 what represent in arr2
    //and vice-verse
    public  static <T> boolean compareTwoArrayList (ArrayList<T> arr1, ArrayList<T> arr2){
        for (T el1: arr1){
            if(arr2.contains(el1)){
                continue;
            } else {
                return false;
            }
        }

        for (T el: arr2){
            if(arr1.contains(el)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    //Write a Java program to swap two elements in an array list

}
