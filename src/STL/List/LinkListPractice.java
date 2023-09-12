package STL.List;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class LinkListPractice {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add("John");
        l.add(10);
        l.add(null);
        System.out.println(l);
        System.out.println("==============");
        l.set(0, 30);
        System.out.println(l);
        l.set(1,new HocSinh("tien", 20));
        System.out.println(l);

        //Init LinkList from ArrayList
        ArrayList<String> a = new ArrayList<>();
        a.add("Xin");
        a.add("Chao");
        a.add("Mọi");

        LinkedList ll = new LinkedList((Collection) a);
        System.out.println(ll);
        System.out.println(a);
    }
    static class HocSinh {
        String _ten;
        int _age;

        @Override
        public String toString() {
            return "HocSinh{" +
                    "_ten='" + _ten + '\'' +
                    ", _age=" + _age +
                    '}';
        }

        public HocSinh(String _ten, int _age) {
            this._ten = _ten;
            this._age = _age;
        }

        public String get_ten() {
            return _ten;
        }

        public void set_ten(String _ten) {
            this._ten = _ten;
        }

        public int get_age() {
            return _age;
        }

        public void set_age(int _age) {
            this._age = _age;
        }

    }

}
