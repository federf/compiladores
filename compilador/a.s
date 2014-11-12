    .text
    .globl  main
    .type   main, @function 
main: 
    pushl   %ebp
    movl %esp, %ebp

    movl $5, %eax 
    movl $4 , %edx 
    subl %eax, %edx 
    movl %eax,-24(%ebp) 

    movl $3 , %eax 
    movl -24(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-28(%ebp) 

    movl $2, %eax 
    movl -28(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-32(%ebp) 

    movl -32(%ebp),-4(%ebp)

    movl $0 , 8(%esp)

    call imprimir

    leave
    ret
