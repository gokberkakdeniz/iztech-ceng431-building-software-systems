package tr.edu.iztech.teamstech.data;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvDataSaver extends DataSaver {
    @Override
    public void save(EntityDirector director) throws Exception {
        saveTeamList(director);
        saveUserList(director);
    }

    private void saveTeamList(EntityDirector director) throws IOException {
        FileWriter writer = new FileWriter(new File("./teamList_test.csv"));

        List<Team> teamList = director.findTeams(v -> true);
        writer.write("Team Name,Team ID,Default Channel,Default Meeting Day and Time,Meeting Channel,Meeting Day and Time,Participant ID,Team Owner ID\n");

        for (Team team : teamList) {
            writer.write(team.toString());
            writer.write('\n');
        }

        writer.close();
    }

    private void saveUserList(EntityDirector director) throws IOException {
        FileWriter writer = new FileWriter(new File("./userList_test.csv"));

        List<User> userList = director.findUsers(v -> true);
        writer.write("User Type,User Name,User ID,Email,Password,Team ID,\n");

        for (User team : userList) {
            writer.write(team.toString());
            writer.write('\n');
        }

        writer.close();
    }
}
