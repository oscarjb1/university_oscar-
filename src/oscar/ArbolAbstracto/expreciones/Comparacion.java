/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.expreciones;

import oscar.ArbolAbstracto.Listas.VarDecList;
import oscar.ArbolAbstracto.otros.Programa;
import oscar.ArbolAbstracto.otros.VarDeclaracion;
import oscar.ArbolAbstracto.tipos.BooleanTipo;
import oscar.ArbolAbstracto.tipos.IntegerTipo;

/**
 *
 * @author OSCAR
 */
public class Comparacion extends Exp{
    private Exp exprecion1;
    private Exp exprecion2;

    public Comparacion(Exp exprecion1, Exp exprecion2) {
        this.exprecion1 = exprecion1;
        this.exprecion2 = exprecion2;
    }
     
    public int eval(){
        if( (exprecion1 instanceof IdentificadorExp | exprecion2 instanceof IdentificadorExp)){
            IdentificadorExp exp1 = (IdentificadorExp) exprecion1;
            IdentificadorExp exp2 = (IdentificadorExp) exprecion2;
            VarDeclaracion dec1 = Programa.getListaVariables().getVar(exp1.getId());
            VarDeclaracion dec2 = Programa.getListaVariables().getVar(exp2.getId());
            if(dec1.getTipo() instanceof BooleanTipo && dec2.getTipo() instanceof BooleanTipo){
                return 1;
            }else if(dec1.getTipo() instanceof IntegerTipo && dec2.getTipo() instanceof IntegerTipo){
                return 1;
            }
        }

        return 0;
    }

    public Exp getExprecion1() {
        return exprecion1;
    }

    public void setExprecion1(Exp exprecion1) {
        this.exprecion1 = exprecion1;
    }

    public Exp getExprecion2() {
        return exprecion2;
    }

    public void setExprecion2(Exp exprecion2) {
        this.exprecion2 = exprecion2;
    }

    @Override
    public String toString(){
        return "Compracion( )\n"+exprecion1.toString()+exprecion2.toString()+"\n\n";
    }
}
