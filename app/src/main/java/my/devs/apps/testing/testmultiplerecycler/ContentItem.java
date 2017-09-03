package my.devs.apps.testing.testmultiplerecycler;

import java.util.List;

/**
 * Created by HarisHashim on 9/3/2017.
 * <myName>@gmail.com
 */

public class ContentItem {
    private String name;

    private String description;

    private List<ContentVariant> variants;

    public ContentItem(String name, String description){
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

    public List<ContentVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<ContentVariant> variants) {
        this.variants = variants;
    }
}
