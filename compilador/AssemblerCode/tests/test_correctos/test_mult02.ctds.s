{PARAM, null, null, Result: [VarLocation{name=factorLabel5, type=int, expr=MethodCallExpr{name=pruMult, args=[]}, size=0}]}
VarLocation{name=factorLabel5, type=int, expr=MethodCallExpr{name=pruMult, args=[]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	pruMult
    .type	pruMult, @function 
pruMult: 
    pushl	%ebp
    movl %esp, %ebp

    movl $5,-4(%ebp)

    movl -4(%ebp) , %eax 
    movl $7, %edx 
    imull %edx, %eax 
    movl %eax,-16(%ebp) 

    movl -16(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    call pruMult

    movl -4(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    leave
    ret


