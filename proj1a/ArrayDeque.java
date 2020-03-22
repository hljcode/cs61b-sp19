/** ArrayDeque
 *1.the nextFirst always points to the position the new element will be put in
 *2.the nextLast  always points to the position the last element will be put in
 *3 the size always equals the number of elements in the array
 */
public class ArrayDeque<Item>{
    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] item;

    private int minusOne(int index){
        int i=index-1;
        if(i<0)
            i=item.length-1;
        return i;
    }

    private int plusOne(int index){
        int i=index+1;
        if(i==item.length)
            i=0;
        return i;
    }

    public boolean isEmpty(){
        if(size==0)
            return true;
        return false;
    }

    public void addFirst(Item X){
        if(size==item.length)
            resize(2*item.length);
        item[nextFirst]=X;
        nextFirst=minusOne(nextFirst);
        size=size+1;
    }

    public void addLast(Item X){
        if(size==item.length)
            resize(2*item.length);
        item[nextLast]=X;
        nextLast=plusOne(nextLast);
        size=size+1;
    }

    public void printDeque(){
        int i=0;
        int firstPos=plusOne(nextFirst);
        while(i<size){
            System.out.print(item[firstPos]+" ");
            firstPos=plusOne(firstPos);
            i=i+1;
        }
        System.out.println();
    }

  public Item get(int index){
        if(index>size)
            return null;
        int ptr=plusOne(nextFirst);
        for(int i=0;i<index;i=i+1){
            ptr=plusOne(ptr);
        }
        return item[ptr];
    }

    public Item get_lefthanded(int index){
        if(index>size)
            return null;
        int ptr=minusOne(nextLast);
        for(int i=0;i<index;i++){
            ptr=minusOne(ptr);
        }
        return item[ptr];
    }

    public Item removeFirst(){
        if(isEmpty())
            return null;
        if(((float)size/item.length<0.25)&&(item.length>=16))
            resize(item.length/2);
        int fP=plusOne(nextFirst);
        Item first=item[fP];
        item[fP]=null;
        nextFirst=fP;
        size=size-1;
        return first;
    }

    public Item removeLast(){
        if(isEmpty())
            return null;
        if(((float)size/item.length<0.25)&&item.length>=16)
            resize(item.length/2);
        int lP=minusOne(nextLast);
        Item last=item[lP];
        item[lP]=null;
        nextLast=lP;
        size=size-1;
        return last;
    }

    public int length(){
        return item.length;
    }
    public void resize(int capacity){
        Item[] newItem=(Item[]) new Object[capacity];
        int beginning=plusOne(nextFirst);
        int end=minusOne(nextLast);
        if(beginning>end){
            int sizeOfFirstHalf=item.length-beginning;
            int sizeOfSecondHalf=size-sizeOfFirstHalf;
            System.arraycopy(item,beginning,newItem,0,sizeOfFirstHalf);
            System.arraycopy(item,0,newItem,sizeOfFirstHalf,sizeOfSecondHalf);
        }
        else{
            System.arraycopy(item,beginning,newItem,0,size);
        }
        nextFirst=newItem.length-1;
        nextLast=size;
        item=newItem;
    }

    public int size(){
        return size;
    }


    private int pos(int index){
        int beginning=plusOne(nextFirst);
        int actualPos=(index+beginning)%(item.length);
        return actualPos;
    }

 /* public Item get(int index){
        if(index<size)
            return item[pos(index)];
        return null;
    }
*/
    public ArrayDeque(){
        size=0;
        nextFirst=0;
        nextLast=1;
        item=(Item[])new Object[8];
    }

    public ArrayDeque(Item X){
        item=(Item[])new Object[8];
        item[0]=X;
        size=1;
        nextFirst=7;
        nextLast=1;
    }
}