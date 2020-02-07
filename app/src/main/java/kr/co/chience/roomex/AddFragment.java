package kr.co.chience.roomex;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    private EditText inputId;
    private EditText inputName;
    private EditText inputEmail;
    private Button btnSave;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        inputId = view.findViewById(R.id.inputId);
        inputName = view.findViewById(R.id.inputName);
        inputEmail = view.findViewById(R.id.inputEmail);
        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(inputId.getText().toString());
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();

                Person person = new Person();
                person.setId(id);
                person.setName(name);
                person.setEmail(email);

                MainActivity.personDatabase.personDao().addPerson(person);
                Log.e("Person", "Data Successfully Save");

                inputId.setText("");
                inputName.setText("");
                inputEmail.setText("");

            }
        });

        return view;
    }

}
