import javax.swing.*;

public class Browser_Linked_List<Item> {
    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    Node current;

    Browser_Linked_List() {
        current = new Node();
        current.item = null;
        current.prev = null;
        current.next = null;
    }

    void search(Item item) {
        if (current.item == null) {
            current = new Node();
        } else {
            current.next = new Node();
            current.next.prev = current;
            current = current.next;
        }
        current.item = item;
    }

    public static void main(String[] args) {
        Browser_Linked_List<String> doubleLinkedList = new Browser_Linked_List<>();
        JFrame frame = new JFrame("Browser");

        JTextField url = new JTextField();
        url.setBounds(50, 250, 300, 30);
        frame.add(url);

        JButton backward = new JButton("Backward");
        backward.setBounds(50, 100, 100, 30);
        backward.addActionListener(e -> {
            if (doubleLinkedList.current.prev != null) {
                doubleLinkedList.current = doubleLinkedList.current.prev;
                url.setText(doubleLinkedList.current.item);
            }
        });
        frame.add(backward);

        JButton forward = new JButton("Forward");
        forward.setBounds(250, 100, 100, 30);
        forward.addActionListener(e -> {
            if (doubleLinkedList.current.next != null) {
                doubleLinkedList.current = doubleLinkedList.current.next;
                url.setText(doubleLinkedList.current.item);
            }
        });
        frame.add(forward);

        JButton search = new JButton("Search");
        search.setBounds(50, 280, 300, 30);
        search.addActionListener(e -> doubleLinkedList.search(url.getText()));
        frame.add(search);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
