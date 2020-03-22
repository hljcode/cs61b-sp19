import java.util.LinkedList;

/*public class LinkedListDeque<T>{
    public class IntNode{
        T item;
        IntNode prev,next;

        public IntNode(){
            prev=next=null;
        }

        public IntNode(T X){
            item=X;
            prev=next=null;
        }

        public T getRecursive(int index){
            if(index==0)
                return this.item;
            return this.next.getRecursive(index-1);
        }
    }

    public int count;
    IntNode sentinel;

    public LinkedListDeque(){
        count=0;
        sentinel=new IntNode();
        sentinel.prev=sentinel.next=sentinel;
    }

    void addFirst(T X){
        IntNode P=new IntNode(X);
        P.next=sentinel.next;
        P.prev=sentinel;
        sentinel.next.prev=sentinel.next=P;
        count++;
    }

    void addLast(T X){
        IntNode P=new IntNode(X);
        P.next=sentinel;
        P.prev=sentinel.prev;
        sentinel.prev=sentinel.prev.next=P;
        count++;
    }

     boolean isEmpty(){
        if(count==0)
            return true;
        else
            return false;
    }

    int size(){
        return count;
    }

    void printDeque(){
        if(isEmpty())
            return ;
        IntNode P=sentinel.next;
        for(int i=0;i<count;i++){
            System.out.print(P.item+" ");
            P=P.next;
        }
        System.out.println();
        return ;
    }

    T removeFirst(){
        if(isEmpty())
            return null;
        T value=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        count--;
        return value;
    }

    T removeLast(){
        if(isEmpty())
                return null;
        T value=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        count--;
        return value;
    }23456789

    public T get(int index){
        if(index>=count)
            return null;
        IntNode P=sentinel.next;
        for(int i=0;i<index;i++)
            P=P.next;
        return P.item;
    }

    public T getRecursive(int index){
        if(index>=count)
            return null;
        return sentinel.next.getRecursive(index-1);
    }

    /*public static void main(String[] args){
        LinkedListDeque<Integer> T=new LinkedListDeque<>(65);
        T.addFirst(20);
        T.addFirst(40);
        T.addFirst(60);
        T.addLast(80);
        T.printDeque();
        System.out.println("First Value: "+T.removeFirst());
        T.printDeque();
        System.out.println("Last Value: "+T.removeLast());
        T.printDeque();
        System.out.println("numbers: "+T.size());
        System.out.println("T[2]: " +T.get(2));
        return ;
          }*/

public class LinkedListDeque<AnyType>{
      public class Node{
          public AnyType item;
          public Node prev;
          public Node next;

          public Node(AnyType i,Node p,Node n){
               item=i;
               prev=p;
               next=n;
          }

          public AnyType get(int index){
              if(index==0)
                 return this.item;
             return this.get(index-1);
          }
      }

      private Node sentinel;
      private int size;

      /**Creates an empty Deque .*/
      public LinkedListDeque(){
          sentinel=new Node(null,null,null);
          sentinel.prev=sentinel;
          sentinel.next=sentinel;
          size=0;
      }

      /** Creates an Deque. */
      public LinkedListDeque(AnyType item){
          sentinel=new Node(null,null,null);
          Node newNode=new Node(item,sentinel,sentinel);
          sentinel.prev=newNode;
          sentinel.next=newNode;
          size=1;
      }

      /** Adds an item to the front of the Deque. */
      public void addFirst(AnyType item){
         Node first=new Node(item,sentinel,sentinel.next);
         sentinel.next.prev=first;
         sentinel.next=first;
         size=size+1;
      }

      public void addLast(AnyType item){
          Node last=new Node(item,sentinel.prev,sentinel);
          sentinel.prev.next=last;
          sentinel.prev=last;
          size=size+1;
      }

      public boolean isEmpty(){
          if(size==0)
             return true;
          return false;
      }

      public int size(){
          return size;
      }

 /** Print the items in the deque from first to last,separated by a space. */
    public void printDeque_righthanded(){
       Node n=sentinel.next;
       while(n!=sentinel){
           System.out.print(n.item+" ");
           n=n.next;
       }
       System.out.println();
    }

  /** Print the items in the deque from last to first,separated by a space. */
     public void printDeque_lefthanded(){
         Node p=sentinel.prev;
         while(p!=sentinel){
             System.out.print(p.item+" ");
             p=p.prev;
         }
         System.out.println();
     }
    /** Removes and returns the item at the front of the deque ,if no such item exists,return null.*/
    public AnyType removeFirst(){
        if(isEmpty())
           return null;
        AnyType first=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size=size-1;
        return first;
    }

    /** Removes and returns the item at the back of the deque.if no such items exitst,return null.*/
    public AnyType removeLast(){
        if(isEmpty())
            return null;
        AnyType last=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size=size-1;
        return last;
    }

    /** Gets the item at the given index,where 0 is the front,1 is the next item,and so forth.if no such item exitst,returns null. */
    public AnyType get(int index){
        if(index>size-1){
            return null;
        }
        int i=0;
        Node p=sentinel.next;
        while(i<index){
           p=p.next;
           i++;
        }
        return p.item;
    }

    /** Same as get,but uese recursive. */
    public AnyType getRecursive(int index){
        if(isEmpty())
           return null;
        return getHelper(sentinel.next,index);
    }

    private AnyType getHelper(Node n,int index){
        if(index==0)
            return n.item;
        return getHelper(n.next,index-1);
    }
}