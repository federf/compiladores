buscado: A
actual VarLocation{name=A, type=int[], expr=null, size=5}
{PARAM, null, null, Result: [4, 8]}
8 , class ir.ast.IntLiteral
4 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [StringLiteral{value="%d resultado : "}, VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=pruArreglos, args=[4, 8]}, size=0}]}
VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=pruArreglos, args=[4, 8]}, size=0} , class ir.ast.VarLocation
StringLiteral{value="%d resultado : "} , class ir.ast.StringLiteral

    .comm A,20

    .comm B,224

    .comm C,40


    .text
    .globl	pruArreglos
    .type	pruArreglos, @function 
pruArreglos: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $2,-44(%ebp)

    movl -40(%ebp), %eax

.BeginForLabel7:

    movl -28(%ebp), %eax
    cmpl -24(%ebp), %eax

    jnl EndForLabel8

    movl -4(%ebp) , %eax 
    movl $2, %edx 
    addl %eax, %edx 
    movl %edx,-36(%ebp) 

    movl -36(%ebp),%eax
    movl %eax, -44(%ebp)

    movl $5, %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-24(%ebp) 

    jmp BeginForLabel7

.EndForLabel8:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $8 , 4(%esp)
    movl $4 , 0(%esp)

    call pruArreglos

    movl -12(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    movl $1, %eax

    leave
    ret


