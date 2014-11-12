{PARAM, null, null, Result: [0.0, 2]}
2 , class ir.ast.IntLiteral
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [0.0, VarLocation{name=f, type=float, expr=0.0, size=0}+VarLocation{name=factorLabel109, type=float, expr=2.0, size=0}]}
VarLocation{name=f, type=float, expr=0.0, size=0}+VarLocation{name=factorLabel109, type=float, expr=2.0, size=0} , class ir.ast.BinOpExpr
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [StringLiteral{value="%f"}, VarLocation{name=factorLabel112, type=float, expr=MethodCallExpr{name=multiples, args=[0.0, VarLocation{name=f, type=float, expr=0.0, size=0}+VarLocation{name=factorLabel109, type=float, expr=2.0, size=0}]}, size=0}]}
VarLocation{name=factorLabel112, type=float, expr=MethodCallExpr{name=multiples, args=[0.0, VarLocation{name=f, type=float, expr=0.0, size=0}+VarLocation{name=factorLabel109, type=float, expr=2.0, size=0}]}, size=0} , class ir.ast.VarLocation
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
    movl $2, %edx 
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
    .globl	multiples
    .type	multiples, @function 
multiples: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	-44(%ebp), %eax 
    negl	%eax 
    movl	%eax, -48(%ebp) 

    movl -48(%ebp),%eax
    movl %eax, -4(%ebp)

    movl	-52(%ebp), %eax 
    negl	%eax 
    movl	%eax, -56(%ebp) 

    movl -56(%ebp),%eax
    movl %eax, -12(%ebp)

    movl	-60(%ebp), %eax 
    negl	%eax 
    movl	%eax, -64(%ebp) 

    movl -64(%ebp),%eax
    movl %eax, -16(%ebp)

    movl	-68(%ebp), %eax 
    negl	%eax 
    movl	%eax, -72(%ebp) 

    movl -72(%ebp),%eax
    movl %eax, -8(%ebp)

    movl -4(%ebp) , %eax 
    movl -8(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-76(%ebp) 

    movl -76(%ebp) , %eax 
    movl -16(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-80(%ebp) 

    movl -80(%ebp),%eax
    movl %eax, -20(%ebp)

    movl $0,-28(%ebp)

    movl $0,-32(%ebp)

    movl $0,-36(%ebp)

    movl $5,-40(%ebp)

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -100(%ebp)

    movl $ 1, %eax
    cmpl -100(%ebp), %eax

    jne elseCondLabel43

    movl	-20(%ebp), %eax
    cmpl	-4(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -104(%ebp)

    movl $ 1, %eax
    cmpl -104(%ebp), %eax

    jne elseCondLabel46

    movl 8(%ebp),%eax
    movl %eax, -24(%ebp)

    jmp endIfLabel47

.elseCondLabel46:

    movl 12(%ebp),%eax
    movl %eax, -24(%ebp)

.endIfLabel47:

    jmp endIfLabel44

.elseCondLabel43:

    movl	-28(%ebp), %eax
    cmpl	-40(%ebp), %eax
    setle %al
    movlzbl %al, %eax
    movl	%eax, -108(%ebp)

.BeginWhileLabel49:

    movl $ 1, %eax
    cmpl -108(%ebp), %eax

    jne EndWhileLabel50

    movl	-32(%ebp), %eax
    cmpl	-40(%ebp), %eax
    setle %al
    movlzbl %al, %eax
    movl	%eax, -112(%ebp)

.BeginWhileLabel52:

    movl $ 1, %eax
    cmpl -112(%ebp), %eax

    jne EndWhileLabel53

    movl	-36(%ebp), %eax
    cmpl	-40(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -116(%ebp)

    movl	-36(%ebp), %eax
    cmpl	-40(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -120(%ebp)

    cmpl	$0, -116(%ebp)
    jne .L3
    cmpl	$0, -120(%ebp)
    je .L3
    movl	$1, %eax
    jmp .L4
.L3:
    movl	$0, %eax
    jmp .L5
.L4:
    movl	%eax, -124(%ebp)
.L5:

.BeginWhileLabel57:

    movl $ 1, %eax
    cmpl -124(%ebp), %eax

    jne EndWhileLabel58

    movl	-12(%ebp), %eax
    cmpl	-128(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -132(%ebp)

    movl $ 1, %eax
    cmpl -132(%ebp), %eax

    jne elseCondLabel61

    movl -24(%ebp) , %eax 
    movl $2.0, %edx 
    addl %eax, %edx 
    movl %edx,-140(%ebp) 

    movl -140(%ebp),%eax
    movl %eax, -24(%ebp)

    jmp endIfLabel62

.elseCondLabel61:

    movl $10.0 , %eax 
    movl $2.0 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-152(%ebp) 

    movl -24(%ebp) , %eax 
    movl -152(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-156(%ebp) 

    movl -156(%ebp),%eax
    movl %eax, -24(%ebp)

.endIfLabel62:

    movl -160(%ebp), %eax
    addl %eax, -36(%ebp)

    jmp BeginWhileLabel57

.EndWhileLabel58:

    movl	-4(%ebp), %eax
    cmpl	8(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -164(%ebp)

    movl	-168(%ebp), %eax
    cmpl	8(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -172(%ebp)

    cmpl	$0, -164(%ebp)
    je .L6
    cmpl	$0, -172(%ebp)
    je .L6
    movl	$1, %eax
    jmp .L7
.L6:
    movl	$0, %eax
    jmp .L8
.L7:
    movl	%eax, -176(%ebp)
.L8:

    movl $ 1, %eax
    cmpl -176(%ebp), %eax

    jne elseCondLabel74

    movl $4.0 , %eax 
    movl -24(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-188(%ebp) 

    movl $35.0, %eax 
    movl -188(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-192(%ebp) 

    movl -192(%ebp) , %eax 
    movl $498.0 , %edx 
    subl %eax, %edx 
    movl %eax,-200(%ebp) 

    movl -200(%ebp),%eax
    movl %eax, -24(%ebp)

    jmp endIfLabel75

.elseCondLabel74:

    movl $3.2, %eax 
    movl -24(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-208(%ebp) 

    movl -208(%ebp) , %eax 
    movl $12345.356 , %edx 
    subl %eax, %edx 
    movl %eax,-216(%ebp) 

    movl -216(%ebp),%eax
    movl %eax, -24(%ebp)

.endIfLabel75:

    movl -32(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-224(%ebp) 

    movl -224(%ebp),%eax
    movl %eax, -32(%ebp)

    jmp BeginWhileLabel52

.EndWhileLabel53:

    movl	8(%ebp), %eax 
    negl	%eax 
    movl	%eax, -228(%ebp) 

    movl -24(%ebp) , %eax 
    movl -228(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-232(%ebp) 

    movl $23.0 , %eax 
    movl 12(%ebp) , %edx 
    imull %edx, %eax 
    movl %eax,-240(%ebp) 

    movl -232(%ebp) , %eax 
    movl -240(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-244(%ebp) 

    movl $2.0 , %eax 
    movl $4.0 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-256(%ebp) 

    movl -244(%ebp) , %eax 
    movl -256(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-260(%ebp) 

    movl -260(%ebp),%eax
    movl %eax, -24(%ebp)

    movl -28(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-268(%ebp) 

    movl -268(%ebp),%eax
    movl %eax, -28(%ebp)

    jmp BeginWhileLabel49

.EndWhileLabel50:

.endIfLabel44:

    movl	-24(%ebp), %eax 
    negl	%eax 
    movl	%eax, -272(%ebp) 

    movl -272(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $80.0,-8(%ebp)

    movl	-16(%ebp), %eax 
    negl	%eax 
    movl	%eax, -20(%ebp) 

    movl -20(%ebp),%eax
    movl %eax, -24(%ebp)

    movl $4.3,-16(%ebp)

    movl	-28(%ebp), %eax 
    negl	%eax 
    movl	%eax, -32(%ebp) 

    movl -32(%ebp),%eax
    movl %eax, -20(%ebp)

    movl $2 , 4(%esp)

    call potencia

    movl %eax,-4(%ebp)

    movl -4(%ebp) , %eax 
    movl $2.0, %edx 
    addl %eax, %edx 
    movl %edx,-48(%ebp) 


    call multiples

    movl -52(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


