package com.example.notes.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.Categories;
import com.example.notes.CategoryName;
import com.example.notes.R;
import com.example.notes.ShareContent;
import com.example.notes.models.Category;
import com.example.notes.models.User;

import io.realm.Realm;
import io.realm.RealmList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.categoriesVH> {
    Context context;
    Realm realm;
    RealmList<Category> categories;

    public CategoriesAdapter(Context context) {
        this.context = context;
        Realm.init(context);
        realm=Realm.getDefaultInstance();
        User user=realm.where(User.class).equalTo("Firstname", ShareContent.name)
                .equalTo("Passward",ShareContent.passward).findFirst();
        categories=user.getCategories();

    }

    @NonNull
    @Override
    public categoriesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.category_cell,parent,false);

        return new categoriesVH(v);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public void onBindViewHolder(@NonNull categoriesVH holder, final int position) {
     holder.name.setText(categories.get(position).getName());
     holder.description.setText(categories.get(position).getDescription());
     holder.one.setText(categories.get(position).getName().substring(0,1));
     holder.delete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             realm.beginTransaction();
             categories.deleteFromRealm(position);
             realm.commitTransaction();
             notifyDataSetChanged();
         }
     });
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             ShareContent.nameCategory=categories.get(position).getName();
             ShareContent.position=position;
             Intent intent=new Intent(context, CategoryName.class);
             context.startActivity(intent);

         }
     });
    }

    class categoriesVH extends RecyclerView.ViewHolder{
        TextView one,name,description;
        ImageView delete;
        public categoriesVH(@NonNull View itemView) {
            super(itemView);

            one=itemView.findViewById(R.id.text_sub1);
            name=itemView.findViewById(R.id.name_category);
            description=itemView.findViewById(R.id.description_category);
            delete=itemView.findViewById(R.id.img_delete);
        }
    }

}
