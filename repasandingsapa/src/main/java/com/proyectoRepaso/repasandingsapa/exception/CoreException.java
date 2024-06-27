package com.proyectoRepaso.repasandingsapa.exception;

/**
 * Excepción personalizada de ejemplo para el arquetipo de los micro-servicios.
 * Permite controlar definir excepciones propias de la aplicación
 *
 * @author estefanicarmona@comfama.com.co
 * @version 1.0
 */
public class CoreException extends Exception {

    /**
     * Serialize
     */
    private static final long serialVersionUID = 6365652257268547172L;
    /**
     * Mensaje informativo para el usuario
     */
    private final String userMessage;
    /**
     * Código que define el estado de la transacción
     */
    private final Integer status;

    /**
     * Método constructor
     */
    public CoreException(String developerMessage, String userMessage, int status, Throwable e) {
        super(developerMessage, e);
        this.userMessage = userMessage;
        this.status = status;
    }

    /**
     * Método constructor
     */
    public CoreException(String developerMessage, String userMessage, int status) {
        super(developerMessage);
        this.userMessage = userMessage;
        this.status = status;
    }

    /**
     * Método constructor
     */
    public CoreException(String userMessage, int state, Throwable e) {
        super(e);
        this.userMessage = userMessage;
        this.status = state;
    }

    /**
     * @return the userMessage
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * @return the state
     */
    public int getState() {
        return status;
    }

}
