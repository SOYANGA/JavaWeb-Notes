package Test;

/**
 * @program: dom4j
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-20 20:42
 * @Version 1.0
 */
public class Cantanct {

    private String id;
    private String name;

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

    @Override
    public String toString() {
        return "Cantanct{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
