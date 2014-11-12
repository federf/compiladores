{PARAM, null, null, Result: [6]}
6 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel29, type=float, expr=MethodCallExpr{name=prueba, args=[6]}, size=0}]}
VarLocation{name=factorLabel29, type=float, expr=MethodCallExpr{name=prueba, args=[6]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	prueba
    .type	prueba, @function 
prueba: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $50,-12(%ebp)

    movl	-12(%ebp), %eax
    cmpl	-20(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -24(%ebp)

    movl $ 1, %eax
    cmpl -24(%ebp), %eax

    jne elseCondLabel4

    movl $4,-4(%ebp)

    movl	-4(%ebp), %eax
    cmpl	-32(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -36(%ebp)

    movl $ 1, %eax
    cmpl -36(%ebp), %eax

    jne elseCondLabel9

    movl	-4(%ebp), %eax
    cmpl	-40(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

.BeginWhileLabel13:

    movl $ 1, %eax
    cmpl -44(%ebp), %eax

    jne EndWhileLabel14

    movl	-12(%ebp), %eax
    cmpl	-48(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -52(%ebp)

.BeginWhileLabel17:

    movl $ 1, %eax
    cmpl -52(%ebp), %eax

    jne EndWhileLabel18

    movl -12(%ebp) , %eax 
    movl $1 , %edx 
    subl %eax, %edx 
    movl %eax,-60(%ebp) 

    movl -60(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -4(%ebp) , %eax 
    movl $2, %edx 
    imull %edx, %eax 
    movl %eax,-68(%ebp) 

    movl -68(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp BeginWhileLabel17

.EndWhileLabel18:

    movl -4(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-76(%ebp) 

    movl -76(%ebp),%eax
    movl %eax, -4(%ebp)

    movl -8(%ebp) , %eax 
    movl $2 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-84(%ebp) 

    movl -84(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp BeginWhileLabel13

.EndWhileLabel14:

    jmp endIfLabel10

.elseCondLabel9:

.endIfLabel10:

    jmp endIfLabel5

.elseCondLabel4:

.endIfLabel5:

    movl -8(%ebp), %eax

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


