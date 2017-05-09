package eldon.lafundacion.eldonapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import eldon.lafundacion.eldonapp.adapter.AdapterServicios;
import eldon.lafundacion.eldonapp.bean.Servicio;
import eldon.lafundacion.eldonapp.bean.Servidor;
import eldon.lafundacion.eldonapp.util.DividerItemDecoration;
import eldon.lafundacion.eldonapp.util.JSONFunctions;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView rvServicios;
    private List<Servicio> servicios;

    private JSONObject jsonObjectServicio;
    private JSONArray jsonArrayServicio;
    private AdapterServicios adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvServicios=(RecyclerView) findViewById(R.id.rvServicios);
        LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        rvServicios.setItemAnimator(new DefaultItemAnimator());
        rvServicios.setLayoutManager(llm);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        actionBar.setHomeButtonEnabled(true);

        servicios = new ArrayList<Servicio>();

        adapter = new AdapterServicios(servicios);
        rvServicios.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvServicios.setAdapter(adapter);

        new DownloadJSONServicios().execute();

        rvServicios.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(getApplicationContext(),rvServicios,
                new MainActivity.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Servicio servicio = new Servicio();
                        servicio = servicios.get(position);
                        Intent intent = new Intent(getApplicationContext(), ServiciosActivity.class);
                        intent.putExtra("IdServicio",servicio.getIdServicio());
                        startActivity(intent);

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));


    }

    private class DownloadJSONServicios extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {
            //servicios = new ArrayList<Servicio>();
            String ligaServicios=getResources().getString(R.string.ws_servicios);
            jsonObjectServicio = JSONFunctions.getJSONfromURL(ligaServicios);

            try {
                jsonArrayServicio = jsonObjectServicio.getJSONArray("oficio");
                for (int i = 0; i < jsonArrayServicio.length(); i++) {
                    jsonObjectServicio = jsonArrayServicio.getJSONObject(i);

                    Servicio servicioAct = new Servicio();

                    servicioAct.setIdServicio(jsonObjectServicio.optInt("idOficio"));
                    servicioAct.setServicio(jsonObjectServicio.optString("oficio"));
                    servicios.add(servicioAct);

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

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
