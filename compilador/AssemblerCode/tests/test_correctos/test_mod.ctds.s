

    .text
    .globl	pruAritmetica
    .type	pruAritmetica, @function 
pruAritmetica: 
    pushl	%ebp
    movl %esp, %ebp

    movl $90,-4(%ebp)

    movl	-12(%ebp), %eax 
    cltd
    idivl -4(%ebp)
    movl	%edx, -16(%ebp)

    movl -16(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    call pruAritmetica

    movl -4(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


