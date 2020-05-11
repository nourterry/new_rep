package com.example.notes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.R;
import com.example.notes.ShareContent;
import com.example.notes.models.User;
import com.example.notes.models.note;

import io.realm.Realm;
import io.realm.RealmList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.noteVH> {
    @NonNull
    Context context;
    RealmList<note> notes;
    Realm realm;
    public  NotesAdapter(Context context){
        this.context=context;
        Realm.init(context);
        realm=Realm.getDefaultInstance();
        User user=realm.where(User.class).equalTo("Firstname", ShareContent.name)
                .equalTo("Passward",ShareContent.passward).findFirst();
        notes=user.getCategories().get(ShareContent.position).getNotes();
    }
    @Override
    public noteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.note_cell,parent,false);
        return new noteVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noteVH holder, final int position) {
    holder.notename.setText(notes.get(position).getName());
    holder.notedescription.setText(notes.get(position).getDescription());
    if(notes.get(position).isIschecked())
       holder.linear_checked.setBackgroundResource(R.drawable.shape_image_true);
    else
        holder.linear_checked.setBackgroundResource(R.drawable.shape_image_false);
    holder.linear_checked.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            realm.beginTransaction();
            notes.get(position).setIschecked(true);
            realm.commitTransaction();
            notifyDataSetChanged();
        }
    });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class noteVH extends RecyclerView.ViewHolder{
      TextView notename,notedescription;
      LinearLayout linear_checked;


        public noteVH(@NonNull View itemView) {
            super(itemView);
            notename=itemView.findViewById(R.id.name_note);
            notedescription=itemView.findViewById(R.id.description_note);
            linear_checked=itemView.findViewById(R.id.linear_check);
        }
    }
}
