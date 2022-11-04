package mx.com.encargalo.tendero.Inicio_sesion.ui.Mi_tienda;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import mx.com.encargalo.R;


public class ga_frgingresostock extends Fragment {
    Button ga_isbtnregistrarstok;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ga_frgingresostock, container, false);

        ga_isbtnregistrarstok=view.findViewById(R.id.ga_isbtnregistrarstok);

        ga_isbtnregistrarstok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_ingreso_stock_to_nav_stock_actualizado);
            }
        });

        return view;
    }
}