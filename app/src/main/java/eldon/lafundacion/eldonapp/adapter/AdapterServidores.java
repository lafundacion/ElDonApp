package eldon.lafundacion.eldonapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import eldon.lafundacion.eldonapp.R;
import eldon.lafundacion.eldonapp.bean.Servidor;

import static eldon.lafundacion.eldonapp.R.id.ivStarCuatro;
import static eldon.lafundacion.eldonapp.R.id.ivStarDos;
import static eldon.lafundacion.eldonapp.R.id.ivStarTres;

public class AdapterServidores extends RecyclerView.Adapter<AdapterServidores.ServidoresViewHolder> {

    public class ServidoresViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        ImageView ivStarUno;
        ImageView ivStarDos;
        ImageView ivStarTres;
        ImageView ivStarCuatro;
        ImageView ivStarCinco;
        TextView tvNombre;
        TextView tvDistancia;
        TextView tvTelefono;
        TextView tvEdad;
        TextView tvExperiencia;
        private Context context;

        ServidoresViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ivFoto = (ImageView)itemView.findViewById(R.id.ivFoto);
            ivStarUno = (ImageView)itemView.findViewById(R.id.ivStarUno);
            ivStarDos = (ImageView)itemView.findViewById(R.id.ivStarDos);
            ivStarTres = (ImageView)itemView.findViewById(R.id.ivStarTres);
            ivStarCuatro = (ImageView)itemView.findViewById(R.id.ivStarCuatro);
            ivStarCinco = (ImageView)itemView.findViewById(R.id.ivStarCinco);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvDistancia = (TextView)itemView.findViewById(R.id.tvDistancia);
            tvTelefono = (TextView)itemView.findViewById(R.id.tvTelefono);
            tvEdad = (TextView)itemView.findViewById(R.id.tvEdad);
            tvExperiencia = (TextView)itemView.findViewById(R.id.tvExperiencia);

        }
    }

    List<Servidor> servidores;

    public AdapterServidores(List<Servidor> servidores){
        this.servidores = servidores;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ServidoresViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_servidores, viewGroup, false);
        ServidoresViewHolder pvh = new ServidoresViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ServidoresViewHolder ServidoresViewHolder, int i) {
        ServidoresViewHolder.tvNombre.setText(servidores.get(i).getNombre());
        ServidoresViewHolder.tvEdad.setText(servidores.get(i).getEdad());
        ServidoresViewHolder.tvDistancia.setText(servidores.get(i).getDistancia());
        ServidoresViewHolder.tvExperiencia.setText(servidores.get(i).getExperiencia());
        ServidoresViewHolder.tvTelefono.setText(servidores.get(i).getTelefono());

        int estrellas = servidores.get(i).getValoracion();
        switch (estrellas){
            case 1:
                ServidoresViewHolder.ivStarCinco.setVisibility(View.INVISIBLE);
                ServidoresViewHolder.ivStarCuatro.setVisibility(View.INVISIBLE);
                ServidoresViewHolder.ivStarTres.setVisibility(View.INVISIBLE);
                ServidoresViewHolder.ivStarDos.setVisibility(View.INVISIBLE);
                break;
            case 2:
                ServidoresViewHolder.ivStarCinco.setVisibility(View.INVISIBLE);
                ServidoresViewHolder.ivStarCuatro.setVisibility(View.INVISIBLE);
                ServidoresViewHolder.ivStarTres.setVisibility(View.INVISIBLE);
                break;
            case 3:
                ServidoresViewHolder.ivStarCinco.setVisibility(View.INVISIBLE);
                ServidoresViewHolder.ivStarCuatro.setVisibility(View.INVISIBLE);
                break;
            case 4:
                ServidoresViewHolder.ivStarCinco.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }


    }

    @Override
    public int getItemCount() {
        return servidores.size();
    }

}