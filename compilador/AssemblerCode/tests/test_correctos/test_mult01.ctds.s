

    .text
    .globl	pruMult
    .type	pruMult, @function 
pruMult: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $5,-4(%ebp)

    movl $2000,-8(%ebp)

    movl -4(%ebp), %eax 
    movl $1000, %edx 
    imull %edx, %eax 
    movl %eax,-24(%ebp) 

    movl -24(%ebp), %eax 
    movl 8(%ebp), %edx 
    imull %edx, %eax 
    movl %eax,-28(%ebp) 

    movl -28(%ebp), %eax 
    movl -8(%ebp), %edx 
    imull %edx, %eax 
    movl %eax,-32(%ebp) 

    movl -32(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $2, 0(%esp)

    call pruMult

    movl -8(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


