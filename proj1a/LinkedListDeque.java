public class LinkedListDeque<T>{
    public class Node{
        T item;
        Node prev,next;

        public Node(){
            item=null;
            prev=next=null;
        }

        public Node(T Item){
            item=Item;
            prev=next=null;
        }
    }

    Node sentinel;
    int count;

    public LinkedListDeque(){
        sentinel=new Node();
        sentinel.next=sentinel.prev=sentinel;
        count=0;
    }

    public LinkedListDeque(T Item){
        sentinel=new Node();
        addFirst(Item);
    }

    public void addFirst(T Item){
        Node N=new Node(Item);
        N.next=sentinel.next;
        N.prev=sentinel;
        sentinel.next.prev=sentinel.next=N;
        count++;
    }

    public void addLast(T Item){
        Node N=new Node(Item);
        N.next=sentinel.prev;
        N.prev=sentinel;
        sentinel.prev.next=sentinel.prev=N;
        count++;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public T removeFirst(){
        if(isEmpty())
            return null;

        T value=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        count--;
        return value;
    }

    public T removeLast(){
        if(isEmpty())
            return null;

        T value=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        count--;
        return value;
    }

    public void printDeque(){
        if(isEmpty())
            return;

        Node P=sentinel.next;
        while(P!=sentinel){
            System.out.println(P.item+" ");
            P=P.next;
        }
    }

    public int size(){
        return count;
    }

    public T get(int Index){
        if((index<0)||(Index>count-1))
            return null;

        Node P=sentinel.next;
        for(int i=0;i<Index;i++){
            P=P.next;
        }
        return P.item;
    }

    public T getRecursive(int Index){
        if((Index<0)||(Index>count-1))
            return null;

        return get_Recursion(1,end,sentinel.next);
    }

    private T get_Recursion(int index ,int end,Node N){
        if(index==end)
            return N.item;
        return get_Recursion(index+1,end,N.next);

    }



}