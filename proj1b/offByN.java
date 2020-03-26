/**
 * Created by Brody on 2020.3.25
 */
public class offByN implements CharacterComparator{
    static int N;
    public offByN(int N){
        this.N=N;
    }

    public boolean equalChars(char x,char y){
        if((x-y==N)||(y-x==N))
            return true;
        return false;
    }
}
