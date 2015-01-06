/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author edwardblurock
 */
public class SetOfPrologAssignments extends HashSet<PrologAssignments> {
    boolean success;
    public SetOfPrologAssignments() {
    }
    
    public void insertAssignmentSet(PrologAssignments assignments) {
        success = true;
        this.add(assignments);
    }
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        Iterator<PrologAssignments> iterator = this.iterator();
        build.append("Set of assignments\n");
        int count = 0;
        while(iterator.hasNext()) {
            build.append("--------------------------------------------------------\n");
            build.append("Set: " + count++ + "\n");
            PrologAssignments next = iterator.next();
            String str = next.toString();
            build.append(str);
        }
        return build.toString();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}
