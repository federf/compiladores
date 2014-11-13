

    .text
    .globl	pruAritmetica
    .type	pruAritmetica, @function 
pruAritmetica: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $3, 0(%esp)

    call pruAritmetica

    movl -8(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


