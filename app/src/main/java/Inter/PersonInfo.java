package Inter;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
public class PersonInfo {
    private String attribute;
    private String value;

    public PersonInfo(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
    }
}
