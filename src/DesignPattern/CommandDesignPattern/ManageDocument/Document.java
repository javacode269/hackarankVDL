package DesignPattern.CommandDesignPattern.ManageDocument;

import java.util.Iterator;
import java.util.Stack;

public class Document {
    private Stack<String> lines;
    private String name;

    public Document() {
        this.lines = new Stack<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void read(){
        Iterator<String> value = lines.iterator();

        // Displaying the values
        // after iterating through the stack
        System.out.println("Starting read the book: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
    }

    protected void addline (String line){
        lines.push(line);
    }


    public void eraseLast(){
        if(!lines.isEmpty()){
            lines.pop();
        }
    }

    //Driver Code
    public static void main(String[] args) {
        Document doc = new Document();
        doc.addline("The Richest Man in Babylon is a 1926 book by George S. Clason that dispenses financial advice through a collection of parables set 4,097 years ago in ancient Babylon. ");
        doc.addline("The book remains in print almost a century after the parables were originally published, and is regarded as a classic of personal financial advice. ");
        doc.read();

        System.out.println("debug");

    }

}
