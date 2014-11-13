

    .text
    .globl	inc
    .type	inc, @function 
inc: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-8(%ebp) 

    movl -8(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $2,-4(%ebp)

    movl $4,-8(%ebp)

    movl -4(%ebp), %eax 
    movl -8(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-32(%ebp) 

    movl -32(%ebp),%eax
    movl %eax, -12(%ebp)

    movl $2, 0(%esp)

    call inc

    movl %eax,-20(%ebp)

    movl -20(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    movl %eax,-16(%ebp) 

    movl -16(%ebp), %eax

    leave
    ret


