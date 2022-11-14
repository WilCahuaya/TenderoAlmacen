package mx.com.encargalo.tendero.Inicio_sesion.ui.Mi_tienda;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.util.Strings;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import mx.com.encargalo.R;
import mx.com.encargalo.tendero.Inicio_sesion.Entidades.ga_EntidadListadoProductoTienda;
import mx.com.encargalo.tendero.Inicio_sesion.Entidades.ga_EntidadProductos;

import static java.lang.String.valueOf;


public class ga_frgingresostock extends Fragment {
    ImageButton ga_isbtnbuscarprod;
    TextInputEditText ga_isedtcodsku,ga_isedtnombreprod,ga_isedtdescripcion,ga_isedtcantproding;
    TextView ga_istxtstockactual;

    ProgressDialog progressDialogBuscar,progressDialogActualizar;
    RequestQueue requestQueueBuscar,requestQueueActualizar;
    JsonObjectRequest jsonObjectRequestBuscar;
    StringRequest stringRequestActualizar;

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
        ga_isbtnbuscarprod=view.findViewById(R.id.ga_isbtnbuscarprod);

        ga_isedtcodsku=view.findViewById(R.id.ga_isedtcodsku);
        ga_isedtnombreprod=view.findViewById(R.id.ga_isedtnombreprod);
        ga_isedtdescripcion=view.findViewById(R.id.ga_isedtdescripcion);
        ga_isedtcantproding=view.findViewById(R.id.ga_isedtcantproding);
        ga_istxtstockactual=view.findViewById(R.id.ga_istxtstockactual);

        requestQueueBuscar= Volley.newRequestQueue(getContext());
        requestQueueActualizar= Volley.newRequestQueue(getContext());

        ga_isbtnregistrarstok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ga_actualizarStock();
                Navigation.findNavController(view).navigate(R.id.action_nav_ingreso_stock_to_nav_stock_actualizado);
            }
        });

        ga_isbtnbuscarprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ga_buscarProducto();
            }
        });

        return view;
    }

    private void ga_actualizarStock() {
        progressDialogActualizar= new ProgressDialog(getContext());
        progressDialogActualizar.setMessage("Actualizando Stock .........");
        progressDialogActualizar.show();
        String urlactualizarstock="http://129.151.103.228/Encargalo/APIS/TenderoApp/m_mod_stock_producto_almacen.php";
        //String urlactualizarstock="http://192.168.101.6:8080/apistendero/m_mod_stock_producto_almacen.php";

        stringRequestActualizar= new StringRequest(Request.Method.POST, urlactualizarstock, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialogActualizar.hide();
                Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();
                 }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialogActualizar.hide();
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String idTienda ="1";
                String idListProducto = "1";
                String stockNuevo = ga_isedtcantproding.getText().toString();

                Map<String, String> params=new HashMap<>();
                params.put("idTienda", idTienda);
                params.put("idListadoProductoTienda", idListProducto);
                params.put("ptStock", stockNuevo);

                return params;
            }
        };
        requestQueueActualizar.add(stringRequestActualizar);
    }

    private void ga_buscarProducto() {
        progressDialogBuscar= new ProgressDialog(getContext());
        progressDialogBuscar.setMessage("Consultando........");
        progressDialogBuscar.show();
        String urlbuscarproducto="http://192.168.101.6:8080/apistendero/c_consultar_stock_producto_x_nombre_codigo_almacen.php";

//        Map<String, String> params=new HashMap<>();
//        String idTienda ="1";
//        String idProducto = ga_isedtcodsku.getText().toString();
//        String prodNombre = ga_isedtnombreprod.getText().toString();
//        String xp_modbusc = "1";
//        params.put("xp_modbusc", xp_modbusc);
//        params.put("idTienda", idTienda);
//        params.put("idProducto", idProducto);
//        params.put("prodDescripcion", prodNombre);
//        JSONObject parametros=new JSONObject(params);
//        Toast.makeText(getContext(), parametros+"", Toast.LENGTH_SHORT).show();
        jsonObjectRequestBuscar=new JsonObjectRequest(Request.Method.POST, urlbuscarproducto,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialogBuscar.hide();
                ga_EntidadProductos producto = new ga_EntidadProductos();
                ga_EntidadListadoProductoTienda listaproducto = new ga_EntidadListadoProductoTienda();
                try {
                    JSONArray json = response.optJSONArray("consulta");
                    JSONObject jsonObject=null;
                    jsonObject = json.getJSONObject(0);
                    producto.setIdProducto(jsonObject.optInt("idProducto"));
                    producto.setProdDescripcion(jsonObject.optString("prodDescripcion"));
                    listaproducto.setLptStock(jsonObject.optInt("lptStock"));
                    listaproducto.setIdListadoProductoTienda(jsonObject.optInt("idListadoProductoTienda"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ga_isedtdescripcion.setText(producto.getProdDescripcion());
                ga_istxtstockactual.setText(Float.toString(listaproducto.getLptStock()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialogBuscar.hide();
                Toast.makeText(getContext(), "No se puedo consultar "+error, Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();

                String idTienda ="1";
                String idProducto = ga_isedtcodsku.getText().toString();
                String prodNombre = ga_isedtnombreprod.getText().toString();
                String xp_modbusc = "1";
                params.put("xp_modbusc", xp_modbusc);
                params.put("idTienda", idTienda);
                params.put("idProducto", idProducto);
                params.put("prodDescripcion", prodNombre);
                JSONObject parametros=new JSONObject(params);
                Toast.makeText(getContext(), parametros+"", Toast.LENGTH_SHORT).show();

                return params;
            }
        };
        requestQueueBuscar.add(jsonObjectRequestBuscar);
    }


}