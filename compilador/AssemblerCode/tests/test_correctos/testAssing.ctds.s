{PARAM, null, null, Result: [5]}
5 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=aritmTest, args=[5]}, size=0}]}
VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=aritmTest, args=[5]}, size=0} , class ir.ast.VarLocation


    .text
    .globl	aritmTest
    .type	aritmTest, @function 
aritmTest: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $1,-4(%ebp)

    movl $2,-8(%ebp)

    movl $1, %eax 
    movl -4(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-24(%ebp) 

    movl -24(%ebp),%eax
    movl %eax, -4(%ebp)

    movl -4(%ebp) , %eax 
    movl $2, %edx 
    addl %eax, %edx 
    movl %edx,-32(%ebp) 

    movl -32(%ebp),%eax
    movl %eax, -8(%ebp)

    movl -4(%ebp) , %eax 
    movl 8(%ebp) , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-36(%ebp) 

    movl -36(%ebp),%eax
    movl %eax, -4(%ebp)

    movl	-40(%ebp), %eax 
    cltd
    idivl -4(%ebp)
    movl	%edx, -44(%ebp)

    movl -44(%ebp),%eax
    movl %eax, 0(%ebp)

    movl -48(%ebp), %eax
    addl %eax, -4(%ebp)

    movl -52(%ebp), %eax
    subl %eax, -4(%ebp)

    movl 8(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $5 , 0(%esp)

    call aritmTest

    movl -8(%esp) , %eax
    movl %eax, 0(%esp)
    call imprimir

    leave
    ret


