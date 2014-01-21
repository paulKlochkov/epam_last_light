package by.pklochkov.jedi.security.credential;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 14.01.14
 * Time: 18:49
 * To change this template use File | Settings | File Templates.
 */
public interface UserDetailsService {
    public UserDetails getByLogin(String login);
}
