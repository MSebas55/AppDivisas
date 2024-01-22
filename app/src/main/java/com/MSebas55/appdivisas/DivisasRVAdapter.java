package com.MSebas55.appdivisas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DivisasRVAdapter extends RecyclerView.Adapter<DivisasRVAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<divisasEventModel> divisasEventModel;
    private int seleccionador = RecyclerView.NO_POSITION;

    public DivisasRVAdapter(Context context, ArrayList<divisasEventModel> divisasEventModel) {
        this.context = context;
        this.divisasEventModel = divisasEventModel;
    }

    @NonNull
    @Override
    public DivisasRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return new DivisasRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DivisasRVAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(divisasEventModel.get(position).getDivisaName());
        holder.tvPrecio.setText(divisasEventModel.get(position).getDivisaPrecio());

        // Glide para los iconos :/
        Glide.with(context)
                .load(divisasEventModel.get(position).getDivisaIcono())
                .into(holder.ivIcon);

        // Cambiar color de fondo
        if (position == seleccionador) {
            holder.itemView.setBackgroundColor(Color.parseColor("#006400"));
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return divisasEventModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvPrecio;
        ImageView ivIcon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvEventName);
            tvPrecio = itemView.findViewById(R.id.tvEventPrecio);
            ivIcon = itemView.findViewById(R.id.eventImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            int previouslySelectedItemPosition = seleccionador;
            seleccionador = adapterPosition;
            if (previouslySelectedItemPosition != RecyclerView.NO_POSITION) {
                notifyItemChanged(previouslySelectedItemPosition);
            }
            notifyItemChanged(seleccionador);
        }
    }

    // Obtener la posición del elemento seleccionado
    public int getSelectedItemPosition() {
        return seleccionador;
    }
}
