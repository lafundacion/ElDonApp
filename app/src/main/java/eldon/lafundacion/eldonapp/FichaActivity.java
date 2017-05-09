package eldon.lafundacion.eldonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import eldon.lafundacion.eldonapp.bean.Servidor;

public class FichaActivity extends AppCompatActivity {

    private int idServicio;
    private Servidor servidor;
    private TextView tvNombre;
    private TextView tvDistancia;
    private TextView tvEdad;
    private TextView tvTelefono;
    private TextView tvActividades;
    private TextView tvExperiencia;
    private TextView tvDatoAdicional;
    private ImageView ivStarUno;
    private ImageView ivStarDos;
    private ImageView ivStarTres;
    private ImageView ivStarCuatro;
    private ImageView ivStarCinco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);

        servidor = (Servidor) getIntent().getExtras().getSerializable("servidor");
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvDistancia = (TextView) findViewById(R.id.tvDistancia);
        tvEdad = (TextView) findViewById(R.id.tvEdad);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvActividades = (TextView) findViewById(R.id.tvActividades);
        tvExperiencia = (TextView) findViewById(R.id.tvExperiencia);
        tvDatoAdicional = (TextView) findViewById(R.id.tvDatoAdicional);
        ivStarUno = (ImageView) findViewById(R.id.ivStarUno);
        ivStarDos = (ImageView) findViewById(R.id.ivStarDos);
        ivStarTres = (ImageView) findViewById(R.id.ivStarTres);
        ivStarCuatro = (ImageView) findViewById(R.id.ivStarCuatro);
        ivStarCinco = (ImageView) findViewById(R.id.ivStarCinco);

        idServicio = servidor.getIdServicio();
        tvNombre.setText(servidor.getNombre());
        tvDistancia.setText(servidor.getDistancia());
        tvEdad.setText(servidor.getEdad());
        tvTelefono.setText(servidor.getTelefono());
        tvActividades.setText(servidor.getActividad());
        tvExperiencia.setText(servidor.getExperiencia());
        tvDatoAdicional.setText(servidor.getDatoAdicional());

        int estrellas = servidor.getValoracion();
        switch (estrellas){
            case 1:
                ivStarCinco.setVisibility(View.INVISIBLE);
                ivStarCuatro.setVisibility(View.INVISIBLE);
                ivStarTres.setVisibility(View.INVISIBLE);
                ivStarDos.setVisibility(View.INVISIBLE);
                break;
            case 2:
                ivStarCinco.setVisibility(View.INVISIBLE);
                ivStarCuatro.setVisibility(View.INVISIBLE);
                ivStarTres.setVisibility(View.INVISIBLE);
                break;
            case 3:
                ivStarCinco.setVisibility(View.INVISIBLE);
                ivStarCuatro.setVisibility(View.INVISIBLE);
                break;
            case 4:
                ivStarCinco.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }


    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), ServiciosActivity.class);
        myIntent.putExtra("IdServicio",idServicio);
        startActivityForResult(myIntent, 0);
        return true;

    }

}


