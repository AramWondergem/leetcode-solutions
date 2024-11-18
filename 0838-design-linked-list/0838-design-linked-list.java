//  83, 86 ,14 ,18  54

class MyLinkedList {
    Node head;
    Node tail;
    int lenght = 0; 

    public MyLinkedList() {
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = this.tail; 
        this.tail.prev = this.head;
        
    }
    
    public int get(int index) {
        Node node = getNode(index);
        if(node == null || node == tail) {
            return -1;
        }
        return node.val; 
    }
    
    public void addAtHead(int val) {
        Node nodeToAdd = new Node(val);
        
        nodeToAdd.next = this.head.next;
        nodeToAdd.prev = this.head;
        nodeToAdd.next.prev = nodeToAdd;
        this.head.next = nodeToAdd;

        this.lenght++;
        
    }
    
    public void addAtTail(int val) {
        Node nodeToAdd = new Node(val);
        
        nodeToAdd.next = this.tail;
        nodeToAdd.prev = this.tail.prev;
        nodeToAdd.prev.next = nodeToAdd;
        this.tail.prev = nodeToAdd;

        this.lenght++;
        
    }
    
    public void addAtIndex(int index, int val) {
         if(index > this.lenght) {
            return;
        }

        if(index == this.lenght){
            addAtTail(val);
            return; 
        }

       
        Node node = getNode(index);

        Node nodeToAdd = new Node(val);
        Node prevNode = node.prev;
        nodeToAdd.prev = prevNode;
        nodeToAdd.next = node;
        prevNode.next = nodeToAdd;
        node.prev = nodeToAdd; 

        this.lenght++;
        
    }
    
    public void deleteAtIndex(int index) {
         Node node = getNode(index);

        if(node == null || node == this.tail) {
            return;
        }

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        this.lenght--;
        
    }

    private Node getNode(int index){
        Node node = this.head;
        for(int i = 0; i <= index; i++) {
            node = node.next;
            if(node == null){
                return null;
            }
        }
        return node; 

    }
}

class Node{
    Node next;
    Node prev;
    int val; 

    public Node (int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */