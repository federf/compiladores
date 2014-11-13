

    .text
    .globl	neg
    .type	neg, @function 
neg: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    cmpl $0, 8(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -4(%ebp) 

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	and
    .type	and, @function 
and: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    cmpl	$0, 8(%ebp)
    je .L0
    cmpl	$0, 12(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -4(%ebp)
.L2:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	or
    .type	or, @function 
or: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    cmpl	$0, 8(%ebp)
    jne .L3
    cmpl	$0, 12(%ebp)
    je .L3
    movl	$1, %eax
    jmp .L4
.L3:
    movl	$0, %eax
    jmp .L5
.L4:
    movl	%eax, -4(%ebp)
.L5:

    movl -4(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $1,-4(%ebp)

    movl $0,-8(%ebp)

    movl $0, 0(%esp)
    call neg

    movl %eax,-8(%ebp)

    movl $0, 4(%esp)    movl $0, 0(%esp)
    call and

    movl %eax,-12(%ebp)

    movl $0, 0(%esp)
    call neg

    movl %eax,-16(%ebp)

    movl $0, 4(%esp)    movl $0, 0(%esp)
    call or

    movl %eax,-20(%ebp)

    movl -20(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


