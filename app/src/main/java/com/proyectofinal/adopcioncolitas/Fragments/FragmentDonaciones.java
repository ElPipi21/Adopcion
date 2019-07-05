package com.proyectofinal.adopcioncolitas.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.proyectofinal.adopcioncolitas.R;

import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentDonaciones.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentDonaciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDonaciones extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    EditText txtNombreDon, txtApellidoDon, txtCorreoDon, txtTelefDon, txtDirecDon, txtMontoDon;
    Button btnRealizarDonacion;


    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    public FragmentDonaciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDonaciones.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDonaciones newInstance(String param1, String param2) {
        FragmentDonaciones fragment = new FragmentDonaciones();
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
        // Inflate the layout for this fragment

        View vista= inflater.inflate(R.layout.fragment_fragment_donaciones, container, false);
        txtNombreDon= (EditText) vista.findViewById(R.id.editNombreDon);
        txtApellidoDon= (EditText) vista.findViewById(R.id.editApellidoDon);
        txtCorreoDon= (EditText) vista.findViewById(R.id.editCorreoDon);
        txtTelefDon= (EditText) vista.findViewById(R.id.editTelefonoDon);
        txtDirecDon= (EditText) vista.findViewById(R.id.editDireccionDon);
        txtMontoDon= (EditText) vista.findViewById(R.id.editMontoDon);
        btnRealizarDonacion= vista.findViewById(R.id.btnRealizarDonacion);

        request= Volley.newRequestQueue(getContext());

        btnRealizarDonacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarWebService();
                
            }


        });






        return vista;
    }

    private void cargarWebService() {
        String url= "http://u881524204.hostingerapp.com/WEBSERVICE/Colitas/RealizarDonacion.php?id_mascota=1"
                +"&Nombres="+txtNombreDon.getText().toString()
                +"&Apellidos="+txtApellidoDon.getText().toString()
                +"&Correo="+txtCorreoDon.getText().toString()
                +"&Telefono="+txtTelefDon.getText().toString()
                +"&Direccion="+txtDirecDon.getText().toString()
                +"&monto="+txtMontoDon.getText().toString();

        //url= url.replace("", "%20");

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, null,this, this);
        request.add(jsonObjectRequest);

    }


    //////////////////////////

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se pudo realizar la donacion"+error.toString(), Toast.LENGTH_SHORT).show();
        Log.i("ERROR", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Se ha realizado la donacion correctamente, MUCHAS GRACIAS", Toast.LENGTH_SHORT).show();
        txtNombreDon.setText("");
        txtApellidoDon.setText("");
        txtCorreoDon.setText("");
        txtTelefDon.setText("");
        txtDirecDon.setText("");
        txtMontoDon.setText("");
    }
    ///////////////////////////

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
