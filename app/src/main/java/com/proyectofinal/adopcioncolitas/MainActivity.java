package com.proyectofinal.adopcioncolitas;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.proyectofinal.adopcioncolitas.Clases.Mascota;
import com.proyectofinal.adopcioncolitas.Clases.Utilidades;
import com.proyectofinal.adopcioncolitas.Fragments.FragmentContenedor;
import com.proyectofinal.adopcioncolitas.Fragments.FragmentDetalleMascota;
import com.proyectofinal.adopcioncolitas.Fragments.FragmentDonaciones;
import com.proyectofinal.adopcioncolitas.Fragments.FragmentFavoritos;
import com.proyectofinal.adopcioncolitas.Fragments.FragmentListarMascotas;
import com.proyectofinal.adopcioncolitas.Fragments.FragmentLlenarFormulario;
import com.proyectofinal.adopcioncolitas.interfaces.IComunicaFragments;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        FragmentDonaciones.OnFragmentInteractionListener,
        FragmentListarMascotas.OnFragmentInteractionListener,
        FragmentFavoritos.OnFragmentInteractionListener,
        FragmentContenedor.OnFragmentInteractionListener,
        FragmentDetalleMascota.OnFragmentInteractionListener,
        IComunicaFragments,
        FragmentLlenarFormulario.OnFragmentInteractionListener

         {

    FragmentListarMascotas listaFragment;
    FragmentDetalleMascota detalleFragment;
    FragmentDonaciones donacionesFragment;
    FragmentLlenarFormulario llenarFormularioFragment;
    FragmentFavoritos favoritosFragment;
    FragmentContenedor contenedorFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if(Utilidades.validaPantalla==true){
            Fragment fragment = new FragmentListarMascotas();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            Utilidades.validaPantalla=false;
        }

        navigationView.setNavigationItemSelectedListener(this);


        ////////////////////
        donacionesFragment = new FragmentDonaciones();
        llenarFormularioFragment = new FragmentLlenarFormulario();
        favoritosFragment = new FragmentFavoritos();
        detalleFragment= new FragmentDetalleMascota();
        /////////////////////


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment=null;
        boolean fragmentSeleccionado=false;

        if (id == R.id.nav_home) {
            miFragment= new FragmentListarMascotas();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_gallery) {
            miFragment= new FragmentFavoritos();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_slideshow) {
            miFragment = new FragmentDonaciones();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_tools) {
            miFragment = new FragmentLlenarFormulario();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_share) {
            miFragment = new FragmentContenedor();
            fragmentSeleccionado=true;

        }

        if(fragmentSeleccionado==true){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, miFragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


     @Override
     public void enviarMascota(Mascota mascota) {
         detalleFragment = new FragmentDetalleMascota();
         Bundle bundleEnvio= new Bundle();
         bundleEnvio.putSerializable("objeto", mascota);
         detalleFragment.setArguments(bundleEnvio);
         //cargar el fragment en el activity
         getSupportFragmentManager().beginTransaction().replace(R.id.content_main, detalleFragment).addToBackStack(null).commit();
     }


     public void onClick(View view) {
         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
         switch (view.getId()){
             case R.id.btnAdoptar:
                 transaction.replace(R.id.content_main, llenarFormularioFragment);

                 break;
             case  R.id.btnDonar:
                 transaction.replace(R.id.content_main, donacionesFragment);
                 break;

             case R.id.btnMegusta:
                 transaction.replace(R.id.content_main, favoritosFragment);

                 /////////////////
                 /*
             case R.id.btnRealizarAdopcion:
             Toast.makeText(getApplicationContext(),
                     "Se ha añadido su solicitud, MUCHAS GRACIAS "
                     , Toast.LENGTH_SHORT).show();
             case R.id.btnRealizarDonacion:
                 Toast.makeText(getApplicationContext(),
                         "Se ha realizado su donacion con éxito, MUCHAS GRACIAS "
                         , Toast.LENGTH_SHORT).show();

                 */
                 /////////////////////////////
             default:
                 break;
         }


         transaction.commit();

     }
         }
