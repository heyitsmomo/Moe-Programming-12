package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;
import java.sql.ResultSet;


public class Main {
    private static final String DATABASE_URL = "jdbc:derby:mydb;create=true";
    private static final String TABLE_NAME = "NEW_DATA";

    /**
     * MAIN METHOD
     * @param args not used
     */
    public static void main(String[] args) {
        try {
            createTableInDatabase();
            insertDataIntoDatabase();
            createNewCSV();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * CREATING TABLE IN THE DATABASE
     * @throws SQLException incase errors occur when creating the table
     */
    private static void createTableInDatabase() throws SQLException {
        String sql = generateCreateTableQuery();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table created successfully.");
        }
    }

    /**
     * INSERTING DATA INTO THE DATABASE
     * @throws SQLException incase errors occur while inserting the data
     */
    private static void insertDataIntoDatabase() throws SQLException {
        String csvFile = "/Users/moe/IdeaProjects/Module 4 Assignment/PlayerData.csv";
        String line;
        String csvSplitBy = ",";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(generateInsertQuery())) {

            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                statement.setString(1, data[0]);
                statement.setString(2, data[1]);
                statement.setInt(3, Integer.parseInt(data[2]));
                statement.setInt(4, Integer.parseInt(data[3]));
                statement.setInt(5, Integer.parseInt(data[4]));
                statement.setInt(6, Integer.parseInt(data[5]));
                statement.setInt(7, Integer.parseInt(data[6]));
                statement.setInt(8, Integer.parseInt(data[7]));
                statement.setInt(9, Integer.parseInt(data[8]));
                statement.setInt(10, Integer.parseInt(data[9]));

                statement.executeUpdate();
            }
            System.out.println("Data inserted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * GENERATE SQL QUERY STRING
     * @return SQL Query string used for creating table in database
     */
    private static String generateCreateTableQuery() {
        return "CREATE TABLE " + TABLE_NAME + " (" +
                "Name VARCHAR(100) NOT NULL, " +
                "Team VARCHAR(50) NOT NULL, " +
                "Games INT NOT NULL, " +
                "AtBats INT NOT NULL, " +
                "Runs INT NOT NULL, " +
                "Hits INT NOT NULL, " +
                "Doubles INT NOT NULL, " +
                "Triples INT NOT NULL, " +
                "HomeRuns INT NOT NULL, " +
                "RBIs INT NOT NULL" +
                ")";
    }

    /**
     * GENERATE INSERT SQL QUERY STRING
     * @return SQL query string used to insert into the table in database
     */
    private static String generateInsertQuery() {
        return "INSERT INTO " + TABLE_NAME + " (Name, Team, Games, AtBats, Runs, Hits, Doubles, Triples, HomeRuns, RBIs) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    /**
     * CREATE NEW CSV
     * @throws SQLException incase errors occur while creating the csv
     */
    private static void createNewCSV() throws SQLException {
        String csvFile = "NewCSV.csv";
        String csvSplitBy = ",";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             FileWriter writer = new FileWriter(csvFile)) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM PLAYERDATA");

            // Write header line
            writer.write("Name,Team,Game,AtBats,Runs,Hits,Doubles,Triples,HomeRuns,RBIs\n");

            // Write data rows
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String team = resultSet.getString("Team");
                int g = resultSet.getInt("Games");
                int ab = resultSet.getInt("AtBats");
                int r = resultSet.getInt("Runs");
                int h = resultSet.getInt("Hits");
                int dbl = resultSet.getInt("Doubles");
                int tpl = resultSet.getInt("Triples");
                int hr = resultSet.getInt("HomeRuns");
                int rbi = resultSet.getInt("RBIs");

                writer.write(name + csvSplitBy + team + csvSplitBy + g + csvSplitBy + ab + csvSplitBy
                        + r + csvSplitBy + h + csvSplitBy + dbl + csvSplitBy + tpl + csvSplitBy + hr + csvSplitBy + rbi + "\n");
            }
            System.out.println("Data exported to CSV successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
