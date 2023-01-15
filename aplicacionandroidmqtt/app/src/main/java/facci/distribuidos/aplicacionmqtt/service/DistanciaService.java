package facci.distribuidos.aplicacionmqtt.service;

import java.util.ArrayList;

import facci.distribuidos.aplicacionmqtt.contans.Api;
import facci.distribuidos.aplicacionmqtt.model.Distancia;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DistanciaService {

    //REGISTER ******
    //LIST AUTOS
    @GET(Api.DISTANCIA_ENDPOINT)
    Call<ArrayList<Distancia>> getDistancia();

}
