Error: Method pruebaLogica must return int

    .comm bool,4


    .text
    .globl	pruebaLogica
    .type	pruebaLogica, @function 
pruebaLogica: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $1,-4(%ebp)

    cmpl	$0, -8(%ebp)
    jne .L0
    cmpl	$0, -4(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -12(%ebp)
.L2:

    cmpl $0, -16(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -20(%ebp) 

    cmpl	$0, -12(%ebp)
    je .L3
    cmpl	$0, -20(%ebp)
    je .L3
    movl	$1, %eax
    jmp .L4
.L3:
    movl	$0, %eax
    jmp .L5
.L4:
    movl	%eax, -24(%ebp)
.L5:

    cmpl $0, 8(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -28(%ebp) 

    cmpl	$0, -24(%ebp)
    je .L6
    cmpl	$0, -28(%ebp)
    je .L6
    movl	$1, %eax
    jmp .L7
.L6:
    movl	$0, %eax
    jmp .L8
.L7:
    movl	%eax, -32(%ebp)
.L8:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $1, 0(%esp)
    call pruebaLogica

    movl -8(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


