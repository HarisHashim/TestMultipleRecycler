package my.devs.apps.testing.testmultiplerecycler;

/**
 * Created by HarisHashim on 9/3/2017.
 * <myName>@gmail.com
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by harishashim on 9/2/2017.
 */

public class VariantAdapter extends RecyclerView.Adapter<VariantAdapter.ViewHolder> {
    List<ContentVariant> variants;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public View view;
        public TextView textVariantName;
        public TextView textVariantDescription;

        public TextView variantDelete;
        public TextView variantPlus;
        public TextView variantMinus;

        private ContentVariant variant;

        public IVariantViewHolderClicks mListener;


        public ViewHolder(View v, IVariantViewHolderClicks listener) {
            super(v);

            this.mListener = listener;

            this.view = v;
            textVariantName = (TextView) v.findViewById(R.id.text_variant_name);
            textVariantDescription = (TextView) v.findViewById(R.id.text_variant_description);

            variantDelete = (TextView) v.findViewById(R.id.variant_delete);
            variantDelete.setOnClickListener(this);

            variantPlus = (TextView) v.findViewById(R.id.variant_plus);
            variantPlus.setOnClickListener(this);

            variantMinus = (TextView) v.findViewById(R.id.variant_minus);
            variantMinus.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Log.d(this.getClass().getSimpleName(), "view id" + v.getId() + " del:" + R.id.variant_delete +
//                    " plus:" + R.id.variant_plus + " minus:" + R.id.variant_minus);

            switch (v.getId()){
                case R.id.variant_delete:
                    mListener.onDelete(view, variant);
                    break;

                case R.id.variant_plus:
                    mListener.onIncrease(view, variant);
                    break;

                case R.id.variant_minus:
                    mListener.onDecrease(view, variant);
                    break;
            }
        }

        public ContentVariant getVariant() {
            return variant;
        }

        public void setVariant(ContentVariant variant) {
            this.variant = variant;
        }

        public static interface IVariantViewHolderClicks {
            void onDelete(View caller, ContentVariant variant);

            void onIncrease(View caller, ContentVariant variant);

            void onDecrease(View caller, ContentVariant variant);
        }
    }

    public VariantAdapter(List<ContentVariant> variants) {
        this.variants = variants;
    }

    @Override
    public VariantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.variant_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(v, variantViewHolderClicks);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VariantAdapter.ViewHolder holder, int position) {

        final ContentVariant variant = variants.get(position);
        holder.textVariantName.setText(variant.getName());
        holder.textVariantDescription.setText((variant.getDescription()));
        holder.setVariant(variant);
        //holder.setIsRecyclable(false);
    }

    private VariantAdapter.ViewHolder.IVariantViewHolderClicks variantViewHolderClicks =
            new VariantAdapter.ViewHolder.IVariantViewHolderClicks() {
                @Override
                public void onDelete(View caller, ContentVariant variant) {
                    Toast.makeText(caller.getContext(),
                            "Variant " + variant.getName() + " delete clicked!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onIncrease(View caller, ContentVariant variant) {
                    Toast.makeText(caller.getContext(),
                            "Variant " + variant.getName() + " increase clicked!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onDecrease(View caller, ContentVariant variant) {
                    Toast.makeText(caller.getContext(),
                            "Variant " + variant.getName() + " decrease clicked!", Toast.LENGTH_SHORT).show();
                }
            };

    public void add(int position, ContentVariant variant) {
        variants.add(position, variant);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        variants.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return variants.size();
    }

}
