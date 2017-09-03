package my.devs.apps.testing.testmultiplerecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HarisHashim on 9/3/2017.
 * <myName>@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        List<ContentItem> input = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            ContentItem item = new ContentItem("Name" + i, "The best description " +i);

            List<ContentVariant> variants = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                ContentVariant variant = new ContentVariant("VariantName" + i + "-" + j, "variantdescription " + i + "-"  + j);
                variants.add(variant);
            }

            item.setVariants(variants);

            input.add(item);
        }

        // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }
}
