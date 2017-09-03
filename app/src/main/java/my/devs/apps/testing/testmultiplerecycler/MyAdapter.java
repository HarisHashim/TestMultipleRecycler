package my.devs.apps.testing.testmultiplerecycler;

/**
 * Created by HarisHashim on 9/3/2017.
 * <myName>@gmail.com
 */

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by harishashim on 9/2/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {
    private List<ContentItem> values;

    private RecyclerView vRecyclerView;
    private RecyclerView.Adapter vAdapter;
    private RecyclerView.LayoutManager vLayoutManager;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtName = (TextView) v.findViewById(R.id.textname);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, ContentItem item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<ContentItem> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        vRecyclerView = (RecyclerView) v.findViewById(R.id.variant_recycler_view);
        vRecyclerView.setHasFixedSize(true);
        vLayoutManager = new LinearLayoutManager(vRecyclerView.getContext());
        vRecyclerView.setLayoutManager(vLayoutManager);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final ContentItem content = values.get(position);
        holder.txtName.setText(content.getName());
        holder.txtHeader.setText(content.getDescription());
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });

        String detail = "";
        for (ContentVariant variant: content.getVariants()) {
            detail += variant.getName() + " (" + variant.getDescription() + ") /n";
        }
        holder.txtFooter.setText(detail);

        //holder.setIsRecyclable(false);

        vAdapter = new VariantAdapter(content.getVariants());
        vRecyclerView.setAdapter(vAdapter);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }
}
