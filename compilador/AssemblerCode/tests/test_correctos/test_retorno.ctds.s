

    .text
    .globl	id
    .type	id, @function 
id: 
    enter   $(4), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $100,-4(%ebp)

    movl $0,-8(%ebp)

    movl 8(%ebp),%eax
    movl %eax, -12(%ebp)

    movl	-8(%ebp), %eax
    cmpl	-4(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -24(%ebp)

.BeginWhileLabel4:

    movl $ 1, %eax
    cmpl -24(%ebp), %eax

    jne EndWhileLabel5

    movl 8(%ebp),%eax
    movl %eax, -28(%ebp)

    movl	8(%ebp), %eax
    cmpl	-32(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -36(%ebp)

    movl	8(%ebp), %eax
    cmpl	-40(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

    cmpl	$0, -36(%ebp)
    jne .L0
    cmpl	$0, -44(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -48(%ebp)
.L2:

.BeginWhileLabel11:

    movl $ 1, %eax
    cmpl -48(%ebp), %eax

    jne EndWhileLabel12

    movl	8(%ebp), %eax
    cmpl	-52(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -56(%ebp)

    movl $ 1, %eax
    cmpl -56(%ebp), %eax

    jne elseCondLabel15

    movl 8(%ebp), %eax 
    movl $1, %edx 
    subl %eax, %edx 
    movl %eax,-64(%ebp) 

    movl -64(%ebp),%eax
    movl %eax, 0(%ebp)

    jmp endIfLabel16

.elseCondLabel15:

    movl 8(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-72(%ebp) 

    movl -72(%ebp),%eax
    movl %eax, 0(%ebp)

.endIfLabel16:

    jmp BeginWhileLabel11

.EndWhileLabel12:

    movl	8(%ebp), %eax
    cmpl	-28(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -76(%ebp)

    movl	8(%ebp), %eax
    cmpl	-28(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -80(%ebp)

    cmpl	$0, -76(%ebp)
    jne .L3
    cmpl	$0, -80(%ebp)
    je .L3
    movl	$1, %eax
    jmp .L4
.L3:
    movl	$0, %eax
    jmp .L5
.L4:
    movl	%eax, -84(%ebp)
.L5:

.BeginWhileLabel24:

    movl $ 1, %eax
    cmpl -84(%ebp), %eax

    jne EndWhileLabel25

    movl	8(%ebp), %eax
    cmpl	-28(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -88(%ebp)

    movl $ 1, %eax
    cmpl -88(%ebp), %eax

    jne elseCondLabel27

    movl 8(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-96(%ebp) 

    movl -96(%ebp),%eax
    movl %eax, 0(%ebp)

    jmp endIfLabel28

.elseCondLabel27:

    movl	8(%ebp), %eax
    cmpl	8(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -100(%ebp)

    movl $ 1, %eax
    cmpl -100(%ebp), %eax

    jne elseCondLabel32

    movl 8(%ebp), %eax 
    movl $1, %edx 
    subl %eax, %edx 
    movl %eax,-108(%ebp) 

    movl -8(%ebp), %eax 
    movl 8(%ebp), %edx 
    imull %edx, %eax 
    movl %eax,-112(%ebp) 

    movl -8(%ebp), %eax 
    movl 8(%ebp), %edx 
    imull %edx, %eax 
    movl %eax,-116(%ebp) 

    movl -112(%ebp), %eax 
    movl -116(%ebp), %edx 
    subl %eax, %edx 
    movl %eax,-120(%ebp) 

    movl -108(%ebp), %eax 
    movl -120(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-124(%ebp) 

    movl -124(%ebp),%eax
    movl %eax, 0(%ebp)

    jmp endIfLabel33

.elseCondLabel32:

.endIfLabel33:

.endIfLabel28:

    jmp BeginWhileLabel24

.EndWhileLabel25:

    movl -12(%ebp),%eax
    movl %eax, 0(%ebp)

    movl -8(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-132(%ebp) 

    movl -132(%ebp),%eax
    movl %eax, -8(%ebp)

    jmp BeginWhileLabel4

.EndWhileLabel5:

    movl 0(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $9, 0(%esp)

    call id

    movl -8(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


