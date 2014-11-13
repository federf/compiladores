Error: Method pruAritmetica must return int


    .text
    .globl	pruAritmetica
    .type	pruAritmetica, @function 
pruAritmetica: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -8(%ebp)

    movl $ 1, %eax
    cmpl -8(%ebp), %eax

    jne elseCondLabel2

    movl 8(%ebp), %eax 
    movl $5, %edx 
    addl %eax, %edx 
    movl %edx,-16(%ebp) 

    movl -16(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp endIfLabel3

.elseCondLabel2:

    movl 12(%ebp),%eax
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

    movl $8, 4(%esp)
    movl $4, 0(%esp)

    call pruAritmetica

    movl -12(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


