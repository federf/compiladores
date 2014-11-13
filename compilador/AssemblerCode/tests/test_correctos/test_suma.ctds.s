

    .text
    .globl	suma
    .type	suma, @function 
suma: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	-4(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -8(%ebp)

    movl $ 1, %eax
    cmpl -8(%ebp), %eax

    jne elseCondLabel3

    movl 4(%ebp), %eax

    jmp endIfLabel4

.elseCondLabel3:

    movl	12(%ebp), %eax
    cmpl	-12(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -16(%ebp)

    movl $ 1, %eax
    cmpl -16(%ebp), %eax

    jne elseCondLabel7

    movl 0(%ebp), %eax

    jmp endIfLabel8

.elseCondLabel7:

    movl 8(%ebp), %eax 
    movl 12(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-20(%ebp) 

    movl -20(%ebp), %eax

.endIfLabel8:

.endIfLabel4:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $3,-8(%ebp)

    movl $1,-4(%ebp)

    movl -20(%ebp), %eax
    addl %eax, -4(%ebp)

    movl -4(%ebp), %eax
    addl %eax, -8(%ebp)

    movl $9, 4(%esp)
    movl $4, 0(%esp)

    call suma

    movl -32(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


