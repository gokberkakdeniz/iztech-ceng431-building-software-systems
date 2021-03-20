package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.List;
import java.util.function.Predicate;

public interface EntityDirector {
    void register(Entity entity);

    Team createTeam(User sender, String teamId, String name, String defaultMeetingTime) throws UnauthorizedUserOperationException;

    Channel createChannel(Team sender, String name, String meetingTime) throws UnauthorizedUserOperationException;

    boolean addMember(Team sender, User user) throws UnauthorizedUserOperationException;

    void addTeamOwner(Team sender, User user) throws UnauthorizedUserOperationException;

    void addParticipant(Channel sender, User user) throws UnauthorizedUserOperationException;

    void removeTeam(Team sender) throws UnauthorizedUserOperationException;

    void removeChannel(Channel sender) throws UnauthorizedUserOperationException;

    void removeParticipant(Channel sender, User user) throws UnauthorizedUserOperationException;

    boolean removeMember(Team sender, User user) throws UnauthorizedUserOperationException;

    List<Team> findTeams(Predicate<Team> predicate);

    List<Channel> findChannels(Predicate<Channel> predicate);

    List<User> findUsers(Predicate<User> predicate);

    void updateMeetingDate(Channel sender, String meetingDate) throws UnauthorizedUserOperationException;

    boolean login(String email, String password);

    User getCurrentUser();

    void requestUnsafeMethodExecution() throws UnauthorizedUserOperationException;

}
