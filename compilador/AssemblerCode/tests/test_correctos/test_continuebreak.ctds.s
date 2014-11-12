{PARAM, null, null, Result: [3.0, 2]}
2 , class ir.ast.IntLiteral
3.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel30, type=float, expr=MethodCallExpr{name=pruContinue, args=[3.0, 2]}, size=0}]}
VarLocation{name=factorLabel30, type=float, expr=MethodCallExpr{name=pruContinue, args=[3.0, 2]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	pruContinue
    .type	pruContinue, @function 
pruContinue: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	-16(%ebp), %eax 
    negl	%eax 
    movl	%eax, -20(%ebp) 

    movl -20(%ebp),%eax
    movl %eax, -12(%ebp)

    movl $23,-8(%ebp)

    movl $23,-4(%ebp)

    movl	-4(%ebp), %eax
    cmpl	-32(%ebp), %eax
    setge %al
    movlzbl %al, %eax
    movl	%eax, -36(%ebp)

.BeginWhileLabel7:

    movl $ 1, %eax
    cmpl -36(%ebp), %eax

    jne EndWhileLabel8

    movl -4(%ebp) , %eax 
    movl $1 , %edx 
    subl %eax, %edx 
    movl %eax,-44(%ebp) 

    movl -44(%ebp),%eax
    movl %eax, -4(%ebp)

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -48(%ebp)

    movl $ 1, %eax
    cmpl -48(%ebp), %eax

    jne elseCondLabel12

    movl	-4(%ebp), %eax
    cmpl	-52(%ebp), %eax
    setgne %al
    movlzbl %al, %eax
    movl	%eax, -56(%ebp)

    movl $ 1, %eax
    cmpl -56(%ebp), %eax

    jne elseCondLabel16

    movl -12(%ebp) , %eax 
    movl 8(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-60(%ebp) 

    movl -60(%ebp) , %eax 
    movl 12(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-64(%ebp) 

    movl -64(%ebp),%eax
    movl %eax, -12(%ebp)

    jmp endIfLabel17

.elseCondLabel16:

.endIfLabel17:

    jmp BeginWhileLabel7

    jmp endIfLabel13

.elseCondLabel12:

    movl	-68(%ebp), %eax 
    negl	%eax 
    movl	%eax, -72(%ebp) 

    movl -72(%ebp) , %eax 
    movl $6752, %edx 
    addl %eax, %edx 
    movl %edx,-80(%ebp) 

    movl -80(%ebp),%eax
    movl %eax, -12(%ebp)

    jmp EndWhileLabel8

.endIfLabel13:

    jmp BeginWhileLabel7

.EndWhileLabel8:

    movl	-84(%ebp), %eax 
    negl	%eax 
    movl	%eax, -88(%ebp) 

    movl -88(%ebp) , %eax 
    movl -12(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-92(%ebp) 

    movl -92(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $2 , 4(%esp)

    call pruContinue

    movl -12(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    leave
    ret


