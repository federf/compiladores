{PARAM, null, null, Result: [0.0, 2]}
2 , class ir.ast.IntLiteral
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [0.0, 0.0]}
0.0 , class ir.ast.FloatLiteral
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [StringLiteral{value="%f"}, VarLocation{name=factorLabel43, type=float, expr=MethodCallExpr{name=multRepeat, args=[0.0, 0.0]}, size=0}]}
VarLocation{name=factorLabel43, type=float, expr=MethodCallExpr{name=multRepeat, args=[0.0, 0.0]}, size=0} , class ir.ast.VarLocation
StringLiteral{value="%f"} , class ir.ast.StringLiteral

    .comm w,4

    .comm m,4

    .comm res,4


    .text
    .globl	potencia
    .type	potencia, @function 
potencia: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $0,-8(%ebp)

    movl $1,-4(%ebp)

    movl $1.0,-12(%ebp)

    movl	12(%ebp), %eax
    cmpl	-28(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -32(%ebp)

    movl $ 1, %eax
    cmpl -32(%ebp), %eax

    jne elseCondLabel6

    movl	12(%ebp), %eax 
    negl	%eax 
    movl	%eax, -36(%ebp) 

    movl -36(%ebp),%eax
    movl %eax, 1(%ebp)

    movl $1,-8(%ebp)

    jmp endIfLabel7

.elseCondLabel6:

.endIfLabel7:

    movl	-4(%ebp), %eax
    cmpl	12(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

    movl	-4(%ebp), %eax
    cmpl	12(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -48(%ebp)

    cmpl	$0, -44(%ebp)
    jne .L0
    cmpl	$0, -48(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -52(%ebp)
.L2:

.BeginWhileLabel13:

    movl $ 1, %eax
    cmpl -52(%ebp), %eax

    jne EndWhileLabel14

    movl -12(%ebp) , %eax 
    movl 8(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-56(%ebp) 

    movl -56(%ebp) , %eax 
    movl $2.0, %edx 
    imull %edx, %eax 
    movl %eax,-64(%ebp) 

    movl -64(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -4(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-72(%ebp) 

    movl -72(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp BeginWhileLabel13

.EndWhileLabel14:

    cmpl $0, -8(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -76(%ebp) 

    cmpl $0, -76(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -80(%ebp) 

    movl $ 1, %eax
    cmpl -80(%ebp), %eax

    jne elseCondLabel22

    movl $1.0 , %eax 
    movl -12(%ebp) , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-88(%ebp) 

    movl -88(%ebp), %eax

    jmp endIfLabel23

.elseCondLabel22:

    movl -12(%ebp), %eax

.endIfLabel23:

    movl	-92(%ebp), %eax 
    negl	%eax 
    movl	%eax, -96(%ebp) 

    movl -96(%ebp), %eax

    leave
    ret



    .text
    .globl	multRepeat
    .type	multRepeat, @function 
multRepeat: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 12(%ebp) , %eax 
    movl 12(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-8(%ebp) 

    movl -8(%ebp) , %eax 
    movl 8(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-12(%ebp) 

    movl -12(%ebp) , %eax 
    movl 8(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-16(%ebp) 

    movl -16(%ebp) , %eax 
    movl 8(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-20(%ebp) 

    movl -20(%ebp) , %eax 
    movl 12(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-24(%ebp) 

    movl -24(%ebp),%eax
    movl %eax, -4(%ebp)

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl	-12(%ebp), %eax 
    negl	%eax 
    movl	%eax, -16(%ebp) 

    movl -16(%ebp),%eax
    movl %eax, -12(%ebp)

    movl $4.3,-4(%ebp)

    movl	-24(%ebp), %eax 
    negl	%eax 
    movl	%eax, -28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -8(%ebp)

    movl $80.0,-8(%ebp)

    movl $2 , 4(%esp)

    call potencia

    movl %eax,-4(%ebp)


    call multRepeat

    movl -44(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


