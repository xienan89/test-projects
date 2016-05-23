import org.junit.Test;

/**
 * Created by Administrator on 2015/12/23.
 */
public class PackageUnPackageTest {

    @Test
    public void assignment(){
        int a = 1;
        Integer b = a;
        Integer c = 1;
        int d = c;
        int e = a + b;
        Integer f = c + d;

        System.out.println(e);
        System.out.println(f);
    }

    @Test
    public void test(){
        Integer a = 129;
        Integer b = 129;
        Integer c = 258;
        int d = 258;

        System.out.println(a == b);
        System.out.println(c == (a+b));
        System.out.println(c == d);
    }

    @Test
    public void compare(){
        Integer a = 129;
        Integer b = 129;
        int c = 129;
        Integer e = 127;
        Integer f = 127;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println(e == f);
    }
}
