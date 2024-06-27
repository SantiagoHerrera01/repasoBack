package com.proyectoRepaso.repasandingsapa.util;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.proyectoRepaso.repasandingsapa.domain.Response;
import com.proyectoRepaso.repasandingsapa.exception.CoreException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;


/**
 * Clase donde se definen métodos utilitarios para conversiones generales
 *
 * @author estefanicarmona@comfama.com.co
 * @version 1.0
 */
@Slf4j
public class Util {


    private Util() {

    }

    /**
     * Permite parsear un Objeto con estructura json en un String con estructura json
     *
     * @param odRespBody Objeto con estructura json
     * @return Cadena de texto con estructura json
     */
    public static String parseBodyToString(Object odRespBody) {
        var odRespBodyStr = "";
        if (odRespBody.toString().contains("{\"") || odRespBody.toString().contains("{ \"")) {
            odRespBodyStr = odRespBody.toString();
        } else {
            odRespBodyStr = new Gson().toJson(odRespBody);
        }
        return odRespBodyStr;
    }

    public static void validateErrorApiManager(HttpClientErrorException ex) throws CoreException {
        var gson = new Gson();
        var apiManagerError = gson.fromJson(ex.getResponseBodyAsString(), JsonObject.class);
        if (apiManagerError.get("fault") != null) {
            log.error("Error en validateErrorApiManager: " + ex.getMessage(), ex);
            var fault = apiManagerError.get("fault").getAsJsonObject();
            var errorDetail = fault.get("faultstring").getAsString();
            throw new CoreException(ex.getMessage(), errorDetail, ex.getStatusCode().value(), ex.getCause());
        }
    }

    public static CoreException validateErrorRightsChecker(HttpClientErrorException ex) {
        var gson = new Gson();
        var apiManagerError = gson.fromJson(ex.getResponseBodyAsString(), JsonObject.class);
        log.error("Error en validateErrorRightsChecker: " + ex.getMessage(), ex);
        var errorDev = apiManagerError.get("Error").getAsString();
        var errorDev1 = apiManagerError.get("ErrorCode").getAsString();
        return new CoreException(errorDev, errorDev1, ex.getStatusCode().value(), ex.getCause());
    }

    public static CoreException validateError(Exception ex, String msg) {
        if (ex instanceof CoreException) {
            return (CoreException) ex;
        }
        log.error("Error en validateError: " + ex.getMessage(), ex);
        return new CoreException(ex.getMessage(), msg, 500, ex.getCause());
    }

    public static Response<Object> setResponse(String msgDev, String msgUser, Object data, Integer statusCode) {
        if (statusCode == null) {
            statusCode = 500;
        }
        var status = HttpStatus.valueOf(statusCode);
        Response<Object> response = new Response<>();
        response.setStatus(status.value());
        response.setStatusName(status.name());
        response.setUserMessage(msgUser);
        response.setDeveloperMessage(msgDev);
        response.setData(data);
        return response;
    }
}
