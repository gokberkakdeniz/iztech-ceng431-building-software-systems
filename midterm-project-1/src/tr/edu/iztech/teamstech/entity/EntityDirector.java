package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

public interface EntityDirector {
    void register(Entity entity);

    boolean addTeam(User actor, Team team);
    boolean removeTeam(User actor, Team team);
    boolean updateTeam(User actor);
    boolean findTeam(User actor, String name);

    boolean addChannel(User actor, Channel channel, Team team);
    boolean removeChannel(User actor, Channel team);
    boolean findChannel(User actor, String name);

    boolean addMember(User actor, User user, Channel channel);
    boolean addMember(User actor, User user, Team channel);

    boolean removeMember(User actor, User user, Channel channel);
    boolean removeMember(User actor, User user, Team channel);

    boolean updateMeetingDate(User actor, Channel channel);

    User login(String email, String password);

}
