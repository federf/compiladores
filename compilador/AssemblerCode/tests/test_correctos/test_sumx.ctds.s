

    .text
    .globl	sumx
    .type	sumx, @function 
sumx: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $0,-4(%ebp)

    movl $0,-8(%ebp)

    movl	-8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -20(%ebp)

.BeginWhileLabel4:

    movl $ 1, %eax
    cmpl -20(%ebp), %eax

    jne EndWhileLabel5

    movl -4(%ebp), %eax 
    movl 8(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-24(%ebp) 

    movl -24(%ebp),%eax
    movl %eax, -4(%ebp)

    movl -8(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-32(%ebp) 

    movl -32(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp BeginWhileLabel4

.EndWhileLabel5:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $2, 4(%esp)

    call sumx

    movl -12(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


