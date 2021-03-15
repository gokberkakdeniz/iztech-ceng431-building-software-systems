package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

public interface EntityDirector {
    void register(Entity entity);

    boolean addTeam(String teamId, String name, String defaultMeetingTime);
    void removeTeam(Team team);
    boolean updateTeam(User actor);
    boolean findTeam(String name);

    boolean addChannel(Channel channel, Team team);
    boolean removeChannel(Channel team);
    boolean findChannel(String name);

    boolean addMember(User user, Channel channel);
    boolean addMember(User user, Team channel);

    boolean removeMember(User user, Channel channel);
    boolean removeMember(User user, Team channel);

    boolean updateMeetingDate(Channel channel);

    boolean login(String email, String password);
}
