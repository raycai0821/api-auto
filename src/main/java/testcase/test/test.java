package testcase.test;
import common.utils.RequestUtil;
import org.testng.annotations.Test;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/3 14:44
 **/
public class test {

    @Test
    public void test(){
        RequestUtil.requestSwagger();
    }
}
