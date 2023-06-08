package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String DATABASE_URL = "jdbc:derby:mydb;create=true";
    private static final String TABLE_NAME = "PLAYERDATA";

    public static void main(String[] args) {
        try {
            createTableInDatabase();
            insertDataIntoDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableInDatabase() throws SQLException {
        String sql = generateCreateTableQuery();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table created successfully.");
        }
    }

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

    private static String generateInsertQuery() {
        return "INSERT INTO " + TABLE_NAME + " (Name, Team, Games, AtBats, Runs, Hits, Doubles, Triples, HomeRuns, RBIs) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
