package tr.edu.iztech.teamstech.data;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.io.CSVReader;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.PrivateChannel;
import tr.edu.iztech.teamstech.team.StandardChannel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.Instructor;
import tr.edu.iztech.teamstech.user.Student;
import tr.edu.iztech.teamstech.user.TeachingAssistant;
import tr.edu.iztech.teamstech.user.User;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CsvDataInitializer extends DataInitializer {
    private static final List<Integer> randomIds = IntStream.range(1, 1001).boxed().collect(Collectors.toList());

    public void init(EntityDirector director) throws Exception {
        initTeamList(director);
        initUserList(director);
    }

    private void initTeamList(EntityDirector director) throws FileNotFoundException {
        CSVReader teamListReader = new CSVReader(new File("./teamList.csv"));

        if (teamListReader.hasData()) teamListReader.nextData();
        while (teamListReader.hasData()) {
            String[] args = teamListReader.nextData();

            String teamName = args[0];
            String teamId = args[1];

            Entity team = new Team(director, teamId, teamName);
            Channel defaultChannel = new StandardChannel(director, args[2], args[3], teamId);

            director.register(team);
            director.register(defaultChannel);

            for (int i = 4; i < args.length; i += 3) {
                if (args[i].equals("")) break;

                Integer[] participantIds = Arrays.stream(args[i + 2]
                        .replaceAll("([\\D])", "")
                        .split(",", -1))
                        .map(Integer::parseInt).toArray(Integer[]::new);

                Channel privateChannel = new PrivateChannel(director,
                        args[i],
                        args[i + 1],
                        teamId,
                        participantIds);

                director.register(privateChannel);
            }
        }

        teamListReader.close();
    }

    private void initUserList(EntityDirector director) throws Exception {
        CSVReader userListReader = new CSVReader(new File("./userList.csv"));

        if (userListReader.hasData()) userListReader.nextData();
        while (userListReader.hasData()) {
            String[] args = userListReader.nextData();

            String userType = args[0];
            String domain = userType.equals("Student")
                    ? "std.iyte.edu.tr"
                    : "iyte.edu.tr";
            String username = args[1].strip();

            int userId = args[2].equals("")
                    ? randomIds.remove(new Random().nextInt(randomIds.size()))
                    : Integer.parseInt(args[2]);
            String email = args[3].equals("")
                    ? username.replaceAll(" ", "").toLowerCase(Locale.ENGLISH) + "@" + domain
                    : args[3];
            String password = args[4].equals("")
                    ? UUID.randomUUID().toString().substring(0, 4)
                    : args[4];
            String[] teamIds = Arrays.stream(args)
                    .skip(5)
                    .takeWhile(id -> !id.equals(""))
                    .toArray(String[]::new);

            System.out.printf("%d, %s, %s, %s, %s, ", userId, username, userType, email, password);
            System.out.println(Arrays.toString(teamIds));

            User user;
            switch (userType) {
                case "Student": {
                    user = new Student(director, userId, username, email, password, teamIds);
                    break;
                }
                case "Instructor": {
                    user = new Instructor(director, userId, username, email, password, teamIds);
                    break;
                }
                case "Teaching Assistant": {
                    user = new TeachingAssistant(director, userId, username, email, password, teamIds);
                    break;
                }
                default: {
                    throw new Exception(String.format("The column 'User Type' is invalid! Expected 'Student', 'Instructor', or 'Teaching Assistant', but found '%s'", userType));
                }
            }

            director.register(user);
        }

        userListReader.close();
    }
}
