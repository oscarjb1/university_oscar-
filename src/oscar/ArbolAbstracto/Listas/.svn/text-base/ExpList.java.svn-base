/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.Listas;

import java.util.ArrayList;
import java.util.List;
import oscar.ArbolAbstracto.expreciones.Exp;


/**
 *
 * @author OSCAR
 */
public class ExpList extends Lista{
    private List<Exp> listaExpreciones = new ArrayList<Exp>();

    public boolean empty(){
        return listaExpreciones.isEmpty();
    }

    public void addStatement(Exp exprecion){
        listaExpreciones.add(exprecion);
    }

    public int size(){
        return listaExpreciones.size();
    }

    public boolean findStatement(Exp exprecion){
        return listaExpreciones.contains(exprecion);
    }

    public void clear(){
        listaExpreciones.clear();
    }
}
