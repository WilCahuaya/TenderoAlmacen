package mx.com.encargalo.tendero.Inicio_sesion.ui.Mi_tienda;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.com.encargalo.R;


public class ga_frgregistrarproveedor extends Fragment {
    Button ga_RPbtnAgregarProv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ga_frgregistrarproveedor, container, false);

        ga_RPbtnAgregarProv=view.findViewById(R.id.ga_rpbtnagregarprov);

        ga_RPbtnAgregarProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_registrar_proveedor_to_nav_proveedor_registrado);
            }
        });

        return view;
    }
}