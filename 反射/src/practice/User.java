package practice;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class User {
    public  int userId=1;
    String userName;

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args)   {
        User u = new User(2);
        u.setUserName("张");
        System.out.println(getFieldValueByName("userId",u));
        System.out.println(getFieldValueByName("userName",u));
        set("userId", 2,u);
        set("userName", "asd",u);
        System.out.println(u+"-------------------");//User{userId='001', userName='xiaoming'}
        System.out.println(u+"-------------------");

    }

    /**
     * @desc 根据字符串来给对应的属性赋值
     * @param
     * @param o
     * @return
     */
    public static void set(String field, Object keyWord,Object o) {
        try {
            Field f = o.getClass().getDeclaredField(field);
            f.setAccessible(true);
            f.set(o, keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @desc 根据属性名获取属性值
     * @param fieldName
     * @param o
     * @return
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        User u=new User(45);
        u.setUserName("李四");
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(u, new Object[] {});

            Field field=o.getClass().getDeclaredField(fieldName);
            Object value1=field.get(u);

            System.out.println(value.equals(value1)? "两个方法作用一样,value="+value+"value1="+value1
                                :"方法作用不一样value="+value+"value1="+value1);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public String toString() {
        return "User{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' + '}';
    }

}