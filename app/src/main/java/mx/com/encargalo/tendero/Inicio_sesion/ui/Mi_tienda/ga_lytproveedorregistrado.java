package mx.com.encargalo.tendero.Inicio_sesion.ui.Mi_tienda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.com.encargalo.R;

public class ga_lytproveedorregistrado extends Fragment {
    Button ga_prbtnvolver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_ga_lytproveedorregistrado, container, false);
        ga_prbtnvolver=view.findViewById(R.id.ga_prbtnvolver);

        ga_prbtnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_proveedor_registrado_to_nav_registrar_proveedor);
            }
        });
        return  view;
    }
}