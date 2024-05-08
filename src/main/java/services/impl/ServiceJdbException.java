package services.impl;

public class ServiceJdbException extends RuntimeException{ //El serviceJdbcException es como un puente de comunicacion entre la clase service cuando ocurre un error
    //Y la clase conexionFilter para que realice el rollback, ocurre el error en service, se lanza la excepcion y la capturamos en el filtro para el rollback, es como lanzar la excepcion.
//Por eso no estamos obligados a usar el try catch en el servlet, pero si en el filtro
    public ServiceJdbException(String message) {
        super(message);
    }

    public ServiceJdbException(String message, Throwable cause) { //El mensaje y la causa
        super(message, cause);
    }
}
