{PARAM, null, null, Result: [5]}
5 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [0, 10.2]}
10.2 , class ir.ast.FloatLiteral
0 , class ir.ast.IntLiteral

    .comm res,4


    .text
    .globl	inc
    .type	inc, @function 
inc: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-8(%ebp) 

    movl -8(%ebp), %eax

    leave
    ret



    .text
    .globl	resto
    .type	resto, @function 
resto: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $3 , %eax 
    movl $2, %edx 
    imull %edx, %eax 
    movl %eax,-16(%ebp) 

    movl	8(%ebp), %eax
    cmpl	-16(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -20(%ebp)

    movl $ 1, %eax
    cmpl -20(%ebp), %eax

    jne elseCondLabel7

    movl 8(%ebp) , %eax 
    movl $3 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp endIfLabel8

.elseCondLabel7:

    movl	-32(%ebp), %eax 
    cltd
    idivl 8(%ebp)
    movl	%edx, -36(%ebp)

    movl -36(%ebp),%eax
    movl %eax, -4(%ebp)

.endIfLabel8:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $0,-4(%ebp)

    movl $5 , 0(%esp)

    call inc

    movl %eax,-4(%ebp)

    movl $0 , 0(%esp)

    call resto

    movl %eax,-16(%ebp)

    leave
    ret


