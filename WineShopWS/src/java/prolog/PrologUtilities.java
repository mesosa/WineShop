/*

 */
package prolog;

import gnu.prolog.io.ParseException;
import gnu.prolog.io.ReadOptions;
import gnu.prolog.io.TermReader;
import gnu.prolog.io.TermWriter;
import gnu.prolog.io.WriteOptions;
import gnu.prolog.term.AtomTerm;
import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.Term;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.Interpreter.Goal;
import gnu.prolog.vm.PrologException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author edwardblurock
 */
public class PrologUtilities {

    Environment environment;
    Interpreter interpreter;

    /**
     *
     * @param env
     */
    public PrologUtilities(Environment env) {
        environment = env;
    }

    /** 
     *
     * @param filename
     * @return The term
     */
    public AtomTerm readFromFile(String filename) {
        AtomTerm term = AtomTerm.get(filename);
        environment.ensureLoaded(term);
        interpreter = environment.createInterpreter();
        environment.runInitialization(interpreter);
        return term;
    }

    /** Get the environment
     *
     * @return
     */
    public Environment getEnvironment() {
        return environment;
    }

    /** Set the environment
     *
     * @param environment
     */
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /** Get the interpreter
     *
     * @return
     */
    public Interpreter getInterpreter() {
        return interpreter;
    }

    /** Set the interpreter
     *
     * @param interpreter
     */
    public void setInterpreter(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    /**
     *
     * @param term
     * @return
     */
    public ArrayList<Term> getSetOfVariables(Term term) {
        ArrayList<Term> set = new ArrayList<Term>();
        getSetOfVariables(term, set);
        return set;
    }

    /**
     *
     * @param term
     * @param set
     */
    public void getSetOfVariables(Term term, ArrayList<Term> set) {
        //System.out.println("getSetOfVariables: " + term.getClass().getName() + " " + term.toString());
        if (term instanceof VariableTerm) {
            Term derefterm = (Term) term.dereference().clone();
            set.add(derefterm);
        } else if (term instanceof CompoundTerm) {
            System.out.println(term.toString()+"BBHEHBE");
            CompoundTerm c = (CompoundTerm) term;
            for (int i = 0, n = c.tag.arity; i < n; i++) {
                Term t = (Term) c.args[i];
                getSetOfVariables(t, set);
            }
        }
    }

    /**
     *
     * @param term
     * @return
     */
    public Goal prepareGoal(Term term) {
        return interpreter.prepareGoal(term);
    }

    /**
     *
     * @param goalTerm
     * @return
     * @throws PrologException
     */
    public int executeGoal(Goal goalTerm) throws PrologException {
        return interpreter.execute(goalTerm);
    }

    /**
     *
     * @param termS
     * @return
     * @throws ParseException
     */
    public Term createTermFromString(String termS) throws ParseException {
        LineNumberReader kin = new LineNumberReader(new InputStreamReader(System.in));
        StringReader rd = new StringReader(termS);
        TermReader trd = new TermReader(rd, environment);
        TermWriter out = new TermWriter(new OutputStreamWriter(System.out));
        ReadOptions rd_ops = new ReadOptions(environment.getOperatorSet());

        rd_ops.operatorSet = environment.getOperatorSet();
        WriteOptions wr_ops = new WriteOptions(null);
        wr_ops.operatorSet = environment.getOperatorSet();
        Term goalTerm = trd.readTermEof();

        return goalTerm;
    }

}
