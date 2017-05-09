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
import eldon.lafundacion.eldonapp.bean.Servicio;

public class AdapterServicios extends RecyclerView.Adapter<AdapterServicios.ServicioViewHolder> {

    public class ServicioViewHolder extends RecyclerView.ViewHolder {

        TextView servicio;
        ImageView imagen;
        private Context context;

        ServicioViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            servicio = (TextView)itemView.findViewById(R.id.tvServicio);
            imagen = (ImageView)itemView.findViewById(R.id.ivImagen);

            //comentario prueba df
        }
    }

    List<Servicio> servicios;

    public AdapterServicios(List<Servicio> servicios){
        this.servicios = servicios;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ServicioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_servicios, viewGroup, false);
        ServicioViewHolder pvh = new ServicioViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ServicioViewHolder ServicioViewHolder, int i) {
        ServicioViewHolder.servicio.setText(servicios.get(i).getServicio());
    }

    @Override
    public int getItemCount() {
        return servicios.size();
    }

}