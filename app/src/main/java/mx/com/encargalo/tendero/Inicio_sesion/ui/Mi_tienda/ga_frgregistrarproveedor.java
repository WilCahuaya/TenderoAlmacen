package mx.com.encargalo.tendero.Inicio_sesion.ui.Mi_tienda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Hashtable;
import java.util.Map;

import mx.com.encargalo.R;


public class ga_frgregistrarproveedor extends Fragment {

    Button ga_RPbtnAgregarProv;
    EditText rpRfcprov,rpNombreprov,rpDireccionprov,rpContactoprov,rpTelefonoprov;
    Spinner rpCiudadprov,rpDistritoprov;
    ProgressDialog progreso;
    RequestQueue request;

    @Override
    public void onCreate(Bundle saveInstanceState){super.onCreate(saveInstanceState);}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ga_frgregistrarproveedor, container, false);

        ga_RPbtnAgregarProv=view.findViewById(R.id.ga_rpbtnagregarprov);
        rpRfcprov = view.findViewById(R.id.ga_rpedtrfcprov);
        rpNombreprov = view.findViewById(R.id.ga_rpedtnombreprov);
        rpDireccionprov = view.findViewById(R.id.ga_rpedtdireccionprov);
        rpCiudadprov = view.findViewById(R.id.ga_rpspnciudadprov);
        rpDistritoprov = view.findViewById(R.id.ga_rpspndistritoprov);
        rpContactoprov = view.findViewById(R.id.ga_rpedtcontactoprov);
        rpTelefonoprov = view.findViewById(R.id.ga_rpedttelefonoprov);
        request = Volley.newRequestQueue(getContext());
        ga_RPbtnAgregarProv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                insertproveedor();
                Navigation.findNavController(view).navigate(R.id.action_nav_registrar_proveedor_to_nav_proveedor_registrado);
            }


        });

//        ga_RPbtnAgregarProv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigate(R.id.action_nav_registrar_proveedor_to_nav_proveedor_registrado);
//            }
//        });

        return view;
    }
    private void insertproveedor() {
        progreso= new ProgressDialog(getContext());
        progreso.setMessage("Registrando........");
        progreso.show();
        String url ="http://129.151.103.228/Encargalo/APIS/TenderoApp/a_reg_proveedor_almacen.php";
        //String url ="http://192.168.101.6:8080/apistendero/a_reg_proveedor_almacen.php";
        final ProgressDialog loading = ProgressDialog.show(getContext(),"subiendo...","Espere por favor...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progreso.hide();

                        Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progreso.hide();

                        Toast.makeText(getContext(), "" +volleyError.getMessage().toString(), Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{

                String provNombre = rpNombreprov.getText().toString().trim();
                String provDireccion = rpDireccionprov.getText().toString().trim();
                //String provCiudad = rpCiudadprov.getText().toString().trim();
                //String provDistrito = rpDistritoprov.getText().toString().trim();
                String provCorreo = rpContactoprov.getText().toString().trim();
                String provTelefono = rpTelefonoprov.getText().toString().trim();
                String provRFC = rpRfcprov.getText().toString().trim();

                Map<String,String> params = new Hashtable<String, String>();

                params.put("provNombre",provNombre);
                params.put("provDireccion",provDireccion);
                //params.put("provCiudad",provCiudad);
                //params.put("provDistrito",provDistrito);
                params.put("provCorreo",provCorreo);
                params.put("provTelefono",provTelefono);
                params.put("provRFC",provRFC);

                return params;
            }
        };

        request.add(stringRequest);


    }
}