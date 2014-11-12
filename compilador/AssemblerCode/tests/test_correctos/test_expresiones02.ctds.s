{PARAM, null, null, Result: [6]}
6 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel17, type=int, expr=MethodCallExpr{name=prueba, args=[6]}, size=0}]}
VarLocation{name=factorLabel17, type=int, expr=MethodCallExpr{name=prueba, args=[6]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	prueba
    .type	prueba, @function 
prueba: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $4,-12(%ebp)

    movl $5,-16(%ebp)

    movl -12(%ebp) , %eax 
    movl -16(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -4(%ebp)

    movl -4(%ebp) , %eax 
    movl 8(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-32(%ebp) 

    movl -32(%ebp),%eax
    movl %eax, 0(%ebp)

    movl $3.14,-36(%ebp)

    movl $2 , %eax 
    movl -36(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-48(%ebp) 

    movl -48(%ebp),%eax
    movl %eax, -8(%ebp)

    movl -4(%ebp) , %eax 
    movl -8(%ebp) , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-52(%ebp) 

    movl	-52(%ebp), %eax
    cmpl	-56(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -60(%ebp)

    movl $ 1, %eax
    cmpl -60(%ebp), %eax

    jne elseCondLabel11

    movl $1, %eax

    jmp endIfLabel12

.elseCondLabel11:

    movl $0, %eax

.endIfLabel12:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $6 , 0(%esp)

    call prueba

    movl -8(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    leave
    ret


