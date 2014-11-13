

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

    cmpl $0, -8(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -40(%ebp) 

    movl -40(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp endIfLabel7

.elseCondLabel6:

.endIfLabel7:

    movl	-4(%ebp), %eax
    cmpl	12(%ebp), %eax
    setle %al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

.BeginWhileLabel11:

    movl $ 1, %eax
    cmpl -44(%ebp), %eax

    jne EndWhileLabel12

    movl -12(%ebp), %eax 
    movl 8(%ebp), %edx 
    imull %edx, %eax 
    movl %eax,-48(%ebp) 

    movl -48(%ebp),%eax
    movl %eax, -12(%ebp)

    movl -4(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-56(%ebp) 

    movl -56(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp BeginWhileLabel11

.EndWhileLabel12:

    cmpl $0, -8(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -60(%ebp) 

    cmpl $0, -60(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -64(%ebp) 

    movl $ 1, %eax
    cmpl -64(%ebp), %eax

    jne elseCondLabel18

    movl $1.0, %eax 
    movl -12(%ebp), %ecx
	 cltd
    idiv %ecx
    movl %ecx,-72(%ebp) 

    movl -72(%ebp), %eax

    jmp endIfLabel19

.elseCondLabel18:

    movl -12(%ebp), %eax

.endIfLabel19:

    movl	-76(%ebp), %eax 
    negl	%eax 
    movl	%eax, -80(%ebp) 

    movl -80(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $8.0,-8(%ebp)

    movl $2, 4(%esp)

    call potencia

    movl %eax,-4(%ebp)

    movl -4(%esp), %eax
    movl %eax,4(%esp)

    call imprimir

    leave
    ret


