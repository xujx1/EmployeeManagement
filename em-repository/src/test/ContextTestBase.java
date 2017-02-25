import com.architecture.em.config.RootConfig;
import com.architecture.em.dao.UserDao;
import com.architecture.em.entity.User;
import com.github.pagehelper.PageHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ContextTestBase {

    @Inject
    private UserDao userDao;

    @Before
    public void before(){
        System.out.println("=====================================");
    }

    @After
    public void after(){
        System.out.println("=====================================");
    }

    @Test
    public void test(){

        PageHelper.startPage(1,1);
        User user=new User();
        user.setUserName("ceshi");

        userDao.select(user).stream().forEach(System.out::println);
    }
}
