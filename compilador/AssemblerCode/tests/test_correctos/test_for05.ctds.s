buscado: A
actual VarLocation{name=A, type=int[], expr=null, size=5}

    .comm A,20

    .comm B,224

    .comm C,40


    .text
    .globl	par
    .type	par, @function 
par: 
    pushl	%ebp
    movl %esp, %ebp

    movl $15, %eax

    leave
    ret



    .text
    .globl	pruArreglos
    .type	pruArreglos, @function 
pruArreglos: 
    enter   $(8), $0 
    pushl	%ebp
    movl %esp, %ebp

    movl $2,-44(%ebp)

    movl -40(%ebp), %eax

    call par

    call par

    movl $MethodCallExpr{name=par, args=[]}, %eax 
    movl $5, %edx 
    addl %eax, %edx 
    movl %edx,-36(%ebp) 

.BeginForLabel12:

    movl -36(%ebp), %eax
    cmpl -24(%ebp), %eax

    jnl EndForLabel13

    movl -4(%ebp), %eax 
    movl $2, %edx 
    addl %eax, %edx 
    movl %edx,-44(%ebp) 

    movl -44(%ebp),%eax
    movl %eax, -44(%ebp)

    movl $MethodCallExpr{name=par, args=[]}, %eax 
    movl $1, %edx 
    addl %eax, %edx 
    movl %edx,-24(%ebp) 

    jmp BeginForLabel12

.EndForLabel13:

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


