package com.example.menguita_multicalc.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menguita_multicalc.Model.FormIcon;
import com.example.menguita_multicalc.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<FormIcon> formula;
    private final LayoutInflater inflater;
    private final RecyclerViewClickListener listener;

    public RecyclerViewAdapter(Context context, List<FormIcon> formula, RecyclerViewClickListener listener) {
        this.formula = formula;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_formula,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.text.setText(formula.get(position).getText());
        holder.img.setImageResource(formula.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return formula.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ConstraintLayout layout;
        private final TextView text;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.formula_layout);
            text = itemView.findViewById(R.id.formula_text);
            img = itemView.findViewById(R.id.formula_png);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }
}
