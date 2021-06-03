package base;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Console;

import java.io.IOException;
import java.util.Properties;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/3 14:02
 * 初始化配置
 **/
public class TestBase {

    public static Properties prop;

    public static void init() {
        prop = new Properties();
        ClassPathResource resource = new ClassPathResource("app.properties");
        try {
            prop.load(resource.getStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Console.log("Properties: {}", prop);
    }


}
