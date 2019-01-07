/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.exc;

/**
 *
 * @author User
 */
public class BadCredentialsException extends Exception {

    /**
     * Creates a new instance of <code>BadCredentialsException</code> without
     * detail message.
     */
    public BadCredentialsException() {
    }

    /**
     * Constructs an instance of <code>BadCredentialsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadCredentialsException(String msg) {
        super(msg);
    }
}
