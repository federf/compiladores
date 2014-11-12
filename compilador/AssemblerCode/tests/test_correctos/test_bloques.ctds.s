{PARAM, null, null, Result: [1]}
1 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [StringLiteral{value="%f resultado : "}, VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=breaks, args=[1]}, size=0}]}
VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=breaks, args=[1]}, size=0} , class ir.ast.VarLocation
StringLiteral{value="%f resultado : "} , class ir.ast.StringLiteral


    .text
    .globl	breaks
    .type	breaks, @function 
breaks: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $0,-4(%ebp)

    movl	-4(%ebp), %eax
    cmpl	-12(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -16(%ebp)

.BeginWhileLabel4:

    movl $ 1, %eax
    cmpl -16(%ebp), %eax

    jne EndWhileLabel5

    movl -4(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-24(%ebp) 

    movl -24(%ebp),%eax
    movl %eax, -4(%ebp)

    movl	8(%ebp), %eax
    cmpl	-28(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -32(%ebp)

    movl $ 1, %eax
    cmpl -32(%ebp), %eax

    jne elseCondLabel10

    jmp EndWhileLabel5

    jmp endIfLabel11

.elseCondLabel10:

    jmp BeginWhileLabel4

.endIfLabel11:

    jmp BeginWhileLabel4

.EndWhileLabel5:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $1 , 0(%esp)

    call breaks

    movl -8(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    movl $1, %eax

    leave
    ret


