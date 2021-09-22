public class Menu {
    public static void main(String[] args) {
        MenuItem<MenuItem<String>> menu = new MenuItem<>("File");
        MenuItem<String> subMenu = new MenuItem<>("");
        subMenu.insert("New");
        subMenu.insert("Open");
        subMenu.insert("Open Recent");
        subMenu.insert("Close Project");

        menu.insert(subMenu);
        menu.navigate();
    }
}
