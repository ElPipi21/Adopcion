package com.proyectofinal.adopcioncolitas.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.proyectofinal.adopcioncolitas.Adapters.MascotasAdapter;
import com.proyectofinal.adopcioncolitas.Clases.Mascota;
import com.proyectofinal.adopcioncolitas.R;
import com.proyectofinal.adopcioncolitas.interfaces.IComunicaFragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentListarMascotas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentListarMascotas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentListarMascotas extends Fragment implements Response.ErrorListener, Response.Listener<JSONObject> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerMascotas;
    ArrayList<Mascota> listaMascotas;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    ////////////
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    ///////////


    public FragmentListarMascotas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentListarMascotas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentListarMascotas newInstance(String param1, String param2) {
        FragmentListarMascotas fragment = new FragmentListarMascotas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_fragment_listar_mascotas, container, false);


        listaMascotas= new ArrayList<>();
        recyclerMascotas=vista.findViewById(R.id.recyclerId);
        recyclerMascotas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerMascotas.setHasFixedSize(true);

        request = Volley.newRequestQueue(getContext());
        
        cargarWebService();


        
        ////////no quitar////
        /*
        llenarLista();

        MascotasAdapter adapter = new MascotasAdapter(listaMascotas);
        recyclerMascotas.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Selecciona: "
                        +listaMascotas.get(recyclerMascotas
                        .getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarMascota(listaMascotas.get(recyclerMascotas.getChildAdapterPosition(view)));

            }
        });
        */
        
        
        
        return vista;
    }

    private void cargarWebService() {
        String url= "http://u881524204.hostingerapp.com/WEBSERVICE/Colitas/ListarMascotas.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this,this);
        request.add(jsonObjectRequest);



    }


    private void llenarLista() {

        /////como debería ser
        /*
        listaMascotas.add(new Mascota(
                getString(R.string.perrito_nombre),
                        getString(R.string.perrito_especie),
                        getString(R.string.perrito_ciudad),
                        R.drawable.perrito,
                        getString(R.string.perrito_detalle)));
        */

        //solo para demostrar///
        /*
        listaMascotas.add(new Mascota("Firulais","Perro","Trujillo", R.drawable.perrito, "Es un perrro bonito"));
        listaMascotas.add(new Mascota("Perales","Perro","Lima",R.drawable.perrito2, "Es un perro bonito"));
        listaMascotas.add(new Mascota("Chistris","Perro","Lambayeque",R.drawable.perrito3, "Es un perro bonito"));
        listaMascotas.add(new Mascota("Rambo","Perro","Trujillo",R.drawable.perrito4, "Es un perro bonito"));
        listaMascotas.add(new Mascota("Pompon","Conejo","Trujillo",R.drawable.conejitos, "Es un conejo bonito"));
        listaMascotas.add(new Mascota("Chasqui","Cuy","Cajamarca",R.drawable.cuy, "Es un cuy bonito"));
        listaMascotas.add(new Mascota("Ranses","Gato","Trujillo",R.drawable.gatito, "Es un gato bonito"));
        listaMascotas.add(new Mascota("Micho","Gato","Trujillo",R.drawable.gatito2, "Es un gato bonito"));
        listaMascotas.add(new Mascota("El machito","Gato","Lima",R.drawable.gatito3, "Es un gato bonito"));
        listaMascotas.add(new Mascota("Fuerza G","Hamster","Trujillo",R.drawable.hamster, "Es un hamster bonito"));
        listaMascotas.add(new Mascota("Piolin","Ave","Trujillo",R.drawable.lorito, "Es un pajarito bonito"));
        listaMascotas.add(new Mascota("Volador","Ave","Trujillo",R.drawable.lorito2, "Es un pajarito bonito"));
        listaMascotas.add(new Mascota("Paco","Ave","Trujillo",R.drawable.lorito3, "Es un pajarito bonito"));
        */
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity=(Activity) context;
            interfaceComunicaFragments=(IComunicaFragments) this.activity;
        }

        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
            + "must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se puede conectar" +error.toString(),Toast.LENGTH_LONG).show();;
        System.out.println();
        Log.d("ERROR", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Mascota mascota;
        JSONArray json= response.optJSONArray("Mascotas");

            try {

                for(int i=0; i<json.length(); i++){
                    mascota= new Mascota();
                    JSONObject jsonObject=null;
                    jsonObject = json.getJSONObject(i);


                    mascota.setNombre(jsonObject.getString("nombre"));
                    mascota.setEspecie(jsonObject.getString("especie"));
                    mascota.setCiudad(jsonObject.getString("ciudad"));
                    mascota.setDetalle(jsonObject.getString("detalle"));

                    listaMascotas.add(mascota);
            }
                MascotasAdapter adapter= new MascotasAdapter(listaMascotas);
                recyclerMascotas.setAdapter(adapter);

            }catch (JSONException e){
                e.printStackTrace();
                Toast.makeText(getContext(), "No se ha podido establecer conexion con el servidor"
                        +""+response, Toast.LENGTH_LONG).show();

        }

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
