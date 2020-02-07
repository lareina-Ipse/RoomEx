package kr.co.chience.roomex;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    private EditText inputId, inputName, inputEmail;
    private Button btnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        inputId = view.findViewById(R.id.inputId);
        inputName = view.findViewById(R.id.inputName);
        inputEmail = view.findViewById(R.id.inputEmail);
        btnUpdate = view.findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ID = Integer.parseInt(inputId.getText().toString());
                String Name = inputName.getText().toString();
                String Email = inputEmail.getText().toString();

                Person person = new Person();
                person.setId(ID);
                person.setName(Name);
                person.setEmail(Email);

                MainActivity.personDatabase.personDao().updatePerson(person);
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new ViewFragment(), null).commit();
            }
        });

        return view;
    }

}
