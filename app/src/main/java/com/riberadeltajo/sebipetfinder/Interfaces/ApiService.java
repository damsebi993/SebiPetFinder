package com.riberadeltajo.sebipetfinder.Interfaces;

import com.google.gson.JsonObject;
import com.riberadeltajo.sebipetfinder.ui.AnimalesEncontrados.Mascota;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    /* PARA EL INICIO DE SESION */
    @FormUrlEncoded
    @POST("login.php")
    Call<String> loginUser(@Field("username") String username,
                           @Field("password") String password);
    /* PARA REGISTRAR */
    @FormUrlEncoded
    @POST("register.php")
    Call<String> registerUser(@Field("user_name") String user_name,
                              @Field("user_lastname") String user_lastname,
                              @Field("username") String username,
                              @Field("email") String email,
                              @Field("password") String password);
    /* OBTENER TODAS LAS MASCOTAS */
    @GET("getMascotas.php")
    Call<List<Mascota>> getMascotas();

    /* OBTENER MASCOTAS ENCONTRADAS */
    @GET("getMascotasEncontradas.php")
    Call<List<Mascota>> getMascotasEncontradas();

    /* OBTENER LAS CIUDADES EXISTENTES DE ANIMALES PERDIDOS */
    @GET("getCities.php")
    Call<List<String>> getCities();

    /* OBTENER LAS CIUDADES EXISTENTES DE ANIMALES ENCONTRADOS */
    @GET("getCitiesEncontradas.php")
    Call<List<String>> getCitiesEncontradas();

    /* AÑADIR MASCOTA ENCONTRADA */
    @FormUrlEncoded
    @POST("addMascota.php")
    Call<String> addMascota(
            @Field("nombre") String nombre,
            @Field("descripcion") String descripcion,
            @Field("telefono") String telefono,
            @Field("ciudad") String ciudad,
            @Field("fotoUrl") String fotoUrl,
            @Field("user_id") int userId
    );
    /* AÑADIR MASCOTA PERDIDA */
    @FormUrlEncoded
    @POST("addMascotaPerdida.php")
    Call<String> addMascotaPerdida(
            @Field("nombre") String nombre,
            @Field("descripcion") String descripcion,
            @Field("telefono") String telefono,
            @Field("ciudad") String ciudad,
            @Field("fotoUrl") String fotoUrl,
            @Field("user_id") int userId
    );
    /* OBTENER LISTA DE ANUNCIOS DEL USUARIO */
    @FormUrlEncoded
    @POST("getAnuncios.php")
    Call<List<JsonObject>> getAnuncios(@Field("user_id") int userId);

    /* OBTENER USUARIO POR ID */
    @FormUrlEncoded
    @POST("getUsuarioPorId.php")
    Call<JsonObject> getUsuarioPorId(@Field("user_id") int userId);;

    /* SUBIR IMAGEN A LA BD */
    @Multipart
    @POST("uploadImage.php")
    Call<JsonObject> uploadImage(@Part MultipartBody.Part image);

    /* EDITAR MASCOTA PERDIDA */
    @FormUrlEncoded
    @POST("editarMascotaPerdida.php")
    Call<String> editarMascotaPerdida(
            @Field("mascota_id") int mascotaId,
            @Field("nombre") String nombre,
            @Field("descripcion") String descripcion,
            @Field("telefono") String telefono,
            @Field("ciudad") String ciudad
    );
    /* EDITAR MASCOTA ENCONTRADA */
    @FormUrlEncoded
    @POST("editarMascotaEncontrada.php")
    Call<String> editarMascotaEncontrada(
            @Field("mascota_id") int mascotaId,
            @Field("nombre") String nombre,
            @Field("descripcion") String descripcion,
            @Field("telefono") String telefono,
            @Field("ciudad") String ciudad
    );
    /* EDITAR USUARIO */
    @FormUrlEncoded
    @POST("editarUsuario.php")
    Call<String> editarUsuario(
            @Field("id") int id,
            @Field("nombre_usuario") String nombre,
            @Field("apellidos_usuario") String apellido,
            @Field("usuario") String usuario,
            @Field("correo") String email,
            @Field("contraseña") String contra
    );
    /* BORRAR MASCOTA PERDIDA */
    @FormUrlEncoded
    @POST("borrarMascotaPerdida.php")
    Call<String> borrarMascotaPerdida(@Field("mascota_id") int mascotaId);

    /* BORRAR USUARIO */
    @FormUrlEncoded
    @POST("borrarUsuario.php")
    Call<String> borrarUsuario(@Field("id") int userId);

    /* BORRAR MASCOTA ENCONTRADA */
    @FormUrlEncoded
    @POST("borrarMascotaEncontrada.php")
    Call<String> borrarMascotaEncontrada(@Field("mascota_id") int mascotaId);

    /* OBTENER TODAS LAS MOSCATAS PERDIDAS DE UNA CIUDAD EN ESPECIFICO */
    @FormUrlEncoded
    @POST("getMascotasByCity.php")
    Call<List<Mascota>> getMascotasByCity(@Field("ciudad") String ciudad);

    /* OBTENER TODAS LAS MOSCATAS ENCONTRADAS DE UNA CIUDAD EN ESPECIFICO */
    @FormUrlEncoded
    @POST("getMascotasEncontradasByCity.php")
    Call<List<Mascota>> getMascotasEncontradasByCity(@Field("ciudad") String ciudad);


}