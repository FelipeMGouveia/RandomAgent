package br.poli.ecomp.sma.massim.action;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.Term;

public class FindDirection extends DefaultInternalAction 
{

	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception 
	{ 
		Term x = args[0]; 
		Term y = args[1]; 
		Term newX = args[2]; 
		Term newY = args[3];
		Term direction = args[4];
		
		double vx = ((NumberTerm)x).solve();
		double vy = ((NumberTerm)y).solve();
		double vNewX = ((NumberTerm)newX).solve();
		double vNewY = ((NumberTerm)newY).solve();
		
		String dir = "";
		
		if(vy < vNewY)
		{
			dir = "north";
		}
		else if(vy > vNewY)
		{
			dir = "south";
		}
		
		if(vx < vNewX)
		{
			dir += "west";
		}
		else if(vx > vNewX)
		{
			dir += "east";
		}

		//Direction result = Direction.valueOf(dir);
		
		un.unifies(direction, new Atom(dir)); 

		System.out.println(dir);
		return true;
	}
}

