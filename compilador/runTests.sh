#!/bin/bash

#
#                           ******************                           
#*****************************     test     ****************************************
#**                         ******************                                    **
#**                                                                               **
#**Descripcion : Script que corre los casos de prueba definidos en la carpeta     **
#**              tests. cada test tiene su propio main.                          **
#**                                                                               **
#***********************************************************************************   
echo "*********************************************************************************** "
echo "**                                                                               ** " 
echo "**                            Corriendo casos de prueba . . .                    ** "                
echo "**                                                                               ** "
echo "**                                                                               ** "
echo "*********************************************************************************** "
echo "     " 
echo "     " 

comp=$1

echo "///////////////////////// TESTS[1er entrega]////////////////////////////////////////" 
files=`ls tests/*.c-tds`


for file in $files ; do 
        echo "---------------- Test $file ... -------------------" 
        java $comp $file 
        echo "---------------------------------------------------" 
        echo "  "
        echo "  "
done

echo "///////////////////////// TESTS CORRECTOS ////////////////////////////////////////" 
files=`ls tests/test_correctos/*.ctds`


for file in $files ; do 
	echo "---------------- Test $file ... -------------------" 
        java $comp $file 
	echo "---------------------------------------------------" 
        echo "  "
        echo "  "
done

echo "///////////////////////// TESTS CON FALLAS ////////////////////////////////////////" 

files=`ls tests/test_errores/*.ctds`

for file in $files ; do 
	echo "---------------- Test $file ... -------------------" 
        java $comp $file  
	echo "---------------------------------------------------" 
        echo "  "
        echo "  "
done

exit 0

