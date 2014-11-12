buscado: A
actual VarLocation{name=A, type=int[], expr=null, size=5}

    .comm A,20

    .comm B,224

    .comm C,40

    .comm y,4


    .text
    .globl	pruArreglos
    .type	pruArreglos, @function 
pruArreglos: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $8.87,-4(%ebp)

    movl $4,-44(%ebp)

    movl $2.6, %eax 
    movl -4(%ebp), %edx 
    addl %eax, %edx 
    movl %edx,-28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -476(%ebp)

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -36(%ebp)

    movl -36(%ebp),%eax
    movl %eax, -336(%ebp)

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setge %al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

    movl -44(%ebp),%eax
    movl %eax, -336(%ebp)

    movl -44(%ebp), %eax

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $1,-300(%ebp)

    movl	-16(%ebp), %eax 
    negl	%eax 
    movl	%eax, -20(%ebp) 

    movl $58, %eax 
    movl -20(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-24(%ebp) 

    movl -24(%ebp),%eax
    movl %eax, -44(%ebp)

    movl	-32(%ebp), %eax 
    negl	%eax 
    movl	%eax, -36(%ebp) 

    movl -36(%ebp),%eax
    movl %eax, -476(%ebp)

    movl	-44(%ebp), %eax
    cmpl	-48(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -52(%ebp)

    cmpl $0, -52(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -56(%ebp) 

    movl -56(%ebp),%eax
    movl %eax, -336(%ebp)

    movl $3, %eax 
    movl $3, %edx 
    addl %eax, %edx 
    movl %edx,-80(%ebp) 

    movl $7, %eax 
    movl -80(%ebp) , %edx 
    subl %eax, %edx 
    movl %eax,-84(%ebp) 

    movl	-64(%ebp), %eax
    cmpl	-88(%ebp), %eax
    setge %al
    movlzbl %al, %eax
    movl	%eax, -92(%ebp)

    cmpl	$0, -92(%ebp)
    jne .L0
    cmpl	$0, -96(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -100(%ebp)
.L2:

    movl -100(%ebp),%eax
    movl %eax, -336(%ebp)

    movl $1, %eax

    leave
    ret


