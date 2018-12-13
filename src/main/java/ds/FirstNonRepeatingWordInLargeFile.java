package ds;

class DoublyLinkedListNode {
    int value;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoublyLinkedListNode{" +
                "value=" + value +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}

class DoublyLinkedList {
     DoublyLinkedListNode head;
     DoublyLinkedListNode tail;

     public DoublyLinkedListNode insertAtBeginning(DoublyLinkedListNode node) {
         if(head == null) {
             head = node;
             tail = node;
         } else {
            node.next = head;
            head.prev = node;
            head = node;
         }
        return node;
     }

    public DoublyLinkedListNode insertAtEnd(DoublyLinkedListNode node) {
        return null;
    }

    public DoublyLinkedListNode delete(DoublyLinkedListNode node) {
        return null;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}

public class FirstNonRepeatingWordInLargeFile {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtBeginning(new DoublyLinkedListNode(1));
        doublyLinkedList.insertAtBeginning(new DoublyLinkedListNode(2));
        System.out.println(doublyLinkedList);
    }
}
