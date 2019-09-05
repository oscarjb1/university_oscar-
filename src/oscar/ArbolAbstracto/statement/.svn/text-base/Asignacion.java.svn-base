/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.statement;

import oscar.ArbolAbstracto.Listas.VarDecList;
import oscar.ArbolAbstracto.expreciones.Exp;
import oscar.ArbolAbstracto.expreciones.False;
import oscar.ArbolAbstracto.expreciones.IdentificadorExp;
import oscar.ArbolAbstracto.expreciones.Plus;
import oscar.ArbolAbstracto.expreciones.True;
import oscar.ArbolAbstracto.otros.Identificador;
import oscar.ArbolAbstracto.otros.Programa;
import oscar.ArbolAbstracto.otros.VarDeclaracion;
import oscar.ArbolAbstracto.tipos.BooleanTipo;
import oscar.ArbolAbstracto.tipos.IntegerTipo;
import oscar.ArbolAbstracto.tipos.Tipo;

/**
 *
 * @author OSCAR
 */
public class Asignacion extends Statement{
    private Identificador identificador;
    private Exp exprecion;

    public Asignacion(Identificador identificador, Exp exprecion) {
        this.identificador = identificador;
        this.exprecion = exprecion;
    }
    
    public int eval(){
        Tipo tipo= Programa.getListaVariables().getVar(identificador.getId()).getTipo();
        if(tipo instanceof BooleanTipo){
            if(exprecion instanceof True | exprecion instanceof False){
                return 1;
            }
        }else if(tipo instanceof IntegerTipo){
            if(exprecion instanceof Plus){
                return 1;
            }
        }
        else if(exprecion instanceof IdentificadorExp){
            IdentificadorExp id = (IdentificadorExp) exprecion;
            VarDeclaracion var = Programa.getListaVariables().getVar(id.getId());
            if(tipo instanceof BooleanTipo & var.getTipo() instanceof BooleanTipo){
                return 1;
            }else if(tipo instanceof IntegerTipo & var.getTipo() instanceof IntegerTipo){
                return 1;
            }
        }
        return 0;
    }

    public Exp getEmprecion() {
        return exprecion;
    }

    public void setEmprecion(Exp emprecion) {
        this.exprecion = emprecion;
    }

    public Identificador getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Identificador identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString(){
        return "Asignacion( )\n"+identificador.toString()+exprecion.toString()+"\n";
    }
}
