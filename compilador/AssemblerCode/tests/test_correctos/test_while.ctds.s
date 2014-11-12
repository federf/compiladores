{PARAM, null, null, Result: [6, 9]}
9 , class ir.ast.IntLiteral
6 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [StringLiteral{value="%dMcd"}, VarLocation{name=factorLabel18, type=int, expr=MethodCallExpr{name=maxcomdiv, args=[6, 9]}, size=0}]}
VarLocation{name=factorLabel18, type=int, expr=MethodCallExpr{name=maxcomdiv, args=[6, 9]}, size=0} , class ir.ast.VarLocation
StringLiteral{value="%dMcd"} , class ir.ast.StringLiteral


    .text
    .globl	maxcomdiv
    .type	maxcomdiv, @function 
maxcomdiv: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $1,-12(%ebp)

    movl	-12(%ebp), %eax
    cmpl	-20(%ebp), %eax
    setgne %al
    movlzbl %al, %eax
    movl	%eax, -24(%ebp)

.BeginWhileLabel4:

    movl $ 1, %eax
    cmpl -24(%ebp), %eax

    jne EndWhileLabel5

    movl	-8(%ebp), %eax 
    cltd
    idivl -4(%ebp)
    movl	%edx, -28(%ebp)

    movl -28(%ebp), %eax
    addl %eax, -12(%ebp)

    movl -8(%ebp), %eax
    subl %eax, -4(%ebp)

    jmp BeginWhileLabel4

    jmp BeginWhileLabel4

.EndWhileLabel5:

    movl	-12(%ebp), %eax
    cmpl	-32(%ebp), %eax
    setgne %al
    movlzbl %al, %eax
    movl	%eax, -36(%ebp)

.BeginWhileLabel9:

    movl $ 1, %eax
    cmpl -36(%ebp), %eax

    jne EndWhileLabel10

    jmp EndWhileLabel10

    jmp BeginWhileLabel9

.EndWhileLabel10:

    movl	-12(%ebp), %eax
    cmpl	-40(%ebp), %eax
    setgne %al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

.BeginWhileLabel13:

    movl $ 1, %eax
    cmpl -44(%ebp), %eax

    jne EndWhileLabel14

    jmp BeginWhileLabel13

.EndWhileLabel14:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $9 , 4(%esp)
    movl $6 , 0(%esp)

    call maxcomdiv

    movl -12(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


