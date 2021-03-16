package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.List;
import java.util.function.Predicate;

public interface EntityDirector {
    void register(Entity entity);

    boolean addTeam(String teamId, String name, String defaultMeetingTime);
    void removeTeam(Team team);
    List<Team> findTeams(Predicate<Team> predicate);

    boolean addChannel(String name, String meetingTime, Team team);
    boolean removeChannel(Channel team);
    List<Channel> findChannels(Predicate<Channel> predicate);

    boolean addMember(User user, Channel channel);
    boolean addMember(User user, Team channel);

    boolean removeMember(User user, Channel channel);
    boolean removeMember(User user, Team channel);

    boolean updateMeetingDate(Channel channel);

    boolean login(String email, String password);
    User getCurrentUser();
}
