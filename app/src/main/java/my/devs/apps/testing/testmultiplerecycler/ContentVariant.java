package my.devs.apps.testing.testmultiplerecycler;

/**
 * Created by HarisHashim on 9/3/2017.
 * <myName>@gmail.com
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
