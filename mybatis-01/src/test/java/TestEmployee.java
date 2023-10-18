import com.ydlclass.entity.Employee;
import com.ydlclass.mapper.EmployeeMapper;
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
public class TestEmployee {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void be() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void Select() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> select = mapper.select(new Employee());
            for (Employee e : select) {
//                Integer dId = e.getDId();
//                Dept dept = DeptMapper.selectById(dId);
//                e.setDept(dept);
            }
        }
    }
    @Test
    public void SelectMore() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> select = mapper.selectMore();
            log.debug("result"+select);
            }
        }
    }


