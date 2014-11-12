{PARAM, null, null, Result: [0.0]}
0.0 , class ir.ast.FloatLiteral
{PARAM, null, null, Result: [StringLiteral{value="%f"}, VarLocation{name=f, type=float, expr=0.0, size=0}]}
VarLocation{name=f, type=float, expr=0.0, size=0} , class ir.ast.VarLocation
StringLiteral{value="%f"} , class ir.ast.StringLiteral


    .text
    .globl	sumatoria
    .type	sumatoria, @function 
sumatoria: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $0.0,-4(%ebp)

    movl 8(%ebp),%eax
    movl %eax, -8(%ebp)

    movl	-8(%ebp), %eax
    cmpl	-20(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -24(%ebp)

    movl	-8(%ebp), %eax
    cmpl	-28(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -32(%ebp)

    cmpl	$0, -24(%ebp)
    jne .L0
    cmpl	$0, -32(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -36(%ebp)
.L2:

.BeginWhileLabel7:

    movl $ 1, %eax
    cmpl -36(%ebp), %eax

    jne EndWhileLabel8

    movl	-8(%ebp), %eax
    cmpl	-40(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

    movl $ 1, %eax
    cmpl -44(%ebp), %eax

    jne elseCondLabel11

    movl -4(%ebp) , %eax 
    movl -8(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-48(%ebp) 

    movl -48(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp endIfLabel12

.elseCondLabel11:

.endIfLabel12:

    movl -52(%ebp), %eax
    subl %eax, -8(%ebp)

    jmp BeginWhileLabel7

.EndWhileLabel8:

    movl -4(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -12(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $8.0,-8(%ebp)


    call sumatoria

    movl %eax,-4(%ebp)

    movl -4(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


