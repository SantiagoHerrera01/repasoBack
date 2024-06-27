package com.proyectoRepaso.repasandingsapa.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Clase que define un DTO genérico para las respuestas de las peticiones a los
 * servicios Rest. Este encapsula el resultado del consumo de las Apis y le
 * adiciona atributos de control
 *
 * @param <T> Objeto de respuesta para las transacciones realizadas en cada Api
 * @author franklinriano@comfama.com.co
 * @version 1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    /**
     * Indica el estado de la transacción
     */
    private int status;

    /**
     * Mensaje informativo para el usuario
     */
    private String userMessage;

    /**
     * Mensaje informativo para los desarrolladores
     */
    private String developerMessage;

    /**
     * Código de error dentro del sistema
     */
    private String statusName;

    /**
     * Url para consultar más información acerca del error
     */
    private String moreInfo;

    /**
     * Objeto con la respuesta de la transacción
     */
    private T data;
}
