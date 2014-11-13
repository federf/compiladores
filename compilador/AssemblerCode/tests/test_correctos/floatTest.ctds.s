

    .text
    .globl	div
    .type	div, @function 
div: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp), %eax 
    movl 12(%ebp), %ecx
	 cltd
    idiv %ecx
    movl %ecx,-4(%ebp) 

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	resta
    .type	resta, @function 
resta: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp), %eax 
    movl 12(%ebp), %edx 
    subl %eax, %edx 
    movl %eax,-4(%ebp) 

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	sum
    .type	sum, @function 
sum: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp), %eax 
    movl 12(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-4(%ebp) 

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	mult
    .type	mult, @function 
mult: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp), %eax 
    movl 12(%ebp), %edx 
    imull %edx, %eax 
    movl %eax,-4(%ebp) 

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $1.234,-20(%ebp)

    movl	-36(%ebp), %eax 
    negl	%eax 
    movl	%eax, -40(%ebp) 

    movl -40(%ebp),%eax
    movl %eax, -24(%ebp)

    movl	-44(%ebp), %eax 
    negl	%eax 
    movl	%eax, -48(%ebp) 

    movl -48(%ebp),%eax
    movl %eax, -28(%ebp)


    call sum

    movl %eax,-4(%ebp)


    call div

    movl %eax,-8(%ebp)

    movl	-24(%ebp), %eax 
    negl	%eax 
    movl	%eax, -60(%ebp) 


    call resta

    movl %eax,-12(%ebp)


    call mult

    movl %eax,-16(%ebp)


    call sum

    movl -72(%esp), %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


