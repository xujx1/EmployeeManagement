import com.architecture.em.config.RootConfig;
import com.architecture.em.dao.UserDao;
import com.architecture.em.entity.User;
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

    @Test
    public void test(){
        User user=new User();
        user.setUserName("ceshi");
        userDao.count(user);
        userDao.insert(user);
    }

}
