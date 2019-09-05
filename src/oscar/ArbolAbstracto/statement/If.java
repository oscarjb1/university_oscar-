/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.statement;

import oscar.ArbolAbstracto.expreciones.Exp;
import oscar.ArbolAbstracto.expreciones.False;
import oscar.ArbolAbstracto.expreciones.True;

/**
 *
 * @author OSCAR
 */
public class If extends Statement{
    private Exp exprecion;
    private Statement instruccion1;
    private Statement instruccion2;

    public If(Exp exprecion, Statement instruccion1, Statement instruccion2) {
        this.exprecion = exprecion;
        this.instruccion1 = instruccion1;
        this.instruccion2 = instruccion2;
    }
    
    public int eval(){
        if(exprecion instanceof True | exprecion instanceof False){
            return 1;
        }else{
            return 0;
        }
    }

    public Exp getExprecion() {
        return exprecion;
    }

    public void setExprecion(Exp exprecion) {
        this.exprecion = exprecion;
    }

    public Statement getInstruccion1() {
        return instruccion1;
    }

    public void setInstruccion1(Statement instruccion1) {
        this.instruccion1 = instruccion1;
    }

    public Statement getInstruccion2() {
        return instruccion2;
    }

    public void setInstruccion2(Statement instruccion2) {
        this.instruccion2 = instruccion2;
    }

    @Override
    public String toString(){
        return "If( )\n"+exprecion.toString()+instruccion1.toString()+instruccion2.toString()+"\n";
    }
}
