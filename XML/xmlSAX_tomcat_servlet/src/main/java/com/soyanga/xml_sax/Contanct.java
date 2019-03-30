package com.soyanga.xml_sax;

/**
 * @program: xmlSAX_tomcat_servlet
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-30 10:09
 * @Version 1.0
 */
public class Contanct {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contanct{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
