package kr.co.chience.roomex;


import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button btnAdd, btnView, btnUpdate, btnDelete;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnAdd = view.findViewById(R.id.add);
        btnView = view.findViewById(R.id.view);
        btnUpdate = view.findViewById(R.id.update);
        btnDelete = view.findViewById(R.id.delete);
        btnAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        MainActivity.fragmentManager.beginTransaction()
                .replace(R.id.Container, new AddFragment(), null)
                .addToBackStack(null)
                .commit();
    }
}
