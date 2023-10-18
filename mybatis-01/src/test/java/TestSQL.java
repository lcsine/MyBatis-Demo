import com.ydlclass.entity.User;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

import java.lang.reflect.Field;

public class TestSQL {
    public void TestSqlDemo() throws IllegalAccessException {
        User user = new User();
        user.setUsername("lucy");
        user.setPassword("123");
        StringBuilder stringBuilder = new StringBuilder("select * from user ");
        Field[] declaredFields = User.class.getDeclaredFields();
        if (declaredFields.length > 1) {
            stringBuilder.append("where ");
        }

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.getName().equals("SerialVersionUID") || declaredField.get(user) == null) {
                continue;
            }

            Object o = declaredField.get(user);
            stringBuilder.append(declaredField.getName()).append("=").append("'").append(declaredField.get(user)).append("'").append(" and ");
        }
        System.out.println(stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length()));
    }
    @Test
    public void TestSQl2(){
        SQL sql = new SQL();
        sql.SELECT("id","user_name","password").FROM("user").WHERE("id=1");
        System.out.println(sql);
    }
}
