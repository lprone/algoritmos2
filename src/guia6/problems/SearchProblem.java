package guia6.problems;

import java.util.*; // necessary due to the use of lists.

/**
 *
 * @author lprone
 */
public interface SearchProblem {

    /**
     * Returns the initial state corresponding to the problem. Concrete
 implementations of SearchProblem must implement this routine, to
 indicate the starting point for the search.
     *
     * @return the initial state for the problem
     * @pre. true.
     * @post. the initial state for the problem is returned.
     */
    State initialState();

    /**
     * Returns the list of successor states for a given state, in the context of
     * the current problem. Concrete implementations of SearchProblem
 must implement this routine, to indicate the 'advance' rules for the
 search.
     *
     * @param s is the state for which its successors are being computed.
     * @return the list of successor states of s.
     * @pre. s!=null.
     * @post. the list of successor states of s is returned.
     */
    List<State> getSuccessors(State s);

    /**
     * Indicates whether a given state is a successful state, in the context of
     * the current problem. Concrete implementations of SearchProblem
 must implement this routine, to indicate when the search has been
 successful.
     *
     * @param s is the state being checked to be successful.
     * @return true iff s is a successful state.
     * @pre. s!=null.
     * @post. true is returned iff s is a successful state.
     */
    boolean success(State s);
}
