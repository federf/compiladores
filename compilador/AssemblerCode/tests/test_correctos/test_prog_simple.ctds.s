Error: Main Method Missing in Class prueba2

    .comm c,4


    .text
    .globl	alo
    .type	alo, @function 
alo: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 20(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-8(%ebp) 

    movl -8(%ebp),%eax
    movl %eax, 12(%ebp)

    leave
    ret


