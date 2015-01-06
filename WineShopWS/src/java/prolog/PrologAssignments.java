/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog;

import gnu.prolog.term.Term;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author edwardblurock
 */
public class PrologAssignments {
    private Map<Term,Term> assignments;

    /** Empty constructor
     *
     */
    public PrologAssignments() {
        assignments = new HashMap<Term,Term>();
    }

    /** Create the class with a Map of assignments
     *
     * @param assignments
     */
    public PrologAssignments(Map<Term,Term> assignments) {
        this.assignments = assignments;
    }

    /** Constructor with names and assignments
     *
     * @param names Set of names
     * @param assigns Set of corresponding assignments
     * @throws Exception
     */
    public PrologAssignments(ArrayList<Term> names , ArrayList<Term> assigns) throws Exception {
        assignments = new HashMap<Term,Term>();
        if(names.size() != assigns.size()) throw new Exception("Size mismatch between names(" 
                + names.size() 
                + ") and assignments(" +
                assigns.size() + ")");
        Iterator<Term> nameiter = names.iterator();
        Iterator<Term> assigniter = assigns.iterator();
        while(nameiter.hasNext()) {
            Term name = nameiter.next();
            Term assign = assigniter.next();
            assignments.put(name, assign);
        }
    }

    /** Get assignments
     *
     * @return get the assignment Map
     */
    public Map<Term,Term> getAssignments() {
        return assignments;
    }
    
    /** Add an assignment 
     *
     * @param name
     * @param assignment
     */
    public void addAssignement(Term name, Term assignment) {
        assignments.put(name, assignment);
    }

    /** Find the assignment for the term
     *
     * @param name
     * @return
     */
    public Term findAssignment(Term name) {
        return (Term) assignments.get(name);
    }

    /** Get the set of names in the assignments
     *
     * @return
     */
    public Set<Term> getSetOfNames() {
        return assignments.keySet();
    }
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        Iterator variables = assignments.keySet().iterator();
        while (variables.hasNext()) {
            Term name = (Term) variables.next();
            Term assignment = assignments.get(name);
            build.append(name + " = " + assignment + ";\n");
        }
        return build.toString();
    }
    
}
