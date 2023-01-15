package facci.distribuidos.aplicacionmqtt.adapter;

import java.util.ArrayList;

import facci.distribuidos.aplicacionmqtt.contans.Api;
import facci.distribuidos.aplicacionmqtt.model.Distancia;
import facci.distribuidos.aplicacionmqtt.service.DistanciaService;
import retrofit2.Call;

public class DistanciaAdapter extends BaseAdapter implements DistanciaService {
    private DistanciaService distanciaService;

    public DistanciaAdapter(){
        super(Api.BASE_AUTOS_URL);
        distanciaService=createService(DistanciaService.class);
    }



    @Override
    public Call<ArrayList<Distancia>> getDistancia() {
        return distanciaService.getDistancia();
    }
}


