package by.pklochkov.jedi.security;

import by.pklochkov.jedi.security.credential.UserDetails;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 14.01.14
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public class SecurityContext {
    private Set<Restriction> restrictions = new HashSet<Restriction>();

    public boolean isAllowedForUser(UserDetails userDetails, String requestPath) {
        return false;
    }
}
