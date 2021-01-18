package ca.cegepgim.gosafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.cegepgim.gosafe.R;

public class TotalCasesAdapter extends RecyclerView.Adapter<TotalCasesAdapter.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;

    public TotalCasesAdapter(Context context) {
        super();
        this.context = context;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_service, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
