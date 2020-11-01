public class ArrayDeque<T>{
    int count;
    int nextFirst,nextLast;
    T[] AD;

    public class ArrayDeque(){
        count=0;
        nextFirst=7;
        nextLast=0;
        AD=(T[]) new Object[8];
    }

    public class ArrayDeque(T[] source){
        T[] target=(T[]) new Object[source.length];
        System.arraycopy(source,0,target,0,source.length);
        count=0;
        nextFirst=target.length-1;
        nextLast=0;
        AD=target;
    }

    private int minusOne(int Index){
        return (Index-1+AD.length)%AD.length;
    }

    private int plusOne(int Index){
        return (Index+1)%AD.length;
    }

    public void resize(int Capacity){
        T[] target=(T[]) new Object[Capacity];
        int begin,end;
        begin=plusOne(nextFirst);
        end=minusOne(nextLast);

        if(begin>end){
            int back_num=AD.length-begin;
            int front_num=end;
            System.arraycopy(target,0,AD,0,back_num);
            System.arraycopy(target,back_num,AD,0,end);
        }else
        {
            System.arraycopy(target,0,AD,begin,end-begin+1);
        }
        count=end-begin+1;
        nextFirst=Capacity-1;
        nextLast=count;
        AD=target;

    }

    public void addFirst(T Item){
        if(count==AD.length)
            resize(AD.length*2);
        AD[nextFirst]=Item;
        nextFirst=minusOne(nextFirst);
        count++;
    }

    public void addLast(T Item){
        if(count==AD.length)
            resize(AD.length*2);
        AD[nextLast]=Item;
        nextLast=plusOne(nextLast);
        count++;
    }

    public T removeFirst(){
        if(isEmpty())
            return null;
        if(nearEmpty())
            resize(AD.length/2);
        T value;
        int begin=plusOne(nextFirst);
        value=AD[begin];
        nextFirst=begin;
        count--;
        return value;
    }

    public T removeLast(){
        if(isEmpty())
            return null;
        if(nearEmpty())
            resize(AD.length/2);
        T value;
        int end=minusOne(nextLast);
        value=AD[end];
        nextLast=end;
        count--;
        return value;
    }

    public void printDeque(){
        if(isEmpty())
            return;
        int begin,end;
        begin=plusOne(nextFirst);
        end=minusOne(nextLast);

        if(begin>end){
            for(int i=begin;i<AD.length;i++)
                System.out.println(AD[i]+" ");
            for(int i=0;i<=end;i++)
                System.out.println(AD[i]+" ");
        }else
        {
            for(int i=begin;i<=end;i++)
                System.out.println(AD[i]+" ");
        }
    }

    public T get(int Index){
        if((Index<0)||(Index>AD.length-1))
            return null;
        int begin,realIndex;
        begin=plusOne(nextFirst);
        realIndex=(begin+Index)%AD.length;
        return AD[realIndex];
    }

    public boolean isEmpty(){
        return count==0;
    }

    public int size(){
        return count;
    }
    private boolean nearEmpty(){
        return (count>=16)&&(count*1.0/AD.length<0.25);
    }
}