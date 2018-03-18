S -> Prog eof.
Prog -> SDec sprog SIns.
SDec -> Dec LDec.
LDec -> eol Dec LDec
      | .
SIns -> Ins LIns.
LIns -> eol Ins LIns
      | .
Dec -> num id
     | bool id.
Ins -> id is Exp0.

Exp0 -> Exp1 R0.
R0 -> Op0 Exp1 R0
    | .
Exp1 -> Exp2 R1.
R1 -> and Exp2 R1
    | or Exp2
    | .
Exp2 -> Exp3 R2.
R2 -> Op2 Exp3 R2
    | .
Exp3 -> Exp4 R3.
R3 -> Op3 Exp4 R3
    | .
Exp4 -> minus Exp4
      | not Exp5
      | Exp5.
Exp5 -> lreal
      | true
      | false
      | pop Exp0 pcl.

Op0 -> plus
     | minus.
Op2 -> eq
     | gt
     | geq
     | lt
     | leq
     | neq.
Op3 -> mul
     | div.