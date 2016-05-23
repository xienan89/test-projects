import org.junit.Test;

/**
 * Created by Administrator on 2015/10/15.
 */
public class FloatTest {
    @Test
    public void test(){
        StringBuffer sb = new StringBuffer(32);
        for (int i = 808; i < 833; i+=2) {
            sb.append(i).append(",");
        }
        System.out.println(sb.toString());
    }
}
