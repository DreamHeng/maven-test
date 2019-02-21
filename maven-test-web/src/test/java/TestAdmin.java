import com.dreamheng.dao.AdminDao;
import com.dreamheng.entity.Admin;
import com.dreamheng.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class TestAdmin {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminDao adminDao;
    @Test
    public void testservice(){
        List<Admin> list = adminDao.selectAll();
        System.out.println(list);
    }
}
