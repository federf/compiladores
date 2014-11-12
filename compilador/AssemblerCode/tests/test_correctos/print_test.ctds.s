{PARAM, null, null, Result: [VarLocation{name=res, type=int, expr=0, size=0}]}
VarLocation{name=res, type=int, expr=0, size=0} , class ir.ast.VarLocation


    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $2,-4(%ebp)

    movl $4,-8(%ebp)

    movl -4(%ebp) , %eax 
    movl -8(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -12(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    movl %eax,-16(%ebp) 

    movl $10, %eax

    leave
    ret


