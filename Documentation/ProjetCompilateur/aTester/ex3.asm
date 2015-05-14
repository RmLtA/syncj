;entete
extrn lirent:proc, ecrent:proc 
extrn ecrbool:proc 
extrn ecrch:proc,ligsuiv:proc

.model SMALL
.586

.CODE
facto : 
;ouvBloc 0
enter 0,0
;iload 4
push word ptr [bp+4]

;iconst 1
push word ptr 1

;iegal 
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0 

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iconst 1
push word ptr 1

;ireturn 6
pop ax
 mov [bp+6],ax

SINON1:
;iload 4
push word ptr [bp+4]

;ireturn 6
pop ax
 mov [bp+6],ax

;iconst 1
push word ptr 1

;ireturn 6
pop ax
 mov [bp+6],ax

;reserveRetour 
sub sp,2
;iload 4
push word ptr [bp+4]

;ireturn 6
pop ax
 mov [bp+6],ax

;iconst 1
push word ptr 1

;ireturn 6
pop ax
 mov [bp+6],ax

;isub 
pop bx 
pop ax 
sub ax, bx 
push ax

;call facto
call facto
;imul 
pop bx 
pop ax 
imul bx
push ax

FSI1:
;fermebloc 2
leave
ret 2


combin : 
;ouvBloc 6
enter 6,0
;reserveRetour 
sub sp,2
;iload 6
push word ptr [bp+6]

;call facto
call facto
;istore -2
pop ax 
mov word ptr [bp-2],ax

;reserveRetour 
sub sp,2
;iload 4
push word ptr [bp+4]

;call facto
call facto
;istore -4
pop ax 
mov word ptr [bp-4],ax

;reserveRetour 
sub sp,2
;iload 6
push word ptr [bp+6]

;iload 4
push word ptr [bp+4]

;isub 
pop bx 
pop ax 
sub ax, bx 
push ax

;call facto
call facto
;istore -6
pop ax 
mov word ptr [bp-6],ax

;iload -2
push word ptr [bp-2]

;ireturn 6
pop ax
 mov [bp+6],ax

;iload -4
push word ptr [bp-4]

;ireturn 6
pop ax
 mov [bp+6],ax

;iload -6
push word ptr [bp-6]

;ireturn 6
pop ax
 mov [bp+6],ax

;imul 
pop bx 
pop ax 
imul bx
push ax

;idiv 
pop bx 
pop ax 
cwd 
idiv bx
push ax

;fermebloc 4
leave
ret 4


arrang : 
;ouvBloc 4
enter 4,0
;reserveRetour 
sub sp,2
;iload 6
push word ptr [bp+6]

;call facto
call facto
;istore -2
pop ax 
mov word ptr [bp-2],ax

;reserveRetour 
sub sp,2
;iload 4
push word ptr [bp+4]

;call facto
call facto
;istore -4
pop ax 
mov word ptr [bp-4],ax

;iload -2
push word ptr [bp-2]

;ireturn 6
pop ax
 mov [bp+6],ax

;iload -4
push word ptr [bp-4]

;ireturn 6
pop ax
 mov [bp+6],ax

;idiv 
pop bx 
pop ax 
cwd 
idiv bx
push ax

;fermebloc 4
leave
ret 4


debut:
	STARTUPCODE

main :
;ouvBloc 10
enter 10,0
;iconst 0
push word ptr 0

;istore -10
pop ax 
mov word ptr [bp-10],ax

FAIRE1 :
;iload -10
push word ptr [bp-10]

;iconst 3
push word ptr 3

;idiff 
pop bx
pop ax
cmp ax,bx
je $+6
push -1
jmp $+4
push 0 

;iffaux FAIT1
pop ax
cmp ax,0
je FAIT1

;ecrireChaine " fact (0)arr (1),combi(2) ou sortie (3) ?" 
.DATA
mess0 DB "  fact (0)arr (1),combi(2) ou sortie (3) ?$" 
.CODE 
lea dx, mess0
push dx
call ecrch

;lireEnt -10
lea dx,[bp-10]
push dx
call lirent

;aLaLigne
call ligsuiv

;iload -10
push word ptr [bp-10]

;iconst 0
push word ptr 0

;iegal 
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0 

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;ecrireChaine "n:" 
.DATA
mess1 DB " n:$" 
.CODE 
lea dx, mess1
push dx
call ecrch

;lireEnt -6
lea dx,[bp-6]
push dx
call lirent

;aLaLigne
call ligsuiv

;ecrireChaine "fact(n)= " 
.DATA
mess2 DB " fact(n)= $" 
.CODE 
lea dx, mess2
push dx
call ecrch

;reserveRetour 
sub sp,2
;iload -6
push word ptr [bp-6]

;call facto
call facto
;istore -8
pop ax 
mov word ptr [bp-8],ax

;iload -8
push word ptr [bp-8]

;ecrireEnt
call ecrent

SINON2:
;iload -10
push word ptr [bp-10]

;iconst 3
push word ptr 3

;idiff 
pop bx
pop ax
cmp ax,bx
je $+6
push -1
jmp $+4
push 0 

;iffaux SINON3
pop ax
cmp ax,0
je SINON3

;ecrireChaine "n:" 
.DATA
mess3 DB " n:$" 
.CODE 
lea dx, mess3
push dx
call ecrch

;lireEnt -6
lea dx,[bp-6]
push dx
call lirent

;aLaLigne
call ligsuiv

;ecrireChaine "p:" 
.DATA
mess4 DB " p:$" 
.CODE 
lea dx, mess4
push dx
call ecrch

;lireEnt -8
lea dx,[bp-8]
push dx
call lirent

;aLaLigne
call ligsuiv

;iload -6
push word ptr [bp-6]

;iload -8
push word ptr [bp-8]

;iinf 
pop bx 
pop ax 
cmp ax,bx 
jge $+6 
push -1 
jmp $+4 
push 0 

;iffaux SINON4
pop ax
cmp ax,0
je SINON4

;ecrireChaine "n<p impossible" 
.DATA
mess5 DB " n<p impossible$" 
.CODE 
lea dx, mess5
push dx
call ecrch

SINON4:
;iload -10
push word ptr [bp-10]

;iconst 1
push word ptr 1

;iegal 
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0 

;iffaux SINON5
pop ax
cmp ax,0
je SINON5

;reserveRetour 
sub sp,2
;iload -6
push word ptr [bp-6]

;iload -8
push word ptr [bp-8]

;call arrang
call arrang
;istore -4
pop ax 
mov word ptr [bp-4],ax

;ecrireChaine "A(n,p)=" 
.DATA
mess6 DB " A(n,p)=$" 
.CODE 
lea dx, mess6
push dx
call ecrch

;iload -4
push word ptr [bp-4]

;ecrireEnt
call ecrent

SINON5:
;reserveRetour 
sub sp,2
;iload -6
push word ptr [bp-6]

;iload -8
push word ptr [bp-8]

;call combin
call combin
;istore -2
pop ax 
mov word ptr [bp-2],ax

;ecrireChaine "C(n,p)=" 
.DATA
mess7 DB " C(n,p)=$" 
.CODE 
lea dx, mess7
push dx
call ecrch

;iload -2
push word ptr [bp-2]

;ecrireEnt
call ecrent

FSI5:
;aLaLigne
call ligsuiv

FSI4:
SINON3:
FSI3:
FSI2:
goto FAIRE1
jmp FAIRE1

FAIT1:
;queue
nop 
exitcode
end debut
