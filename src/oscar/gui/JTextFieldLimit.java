package oscar.gui;

import javax.swing.JTextArea;
import javax.swing.text.*;

public class JTextFieldLimit extends PlainDocument {
    private JTextArea areaTexto;

    public JTextFieldLimit(JTextArea areaTexto) {
        super();
        this.putProperty(PlainDocument.tabSizeAttribute, new Integer(2));
        this.areaTexto = areaTexto;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        boolean regresar=false;
        if(str.equals("{")){
            str+="  }";
            regresar = true;
        }else if(str.equals("(")){
            str+="  )";
            regresar = true;
        }

        super.insertString(offset, str, attr);
        if(regresar){
            areaTexto.setCaretPosition(areaTexto.getCaretPosition()-2);
        }
    }
}  