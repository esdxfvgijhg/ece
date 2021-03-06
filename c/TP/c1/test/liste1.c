#include <stdio.h>
#include <stdlib.h>
typedef struct no *liste;
typedef struct no {
	int elm;
	liste svt;
} noeud;
liste creer() /****************************************creer*/
{
	liste l = (liste)malloc(sizeof(noeud));
	if (!l) {
		printf("erreur d'allocation");
		exit(-1);
	}
	return (l);
}
void ajout(liste *l, int e) /***************************ajout en tete*/
{
	liste n = creer();
	n->elm = e;
	n->svt = *l;
	*l = n;
}
void suprim(liste *l) /*****************************suprimer la tete*/
{
	liste p = *l;
	*l = (*l)->svt;
	free(p);
}
void ghiles(liste *l, int n) {
	int e;
	if (n == 0)
		;
	else {
		scanf("%d", &e);
		ajout(l, e);
		ghiles(l, n - 1);
	}
}
void aghiles(liste *l, int n) {
	int e;
	if (n == 0)
		;
	else {
		scanf("%d", &e);
		ajout(l, e);
		aghiles(&(*l)->svt, n - 1);
	}
}
liste lifo() /******************************************LIFO*/
{
	liste l = NULL;
	int n;
	printf("le nbr d'elm");
	scanf("%d", &n);
	ghiles(&l, n);
	return (l);
}
liste fifo() /******************************************FIFO*/
{
	liste l = NULL;
	int n;
	printf("le nbr d'elm");
	scanf("%d", &n);
	aghiles(&l, n);
	return (l);
}

void recherche1(liste l, int e) /*recher ds une liste trier*/
{
	if (!l || l->elm > e)
		printf("la valeur n'existe pas");
	else if (l->elm < e)
		recherche1(l->svt, e);
	else
		printf("la valeur existe");
}
int recherche2(liste l, int e) /*****************recherche*/
{
	if (!l)
		return (0);
	else if ((l)->elm == e)
		return (1);
	else
		recherche2((l)->svt, e);
}
void modifier(liste l, int x, int y) /************************modifier*/
{
	if (!l)
		;
	else if ((l)->elm == x) {
		modifier((l)->svt, x, y);
		(l)->elm = y;
	} else
		modifier((l)->svt, x, y);
}
void insert(liste l, int e) /************insertion ds une liste trier*/
{
	if (!l)
		ajout(&l, e);
	else if ((l)->elm < e)
		insert((l)->svt, e);
	else
		ajout(&l, e);
}
void suprimmer(liste *l, int e) /***************************suprimmer**/
{
	if (!*l)
		;
	else if ((*l)->elm == e) {
		suprim(l);
		suprimmer(l, e);
	} else
		suprimmer(&(*l)->svt, e);
}
void affichage(liste l) /***********************************affichage*/
{
	if (!l)
		printf("liste vide");
	else if (l->svt == NULL)
		printf("%d", l->elm);
	else {
		printf("%d ", l->elm);
		affichage(l->svt);
	}
}
void triliste(liste *tete, liste p) {
	if (!(*tete)->svt)
		;
	else if (!p)
		triliste(&(*tete)->svt, (*tete)->svt);
	else if ((*tete)->elm > p->elm) {
		int q = (*tete)->elm;
		(*tete)->elm = p->elm;
		p->elm = q;
		triliste(tete, p->svt);
	} else
		triliste(tete, p->svt);
}
void tri(liste l) { triliste(&l, l); }
main() /***************************************************************/
{
	liste l = fifo();
	affichage(l);
	tri(l);
	affichage(l);
}
