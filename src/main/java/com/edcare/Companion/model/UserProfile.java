package com.edcare.Companion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_profiles") // Specify the MongoDB collection name
public class UserProfile {

    @Id
    private String id; // Use String for MongoDB ID

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private int age;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String country;

    private List<String> preferredLanguages;
    private List<String> interests;
    private List<String> medicalConditions;

    // Personalization fields
    private List<String> favoriteGenres;
    private List<String> favoriteActivities;
    private List<String> moods;
    private List<String> memoryCareNeeds;
    private List<String> occupations;
    private List<String> maritalStatuses;
    private List<String> educationLevels;

    // Memory related fields
    private List<String> childhoodMemories;
    private List<String> favoriteVacationSpots;
    private List<String> memorableEvents;

    // Family and relationships
    private List<String> familyMembers;
    private List<String> closeFriends;
    private List<String> petNames;

    // Multimedia preferences
    private List<String> favoriteSongs;
    private List<String> favoriteMovies;
    private List<String> favoriteBooks;

    // Hobbies and activities
    private List<String> hobbies;
    private List<String> dailyRoutines;

    // Health and wellness
    private List<String> fitnessRoutines;
    private List<String> dietaryPreferences;
    private List<String> sleepSchedules;

    // Technological skills and preferences
    private List<String> techSkillLevels;

    // Other fields for personalization
    private List<String> storytellingPreferences; // e.g., "prefer interactive stories", "likes historical fiction"
    private List<String> cognitiveTrainingGoals;
}
