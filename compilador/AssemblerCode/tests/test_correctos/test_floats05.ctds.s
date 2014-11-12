{PARAM, null, null, Result: [0.0, 0.0]}
0.0 , class ir.ast.FloatLiteral
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [0.0, 0.0]}
0.0 , class ir.ast.FloatLiteral
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [0.0, 0.0]}
0.0 , class ir.ast.FloatLiteral
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [StringLiteral{value="anidandofuncionesflotantes"}, VarLocation{name=factorLabel13, type=float, expr=MethodCallExpr{name=sum, args=[0.0, 0.0]}, size=0}]}
VarLocation{name=factorLabel13, type=float, expr=MethodCallExpr{name=sum, args=[0.0, 0.0]}, size=0} , class ir.ast.VarLocation
StringLiteral{value="anidandofuncionesflotantes"} , class ir.ast.StringLiteral


    .text
    .globl	div
    .type	div, @function 
div: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp) , %eax 
    movl 12(%ebp) , %ecx
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

    movl 8(%ebp) , %eax 
    movl 12(%ebp) , %edx 
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

    movl 8(%ebp) , %eax 
    movl 12(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-4(%ebp) 

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $6.982,-12(%ebp)

    movl	-28(%ebp), %eax 
    negl	%eax 
    movl	%eax, -32(%ebp) 

    movl -32(%ebp),%eax
    movl %eax, -16(%ebp)

    movl $3.5698,-20(%ebp)


    call resta

    movl %eax,-4(%ebp)


    call div

    movl %eax,-8(%ebp)


    call sum

    movl -48(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


