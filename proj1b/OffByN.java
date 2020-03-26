/**
 * Created by Brody on 2020.3.25
 */
public class OffByN implements CharacterComparator{
    static int N;
    public OffByN(int N){
        this.N=N;
    }
    @Override
    public boolean equalChars(char x,char y){
        if((x-y==N)||(y-x==N))
            return true;
        return false;
    }
}
