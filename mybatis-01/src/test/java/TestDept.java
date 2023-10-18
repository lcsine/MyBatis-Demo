import com.ydlclass.entity.Dept;
import com.ydlclass.mapper.DeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Slf4j
public class TestDept {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void be() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    @Test
    public void SelectMore() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            List<Dept> select = mapper.selectAll(null);
            for (Dept dept :
                    select) {
                log.debug(String.valueOf(dept.getId()));
            }
        }
    }
}

