package io.github.zhangdihong.server.model;

/**
 * <p>Project: io.github.zhangdihong.server.model</p>
 * <p>Title: User.java</p>
 * <p/>
 * <p>Description: User </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/19
 */
public class User {
    private String id;
    private String name;
    private String sex;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
