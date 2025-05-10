% --- Facts ---
parent(satyam, kabir).
parent(anshu, kabir).
parent(harishchandra, satyam).
parent(bimal, satyam).
parent(mewalal, harishchandra).
  % kabir other parent

male(satyam).
male(harishchandra).
male(mewalal).
male(kabir).

female(bimal).
female(anshu).

% --- Rules ---
dada(X, Z) :- 
    male(X),
    parent(X, Y),
    parent(Y, Z).

dadi(X, Z) :-
    female(X),
    parent(X, Y),
    parent(Y, Z).

papa(X,Y) :-
    male(X),
    parent(X, Y).

mummy(X,Y) :-
    female(X),
    parent(X, Y).