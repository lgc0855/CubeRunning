package db;

/**
 * Created by liguochao on 2016/5/25.
 */
public class PersonMessage {
    private String name ;
    private String value ;

    public PersonMessage(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValues(String value) {
        this.value = value;
    }
}
