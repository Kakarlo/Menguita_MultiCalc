package com.example.menguita_multicalc.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.menguita_multicalc.Adapter.RecyclerViewAdapter;
import com.example.menguita_multicalc.Model.FormIcon;
import com.example.menguita_multicalc.R;
import com.example.menguita_multicalc.View.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Physics extends Fragment {

    private RecyclerView recyclerView;
    private List<FormIcon> formula;
    private RecyclerViewAdapter.RecyclerViewClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_physics, container, false);
        recyclerView = view.findViewById(R.id.physicsRecycler);
        //Adapter
        setOnClickListener();
        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(getContext(), formula, listener);
        //Grids
        GridLayoutManager glManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(glManager);
        recyclerView.setAdapter(rvAdapter);
        return view;
    }

    private void setOnClickListener() {
        listener = (view, position) -> {
            Intent intent = new Intent(requireActivity().getApplicationContext(), Calculator.class);
            intent.putExtra("kind", "Physics");
            intent.putExtra("type", formula.get(position).getText());
            startActivity(intent);
        };
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        formula = new ArrayList<>();
        formula.add(new FormIcon("Frequency", R.drawable.frequency));
        formula.add(new FormIcon("Kinetic Energy", R.drawable.kinetic_energy));
        formula.add(new FormIcon("Power", R.drawable.power));
        formula.add(new FormIcon("Pressure", R.drawable.pressure));
        formula.add(new FormIcon("Speed", R.drawable.speed));


    }
}