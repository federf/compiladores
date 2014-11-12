{PARAM, null, null, Result: [3]}
3 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel3, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[3]}, size=0}]}
VarLocation{name=factorLabel3, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[3]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	pruAritmetica
    .type	pruAritmetica, @function 
pruAritmetica: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $3 , 0(%esp)

    call pruAritmetica

    movl -8(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    leave
    ret


