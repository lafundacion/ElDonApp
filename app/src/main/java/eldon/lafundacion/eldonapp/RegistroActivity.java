package eldon.lafundacion.eldonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import eldon.lafundacion.eldonapp.bean.Servidor;

public class RegistroActivity extends AppCompatActivity {

    private int idServicio;
    //private Servidor servidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        idServicio = getIntent().getIntExtra("IdServidor",0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.etNombre);
        String[] countries = {"Dato 1", "Dato 2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(adapter);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), ServiciosActivity.class);
        myIntent.putExtra("IdServicio",idServicio);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
