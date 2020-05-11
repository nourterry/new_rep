package com.example.notes.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.CategoryName;
import com.example.notes.MainActivity;
import com.example.notes.Profile;
import com.example.notes.R;
import com.example.notes.models.MultiView;

import java.util.ArrayList;

public class MultiViewAdapter extends RecyclerView.Adapter{
    private ArrayList<MultiView> dataSet;
    Context mContext;
    int total_types;

    public MultiViewAdapter(ArrayList<MultiView> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType%2) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settting_cell_left, parent, false);
                return new viewLeftVH(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_cell_right, parent, false);
                return new viewRightVH(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       if(dataSet.get(position).getType()==0){
           ((viewLeftVH) holder).name.setText(dataSet.get(position).getName());
         ((viewLeftVH) holder).description.setText(dataSet.get(position).getDescription());
         ((viewLeftVH) holder).imageView.setImageResource(dataSet.get(position).getImage());}
         else{
            ((viewRightVH) holder).name.setText(dataSet.get(position).getName());
            ((viewRightVH) holder).description.setText(dataSet.get(position).getDescription());
            ((viewRightVH) holder).imageView.setImageResource(dataSet.get(position).getImage());
        }
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(position==1){
                     Intent intent=new Intent(mContext, Profile.class);
                     mContext.startActivity(intent);
                 }
                 if(position==4){
                     AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
// Add the buttons
                     builder.setIcon(R.drawable.ic_app_icon);
                     builder.setMessage("Are you sure to Leave");
                     builder.setTitle("Notes App");
                     builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int id) {
                             // User clicked OK button
                             Intent intent=new Intent(mContext, MainActivity.class);
                             mContext.startActivity(intent);
                         }
                     });
                     builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int id) {
                             // User cancelled the dialog
                         }
                     });
// Set other dialog properties


// Create the AlertDialog
                     AlertDialog dialog = builder.create();
                     dialog.show();

                 }
             }
         });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    @Override
  public int   getItemViewType(int position){

                return dataSet.get(position).getType();
        }


    class viewLeftVH extends RecyclerView.ViewHolder{
     public    TextView name,description;
     public    ImageView imageView;
        public viewLeftVH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_left);
            description=itemView.findViewById(R.id.description_left);
            imageView=itemView.findViewById(R.id.image_left);
        }
    }
    class viewRightVH extends RecyclerView.ViewHolder{
        TextView name,description;
        ImageView imageView;
        public viewRightVH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_right);
            description=itemView.findViewById(R.id.description_right);
            imageView=itemView.findViewById(R.id.image_right);
        }
    }
}
