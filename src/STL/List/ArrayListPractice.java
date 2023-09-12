package STL.List;

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



        //Write a Java program to swap two elements in an array list
        ArrayList<String> tvGiaDinh = new ArrayList<String>(5);
        tvGiaDinh.clear();
        tvGiaDinh.add("Ich");
        tvGiaDinh.add("Lan");
        tvGiaDinh.add("Phuong");
        tvGiaDinh.add("Linh");
        tvGiaDinh.add("Khoa");
        Collections.swap(tvGiaDinh, 2, 3);

        System.out.println("Phan tu thu 2 la : " + tvGiaDinh.get(2));
        System.out.println("Phan tu thu 3 la : "+ tvGiaDinh.get(3));
        System.out.println("Before swap: ");
        for (String tv: tvGiaDinh) {
            System.out.print(tv + "; ");
        }
        Collections.swap(tvGiaDinh,2,3);

        System.out.println("After swap: ");
        for (String tv: tvGiaDinh) {
            System.out.print(tv + "; ");
        }
    }
}
