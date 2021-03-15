package tr.edu.iztech.teamstech.data;

import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.function.Predicate;

public interface DataAccessor {
    User getUsers(int id);
    User getUsers(Predicate<User> predicate);

    Team getTeams(String id);
    Team getTeams(Predicate<Team> predicate);

    Channel getChannels(String teamId, String name);
    Channel getChannels(Predicate<Channel> predicate);
}
