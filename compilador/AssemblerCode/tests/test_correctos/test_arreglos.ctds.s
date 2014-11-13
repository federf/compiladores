Error: Method pruArreglos must return int

    .comm A,2356

    .comm B,224

    .comm C,20


    .text
    .globl	pruArreglos
    .type	pruArreglos, @function 
pruArreglos: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -44(%ebp)

    movl $ 1, %eax
    cmpl -44(%ebp), %eax

    jne elseCondLabel2

    movl $1, %eax 
    movl 12(%ebp), %edx 
    subl %eax, %edx 
    movl %eax,-56(%ebp) 

    movl -56(%ebp),%eax
    movl %eax, -68(%ebp)

    jmp endIfLabel3

.elseCondLabel2:

.endIfLabel3:

    movl	8(%ebp), %eax
    cmpl	12(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -60(%ebp)

    movl $ 1, %eax
    cmpl -60(%ebp), %eax

    jne elseCondLabel8

    movl $1, %eax 
    movl $1, %edx 
    subl %eax, %edx 
    movl %eax,-72(%ebp) 

    movl 8(%ebp), %eax 
    movl $5, %edx 
    imull %edx, %eax 
    movl %eax,-80(%ebp) 

    movl -80(%ebp),%eax
    movl %eax, -68(%ebp)

    jmp endIfLabel9

.elseCondLabel8:

    movl 8(%ebp), %eax 
    movl 8(%ebp), %edx 
    subl %eax, %edx 
    movl %eax,-84(%ebp) 

    movl 12(%ebp),%eax
    movl %eax, -68(%ebp)

.endIfLabel9:

    movl $0,-40(%ebp)

    movl	-40(%ebp), %eax
    cmpl	-92(%ebp), %eax
    setl	%al
    movlzbl %al, %eax
    movl	%eax, -96(%ebp)

.BeginWhileLabel19:

    movl $ 1, %eax
    cmpl -96(%ebp), %eax

    jne EndWhileLabel20

    movl -40(%ebp), %eax 
    movl $2, %edx 
    imull %edx, %eax 
    movl %eax,-104(%ebp) 

    movl -104(%ebp),%eax
    movl %eax, -4716(%ebp)

    movl -108(%ebp), %eax
    addl %eax, -40(%ebp)

    jmp BeginWhileLabel19

.EndWhileLabel20:

    movl $8,-40(%ebp)

    movl	-40(%ebp), %eax
    cmpl	-116(%ebp), %eax
    setge %al
    movlzbl %al, %eax
    movl	%eax, -120(%ebp)

.BeginWhileLabel27:

    movl $ 1, %eax
    cmpl -120(%ebp), %eax

    jne EndWhileLabel28

    movl -40(%ebp), %eax 
    movl $2, %edx 
    imull %edx, %eax 
    movl %eax,-128(%ebp) 

    movl -128(%ebp), %eax 
    movl $8, %edx 
    addl %eax, %edx 
    movl %edx,-136(%ebp) 

    movl $ArrayLiteral{id=A, index=VarLocation{name=PLUSLabel32, type=int, expr=VarLocation{name=MULTIPLYLabel30, type=int, expr=VarLocation{name=i, type=int, expr=0, size=0}*VarLocation{name=factorLabel29, type=int, expr=2, size=0}, size=0}+VarLocation{name=factorLabel31, type=int, expr=8, size=0}, size=0}}, %eax 
    movl $3, %edx 
    addl %eax, %edx 
    movl %edx,-148(%ebp) 

    movl -148(%ebp),%eax
    movl %eax, -2812(%ebp)

    movl -152(%ebp), %eax
    subl %eax, -40(%ebp)

    jmp BeginWhileLabel27

.EndWhileLabel28:

    movl $0,-40(%ebp)

    movl $5, %eax 
    movl $9, %edx 
    imull %edx, %eax 
    movl %eax,-168(%ebp) 

    movl -168(%ebp), %eax 
    movl $40, %edx 
    subl %eax, %edx 
    movl %eax,-176(%ebp) 

    movl	-40(%ebp), %eax
    cmpl	-176(%ebp), %eax
    setle %al
    movlzbl %al, %eax
    movl	%eax, -180(%ebp)

.BeginWhileLabel44:

    movl $ 1, %eax
    cmpl -180(%ebp), %eax

    jne EndWhileLabel45

    movl -40(%ebp), %eax 
    movl $2, %edx 
    imull %edx, %eax 
    movl %eax,-188(%ebp) 

    movl -188(%ebp), %eax 
    movl $8, %edx 
    addl %eax, %edx 
    movl %edx,-196(%ebp) 

    movl	-200(%ebp), %eax
    cmpl	-204(%ebp), %eax
    setg	%al
    movlzbl %al, %eax
    movl	%eax, -208(%ebp)

    movl -208(%ebp),%eax
    movl %eax, -2632(%ebp)

    movl -40(%ebp), %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-216(%ebp) 

    movl -216(%ebp),%eax
    movl %eax, -40(%ebp)

    jmp BeginWhileLabel44

.EndWhileLabel45:

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

    call pruArreglos

    movl -12(%esp), %eax
    movl %eax,0(%esp)

    call imprimir


    call imprimir

    leave
    ret


