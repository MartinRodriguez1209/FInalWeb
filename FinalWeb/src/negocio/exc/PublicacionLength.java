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
public class PublicacionLength extends Exception {

    /**
     * Creates a new instance of <code>PublicacionLength</code> without detail
     * message.
     */
    public PublicacionLength() {
    }

    /**
     * Constructs an instance of <code>PublicacionLength</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PublicacionLength(String msg) {
        super(msg);
    }
}
