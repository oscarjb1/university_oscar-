/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.otros;

/**
 *
 * @author OSCAR
 */
public class SemanticException extends Exception {

    /**
     * Creates a new instance of <code>SemanticException</code> without detail message.
     */
    public SemanticException() {
    }


    /**
     * Constructs an instance of <code>SemanticException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SemanticException(String msg) {
        super(msg);
    }
}
