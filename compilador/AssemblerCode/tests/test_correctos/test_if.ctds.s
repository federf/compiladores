Error: Method pruAritmetica must return int


    .text
    .globl	pruAritmetica
    .type	pruAritmetica, @function 
pruAritmetica: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -8(%ebp)

    movl $ 1, %eax
    cmpl -8(%ebp), %eax

    jne elseCondLabel2

    movl 8(%ebp), %eax 
    movl 12(%ebp), %edx 
    subl %eax, %edx 
    movl %eax,-12(%ebp) 

    movl -12(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp endIfLabel3

.elseCondLabel2:

.endIfLabel3:

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -16(%ebp)

    movl $ 1, %eax
    cmpl -16(%ebp), %eax

    jne elseCondLabel6

    movl 8(%ebp), %eax 
    movl $5, %edx 
    imull %edx, %eax 
    movl %eax,-24(%ebp) 

    movl -24(%ebp),%eax
    movl %eax, -4(%ebp)

    jmp endIfLabel7

.elseCondLabel6:

    movl 12(%ebp), %eax 
    movl 8(%ebp), %edx 
    subl %eax, %edx 
    movl %eax,-28(%ebp) 

    movl -28(%ebp),%eax
    movl %eax, -4(%ebp)

.endIfLabel7:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $8, 4(%esp)
    movl $4, 0(%esp)

    call pruAritmetica

    movl -12(%esp), %eax
    movl %eax,0(%esp)

    call imprimir


    call imprimir

    movl $4, 4(%esp)
    movl $4, 0(%esp)

    call pruAritmetica

    movl -24(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    movl $5, 4(%esp)
    movl $8, 0(%esp)

    call pruAritmetica

    movl -36(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


