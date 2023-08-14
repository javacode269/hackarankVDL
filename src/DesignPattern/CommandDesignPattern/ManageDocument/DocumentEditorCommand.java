package DesignPattern.CommandDesignPattern.ManageDocument;

public class DocumentEditorCommand implements Command {

    Document document;
    String text;
    @Override
    public void undo() {
        document.eraseLast();
    }

    @Override
    public void redo() {
        document.addline(text);
    }

    public DocumentEditorCommand(Document document, String text) {
        this.document = document;
        this.text = text;
    }
}
