package mx.com.encargalo.tendero.Inicio_sesion.ui.Mi_tienda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import mx.com.encargalo.R;


public class ga_frgmenuproveedor extends Fragment {
    Button ga_mpbtnregistrarprov;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_ga_frgmenuproveedor, container, false);
        ga_mpbtnregistrarprov=view.findViewById(R.id.ga_mpbtnregistrarprov);

        ga_mpbtnregistrarprov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_menu_proveedor_to_nav_registrar_proveedor);
            }
        });
        return view;
    }
}