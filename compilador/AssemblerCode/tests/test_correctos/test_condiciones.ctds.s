

    .text
    .globl	dados
    .type	dados, @function 
dados: 
    enter   $(12), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl	8(%ebp), %eax
    cmpl	-4(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -8(%ebp)

    cmpl $0, -8(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -12(%ebp) 

    movl	12(%ebp), %eax
    cmpl	-16(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -20(%ebp)

    cmpl $0, -20(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -24(%ebp) 

    cmpl	$0, -12(%ebp)
    je .L0
    cmpl	$0, -24(%ebp)
    je .L0
    movl	$1, %eax
    jmp .L1
.L0:
    movl	$0, %eax
    jmp .L2
.L1:
    movl	%eax, -28(%ebp)
.L2:

    movl	16(%ebp), %eax
    cmpl	-32(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -36(%ebp)

    cmpl $0, -36(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -40(%ebp) 

    cmpl	$0, -28(%ebp)
    je .L3
    cmpl	$0, -40(%ebp)
    je .L3
    movl	$1, %eax
    jmp .L4
.L3:
    movl	$0, %eax
    jmp .L5
.L4:
    movl	%eax, -44(%ebp)
.L5:

    movl $ 1, %eax
    cmpl -44(%ebp), %eax

    jne elseCondLabel12

    movl $1.00, %eax

    jmp endIfLabel13

.elseCondLabel12:

.endIfLabel13:

    movl	8(%ebp), %eax
    cmpl	-52(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -56(%ebp)

    movl	12(%ebp), %eax
    cmpl	-60(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -64(%ebp)

    cmpl $0, -64(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -68(%ebp) 

    cmpl	$0, -56(%ebp)
    je .L6
    cmpl	$0, -68(%ebp)
    je .L6
    movl	$1, %eax
    jmp .L7
.L6:
    movl	$0, %eax
    jmp .L8
.L7:
    movl	%eax, -72(%ebp)
.L8:

    movl	16(%ebp), %eax
    cmpl	-76(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -80(%ebp)

    cmpl $0, -80(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -84(%ebp) 

    cmpl	$0, -72(%ebp)
    je .L9
    cmpl	$0, -84(%ebp)
    je .L9
    movl	$1, %eax
    jmp .L10
.L9:
    movl	$0, %eax
    jmp .L11
.L10:
    movl	%eax, -88(%ebp)
.L11:

    movl	8(%ebp), %eax
    cmpl	-92(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -96(%ebp)

    cmpl $0, -96(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -100(%ebp) 

    movl	12(%ebp), %eax
    cmpl	-104(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -108(%ebp)

    cmpl	$0, -100(%ebp)
    je .L12
    cmpl	$0, -108(%ebp)
    je .L12
    movl	$1, %eax
    jmp .L13
.L12:
    movl	$0, %eax
    jmp .L14
.L13:
    movl	%eax, -112(%ebp)
.L14:

    movl	16(%ebp), %eax
    cmpl	-116(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -120(%ebp)

    cmpl $0, -120(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -124(%ebp) 

    cmpl	$0, -112(%ebp)
    je .L15
    cmpl	$0, -124(%ebp)
    je .L15
    movl	$1, %eax
    jmp .L16
.L15:
    movl	$0, %eax
    jmp .L17
.L16:
    movl	%eax, -128(%ebp)
.L17:

    cmpl	$0, -88(%ebp)
    jne .L18
    cmpl	$0, -128(%ebp)
    je .L18
    movl	$1, %eax
    jmp .L19
.L18:
    movl	$0, %eax
    jmp .L20
.L19:
    movl	%eax, -132(%ebp)
.L20:

    movl	8(%ebp), %eax
    cmpl	-136(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -140(%ebp)

    cmpl $0, -140(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -144(%ebp) 

    movl	12(%ebp), %eax
    cmpl	-148(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -152(%ebp)

    cmpl $0, -152(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -156(%ebp) 

    cmpl	$0, -144(%ebp)
    je .L21
    cmpl	$0, -156(%ebp)
    je .L21
    movl	$1, %eax
    jmp .L22
.L21:
    movl	$0, %eax
    jmp .L23
.L22:
    movl	%eax, -160(%ebp)
.L23:

    movl	16(%ebp), %eax
    cmpl	-164(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -168(%ebp)

    cmpl	$0, -160(%ebp)
    je .L24
    cmpl	$0, -168(%ebp)
    je .L24
    movl	$1, %eax
    jmp .L25
.L24:
    movl	$0, %eax
    jmp .L26
.L25:
    movl	%eax, -172(%ebp)
.L26:

    cmpl	$0, -132(%ebp)
    jne .L27
    cmpl	$0, -172(%ebp)
    je .L27
    movl	$1, %eax
    jmp .L28
.L27:
    movl	$0, %eax
    jmp .L29
.L28:
    movl	%eax, -176(%ebp)
.L29:

    movl $ 1, %eax
    cmpl -176(%ebp), %eax

    jne elseCondLabel47

    movl $4.00, %eax

    jmp endIfLabel48

.elseCondLabel47:

.endIfLabel48:

    movl	8(%ebp), %eax
    cmpl	-184(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -188(%ebp)

    movl	12(%ebp), %eax
    cmpl	-192(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -196(%ebp)

    cmpl	$0, -188(%ebp)
    je .L30
    cmpl	$0, -196(%ebp)
    je .L30
    movl	$1, %eax
    jmp .L31
.L30:
    movl	$0, %eax
    jmp .L32
.L31:
    movl	%eax, -200(%ebp)
.L32:

    movl	16(%ebp), %eax
    cmpl	-204(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -208(%ebp)

    cmpl $0, -208(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -212(%ebp) 

    cmpl	$0, -200(%ebp)
    je .L33
    cmpl	$0, -212(%ebp)
    je .L33
    movl	$1, %eax
    jmp .L34
.L33:
    movl	$0, %eax
    jmp .L35
.L34:
    movl	%eax, -216(%ebp)
.L35:

    movl	8(%ebp), %eax
    cmpl	-220(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -224(%ebp)

    movl	12(%ebp), %eax
    cmpl	-228(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -232(%ebp)

    cmpl $0, -232(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -236(%ebp) 

    cmpl	$0, -224(%ebp)
    je .L36
    cmpl	$0, -236(%ebp)
    je .L36
    movl	$1, %eax
    jmp .L37
.L36:
    movl	$0, %eax
    jmp .L38
.L37:
    movl	%eax, -240(%ebp)
.L38:

    movl	16(%ebp), %eax
    cmpl	-244(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -248(%ebp)

    cmpl	$0, -240(%ebp)
    je .L39
    cmpl	$0, -248(%ebp)
    je .L39
    movl	$1, %eax
    jmp .L40
.L39:
    movl	$0, %eax
    jmp .L41
.L40:
    movl	%eax, -252(%ebp)
.L41:

    cmpl	$0, -216(%ebp)
    jne .L42
    cmpl	$0, -252(%ebp)
    je .L42
    movl	$1, %eax
    jmp .L43
.L42:
    movl	$0, %eax
    jmp .L44
.L43:
    movl	%eax, -256(%ebp)
.L44:

    movl	8(%ebp), %eax
    cmpl	-260(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -264(%ebp)

    cmpl $0, -264(%ebp) 
    sete %al 
    movlzbl %al, %eax 
    movl %eax, -268(%ebp) 

    movl	12(%ebp), %eax
    cmpl	-272(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -276(%ebp)

    cmpl	$0, -268(%ebp)
    je .L45
    cmpl	$0, -276(%ebp)
    je .L45
    movl	$1, %eax
    jmp .L46
.L45:
    movl	$0, %eax
    jmp .L47
.L46:
    movl	%eax, -280(%ebp)
.L47:

    movl	16(%ebp), %eax
    cmpl	-284(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -288(%ebp)

    cmpl	$0, -280(%ebp)
    je .L48
    cmpl	$0, -288(%ebp)
    je .L48
    movl	$1, %eax
    jmp .L49
.L48:
    movl	$0, %eax
    jmp .L50
.L49:
    movl	%eax, -292(%ebp)
.L50:

    cmpl	$0, -256(%ebp)
    jne .L51
    cmpl	$0, -292(%ebp)
    je .L51
    movl	$1, %eax
    jmp .L52
.L51:
    movl	$0, %eax
    jmp .L53
.L52:
    movl	%eax, -296(%ebp)
.L53:

    movl $ 1, %eax
    cmpl -296(%ebp), %eax

    jne elseCondLabel79

    movl $8.50, %eax

    jmp endIfLabel80

.elseCondLabel79:

.endIfLabel80:

    movl	8(%ebp), %eax
    cmpl	-304(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -308(%ebp)

    movl	12(%ebp), %eax
    cmpl	-312(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -316(%ebp)

    cmpl	$0, -308(%ebp)
    je .L54
    cmpl	$0, -316(%ebp)
    je .L54
    movl	$1, %eax
    jmp .L55
.L54:
    movl	$0, %eax
    jmp .L56
.L55:
    movl	%eax, -320(%ebp)
.L56:

    movl	16(%ebp), %eax
    cmpl	-324(%ebp), %eax
    sete %al
    movlzbl %al, %eax
    movl	%eax, -328(%ebp)

    cmpl	$0, -320(%ebp)
    je .L57
    cmpl	$0, -328(%ebp)
    je .L57
    movl	$1, %eax
    jmp .L58
.L57:
    movl	$0, %eax
    jmp .L59
.L58:
    movl	%eax, -332(%ebp)
.L59:

    movl $ 1, %eax
    cmpl -332(%ebp), %eax

    jne elseCondLabel90

    movl $10.00, %eax

    jmp endIfLabel91

.elseCondLabel90:

.endIfLabel91:

    leave
    ret



    .text
    .globl	main
    .type	main, @function 
main: 
    pushl	%ebp
    movl %esp, %ebp

    movl $9, 8(%esp)
    movl $6, 4(%esp)
    movl $1, 0(%esp)

    call dados

    movl -16(%esp), %eax
    movl %eax,0(%esp)

    call imprimir

    leave
    ret


