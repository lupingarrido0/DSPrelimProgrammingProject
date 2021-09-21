public class Menu {
    public static void main(String[] args) {
        MenuItem<String> menu = new MenuItem<String>("Clipboard");
        menu.insert("Cut");
        menu.insert("Copy");
        menu.insert("Paste");
        menu.navigate();
    }
}
