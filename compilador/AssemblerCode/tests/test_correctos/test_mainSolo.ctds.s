

    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $1,-4(%ebp)

    cmpl $0, -4(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -8(%ebp)

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
    movl	%eax, -32(%ebp)
.L2:

    cmpl $0, -8(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -36(%ebp) 

    cmpl	$0, -32(%ebp)
    jne .L3
    cmpl	$0, -36(%ebp)
    je .L3
    movl	$1, %eax
    jmp .L4
.L3:
    movl	$0, %eax
    jmp .L5
.L4:
    movl	%eax, -40(%ebp)
.L5:

    movl -40(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -12(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


