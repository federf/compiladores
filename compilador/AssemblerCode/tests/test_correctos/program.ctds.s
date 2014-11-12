{PARAM, null, null, Result: []}
{PARAM, null, null, Result: [0]}
0 , class ir.ast.IntLiteral
{PARAM, null, null, Result: [StringLiteral{value="y==1\n"}]}
StringLiteral{value="y==1\n"} , class ir.ast.StringLiteral
{PARAM, null, null, Result: [StringLiteral{value="y==%d\n"}, VarLocation{name=y, type=int, expr=0, size=0}]}
VarLocation{name=y, type=int, expr=0, size=0} , class ir.ast.VarLocation
StringLiteral{value="y==%d\n"} , class ir.ast.StringLiteral


    .text
    .globl	inc
    .type	inc, @function 
inc: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl 8(%ebp) , %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-8(%ebp) 

    movl -8(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp


    call get_int

    movl %eax,-8(%ebp) 

    movl $0 , 0(%esp)

    call inc

    movl %eax,-4(%ebp)

    movl	-4(%ebp), %eax
    cmpl	-20(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -24(%ebp)

    movl $ 1, %eax
    cmpl -24(%ebp), %eax

    jne elseCondLabel9


    call imprimir

    jmp endIfLabel10

.elseCondLabel9:

    movl -4(%esp) , %eax
    movl %eax,4(%esp)

    call imprimir

.endIfLabel10:

    leave
    ret


