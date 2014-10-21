// Agent basis
/* agent perceives an area that is a square with the size N with
   the agent in the center. Each agent is able to see N*N cells. */

/* Initial beliefs and rules */
/* BELIEFS */


/* RULES */



/* initial DESIRES */
!move.

+!move:not pos(_,_,_)
<- .print("I...");
   .wait("+pos(_,_,_)");
   .print("I...");
   !move.
  
+!move : pos(X,Y,_) 
<- .print("Selecting a new position randomly..."); 
   br.poli.ecomp.sma.massim.action.RandomPos(X,Y,NewX,NewY);
   .print("Discovering the new position direction...");
   br.poli.ecomp.sma.massim.action.FindDirection(X,Y,NewX,NewY,Direction);
   moveTo(Direction); // Moving (acting in the environment) randomly 
   .wait("+pos(_,_,_)");// Wait for the new position to be added to the BB. 
   !move. // and Move again.
  