package my.devs.apps.testing.testmultiplerecycler;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HarisHashim on 9/3/2017.
 * <myName>@gmail.com
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtHeader;
        public TextView txtFooter;

        private RecyclerView variantRecyclerView;

        public View view;

        public ViewHolder(View v) {
            super(v);
            this.view = v;
            txtName = (TextView) v.findViewById(R.id.text_name);
            txtHeader = (TextView) v.findViewById(R.id.first_line);
            txtFooter = (TextView) v.findViewById(R.id.second_line);
            variantRecyclerView = (RecyclerView) v.findViewById(R.id.variant_recycler_view);
        }
    }

    private List<ContentItem> values;
    private RecyclerView.Adapter variantAdapter;
    private RecyclerView.LayoutManager variantLayoutManager;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<ContentItem> myDataset) {
        values = myDataset;
    }

    public void add(int position, ContentItem item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Create new views (invoked by the view manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and view parameters
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the view manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ContentItem content = values.get(position);
        holder.txtName.setText(content.getName());
        holder.txtHeader.setText(content.getDescription());
        holder.txtFooter.setText("Footer text is here!");

//        holder.setIsRecyclable(false);

        variantLayoutManager = new LinearLayoutManager(holder.view.getContext());
        holder.variantRecyclerView.setLayoutManager(variantLayoutManager);
        variantAdapter = new VariantAdapter(content.getVariants());
        holder.variantRecyclerView.setAdapter(variantAdapter);
    }


    // Return the size of your dataset (invoked by the view manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}

