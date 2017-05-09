package eldon.lafundacion.eldonapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import eldon.lafundacion.eldonapp.adapter.AdapterServicios;
import eldon.lafundacion.eldonapp.adapter.AdapterServidores;
import eldon.lafundacion.eldonapp.bean.Servicio;
import eldon.lafundacion.eldonapp.bean.Servidor;
import eldon.lafundacion.eldonapp.util.DividerItemDecoration;
import eldon.lafundacion.eldonapp.util.JSONFunctions;

public class ServiciosActivity extends AppCompatActivity {

    private RecyclerView rvServidores;
    private List<Servidor> servidores;
    private JSONObject jsonObjectServidores;
    private JSONArray jsonArrayServidores;
    private AdapterServidores adapter;
    private int idServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servidores);

        idServicio = getIntent().getIntExtra("IdServicio",0);

        rvServidores=(RecyclerView) findViewById(R.id.rvServidores);
        LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        rvServidores.setItemAnimator(new DefaultItemAnimator());
        rvServidores.setLayoutManager(llm);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        servidores = new ArrayList<Servidor>();

        adapter = new AdapterServidores(servidores);
        rvServidores.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvServidores.setAdapter(adapter);

        new ServiciosActivity.DownloadJSONServidores().execute();

        rvServidores.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(getApplicationContext(),rvServidores,
                new MainActivity.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Servidor servidor = new Servidor();
                        servidor = servidores.get(position);
                        Intent intent = new Intent(getApplicationContext(), FichaActivity.class);
                        intent.putExtra("servidor",servidor);
                        startActivity(intent);

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_servidores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                Intent intentAdd = new Intent(getApplicationContext(), RegistroActivity.class);
                intentAdd.putExtra("IdServicio",idServicio);
                startActivityForResult(intentAdd, 0);
                break;
            case android.R.id.home:
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                break;
        }
        return (super.onOptionsItemSelected(item));
    }

    private class DownloadJSONServidores extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {
            //servicios = new ArrayList<Servicio>();
            String ligaServidores=getResources().getString(R.string.ws_servidores)+idServicio+"/1";
            jsonObjectServidores = JSONFunctions.getJSONfromURL(ligaServidores);

            try {
                jsonArrayServidores = jsonObjectServidores.getJSONArray("servidor");
                for (int i = 0; i < jsonArrayServidores.length(); i++) {
                    jsonObjectServidores = jsonArrayServidores.getJSONObject(i);

                    Servidor servidorAct = new Servidor();

                    servidorAct.setIdServidor(jsonObjectServidores.optInt("idServidor"));
                    servidorAct.setValoracion(jsonObjectServidores.optInt("valoracion"));
                    servidorAct.setNombre(jsonObjectServidores.optString("nombre"));
                    servidorAct.setDistancia(jsonObjectServidores.optString("distancia"));
                    servidorAct.setEdad(jsonObjectServidores.optString("edad"));
                    servidorAct.setTelefono(jsonObjectServidores.optString("telefono"));
                    servidorAct.setActividad(jsonObjectServidores.optString("actividad"));
                    servidorAct.setDatoAdicional(jsonObjectServidores.optString("adicional"));
                    servidorAct.setExperiencia(jsonObjectServidores.optString("experiencia"));
                    servidores.add(servidorAct);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            adapter.notifyDataSetChanged();
        }
    }


}
