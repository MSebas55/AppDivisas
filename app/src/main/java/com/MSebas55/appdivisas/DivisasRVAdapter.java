package com.MSebas55.appdivisas;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
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
    private int selectedItemPosition = RecyclerView.NO_POSITION; // Posición del elemento seleccionado

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

        // Cargar el icono de la divisa utilizando Glide
        Glide.with(context)
                .load(divisasEventModel.get(position).getDivisaIcon())
                .into(holder.ivIcon);

        // Cambiar el color de fondo si selecciono una divisa
        if (position == selectedItemPosition) {
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

            // Deseleccionar el elemento
            int previouslySelectedItemPosition = selectedItemPosition;
            selectedItemPosition = adapterPosition;
            if (previouslySelectedItemPosition != RecyclerView.NO_POSITION) {
                notifyItemChanged(previouslySelectedItemPosition);
            }
            notifyItemChanged(selectedItemPosition);
        }
    }

    // Método para obtener la posición del elemento seleccionado
    public int getSelectedItemPosition() {
        return selectedItemPosition;
    }
}
