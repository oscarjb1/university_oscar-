/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.expreciones;

import oscar.ArbolAbstracto.otros.Programa;

/**
 *
 * @author OSCAR
 */
public class IdentificadorExp extends Exp{
    private String id;

    public IdentificadorExp(String id) {
        this.id = id;
    }
    
    /**
     * Regresa la posicion de la variable dentro del arreglo de 
     * variables o -1 si no se encontro nada
     * @return posicion de la variable, -1 si no se encontro nada
     */
    public int eval(){
        return Programa.getListaVariables().getVarIndex(Programa.getListaVariables().getVar(id));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "IdentificadorExp( )\n";
    }
}
