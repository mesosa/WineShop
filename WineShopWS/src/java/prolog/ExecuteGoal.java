/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;

import gnu.prolog.io.ParseException;
import gnu.prolog.term.AtomTerm;
import gnu.prolog.term.Term;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author edwardblurock
 */
public class ExecuteGoal {

    Environment env;
    PrologUtilities prolog;

    /** The empty constructor
     *
     */
    public ExecuteGoal() {
        env = new Environment();
        prolog = new PrologUtilities(env);
    }

    /**
     *
     * @param textToLoad: The text file with the PROLOG program
     * @return
     */
    public Term readInPredicates(String textToLoad) {
        AtomTerm term = prolog.readFromFile(textToLoad);
        return term;
    }

    /**
     *
     * @param goalToRun a string with the PROLOG predicate to evaluate
     * @return a set of assignments
     */
    public SetOfPrologAssignments executeGoal(String goalToRun) throws ParseException, PrologException, Exception {

        Term goalTerm = prolog.createTermFromString(goalToRun);
        Interpreter.Goal goal = prolog.prepareGoal(goalTerm);
        ArrayList<Term> vset = prolog.getSetOfVariables(goalTerm);
        
        
        SetOfPrologAssignments totalset = new SetOfPrologAssignments();
        totalset.setSuccess(false);
        boolean runloop = true;
        do {
            int rc = prolog.executeGoal(goal);
            switch (rc) {
                case PrologCode.SUCCESS: {
                    ArrayList<Term> set = new ArrayList<Term>();
                    prolog.getSetOfVariables(goalTerm, set);
                    PrologAssignments assignments = new PrologAssignments(vset, set);
                    totalset.insertAssignmentSet(assignments);
                    break;
                }
                case PrologCode.SUCCESS_LAST: {
                    ArrayList<Term> set = new ArrayList<Term>();
                    prolog.getSetOfVariables(goalTerm, set);
                    PrologAssignments assignments = new PrologAssignments(vset, set);
                    totalset.insertAssignmentSet(assignments);
                    totalset.setSuccess(true);
                    runloop = false;
                    break;
                }
                case PrologCode.FAIL:
                    runloop = false;
                    break;
                case PrologCode.HALT:
                    System.out.println("HALT");
                    env.closeStreams();
                    System.exit(prolog.getInterpreter().getExitCode());
                    runloop = false;
                    break;
            }
        } while (runloop);
        return totalset;
    }

}
