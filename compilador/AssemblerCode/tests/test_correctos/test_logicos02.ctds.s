{PARAM, null, null, Result: [3.3, 0.66, 10.0]}
10.0 , class ir.ast.FloatLiteral
0.66 , class ir.ast.FloatLiteral
3.3 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [StringLiteral{value="%f resultado : "}, VarLocation{name=factorLabel36, type=float, expr=MethodCallExpr{name=promedio, args=[3.3, 0.66, 10.0]}, size=0}]}
VarLocation{name=factorLabel36, type=float, expr=MethodCallExpr{name=promedio, args=[3.3, 0.66, 10.0]}, size=0} , class ir.ast.VarLocation
StringLiteral{value="%f resultado : "} , class ir.ast.StringLiteral


    .text
    .globl	promedio
    .type	promedio, @function 
promedio: 
    enter   $(12), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -4(%ebp)

    movl	16(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -8(%ebp)

    cmpl	$0, -4(%ebp)
    je .L0
    cmpl	$0, -8(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -12(%ebp)
.L2:

    movl $ 1, %eax
    cmpl -12(%ebp), %eax

    jne elseCondLabel4

    movl 8(%ebp) , %eax 
    movl 16(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-16(%ebp) 

    movl -16(%ebp) , %eax 
    movl $2.0 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-24(%ebp) 

    movl -24(%ebp), %eax

    jmp endIfLabel5

.elseCondLabel4:

.endIfLabel5:

    movl	8(%ebp), %eax
    cmpl	16(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -28(%ebp)

    movl	12(%ebp), %eax
    cmpl	16(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -32(%ebp)

    cmpl	$0, -28(%ebp)
    je .L3
    cmpl	$0, -32(%ebp)
    je .L3
    movl	$1, %eax
    jmp .L4
.L3:
    movl	$0, %eax
    jmp .L5
.L4:
    movl	%eax, -36(%ebp)
.L5:

    movl $ 1, %eax
    cmpl -36(%ebp), %eax

    jne elseCondLabel12

    movl 8(%ebp) , %eax 
    movl 12(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-40(%ebp) 

    movl -40(%ebp) , %eax 
    movl $2.0 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-48(%ebp) 

    movl -48(%ebp), %eax

    jmp endIfLabel13

.elseCondLabel12:

.endIfLabel13:

    movl	16(%ebp), %eax
    cmpl	8(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -52(%ebp)

    movl	12(%ebp), %eax
    cmpl	8(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -56(%ebp)

    cmpl	$0, -52(%ebp)
    je .L6
    cmpl	$0, -56(%ebp)
    je .L6
    movl	$1, %eax
    jmp .L7
.L6:
    movl	$0, %eax
    jmp .L8
.L7:
    movl	%eax, -60(%ebp)
.L8:

    movl $ 1, %eax
    cmpl -60(%ebp), %eax

    jne elseCondLabel20

    movl 12(%ebp) , %eax 
    movl 16(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-64(%ebp) 

    movl -64(%ebp) , %eax 
    movl $2.0 , %ecx
	 cltd
    idiv %ecx
    movl %ecx,-72(%ebp) 

    movl -72(%ebp), %eax

    jmp endIfLabel21

.elseCondLabel20:

.endIfLabel21:

    movl	8(%ebp), %eax
    cmpl	16(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -76(%ebp)

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -80(%ebp)

    cmpl	$0, -76(%ebp)
    je .L9
    cmpl	$0, -80(%ebp)
    je .L9
    movl	$1, %eax
    jmp .L10
.L9:
    movl	$0, %eax
    jmp .L11
.L10:
    movl	%eax, -84(%ebp)
.L11:

    movl	16(%ebp), %eax
    cmpl	12(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -88(%ebp)

    cmpl	$0, -84(%ebp)
    je .L12
    cmpl	$0, -88(%ebp)
    je .L12
    movl	$1, %eax
    jmp .L13
.L12:
    movl	$0, %eax
    jmp .L14
.L13:
    movl	%eax, -92(%ebp)
.L14:

    movl $ 1, %eax
    cmpl -92(%ebp), %eax

    jne elseCondLabel30

    movl 8(%ebp), %eax

    jmp endIfLabel31

.elseCondLabel30:

.endIfLabel31:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp


    call promedio

    movl -16(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    movl $1, %eax

    leave
    ret


