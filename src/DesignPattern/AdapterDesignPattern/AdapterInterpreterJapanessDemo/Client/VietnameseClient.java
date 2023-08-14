package DesignPattern.AdapterDesignPattern.AdapterInterpreterJapanessDemo.Client;

import DesignPattern.AdapterDesignPattern.AdapterInterpreterJapanessDemo.Adaptee.JapaneseAdaptee;
import DesignPattern.AdapterDesignPattern.AdapterInterpreterJapanessDemo.Adapter.TranslatorAdapter;
import DesignPattern.AdapterDesignPattern.AdapterInterpreterJapanessDemo.Target.VietnameseTarget;

public class VietnameseClient {

    public static void main(String[] args) {
        VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());
        client.send("Xin chào");
    }
}