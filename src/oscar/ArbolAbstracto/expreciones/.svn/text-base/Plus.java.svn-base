/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.expreciones;

/**
 *
 * @author OSCAR
 */
public class Plus extends Exp{
    private Exp exprecion1;
    private Exp exprecion2;

    public Plus(Exp exprecion1, Exp exprecion2) {
        this.exprecion1 = exprecion1;
        this.exprecion2 = exprecion2;
    }
    
    public int eval(){
        return exprecion1.eval()+exprecion2.eval();
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
        return "Plus( )\n"+exprecion1.toString()+exprecion2.toString()+"\n";
    }
}