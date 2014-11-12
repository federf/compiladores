{PARAM, null, null, Result: [3]}
3 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel11, type=int, expr=MethodCallExpr{name=factorial, args=[3]}, size=0}]}
VarLocation{name=factorLabel11, type=int, expr=MethodCallExpr{name=factorial, args=[3]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	factorial
    .type	factorial, @function 
factorial: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp),%eax
    movl %eax, -4(%ebp)

    movl $1,-8(%ebp)

    movl	-4(%ebp), %eax
    cmpl	-16(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -20(%ebp)

.BeginWhileLabel4:

    movl $ 1, %eax
    cmpl -20(%ebp), %eax

    jne EndWhileLabel5

    movl -8(%ebp) , %eax 
    movl -4(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-24(%ebp) 

    movl -24(%ebp),%eax
    movl %eax, -8(%ebp)

    movl -4(%ebp) , %eax 
    movl $1 , %edx 
    subl %eax, %edx 
    movl %eax,-32(%ebp) 

    movl -32(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp BeginWhileLabel4

.EndWhileLabel5:

    movl -8(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $3 , 0(%esp)

    call factorial

    movl -8(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    leave
    ret


