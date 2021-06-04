package testcase.test;

import base.TestBase;
import common.utils.JsonParseUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/3 14:44
 **/
public class test extends TestBase {

    @BeforeTest
    public void setUp(){
        init();
    }

    @Test
    public void test(){
        JsonParseUtils.getDefData("required", "CollectionAccountApiReq");
        System.out.println("22");
    }
}
