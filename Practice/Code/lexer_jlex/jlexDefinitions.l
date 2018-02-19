package lexer_jlex;

%%
%line
%class TinyLexer
%type  LexicalItem
%unicode

%{
  private LexicalItemFactory itemfact;

  public String getLexema() {
    return yytext();
  }

  public int getRow() {
    return yyline+1;
  }
%}

%eofval{
  return itemfact.getItem('EOF');
%eofval}

%init{
  itemfact = new LexicalItemFactory(this);
%init}

SPROG = \& \&
Dig = [0-9]
Sign = [\+, \-]
LENT = {Sign}? {Dig}* {Dig}
PDEC = \. {Dig}* {Dig}
PEXP = (E|e) {LENT}
LREAL = {LENT} {PDEC}? {PEXP}?
Letter = ([a-z] | [A-Z])
ID = {Letter} ({Letter} | {Dig} | \_)*
BOOL = bool
NUM = num
TRUE = true
FALSE = false
PLUS = \+
MINUS = \-
MUL = \*
DIV = /
IS = \=
EQ = {IS} \=
GT = \>
GEQ = {GT} \=
LT = \<
LEQ = {LT} \=
NEQ = \! \=
AND = and
OR = or
NOT = not
POP = \(
PCL = \)
SEP = [ \t\r\b\n]

%%
{SEP}               {}
//TODO
{evalua}                  {return ops.unidadEvalua();}
{donde}                   {return ops.unidadDonde();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{numeroReal}              {return ops.unidadReal();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
[^]                       {ops.error();}  
