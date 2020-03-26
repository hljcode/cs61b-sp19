/**
 * Created by Brody on 2020.3.26
 */
public class offByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char a,char b){
        if((a-b==1)||(b-a==1))
            return true;
        return false;
    }
}
