{PARAM, null, null, Result: [0]}
0 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [0]}
0 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [0]}
0 , class ir.ast.IntLiteral

    .comm c,4


    .text
    .globl	alo
    .type	alo, @function 
alo: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 12(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-8(%ebp) 

    movl -8(%ebp),%eax
    movl %eax, 12(%ebp)

    leave
    ret



    .text
    .globl	alo2
    .type	alo2, @function 
alo2: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $0 , 0(%esp)

    call alo

    movl 8(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-8(%ebp) 

    movl -8(%ebp),%eax
    movl %eax, 0(%ebp)

    movl 8(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $7,-4(%ebp)

    movl $8.0,-4(%ebp)

    movl $0 , 0(%esp)

    call alo2

    movl %eax,-4(%ebp)

    movl $3 , %eax 
    movl -4(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -8(%ebp)

    movl $0 , 0(%esp)

    call alo2

    movl %eax,-4(%ebp)

    leave
    ret


