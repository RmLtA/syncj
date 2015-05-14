;entete
extrn lirent:proc, ecrent:proc 
extrn ecrbool:proc 
extrn ecrch:proc,ligsuiv:proc

.model SMALL
.586

.CODE
valeurde : 
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

;iconst 100
push word ptr 100

;ireturn 6
pop ax
 mov [bp+6],ax

SINON1:
;iload 4
push word ptr [bp+4]

;iconst 2
push word ptr 2

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

;iconst 50
push word ptr 50

;ireturn 6
pop ax
 mov [bp+6],ax

SINON2:
;iload 4
push word ptr [bp+4]

;iconst 3
push word ptr 3

;iegal 
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0 

;iffaux SINON3
pop ax
cmp ax,0
je SINON3

;iconst 20
push word ptr 20

;ireturn 6
pop ax
 mov [bp+6],ax

SINON3:
;iload 4
push word ptr [bp+4]

;iconst 4
push word ptr 4

;iegal 
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0 

;iffaux SINON4
pop ax
cmp ax,0
je SINON4

;iconst 10
push word ptr 10

;ireturn 6
pop ax
 mov [bp+6],ax

SINON4:
;iload 4
push word ptr [bp+4]

;iconst 5
push word ptr 5

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

;iconst 5
push word ptr 5

;ireturn 6
pop ax
 mov [bp+6],ax

SINON5:
;iload 4
push word ptr [bp+4]

;iconst 6
push word ptr 6

;iegal 
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0 

;iffaux SINON6
pop ax
cmp ax,0
je SINON6

;iconst 2
push word ptr 2

;ireturn 6
pop ax
 mov [bp+6],ax

SINON6:
;iload 4
push word ptr [bp+4]

;iconst 7
push word ptr 7

;iegal 
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0 

;iffaux SINON7
pop ax
cmp ax,0
je SINON7

;iconst 1
push word ptr 1

;ireturn 6
pop ax
 mov [bp+6],ax

SINON7:
FSI7:
FSI6:
FSI5:
FSI4:
FSI3:
FSI2:
FSI1:
;fermebloc 2
leave
ret 2


nbc : 
;ouvBloc 6
enter 6,0
;iload 6
push word ptr [bp+6]

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

;iffaux SINON8
pop ax
cmp ax,0
je SINON8

;iconst 1
push word ptr 1

;istore -4
pop ax 
mov word ptr [bp-4],ax

SINON8:
;iload 6
push word ptr [bp+6]

;iconst 0
push word ptr 0

;iinf 
pop bx 
pop ax 
cmp ax,bx 
jge $+6 
push -1 
jmp $+4 
push 0 

;iload 4
push word ptr [bp+4]

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

;ior 
;iffaux SINON9
pop ax
cmp ax,0
je SINON9

;iconst 0
push word ptr 0

;istore -4
pop ax 
mov word ptr [bp-4],ax

SINON9:
;reserveRetour 
sub sp,2
;iload 4
push word ptr [bp+4]

;call valeurde
call valeurde
;istore -6
pop ax 
mov word ptr [bp-6],ax

;reserveRetour 
sub sp,2
;iload 6
push word ptr [bp+6]

;iload -6
push word ptr [bp-6]

;isub 
pop bx 
pop ax 
sub ax, bx 
push ax

;iload 4
push word ptr [bp+4]

;call nbc
call nbc
;istore -4
pop ax 
mov word ptr [bp-4],ax

;reserveRetour 
sub sp,2
;iload 6
push word ptr [bp+6]

;iload 4
push word ptr [bp+4]

;iconst 1
push word ptr 1

;isub 
pop bx 
pop ax 
sub ax, bx 
push ax

;call nbc
call nbc
;istore -2
pop ax 
mov word ptr [bp-2],ax

;iload -4
push word ptr [bp-4]

;iload -2
push word ptr [bp-2]

;iadd 
pop bx 
pop ax 
add ax, bx 
push ax

;istore -4
pop ax 
mov word ptr [bp-4],ax

FSI9:
FSI8:
;iload -4
push word ptr [bp-4]

;ireturn 8
pop ax
 mov [bp+8],ax

;fermebloc 4
leave
ret 4


debut:
	STARTUPCODE

main :
;ouvBloc 4
enter 4,0
;ecrireChaine "donner le montant: " 
.DATA
mess0 DB " donner le montant: $" 
.CODE 
lea dx, mess0
push dx
call ecrch

;aLaLigne
call ligsuiv

;lireEnt -2
lea dx,[bp-2]
push dx
call lirent

;reserveRetour 
sub sp,2
;iload -2
push word ptr [bp-2]

;iconst 7
push word ptr 7

;call nbc
call nbc
;istore -4
pop ax 
mov word ptr [bp-4],ax

;ecrireChaine "il y a " 
.DATA
mess1 DB " il y a $" 
.CODE 
lea dx, mess1
push dx
call ecrch

;iload -4
push word ptr [bp-4]

;ecrireEnt
call ecrent

;ecrireChaine " facons de changer " 
.DATA
mess2 DB "  facons de changer $" 
.CODE 
lea dx, mess2
push dx
call ecrch

;iload -2
push word ptr [bp-2]

;ecrireEnt
call ecrent

;ecrireChaine ' francs.' 
.DATA
mess3 DB "  francs.$" 
.CODE 
lea dx, mess3
push dx
call ecrch

;aLaLigne
call ligsuiv

;queue
nop 
exitcode
end debut
