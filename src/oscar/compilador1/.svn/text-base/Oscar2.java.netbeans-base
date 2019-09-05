package oscar.compilador1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import oscar.ArbolAbstracto.expreciones.Comparacion;
import oscar.ArbolAbstracto.expreciones.Exp;
import oscar.ArbolAbstracto.expreciones.IdentificadorExp;
import oscar.ArbolAbstracto.expreciones.Plus;
import oscar.ArbolAbstracto.otros.Identificador;
import oscar.ArbolAbstracto.otros.Programa;
import oscar.ArbolAbstracto.otros.SemanticException;
import oscar.ArbolAbstracto.otros.VarDeclaracion;
import oscar.ArbolAbstracto.statement.Asignacion;
import oscar.ArbolAbstracto.statement.If;
import oscar.ArbolAbstracto.statement.Print;
import oscar.ArbolAbstracto.statement.Statement;
import oscar.ArbolAbstracto.tipos.BooleanTipo;
import oscar.ArbolAbstracto.tipos.IntegerTipo;
import oscar.ArbolAbstracto.tipos.Tipo;
import oscar.CodigoObjeto.GeneracionCodigoObjeto;
import oscar.compilador1.ParseException;

public class Oscar2 implements Oscar2Constants {

    public static void main(String args[]) throws ParseException, SemanticException, IOException {
        Oscar2 miParser = new Oscar2(System.in);

        miParser.programa();
    }

    final public void programa() throws ParseException, SemanticException, IOException {
        label_1:
        while (true) {
            if (!jj_2_1(3)) {
                break label_1;
            }
            if (jj_2_2(3)) {
                VarDeclaracion var = declaracionVariable();
                Programa.addDecVar(var);
            } else if (jj_2_3(3)) {
                Statement statement = statement();
                Programa.addStatement(statement);
            } else {
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
        jj_consume_token(0);
    }

    final public VarDeclaracion declaracionVariable() throws ParseException, SemanticException {
        VarDeclaracion var = null;
        Token tok = null;
        jj_consume_token(tipo);
        tok = token;
        jj_consume_token(id);

        //Validamos que no aya sido declara la variable con anterioridad
        //Si no la agregamos al arreglo de variables
        if (Programa.getListaVariables().conteinsKey(token.image)) {
            throw new SemanticException("--> El identificador '" + token.image + "' ya fue definido anteriormente\n\nError producido en la linea: " + tok.beginLine + " Columna: " + tok.beginColumn);
        } else {
            Tipo t = null;
            if (tok.image.equals("int")) {
                t = new IntegerTipo();
            } else {
                t = new BooleanTipo();
            }

            var = new VarDeclaracion(t, new Identificador(token.image));

        //-------------------------------------------------
        //Programa.getListaVariables().addVar(var);
        //-------------------------------------------------
        }

        jj_consume_token(12);
        return var;
    }

    final public Exp exprecion() throws ParseException, SemanticException {
        VarDeclaracion var1 = null;
        VarDeclaracion var2 = null;
        Token tok = null;

        if (jj_2_4(3)) {
            jj_consume_token(id);
            if (!Programa.getListaVariables().conteinsKey(token.image)) {
                throw new SemanticException("Identificador '" + token.image + "' no definido\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
            }
            var1 = Programa.getListaVariables().getVar(token.image);
            jj_consume_token(op);
            tok = token;
            jj_consume_token(id);
            if (!Programa.getListaVariables().conteinsKey(token.image)) {
                throw new SemanticException("Identificador '" + token.image + "' no definido\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
            }
            var2 = Programa.getListaVariables().getVar(token.image);

            if (tok.image.equals("+")) {
                if (!(var1.getTipo() instanceof IntegerTipo & var2.getTipo() instanceof IntegerTipo)) {
                    throw new SemanticException("--> Tipos incompatibles - Linea: " + token.beginLine + " Columna: " + token.beginColumn);
                }
                return new Plus(new IdentificadorExp(var1.getId().getId()), new IdentificadorExp(var2.getId().getId()));
            } else if (tok.image.equals("==")) {
                if ((var1.getTipo() instanceof BooleanTipo & var2.getTipo() instanceof IntegerTipo) | (var1.getTipo() instanceof IntegerTipo & var2.getTipo() instanceof BooleanTipo)) {
                    throw new SemanticException("--> Tipos incompatibles - Linea: " + token.beginLine + " Columna: " + token.beginColumn);
                }

                return new Comparacion(new IdentificadorExp(var1.getId().getId()), new IdentificadorExp(var2.getId().getId()));
            }
        } else if (jj_2_5(3)) {
            jj_consume_token(id);
            if (!Programa.getListaVariables().conteinsKey(token.image)) {
                throw new SemanticException("Identificador '" + token.image + "' no definido\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
            }
            return new IdentificadorExp(token.image);

        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
        return null;
    }

    final public Statement statement() throws ParseException, SemanticException {
        Token tok = null;

        if (jj_2_6(3)) {
            If statementIf = null;
            jj_consume_token(ifs);
            jj_consume_token(parIzquierdo);
            tok = token;
            Exp exp = exprecion();

            //---------------------------------------
            //Programa.addExprecion(exp);
            //---------------------------------------

            if (!(exp instanceof Comparacion | exp instanceof IdentificadorExp)) {
                throw new SemanticException("--> Se esperaba booleano\n\nLinea: " + tok.beginLine + " Columna: " + tok.beginColumn);
            } else if (exp instanceof Comparacion) {
                if (exp.eval() == 0) {
                    throw new SemanticException("--> Se encontraron tipo incompatibles\n\nLinea: " + tok.beginLine + " Columna: " + tok.beginColumn);
                }
            } else if (exp instanceof IdentificadorExp) {
                IdentificadorExp id = (IdentificadorExp) exp;
                VarDeclaracion var = Programa.getListaVariables().getVar(id.getId());
                if (!(var.getTipo() instanceof BooleanTipo)) {
                    throw new SemanticException("--> Se esperaba booleano\n\nLinea: " + tok.beginLine + " Columna: " + tok.beginColumn);
                }
            }

            jj_consume_token(parDerecho);
            Statement statement1 = statement();

            //------------------------------------------
            //Programa.addStatement(statement1);
            //------------------------------------------

            jj_consume_token(elses);

            Statement statement2 = statement();

            //------------------------------------------
            //Programa.addStatement(statement2);
            //------------------------------------------

            statementIf = new If(exp, statement1, statement2);
            return statementIf;
        } else if (jj_2_7(3)) {
            jj_consume_token(13);
            jj_consume_token(parIzquierdo);
            Exp exprecion = exprecion();

            //------------------------------------------
            //Programa.addExprecion(exprecion);
            //------------------------------------------

            jj_consume_token(parDerecho);
            jj_consume_token(12);
            Print print = new Print(exprecion);
            return print;
        } else if (jj_2_8(3)) {
            VarDeclaracion var = null;
            jj_consume_token(id);
            if (!Programa.getListaVariables().conteinsKey(token.image)) {
                throw new SemanticException("Identificador '" + token.image + "' no definido\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
            }
            var = Programa.getListaVariables().getVar(token.image);
            jj_consume_token(14);
            Exp exprecion = exprecion();

            //----------------------------------------
            //Programa.addExprecion(exprecion);
            //----------------------------------------

            if (var.getTipo() instanceof BooleanTipo) {
                if (!(exprecion instanceof Comparacion | exprecion instanceof IdentificadorExp)) {
                    throw new SemanticException("--> Se encontraron tipo incompatibles, Se esperaba booleano como resultado\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
                }
                if (exprecion instanceof Comparacion) {
                    if (exprecion.eval() == 0) {
                        throw new SemanticException("--> Se encontraron tipo incompatibles\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
                    }
                } else if (exprecion instanceof IdentificadorExp) {
                    IdentificadorExp identi = (IdentificadorExp) exprecion;
                    VarDeclaracion variable = Programa.getListaVariables().getVar(identi.getId());
                    if (!(variable.getTipo() instanceof BooleanTipo)) {
                        throw new SemanticException("--> Se encontraron tipo incompatibles\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
                    }
                }
            } else if (var.getTipo() instanceof IntegerTipo) {
                if (!(exprecion instanceof Plus | exprecion instanceof IdentificadorExp)) {
                    throw new SemanticException("--> Se encontraron tipo incompatibles, Se esperaba Entero como resultado\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
                }
                if (exprecion instanceof Plus) {
                    ;
                } else if (exprecion instanceof IdentificadorExp) {
                    IdentificadorExp identi = (IdentificadorExp) exprecion;
                    VarDeclaracion variable = Programa.getListaVariables().getVar(identi.getId());
                    if (!(variable.getTipo() instanceof IntegerTipo)) {
                        throw new SemanticException("--> Se encontraron tipo incompatibles\n\nLinea: " + token.beginLine + " Columna: " + token.beginColumn);
                    }
                }
            }
            //---------------------------
            //---------------------------
            jj_consume_token(12);
            Asignacion asignacion = new Asignacion(var.getId(), exprecion);
            return asignacion;
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    private boolean jj_2_1(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_1();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(0, xla);
        }
    }

    private boolean jj_2_2(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(1, xla);
        }
    }

    private boolean jj_2_3(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_3();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(2, xla);
        }
    }

    private boolean jj_2_4(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_4();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(3, xla);
        }
    }

    private boolean jj_2_5(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_5();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(4, xla);
        }
    }

    private boolean jj_2_6(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_6();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(5, xla);
        }
    }

    private boolean jj_2_7(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_7();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(6, xla);
        }
    }

    private boolean jj_2_8(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_8();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(7, xla);
        }
    }

    private boolean jj_3_8() {
        if (jj_scan_token(id)) {
            return true;
        }
        if (jj_scan_token(14)) {
            return true;
        }
        if (jj_3R_4()) {
            return true;
        }
        return false;
    }

    private boolean jj_3_7() {
        if (jj_scan_token(13)) {
            return true;
        }
        if (jj_scan_token(parIzquierdo)) {
            return true;
        }
        if (jj_3R_4()) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_3() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_6()) {
            jj_scanpos = xsp;
            if (jj_3_7()) {
                jj_scanpos = xsp;
                if (jj_3_8()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean jj_3_6() {
        if (jj_scan_token(ifs)) {
            return true;
        }
        if (jj_scan_token(parIzquierdo)) {
            return true;
        }
        if (jj_3R_4()) {
            return true;
        }
        return false;
    }

    private boolean jj_3_5() {
        if (jj_scan_token(id)) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_4() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_4()) {
            jj_scanpos = xsp;
            if (jj_3_5()) {
                return true;
            }
        }
        return false;
    }

    private boolean jj_3_4() {
        if (jj_scan_token(id)) {
            return true;
        }
        if (jj_scan_token(op)) {
            return true;
        }
        if (jj_scan_token(id)) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_2() {
        if (jj_scan_token(tipo)) {
            return true;
        }
        if (jj_scan_token(id)) {
            return true;
        }
        if (jj_scan_token(12)) {
            return true;
        }
        return false;
    }

    private boolean jj_3_3() {
        if (jj_3R_3()) {
            return true;
        }
        return false;
    }

    private boolean jj_3_1() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_2()) {
            jj_scanpos = xsp;
            if (jj_3_3()) {
                return true;
            }
        }
        return false;
    }

    private boolean jj_3_2() {
        if (jj_3R_2()) {
            return true;
        }
        return false;
    }
    /** Generated Token Manager. */
    public Oscar2TokenManager token_source;
    SimpleCharStream jj_input_stream;
    /** Current token. */
    public Token token;
    /** Next token. */
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos,  jj_lastpos;
    private int jj_la;
    private int jj_gen;
    final private int[] jj_la1 = new int[0];
    static private int[] jj_la1_0;


    static {
        jj_la1_init_0();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{};
    }
    final private JJCalls[] jj_2_rtns = new JJCalls[8];
    private boolean jj_rescan = false;
    private int jj_gc = 0;

    /** Constructor with InputStream. */
    public Oscar2(java.io.InputStream stream) {
        this(stream, null);
    }

    /** Constructor with InputStream and supplied encoding */
    public Oscar2(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new Oscar2TokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /** Reinitialise. */
    public void ReInit(java.io.InputStream stream) {
        ReInit(stream, null);
    }

    /** Reinitialise. */
    public void ReInit(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream.ReInit(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /** Constructor. */
    public Oscar2(java.io.Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new Oscar2TokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /** Reinitialise. */
    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /** Constructor with generated Token Manager. */
    public Oscar2(Oscar2TokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /** Reinitialise. */
    public void ReInit(Oscar2TokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            if (++jj_gc > 100) {
                jj_gc = 0;
                for (int i = 0; i < jj_2_rtns.length; i++) {
                    JJCalls c = jj_2_rtns[i];
                    while (c != null) {
                        if (c.gen < jj_gen) {
                            c.first = null;
                        }
                        c = c.next;
                    }
                }
            }
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    static private final class LookaheadSuccess extends java.lang.Error {
    }
    final private LookaheadSuccess jj_ls = new LookaheadSuccess();

    private boolean jj_scan_token(int kind) {
        if (jj_scanpos == jj_lastpos) {
            jj_la--;
            if (jj_scanpos.next == null) {
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
            } else {
                jj_lastpos = jj_scanpos = jj_scanpos.next;
            }
        } else {
            jj_scanpos = jj_scanpos.next;
        }
        if (jj_rescan) {
            int i = 0;
            Token tok = token;
            while (tok != null && tok != jj_scanpos) {
                i++;
                tok = tok.next;
            }
            if (tok != null) {
                jj_add_error_token(kind, i);
            }
        }
        if (jj_scanpos.kind != kind) {
            return true;
        }
        if (jj_la == 0 && jj_scanpos == jj_lastpos) {
            throw jj_ls;
        }
        return false;
    }

    /** Get the next Token. */
    final public Token getNextToken() {
        if (token.next != null) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    /** Get the specific Token. */
    final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) {
                t = t.next;
            } else {
                t = t.next = token_source.getNextToken();
            }
        }
        return t;
    }

    private int jj_ntk() {
        if ((jj_nt = token.next) == null) {
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        } else {
            return (jj_ntk = jj_nt.kind);
        }
    }
    private java.util.List jj_expentries = new java.util.ArrayList();
    private int[] jj_expentry;
    private int jj_kind = -1;
    private int[] jj_lasttokens = new int[100];
    private int jj_endpos;

    private void jj_add_error_token(int kind, int pos) {
        if (pos >= 100) {
            return;
        }
        if (pos == jj_endpos + 1) {
            jj_lasttokens[jj_endpos++] = kind;
        } else if (jj_endpos != 0) {
            jj_expentry = new int[jj_endpos];
            for (int i = 0; i < jj_endpos; i++) {
                jj_expentry[i] = jj_lasttokens[i];
            }
            jj_entries_loop:
            for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
                int[] oldentry = (int[]) (it.next());
                if (oldentry.length == jj_expentry.length) {
                    for (int i = 0; i < jj_expentry.length; i++) {
                        if (oldentry[i] != jj_expentry[i]) {
                            continue jj_entries_loop;
                        }
                    }
                    jj_expentries.add(jj_expentry);
                    break jj_entries_loop;
                }
            }
            if (pos != 0) {
                jj_lasttokens[(jj_endpos = pos) - 1] = kind;
            }
        }
    }

    /** Generate ParseException. */
    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[15];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 0; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 15; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = (int[]) jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    /** Enable tracing. */
    final public void enable_tracing() {
    }

    /** Disable tracing. */
    final public void disable_tracing() {
    }

    private void jj_rescan_token() {
        jj_rescan = true;
        for (int i = 0; i < 8; i++) {
            try {
                JJCalls p = jj_2_rtns[i];
                do {
                    if (p.gen > jj_gen) {
                        jj_la = p.arg;
                        jj_lastpos = jj_scanpos = p.first;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                            case 2:
                                jj_3_3();
                                break;
                            case 3:
                                jj_3_4();
                                break;
                            case 4:
                                jj_3_5();
                                break;
                            case 5:
                                jj_3_6();
                                break;
                            case 6:
                                jj_3_7();
                                break;
                            case 7:
                                jj_3_8();
                                break;
                        }
                    }
                    p = p.next;
                } while (p != null);
            } catch (LookaheadSuccess ls) {
            }
        }
        jj_rescan = false;
    }

    private void jj_save(int index, int xla) {
        JJCalls p = jj_2_rtns[index];
        while (p.gen > jj_gen) {
            if (p.next == null) {
                p = p.next = new JJCalls();
                break;
            }
            p = p.next;
        }
        p.gen = jj_gen + xla - jj_la;
        p.first = token;
        p.arg = xla;
    }

    static final class JJCalls {

        int gen;
        Token first;
        int arg;
        JJCalls next;
    }
}
