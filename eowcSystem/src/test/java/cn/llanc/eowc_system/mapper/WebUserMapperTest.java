package cn.llanc.eowc_system.mapper;

import cn.llanc.eowc_system.common.MD5Utils;
import cn.llanc.eowc_system.domain.WebUser;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @author liulc
 * @ClassName WebUserMapperTest
 * @Description TODO
 * @date 2019/05/16
 **/
public class WebUserMapperTest {
    private static WebUserMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(WebUserMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/WebUserMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(WebUserMapper.class, builder.openSession(true));
    }

    @Test
    public void testinsert() throws FileNotFoundException {
        WebUser addUser = new WebUser();
        addUser.setUName("Langel");
        addUser.setUPassword(MD5Utils.generate("123"));
        addUser.setURole(1);
        mapper.insert(addUser);
    }

    @Test
    public void testfindUPasswordByUName() throws FileNotFoundException {
        String md5Pwd = mapper.findUPasswordByUName("测试").get(0);
        boolean verify = MD5Utils.verify("123",md5Pwd);
        System.out.println(verify);
    }
}
