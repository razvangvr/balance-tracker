
### Initial State/Initial Depozit/ State Zero
- poate nu o sa pot sa fac tracking de la Adevaratul/**The REAL** `To`(Intial Depozit) din BlackBull,
pentru ca nu ma apuc sa fac Copy-Paste si sa portez toate Evenimentele a.i. sa ajung La Cifrele reale

- Si atunci trebuie sa incep cu un `To` arbitrar,

Apoi incep cu cel mai Simple Repository, Care are doar trei valori

- To
- Tn-1
- Tn

Si am un Serviciu Care Doar Citeste Valorile Relevante pentru Socoteala, din Repository
Initial Lucreaza cu un simplu Inmemory/Mock repository
Acesta ii da Serviciului De Calcul datele Corecte de care are nevoie, E.G. `Day's Close`, etc..

Apoi cu un Real DB Repository

Apoi cu un Event Repository, Envents Replay, Materialized View
