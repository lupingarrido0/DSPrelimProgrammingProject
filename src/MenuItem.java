import java.util.Scanner;

public class MenuItem<E> extends MyDoublyLinkedCircularList<E> {
    DoublyLinkedNode<E> current;
    String label;

    MenuItem(String label) {
        current = super.getTail().getNext();
        this.label = label;
    }

    @Override
    public String toString() {
        DoublyLinkedNode<E> current = getTail();
        StringBuilder menu = new StringBuilder("[ ");
        do {
            menu.append(current.getData().toString()).append(", ");
            current = current.getNext();
        } while (!current.equals(getTail()) || getSize() == 1);
        menu.append(" ]");
        return menu.toString();
    }

    public DoublyLinkedNode<E> lookup(String data) {
        if (getSize() == 0) return null;
        DoublyLinkedNode<E> current = getTail();
        do {
            if (current.getData().toString().equals(data)) return current;
            current = current.getNext();
        } while(!current.equals(getTail())|| getSize() == 1);
        return null;
    }

    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public void navigate() {
        System.out.println(current.toString());
        String choice = getInput("Input");
        if (choice.equalsIgnoreCase("x")) return;
        current = lookup(choice);
        navigate();
    }
}
