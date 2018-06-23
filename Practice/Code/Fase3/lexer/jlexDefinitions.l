package lexer;

import errors.ErrorManager;

%%
%cup
%line
%class TinyLexer
%unicode
%public

%{
  private LexicalItemFactory itemfact;
  private ErrorManager err;

  public String getLexeme() {
    return yytext();
  }

  public int getRow() {
    return yyline+1;
  }

  public void setErrorManager(ErrorManager err) {
    this.err = err;
  }
%}

%eofval{
  return itemfact.getItem("EOF");
%eofval}

%init{
  itemfact = new LexicalItemFactory(this);
%init}

SPROG = \&\&
Dig = [0-9]
Sign = [\+,\-]
LENT = {Sign}?{Dig}*{Dig}
PDEC = \.{Dig}*{Dig}
PEXP = (E|e){LENT}
LDEC = {LENT}{PDEC}
LEXP = ({LENT}|{LDEC}){PEXP}
LREAL = {LENT}|{LDEC}|{LEXP}
Letter = ([A-Z]|[a-z])
ID = {Letter}({Letter}|{Dig}|\_)*
BOOL = bool
NUM = num
TRUE = true
FALSE = false
PLUS = \+
MINUS = \-
MUL = \*
DIV = /
IS = \=
EQ = {IS}\=
GT = \>
GEQ = {GT}\=
LT = \<
LEQ = {LT}\=
NEQ = \!\=
AND = and
OR = or
NOT = not
POP = \(
PCL = \)
EOL = \;
SEP = [ \t\r\b\n]
%%
{SEP}   {}
{SPROG} {return itemfact.getItem("SPROG");}
{LREAL} {return itemfact.getItem("LREAL");}
{BOOL}  {return itemfact.getItem("BOOL");}
{NUM}   {return itemfact.getItem("NUM");}
{TRUE}  {return itemfact.getItem("TRUE");}
{FALSE} {return itemfact.getItem("FALSE");}
{AND}   {return itemfact.getItem("AND");}
{OR}    {return itemfact.getItem("OR");}
{NOT}   {return itemfact.getItem("NOT");}
{ID}   {return itemfact.getItem("ID");}
{PLUS}  {return itemfact.getItem("PLUS");}
{MINUS} {return itemfact.getItem("MINUS");}
{MUL}   {return itemfact.getItem("MUL");}
{DIV}   {return itemfact.getItem("DIV");}
{IS}    {return itemfact.getItem("IS");}
{EQ}    {return itemfact.getItem("EQ");}
{GT}    {return itemfact.getItem("GT");}
{GEQ}   {return itemfact.getItem("GEQ");}
{LT}    {return itemfact.getItem("LT");}
{LEQ}   {return itemfact.getItem("LEQ");}
{NEQ}   {return itemfact.getItem("NEQ");}
{PCL}   {return itemfact.getItem("PCL");}
{POP}   {return itemfact.getItem("POP");}
{EOL}   {return itemfact.getItem("EOL");}
[^]     {err.lexer(this.getRow(), this.getLexeme());}
