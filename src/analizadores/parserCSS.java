
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import java_cup.runtime.*;
import CSS.*;
import java.util.LinkedList;
import proyecto1.Reporte;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parserCSS extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym2.class;
}

  /** Default constructor. */
  @Deprecated
  public parserCSS() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parserCSS(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parserCSS(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\011\002\000\002\004\007" +
    "\000\002\004\007\000\002\007\004\000\002\007\003\000" +
    "\002\010\006\000\002\010\006\000\002\010\006\000\002" +
    "\010\006\000\002\010\006\000\002\010\006\000\002\010" +
    "\006\000\002\010\006\000\002\010\006\000\002\010\006" +
    "\000\002\005\003\000\002\005\003\000\002\005\012\000" +
    "\002\006\003\000\002\006\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\106\000\006\006\004\031\010\001\002\000\004\031" +
    "\105\001\002\000\010\002\ufffe\006\ufffe\031\ufffe\001\002" +
    "\000\010\002\000\006\004\031\010\001\002\000\004\002" +
    "\103\001\002\000\004\005\ufffd\001\002\000\004\005\012" +
    "\001\002\000\026\013\013\014\020\015\025\016\023\017" +
    "\022\020\016\021\017\022\021\023\024\024\014\001\002" +
    "\000\004\011\100\001\002\000\004\011\075\001\002\000" +
    "\030\004\073\013\013\014\020\015\025\016\023\017\022" +
    "\020\016\021\017\022\021\023\024\024\014\001\002\000" +
    "\004\011\070\001\002\000\004\011\065\001\002\000\004" +
    "\011\062\001\002\000\004\011\057\001\002\000\004\011" +
    "\054\001\002\000\004\011\051\001\002\000\004\011\044" +
    "\001\002\000\004\011\027\001\002\000\030\004\ufff9\013" +
    "\ufff9\014\ufff9\015\ufff9\016\ufff9\017\ufff9\020\ufff9\021\ufff9" +
    "\022\ufff9\023\ufff9\024\ufff9\001\002\000\010\025\032\031" +
    "\033\032\031\001\002\000\004\012\043\001\002\000\004" +
    "\012\uffee\001\002\000\004\007\034\001\002\000\004\012" +
    "\uffed\001\002\000\004\034\035\001\002\000\004\033\036" +
    "\001\002\000\004\034\037\001\002\000\004\033\040\001" +
    "\002\000\004\034\041\001\002\000\004\010\042\001\002" +
    "\000\004\012\uffec\001\002\000\030\004\ufff6\013\ufff6\014" +
    "\ufff6\015\ufff6\016\ufff6\017\ufff6\020\ufff6\021\ufff6\022\ufff6" +
    "\023\ufff6\024\ufff6\001\002\000\006\031\047\034\046\001" +
    "\002\000\004\012\050\001\002\000\004\012\uffeb\001\002" +
    "\000\004\012\uffea\001\002\000\030\004\ufff0\013\ufff0\014" +
    "\ufff0\015\ufff0\016\ufff0\017\ufff0\020\ufff0\021\ufff0\022\ufff0" +
    "\023\ufff0\024\ufff0\001\002\000\006\031\047\034\046\001" +
    "\002\000\004\012\053\001\002\000\030\004\ufff5\013\ufff5" +
    "\014\ufff5\015\ufff5\016\ufff5\017\ufff5\020\ufff5\021\ufff5\022" +
    "\ufff5\023\ufff5\024\ufff5\001\002\000\004\027\055\001\002" +
    "\000\004\012\056\001\002\000\030\004\ufff4\013\ufff4\014" +
    "\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4\021\ufff4\022\ufff4" +
    "\023\ufff4\024\ufff4\001\002\000\010\025\032\031\033\032" +
    "\031\001\002\000\004\012\061\001\002\000\030\004\ufff1" +
    "\013\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1\020\ufff1\021" +
    "\ufff1\022\ufff1\023\ufff1\024\ufff1\001\002\000\004\026\063" +
    "\001\002\000\004\012\064\001\002\000\030\004\ufff8\013" +
    "\ufff8\014\ufff8\015\ufff8\016\ufff8\017\ufff8\020\ufff8\021\ufff8" +
    "\022\ufff8\023\ufff8\024\ufff8\001\002\000\006\031\047\034" +
    "\046\001\002\000\004\012\067\001\002\000\030\004\ufff2" +
    "\013\ufff2\014\ufff2\015\ufff2\016\ufff2\017\ufff2\020\ufff2\021" +
    "\ufff2\022\ufff2\023\ufff2\024\ufff2\001\002\000\004\030\071" +
    "\001\002\000\004\012\072\001\002\000\030\004\ufff3\013" +
    "\ufff3\014\ufff3\015\ufff3\016\ufff3\017\ufff3\020\ufff3\021\ufff3" +
    "\022\ufff3\023\ufff3\024\ufff3\001\002\000\010\002\ufffc\006" +
    "\ufffc\031\ufffc\001\002\000\030\004\ufffa\013\ufffa\014\ufffa" +
    "\015\ufffa\016\ufffa\017\ufffa\020\ufffa\021\ufffa\022\ufffa\023" +
    "\ufffa\024\ufffa\001\002\000\006\031\047\034\046\001\002" +
    "\000\004\012\077\001\002\000\030\004\uffef\013\uffef\014" +
    "\uffef\015\uffef\016\uffef\017\uffef\020\uffef\021\uffef\022\uffef" +
    "\023\uffef\024\uffef\001\002\000\010\025\032\031\033\032" +
    "\031\001\002\000\004\012\102\001\002\000\030\004\ufff7" +
    "\013\ufff7\014\ufff7\015\ufff7\016\ufff7\017\ufff7\020\ufff7\021" +
    "\ufff7\022\ufff7\023\ufff7\024\ufff7\001\002\000\004\002\001" +
    "\001\002\000\010\002\uffff\006\uffff\031\uffff\001\002\000" +
    "\004\005\106\001\002\000\026\013\013\014\020\015\025" +
    "\016\023\017\022\020\016\021\017\022\021\023\024\024" +
    "\014\001\002\000\030\004\110\013\013\014\020\015\025" +
    "\016\023\017\022\020\016\021\017\022\021\023\024\024" +
    "\014\001\002\000\010\002\ufffb\006\ufffb\031\ufffb\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\106\000\010\002\006\003\005\004\004\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\004\103\001\001" +
    "\000\002\001\001\000\004\011\010\001\001\000\002\001" +
    "\001\000\006\007\014\010\025\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\010\073\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\005\027\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\006\044" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\006\051\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\005\057\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\006\065\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\006\075\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\005\100\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\007\106\010\025\001\001\000\004\010\073" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parserCSS$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parserCSS$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parserCSS$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  
    String estiloActual="";
    public void syntax_error(Symbol s){ 
            System.err.println("[CSS] No se esperaba este componente: " + s.value + " linea: "+s.left+" columna: "+s.right);
            Reporte.agregarReporte(new Reporte("Sintactico", "[CSS] No se esperaba este componente: " + s.value, s.left,s.right));
           } 
   
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
       
      System.err.println(s.value + " error falta");
     
    }

    private String ConvertirRGB(int r, int g , int b){
        return String.format("#%02x%02x%02x", r, g, b); 
    }
    private String ConvertirColor(String color) {
        switch (color) {
            case "red": {
                return "#ff3333";
            }
            case "pink": {
                return "#ff0080";
            }
            case "orange": {
                return "#ffb266";
            }
            case "yellow": {
                return "#ffff66";
            }
            case "purple": {
                return "#cc00cc";
            }
            case "magenta": {
                return "#f50087";
            }
            case "green": {
                return "#9ff781";
            }
            case "blue": {
                return "#3333ff";
            }
            case "brown": {
                return "#994c00";
            }
            case "white": {
                return "#ffffff";
            }
            case "gray": {
                return "#c0c0c0";
            }
            case "black": {
                return "#202020";
            } 
        }
        return "#CCCCFF";
    }
  


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parserCSS$actions {
  private final parserCSS parser;

  /** Constructor */
  CUP$parserCSS$actions(parserCSS parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parserCSS$do_action_part00000000(
    int                        CUP$parserCSS$act_num,
    java_cup.runtime.lr_parser CUP$parserCSS$parser,
    java.util.Stack            CUP$parserCSS$stack,
    int                        CUP$parserCSS$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parserCSS$result;

      /* select the action based on the action number */
      switch (CUP$parserCSS$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		RESULT = start_val;
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parserCSS$parser.done_parsing();
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= L_COMPONENTE 
            {
              String RESULT =null;

              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // L_COMPONENTE ::= L_COMPONENTE COMPONENTE 
            {
              String RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String l = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		 RESULT = l+a+"\n"; 
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("L_COMPONENTE",1, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // L_COMPONENTE ::= COMPONENTE 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		RESULT =a+"\n";
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("L_COMPONENTE",1, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // NT$0 ::= 
            {
              String RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
estiloActual=id;
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("NT$0",7, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // COMPONENTE ::= id NT$0 llaveIzq L_PROPIEDAD llaveDer 
            {
              String RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (String) ((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-4)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-4)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-4)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		LinkedList<AtributoCSS> l = (LinkedList<AtributoCSS>)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                      CSS.addEstilo(new CSS(id, l)); 
                                                   //   RESULT = id+"{\n"+l+"\n}\n";
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("COMPONENTE",2, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-4)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // COMPONENTE ::= punto id llaveIzq L_PROPIEDAD llaveDer 
            {
              String RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		LinkedList<AtributoCSS> l = (LinkedList<AtributoCSS>)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        for (int i = 0; i < CSS.estilos.size(); i++) {
                                            if (CSS.estilos.get(i).id.equals(estiloActual)) {
                                                CSS.estilos.get(i).agregarSubEstilo(new CSS(id, l));
                                            }
                                        }                                        
                                       // RESULT = "."+id+"{\n"+l+"\n}\n";
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("COMPONENTE",2, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-4)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // L_PROPIEDAD ::= L_PROPIEDAD PROPIEDAD 
            {
              LinkedList<AtributoCSS> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		LinkedList<AtributoCSS> a = (LinkedList<AtributoCSS>)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		AtributoCSS b = (AtributoCSS)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		
                                        //RESULT =l+a+"\n";
                                        RESULT = a; RESULT.add(b);
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("L_PROPIEDAD",5, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // L_PROPIEDAD ::= PROPIEDAD 
            {
              LinkedList<AtributoCSS> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		AtributoCSS a = (AtributoCSS)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		
                                        RESULT = new LinkedList<>(); RESULT.add(a);
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("L_PROPIEDAD",5, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // PROPIEDAD ::= border dospuntos tf pyc 
            {
              AtributoCSS RESULT =null;
		int tfleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int tfright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String tf = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                       // RESULT = "border :"+tf;
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.existeBorde, new Nodo("BOOLEAN",tf,tfleft,tfright));
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // PROPIEDAD ::= background dospuntos COLOR pyc 
            {
              AtributoCSS RESULT =null;
		int fondoleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int fondoright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String fondo = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        //RESULT = "background :"+fondo;
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.fondo, new Nodo("STRING",fondo,fondoleft,fondoright));

                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // PROPIEDAD ::= border_color dospuntos COLOR pyc 
            {
              AtributoCSS RESULT =null;
		int color_bordeleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int color_borderight = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String color_borde = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.color_borde,new Nodo("STRING",color_borde,color_bordeleft,color_borderight));
                                        //RESULT = "border-color :"+color_borde;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // PROPIEDAD ::= border_width dospuntos NUMERO pyc 
            {
              AtributoCSS RESULT =null;
		int grosor_bordeleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int grosor_borderight = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String grosor_borde = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.grosor_borde, new Nodo("INT",grosor_borde,grosor_bordeleft,grosor_borderight));

                                       /// RESULT = "border-width :"+grosor_borde;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // PROPIEDAD ::= align dospuntos alineacion pyc 
            {
              AtributoCSS RESULT =null;
		int alineacionleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int alineacionright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String alineacion = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.alineacion, new Nodo("STRING",alineacion,alineacionleft,alineacionright));
                                       // RESULT = "align :"+alineacion;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // PROPIEDAD ::= font dospuntos fuente pyc 
            {
              AtributoCSS RESULT =null;
		int fuenteleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int fuenteright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String fuente = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.fuente, new Nodo("STRING",fuente.replace("\'",""),fuenteleft,fuenteright));
                                      //  RESULT = "font :"+fuente;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // PROPIEDAD ::= font_size dospuntos NUMERO pyc 
            {
              AtributoCSS RESULT =null;
		int size_fuenteleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int size_fuenteright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String size_fuente = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.size_fuente, new Nodo("INT",size_fuente,size_fuenteleft,size_fuenteright));
                                      //  RESULT = "font-size :"+num;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // PROPIEDAD ::= font_color dospuntos COLOR pyc 
            {
              AtributoCSS RESULT =null;
		int color_fuenteleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int color_fuenteright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String color_fuente = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.color_fuente,  new Nodo("STRING",color_fuente,color_fuenteleft,color_fuenteright));
                                      //  RESULT = "font-color :"+a;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // PROPIEDAD ::= height dospuntos NUMERO pyc 
            {
              AtributoCSS RESULT =null;
		int alturaleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int alturaright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String altura = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.altura, new Nodo("INT",altura,alturaleft,alturaright));
                                       // RESULT = "height :"+num;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // PROPIEDAD ::= width dospuntos NUMERO pyc 
            {
              AtributoCSS RESULT =null;
		int anchuraleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int anchuraright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String anchura = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = new AtributoCSS(AtributoCSS.EnumPropiedad.anchura, new Nodo("INT",anchura,anchuraleft,anchuraright));
                                       // RESULT = "width :"+num;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("PROPIEDAD",6, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // COLOR ::= color 
            {
              String RESULT =null;
		int colorleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		String color = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		
                                        RESULT = color;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("COLOR",3, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // COLOR ::= id 
            {
              String RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		
                                        RESULT = ConvertirColor(id);
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("COLOR",3, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // COLOR ::= rgb parentesisIzq numero coma numero coma numero parentesisDer 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-5)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-5)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-5)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-1)).value;
		
                                        RESULT = ConvertirRGB(Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c));
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("COLOR",3, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.elementAt(CUP$parserCSS$top-7)), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // NUMERO ::= numero 
            {
              String RESULT =null;
		int numeroleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int numeroright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		String numero = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		
                                        RESULT = numero;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("NUMERO",4, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // NUMERO ::= id 
            {
              String RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parserCSS$stack.peek()).value;
		
                                        RESULT = id;
                                    
              CUP$parserCSS$result = parser.getSymbolFactory().newSymbol("NUMERO",4, ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCSS$stack.peek()), RESULT);
            }
          return CUP$parserCSS$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parserCSS$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parserCSS$do_action(
    int                        CUP$parserCSS$act_num,
    java_cup.runtime.lr_parser CUP$parserCSS$parser,
    java.util.Stack            CUP$parserCSS$stack,
    int                        CUP$parserCSS$top)
    throws java.lang.Exception
    {
              return CUP$parserCSS$do_action_part00000000(
                               CUP$parserCSS$act_num,
                               CUP$parserCSS$parser,
                               CUP$parserCSS$stack,
                               CUP$parserCSS$top);
    }
}

}
