

    .text
    .globl	maxcomdiv
    .type	maxcomdiv, @function 
maxcomdiv: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -16(%ebp)

    movl $ 1, %eax
    cmpl -16(%ebp), %eax

    jne elseCondLabel2

    movl 8(%ebp),%eax
    movl %eax, -4(%ebp)

    movl 12(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp endIfLabel3

.elseCondLabel2:

    movl 12(%ebp),%eax
    movl %eax, -4(%ebp)

    movl 8(%ebp),%eax
    movl %eax, -8(%ebp)

.endIfLabel3:

    movl $1,-12(%ebp)

    movl	-12(%ebp), %eax
    cmpl	-24(%ebp), %eax
    setgne %al
    movlzbl %al, %eax
    movl	%eax, -28(%ebp)

.BeginWhileLabel7:

    movl $ 1, %eax
    cmpl -28(%ebp), %eax

    jne EndWhileLabel8

    movl	-8(%ebp), %eax 
    cltd
    idivl -4(%ebp)
    movl	%edx, -32(%ebp)

    movl -32(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -8(%ebp),%eax
    movl %eax, -4(%ebp)

    movl -12(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp BeginWhileLabel7

.EndWhileLabel8:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $9, 4(%esp)
    movl $6, 0(%esp)

    call maxcomdiv

    movl -12(%esp), %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


