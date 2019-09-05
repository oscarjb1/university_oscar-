/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oscar.ArbolAbstracto.otros;

import java.util.ArrayList;
import java.util.List;
import oscar.ArbolAbstracto.Listas.ExpList;
import oscar.ArbolAbstracto.Listas.StatementList;
import oscar.ArbolAbstracto.Listas.VarDecList;
import oscar.ArbolAbstracto.expreciones.Exp;
import oscar.ArbolAbstracto.statement.Statement;

public class Programa {
    private static VarDecList listaVariables = new VarDecList();
    private static StatementList listaStatement = new StatementList();
    private static ExpList listaExpreciones = new ExpList();

    private static List<Estatuto> estatutos = new ArrayList<Estatuto>();

    public Programa() {
    }

    public static void addDecVar(VarDeclaracion declracion){
        estatutos.add(declracion);
        listaVariables.addVar(declracion);
    }

    public static void addStatement(Statement statement){
        estatutos.add(statement);
        listaStatement.addStatement(statement);
    }

    public static void addExprecion(Exp exprecion){
        listaExpreciones.addStatement(exprecion);
    }

    public static int varSize(){
        return listaVariables.size();
    }

    public static int statementSize(){
        return listaStatement.size();
    }

    public static int expSize(){
        return listaExpreciones.size();
    }

    public static ExpList getListaExpreciones() {
        return listaExpreciones;
    }

    public static StatementList getListaStatement() {
        return listaStatement;
    }

    public static VarDecList getListaVariables() {
        return listaVariables;
    }

    public static List<Estatuto> getEstatutos() {
        return estatutos;
    }

    public static void setEstatutos(List<Estatuto> aEstatutos) {
        estatutos = aEstatutos;
    }
}