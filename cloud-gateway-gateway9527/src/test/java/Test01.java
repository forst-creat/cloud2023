import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * ClassName: Test01
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/11 - 8:09
 */
public class Test01 {
    @Test
    void test01() {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
