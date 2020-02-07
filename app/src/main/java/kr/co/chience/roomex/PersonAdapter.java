package kr.co.chience.roomex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.viewHolder>{
    List<Person> list;

    public PersonAdapter(List<Person> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.id.setText(String.valueOf(list.get(position).getId()));
        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id, name, email;
        Button btnDelete;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            btnDelete = itemView.findViewById(R.id.delete);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Person person = new Person();
            int ID = list.get(getAdapterPosition()).getId();

            person.setId(ID);

            MainActivity.personDatabase.personDao().deletePerson(person);
            MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new ViewFragment(), null).commit();

        }

    }


}
