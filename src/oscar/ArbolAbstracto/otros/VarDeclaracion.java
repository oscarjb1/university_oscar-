/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.otros;

import oscar.ArbolAbstracto.tipos.Tipo;

/**
 *
 * @author OSCAR
 */
public class VarDeclaracion extends Estatuto{
    private Tipo tipo;
    private Identificador id;

    public VarDeclaracion(Tipo tipo, Identificador id) {
        this.tipo = tipo;
        this.id = id;
    }

    public Identificador getId() {
        return id;
    }

    public void setId(Identificador id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "VarDeclaracion( )\n"+tipo.toString()+id.toString()+"\n";
    }
}
