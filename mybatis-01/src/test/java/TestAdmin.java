import com.ydlclass.entity.Admin;
import com.ydlclass.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class TestAdmin {
    @Test
    public void testfindAdminById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdminMapper mapper = session.getMapper(AdminMapper.class);
            Admin admin = mapper.findAdminById(1);
            log.debug("admin[{}]"+admin);

        }
    }
    @Test
    public void testSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdminMapper mapper = session.getMapper(AdminMapper.class);
            int admin = mapper.saveAdmin(new Admin(3,"张熙鹏","345"));
            session.commit();
            log.debug("admin[{}]"+admin);

        }
    }
}
