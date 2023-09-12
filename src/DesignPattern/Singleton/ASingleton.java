package DesignPattern.Singleton;

public class ASingleton {

    private static volatile ASingleton instance;
    private static Object mutex = new Object();
    private  String _name;
    private String _config;

    private ASingleton(String name, String config) {
        this._name=name;
        this._config=config;
    }

    public static ASingleton getInstance() {
        ASingleton result = instance;
        if (result == null) {
            synchronized (mutex) {
                //Write constructor in here
                result = instance;
                if (result == null)
                    instance = result = new ASingleton("Application download", "/x/x/x/");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ASingleton instance = ASingleton.getInstance();
    }

}
