import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFindPatternInNumber {
    FindPatternInNumber pattern;

    @BeforeEach
    public void setUp(){
        pattern = new FindPatternInNumber();
        pattern.base = 22707;
        pattern.target=666;
    }

    @Test
    public void findMatches(){

        String base = pattern.target.toString();
        String target = pattern.base.toString();

        System.out.println(base);
        System.out.println(target);

        pattern.findMathes(Integer.valueOf(target), Integer.valueOf(base));
        pattern.showResults();

        Assertions.assertNotEquals(target,base);

    }


    @Test
    void test(){
        String tNumber = "0123456";
        int index = 2;

        String subStr = tNumber.substring(index, index + 3);
        Assertions.assertEquals("234", subStr);




        String base = "012345678";
        String target = "6789";
        int indx = base.indexOf("6");
        boolean ans = false;

        System.out.println("base.length() = " + base.length());
        System.out.println("indx = "+ indx);
        System.out.println("base.length() - indx = " + (base.length() - indx));
        System.out.println("target.length() = " + target.length());


        if( (base.length() - indx) <= target.length() &&
            (indx + target.length()) <= base.length() &&
            target.equals( base.substring(index, index + target.length())) ){
            ans = true;
        }

        Assertions.assertFalse(ans);
    }

}
