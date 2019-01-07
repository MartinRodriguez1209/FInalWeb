/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.exc;

/**
 *
 * @author User
 */
public class UserAlreadyTaken extends Exception {

    /**
     * Creates a new instance of <code>UserAlreadyTaken</code> without detail
     * message.
     */
    public UserAlreadyTaken() {
    }

    /**
     * Constructs an instance of <code>UserAlreadyTaken</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserAlreadyTaken(String msg) {
        super(msg);
    }
}
