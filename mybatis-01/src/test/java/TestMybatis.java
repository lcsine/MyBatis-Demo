import com.ydlclass.entity.User;
import com.ydlclass.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class TestMybatis {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectAll();
            System.out.println(users);
        }
    }

    @Test
    public void testFindById() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User users = mapper.selectOne(1);
            log.debug(" " + users);
        }
    }

    @Test
    public void testFindByPdAndU() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User users = mapper.select("itnanls", "123456");
            log.debug(" " + users);
        }

    }

    @Test
    public void testFindByMap() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>(2);
            map.put("username", "itnanls");
            map.put("password", "123456");

            User users = mapper.selectMap(map);
            log.debug(" " + users);
        }
    }

    @Test
    public void testFindLike() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectLike("%i%");
            log.debug(" " + users);
        }
    }

    @Test
    public void testInsert() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);
                mapper.insert(new User(4, "tangyubin", "123"));
                session.commit();
            } catch (Exception e) {
                log.error("err!" + e);
                session.rollback();
            }
        }
    }

    @Test
    public void testUpdate() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);
                int result = mapper.update("唐宇彬", "345", 4);
                log.debug("result" + result);

            } catch (Exception e) {
                log.error("err!" + e);
                session.rollback();
            }
        }
    }

    @Test
    public void testDelete() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);
                int result = mapper.delete(4);
                log.debug("result" + result);

            } catch (Exception e) {
                log.error("err!" + e);
                session.rollback();
            }
        }
    }
    @Test
    public void testSQL() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);
                List<User> result = mapper.selectSql(1,"itnanls","123456");
                log.debug("result" + result);
            } catch (Exception e) {
                log.error("err!" + e);
            }
        }
    }
    @Test
    public void testUpdateSQL() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);
                int result = mapper.setSql(4,"itnanls",null);
                log.debug("result" + result);
            } catch (Exception e) {
                log.error("err!" + e);
            }
        }
    }
    @Test
    public void testDelSQL() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);


                List<Integer> ids = List.of(7,8,9,10,11,12,13);
                int result = mapper.delByIds(ids);
                log.debug("result" + result);
            } catch (Exception e) {
                log.error("err!" + e);
            }
        }
    }
    @Test
    public void testInsertSQL() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);

                int result = mapper.insertSql(List.of(new User(null,"zxp","123"),new User(null,"lxy","456")));
                log.debug("result" + result);
            } catch (Exception e) {
                log.error("err!" + e);
            }
        }
    }

}
