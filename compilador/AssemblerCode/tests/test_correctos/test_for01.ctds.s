buscado: A
actual VarLocation{name=A, type=int[], expr=null, size=5}

    .comm A,20

    .comm B,224

    .comm C,40


    .text
    .globl	pruArreglos
    .type	pruArreglos, @function 
pruArreglos: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $2,-44(%ebp)

    movl -40(%ebp), %eax

    movl -4(%ebp), %eax 
    movl $10, %edx 
    imull %edx, %eax 
    movl %eax,-32(%ebp) 

.BeginForLabel8:

    movl -32(%ebp), %eax
    cmpl -24(%ebp), %eax

    jnl EndForLabel9

    movl -4(%ebp), %eax 
    movl $2, %edx 
    addl %eax, %edx 
    movl %edx,-40(%ebp) 

    movl -40(%ebp),%eax
    movl %eax, -44(%ebp)

    movl $5, %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-24(%ebp) 

    jmp BeginForLabel8

.EndForLabel9:

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
    movl %eax,4(%esp)

    call imprimir

    movl $1, %eax

    leave
    ret


