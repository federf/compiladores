Error: Method pruAritmetica must return int
{PARAM, null, null, Result: [4, 8]}
8 , class ir.ast.IntLiteral
4 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[4, 8]}, size=0}]}
VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[4, 8]}, size=0} , class ir.ast.VarLocation
{PARAM, null, null, Result: []}
{PARAM, null, null, Result: [4, 4]}
4 , class ir.ast.IntLiteral
4 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel20, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[4, 4]}, size=0}]}
VarLocation{name=factorLabel20, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[4, 4]}, size=0} , class ir.ast.VarLocation
{PARAM, null, null, Result: [8, 5]}
5 , class ir.ast.IntLiteral
8 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel25, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[8, 5]}, size=0}]}
VarLocation{name=factorLabel25, type=int, expr=MethodCallExpr{name=pruAritmetica, args=[8, 5]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	pruAritmetica
    .type	pruAritmetica, @function 
pruAritmetica: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setgne %al
    movlzbl %al, %eax
    movl	%eax, -8(%ebp)

    movl $ 1, %eax
    cmpl -8(%ebp), %eax

    jne elseCondLabel2

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -12(%ebp)

    movl $ 1, %eax
    cmpl -12(%ebp), %eax

    jne elseCondLabel5

    movl 8(%ebp) , %eax 
    movl 12(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-16(%ebp) 

    movl -16(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp endIfLabel6

.elseCondLabel5:

    movl 12(%ebp) , %eax 
    movl 8(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-20(%ebp) 

    movl -20(%ebp),%eax
    movl %eax, -4(%ebp)

.endIfLabel6:

    jmp endIfLabel3

.elseCondLabel2:

    movl 8(%ebp) , %eax 
    movl $5, %edx 
    imull %edx, %eax 
    movl %eax,-28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -4(%ebp)

.endIfLabel3:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $8 , 4(%esp)
    movl $4 , 0(%esp)

    call pruAritmetica

    movl -12(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir


    call imprimir

    movl $4 , 4(%esp)
    movl $4 , 0(%esp)

    call pruAritmetica

    movl -24(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    movl $5 , 4(%esp)
    movl $8 , 0(%esp)

    call pruAritmetica

    movl -36(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    leave
    ret


