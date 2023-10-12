public class GenericStack<T> {
    private Node<T> top;
    private int size;

    public GenericStack() {
        top = null;
        size = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display(){

        Node<T> n=new Node<>(null);
        n=top;
        while(n!=null){
            System.out.println(n.data);
            n=n.next;
            
        }

    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        
        System.out.println("Integer Stack:");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        
        GenericStack<String> stackString = new GenericStack<>();
        System.out.println("String Stack:");
        stackString.push("a");
        stackString.push("b");
        stackString.push("c");
        stackString.display();

        System.out.println("Stack size: " + stack.size()); 
        
        System.out.println("Integer stack Popped : "); 
        int poppedItem = stack.pop();
        System.out.println("Popped item: " + poppedItem); 
        System.out.println("After Popped : ");         
        stack.display();
        System.out.println("Integer Stack size after pop: " + stack.size());

        System.out.println("String stack Popped : "); 
        String poppedS = stackString.pop();
        System.out.println("Popped item: " + poppedS); 
        System.out.println("After Popped : ");         
        stackString.display();

        System.out.println("String Stack size after pop: " + stackString.size());

        
        
    }
}
