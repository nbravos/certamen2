package cl.telematica.android.certamen2;

/**
 * Created by Naty on 06-10-2016.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {
    //private List<Libro> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextID;
        public TextView mTextJoke;

        public ViewHolder(View v) {
            super(v);
            mTextID = (TextView) v.findViewById(R.id.text_ID);
            mTextJoke = (TextView) v.findViewById(R.id.text_joke2);
        }
    }

   // public UIAdapter(List<Libro> myDataset) {
     //   mDataset = myDataset;
    //}

    @Override
    public UIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // Libro libro = mDataset.get(position);

        holder.mTextID.setText(RecyclerView.Adapter.);
        holder.mGeneroView.setText(libro.getGenero());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}