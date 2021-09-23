public class Menu {
    public static void main(String[] args) {

        MenuItem<MenuItem<MenuItem<String>>> main = new MenuItem<>("Main");
        MenuItem<MenuItem<String>> fileMenu = new MenuItem<>("File");
        MenuItem<MenuItem<String>> editMenu = new MenuItem<>("Edit");
        MenuItem<MenuItem<String>> viewMenu = new MenuItem<>("View");

        // Main Menu Operations
        main.insert(fileMenu);
        main.insert(editMenu);
        main.insert(viewMenu);

        // File menu Operations
        MenuItem<String> newSubMenu = new MenuItem<>("New");
        MenuItem<String> openSubMenu = new MenuItem<>("Open");
        MenuItem<String> settingsSubMenu = new MenuItem<>("Settings");
        fileMenu.insert(newSubMenu);
        fileMenu.insert(openSubMenu);
        fileMenu.insert(settingsSubMenu);

        // Edit menu operations
        MenuItem<String> undoTypingSubMenu = new MenuItem<>("Undo Typing");
        MenuItem<String> cutSubMenu = new MenuItem<>("Cut");
        MenuItem<String> copySubMenu = new MenuItem<>("Copy");
        MenuItem<String> pasteSubMenu = new MenuItem<>("Paste");
        editMenu.insert(undoTypingSubMenu);
        editMenu.insert(cutSubMenu);
        editMenu.insert(copySubMenu);
        editMenu.insert(pasteSubMenu);

        // View menu operations
        MenuItem<String> quickDefSubMenu = new MenuItem<>("Quick Definitions");
        MenuItem<String> siblingsSubMenu = new MenuItem<>("Show Siblings");
        MenuItem<String> documentationSubMenu = new MenuItem<>("Quick Documentation");
        viewMenu.insert(quickDefSubMenu);
        viewMenu.insert(siblingsSubMenu);
        viewMenu.insert(documentationSubMenu);

        main.navigate();
    }
}
