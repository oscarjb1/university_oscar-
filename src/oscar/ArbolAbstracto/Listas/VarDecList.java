/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.Listas;

import java.util.ArrayList;
import java.util.List;
import oscar.ArbolAbstracto.otros.VarDeclaracion;

/**
 *
 * @author OSCAR
 */
public class VarDecList {
    public List<VarDeclaracion> listaVariables = new ArrayList<VarDeclaracion>();
    
    /**
     * Agregar una nueva declracion de variable
     * @param declaracion
     */
    public void addVar(VarDeclaracion declaracion){
        listaVariables.add(declaracion);
    }
    
    /**
     * Valida si un declaracion de una variable no fue previamente definida
     * @param declaracion
     * @return true si contiene la delcracion
     */
    public boolean conteinsKey(String identificador){
        for (VarDeclaracion var : listaVariables) {
            if(var.getId().getId().equals(identificador)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Regresa la declaracion por medio de si identificador
     * @param id
     * @return null si no encuentra nada
     */
    public VarDeclaracion getVar(String id){
        for (VarDeclaracion var : listaVariables) {
            if(var.getId().getId().equals(id)){
                return var;
            }
        }
        return null;
    }
    
    /**
     * Regresa el indise donde se encuentra guardado la declaracion
     * @param declaracion
     * @return index dentro del arreglo donde se encuentra la variable
     *          regresa -1 si no lo encontro
     */
    public int getVarIndex(VarDeclaracion declaracion){
        return listaVariables.indexOf(declaracion);
    }

    public void clear(){
        listaVariables.clear();
    }

    public int size(){
        return listaVariables.size();
    }
}
