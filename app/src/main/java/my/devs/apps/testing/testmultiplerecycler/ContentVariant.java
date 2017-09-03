package my.devs.apps.testing.testmultiplerecycler;

/**
 * Created by harishashim on 9/2/2017.
 */

public class ContentVariant {
    private String name;

    private String description;

    public ContentVariant(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
