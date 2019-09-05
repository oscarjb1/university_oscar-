/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.statement;

import oscar.ArbolAbstracto.expreciones.Exp;

/**
 *
 * @author OSCAR
 */
public class Print extends Statement{
    private Exp exprecion;

    public Print(Exp exprecion) {
        this.exprecion = exprecion;
    }
    
    public int eval(){
        return 1;
    }

    public Exp getEmprecion() {
        return exprecion;
    }

    public void setEmprecion(Exp emprecion) {
        this.exprecion = emprecion;
    }

    @Override
    public String toString(){
        return "Print( )\n"+exprecion.toString()+"\n";
    }
}
