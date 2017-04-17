package com.springcachetest.bean;

/**
 * @author 杨志远[of2551]
 *         company qianmi.com
 *         Date    2017-03-23
 */

//@ToString
/*@Builder
@Data*/
public class ParamBean {
    private Integer id;
    private String name;
    private int num;

    @Override
    public String toString() {
        return "ParamBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


   /* @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + num;
        return result;
    }*/
}
