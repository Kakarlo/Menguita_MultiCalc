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

import com.example.menguita_multicalc.Adapter.RecyclerViewAdapter;
import com.example.menguita_multicalc.Model.FormIcon;
import com.example.menguita_multicalc.R;
import com.example.menguita_multicalc.View.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Geometry extends Fragment {

    private RecyclerView recyclerView;
    private List<FormIcon> formula;
    private RecyclerViewAdapter.RecyclerViewClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_geometry, container, false);
        recyclerView = view.findViewById(R.id.geometryRecycler);
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
            intent.putExtra("kind", "Geometry");
            intent.putExtra("type", formula.get(position).getText());
            startActivity(intent);
        };
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        formula = new ArrayList<>();
        formula.add(new FormIcon("Sphere", R.drawable.sphere));
        formula.add(new FormIcon("Cone", R.drawable.cone));
        formula.add(new FormIcon("Capsule", R.drawable.capsule));
        formula.add(new FormIcon("Cylinder", R.drawable.cylinder));
        formula.add(new FormIcon("Rectangular Prism", R.drawable.rectangular_prism));

    }

}