import java.util.*;

public class SinglyLinkedList{
    
    Node head;

    //This method inserts at First position of Singly linked list
    void insertFirst(int data){
        Node newNode=new Node(data);
        if(head == null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //This method inserts at Last position of Singly linked list
    void insertLast(int data){
        Node newNode=new Node(data);
        if(head == null){
            head=newNode;
            return;
        }
        Node save=head;
        while(save.next!=null){
            save=save.next;
        }
        save.next=newNode;
    }


    void countNodes(){
        Node save=head;
        int count=0;
        while (save!=null) {
            count++;
            save=save.next;
        }
        System.out.println("Count: "+count);
    }

    //This method prints the list
    void printList(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node save=head;
        while(save!=null){
            System.out.print(+save.data+" -> ");
            save=save.next;
        }       
        System.out.print("NULL\n");
    }

    //This method deletes the first node from the list
    void deleteFirst(){
        if (head == null) {
            System.out.println("List is empty, deletion unsuccessful");
            return;
        }
        head=head.next;
    }


    //This method deletes a node from last
    void deleteLast(){
        if (head == null) {
            System.out.println("List is empty, deletion unsuccessful");
            return;
        }
        if (head.next==null) {
            head=null;
            return;
        }
        Node secondLast=head;
        Node last=head.next;
        while (last.next!=null) {
            last=last.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
    }


    //This method inserts node in an ordered list
    void insertOrder(int data){
        Node newNode=new Node(data);
        if (head == null || head.data>newNode.data) {
            newNode.next=head;
            head=newNode;
            return;
        }
        Node save=head;
        while (save.next!=null && newNode.data>save.next.data) {
            save=save.next;
        }
        newNode.next=save.next;
        save.next=newNode;
    }


    //This method reverses the Singly Linked List
    void reverse(){
        if (head==null || head.next==null) {
            return;
        }
        Node prevNode=head;
        Node curNode=head.next;
        while (curNode!=null) {
            Node nextNode=curNode.next;
            curNode.next=prevNode;

            prevNode=curNode;
            curNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }


    //This methods sorts the elements of linked list
    void sort(){
        if (head==null || head.next==null) {
            return;
        }
        Node save=head;
        while (save!=null) {
            Node save2=save.next;
            while (save2!=null) {
                if (save.data>save2.data) {
                    int temp=save.data;
                    save.data=save2.data;
                    save2.data=temp;
                }
                save2=save2.next;
            }
            save=save.next;
        }
    }

    void addGCD(){
        if (head==null || head.next==null) {
            return;
        }
        Node save=head;
        Node save2=head.next;
        while (save2!=null) {
            int gcd=1;
            int min=Math.min(save.data, save2.data);
            for (int i = min; i > 0; i--) {
                if (save.data%i==0 && save2.data%i==0) {
                    gcd=i;
                    break;
                }
            }
            Node newNode=new Node(gcd);
            newNode.next=save2;
            save.next=newNode;
            save=save2;
            save2=save2.next;
        }
    }


    //pending
    public void swap() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        head = current.next;  

        while (current != null && current.next != null) {
            Node nextPair = current.next.next;
            Node second = current.next;


            second.next = current;
            current.next = nextPair;


            if (prev != null) {
                prev.next = second;
            }

            prev = current;
            current = nextPair;
        }
    }

    //method removes duplicate value in sorted singly linked list 
    void removeDuplicateValues(){
        if (head==null || head.next==null) {
            return;
        }
        Node save = head;

        while (save != null && save.next != null) {
            if (save.data == save.next.data) {
                save.next = save.next.next;
            } else {
                save = save.next; 
            }
        }
    }

    public static void main(String []args){
        SinglyLinkedList ll=new SinglyLinkedList();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.printList();
        ll.reverse();
        ll.printList();
    }
}
