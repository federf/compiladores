{PARAM, null, null, Result: [2]}
2 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [2]}
2 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [5]}
5 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [StringLiteral{value="-estoEsUnaPrueba"}]}
StringLiteral{value="-estoEsUnaPrueba"} , class ir.ast.StringLiteral
{PARAM, null, null, Result: [StringLiteral{value="%d"}, VarLocation{name=x, type=int, expr=0, size=0}]}
VarLocation{name=x, type=int, expr=0, size=0} , class ir.ast.VarLocation
StringLiteral{value="%d"} , class ir.ast.StringLiteral
{PARAM, null, null, Result: []}

    .comm c,4


    .text
    .globl	alo
    .type	alo, @function 
alo: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

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
    .globl	alo_2
    .type	alo_2, @function 
alo_2: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $2 , 0(%esp)

    call alo

    movl $2 , 0(%esp)

    call alo

    movl $MethodCallExpr{name=alo, args=[2]}, %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-20(%ebp) 

    movl -20(%ebp),%eax
    movl %eax, 12(%ebp)

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $5 , 0(%esp)

    call alo

    movl %eax,-4(%ebp)


    call imprimir

    movl -4(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir


    call /home/programas/primer_primo_par

    leave
    ret


