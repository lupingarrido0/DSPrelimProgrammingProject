public class Menu {
    public static void main(String[] args) {
        MenuItem<MenuItem<MenuItem<String>>> mainMenu = new MenuItem<>("Google Slides");
        MenuItem<MenuItem<String>> fileRibbon = new MenuItem<>("File Operations");
        
        MenuItem<MenuItem<MenuItem<String>>> workingSpaceRibbon = new MenuItem<> ("Actual Working Space");
        mainMenu.insert(workingSpaceRibbon);
        workingSpaceRibbon.inputText();

        /*  TO TEST PROGRAM:
            mainMenu.insert() to add every ribbon to the main menu
            mainMenu.navigate()
         */
    }

}
