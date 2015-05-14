;entete
extrn lirent:proc, ecrent:proc 
extrn ecrbool:proc 
extrn ecrch:proc,ligsuiv:proc

.model SMALL
.586

.CODE
debut:
	STARTUPCODE

;ouvrePrinc 4
mov bp,sp
sub sp,4

;ouvrePrinc 6
mov bp,sp
sub sp,6

;iconst 2
push word ptr 2

;istore -2
pop ax 
mov word ptr [bp-2],ax

;iload -2
push word ptr [bp-2]

;iconst 4
push word ptr 4

;iinf 
pop bx 
pop ax 
cmp ax,bx 
jge $+6 
push -1 
jmp $+4 
push 0 

;ecrireEnt
call ecrent

;iconst 2
push word ptr 2

;iload -2
push word ptr [bp-2]

;imul 
pop bx 
pop ax 
imul bx
push ax

;iconst 3
push word ptr 3

;iadd 
pop bx 
pop ax 
add ax, bx 
push ax

;iload -2
push word ptr [bp-2]

;iconst 3
push word ptr 3

;imul 
pop bx 
pop ax 
imul bx
push ax

;iadd 
pop bx 
pop ax 
add ax, bx 
push ax

;ecrireEnt
call ecrent

;queue
nop 
exitcode
end debut
