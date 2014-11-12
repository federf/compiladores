{PARAM, null, null, Result: [6, 9]}
9 , class ir.ast.IntLiteral
6 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [StringLiteral{value="%d%f"}, StringLiteral{value="mcd"}, VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=maxcomdiv, args=[6, 9]}, size=0}, VarLocation{name=MINUSLabel20, type=float, expr=VarLocation{name=MULTIPLYLabel16, type=float, expr=VarLocation{name=factorLabel15, type=float, expr=3.5, size=0}*VarLocation{name=a, type=int, expr=0, size=0}, size=0}-VarLocation{name=DIVIDELabel19, type=int, expr=VarLocation{name=factorLabel17, type=int, expr=7, size=0}/VarLocation{name=factorLabel18, type=int, expr=6, size=0}, size=0}, size=0}]}
VarLocation{name=MINUSLabel20, type=float, expr=VarLocation{name=MULTIPLYLabel16, type=float, expr=VarLocation{name=factorLabel15, type=float, expr=3.5, size=0}*VarLocation{name=a, type=int, expr=0, size=0}, size=0}-VarLocation{name=DIVIDELabel19, type=int, expr=VarLocation{name=factorLabel17, type=int, expr=7, size=0}/VarLocation{name=factorLabel18, type=int, expr=6, size=0}, size=0}, size=0} , class ir.ast.VarLocation
VarLocation{name=factorLabel14, type=int, expr=MethodCallExpr{name=maxcomdiv, args=[6, 9]}, size=0} , class ir.ast.VarLocation
StringLiteral{value="mcd"} , class ir.ast.StringLiteral
StringLiteral{value="%d%f"} , class ir.ast.StringLiteral


    .text
    .globl	maxcomdiv
    .type	maxcomdiv, @function 
maxcomdiv: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -16(%ebp)

    movl $ 1, %eax
    cmpl -16(%ebp), %eax

    jne elseCondLabel2

    movl 8(%ebp),%eax
    movl %eax, -4(%ebp)

    movl 12(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp endIfLabel3

.elseCondLabel2:

    movl 12(%ebp),%eax
    movl %eax, -4(%ebp)

    movl 8(%ebp),%eax
    movl %eax, -8(%ebp)

.endIfLabel3:

    movl $1,-12(%ebp)

    movl	-12(%ebp), %eax
    cmpl	-24(%ebp), %eax
    setgne %al
    movlzbl %al, %eax
    movl	%eax, -28(%ebp)

.BeginWhileLabel7:

    movl $ 1, %eax
    cmpl -28(%ebp), %eax

    jne EndWhileLabel8

    movl	-8(%ebp), %eax 
    cltd
    idivl -4(%ebp)
    movl	%edx, -32(%ebp)

    movl -32(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -8(%ebp),%eax
    movl %eax, -4(%ebp)

    movl -12(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp BeginWhileLabel7

.EndWhileLabel8:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $10000,-4(%ebp)

    movl $9 , 4(%esp)
    movl $6 , 0(%esp)

    call maxcomdiv

    movl $3.5 , %eax 
    movl -4(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-28(%ebp) 

    movl $7 , %eax 
    movl $6 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-40(%ebp) 

    movl -28(%ebp) , %eax 
    movl -40(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-44(%ebp) 

    movl -44(%esp) , %eax
    movl %eax,12(%esp)
    movl -20(%esp) , %eax
    movl %eax,8(%esp)

    call imprimir

    leave
    ret


