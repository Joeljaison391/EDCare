package com.edcare.Companion.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private int age;
    private String address;
    private String city;
    private String state;
    private String country;

    @ElementCollection
    private List<String> preferredLanguages;
    @ElementCollection
    private List<String> interests;
    @ElementCollection
    private List<String> medicalConditions;

    // Personalization fields
    @ElementCollection
    private List<String> favoriteGenres;
    @ElementCollection
    private List<String> favoriteActivities;
    @ElementCollection
    private List<String> moods;
    @ElementCollection
    private List<String> memoryCareNeeds;
    @ElementCollection
    private List<String> occupations;
    @ElementCollection
    private List<String> maritalStatuses;
    @ElementCollection
    private List<String> educationLevels;

    // Memory related fields
    @ElementCollection
    private List<String> childhoodMemories;
    @ElementCollection
    private List<String> favoriteVacationSpots;
    @ElementCollection
    private List<String> memorableEvents;

    // Family and relationships
    @ElementCollection
    private List<String> familyMembers;
    @ElementCollection
    private List<String> closeFriends;
    @ElementCollection
    private List<String> petNames;

    // Multimedia preferences
    @ElementCollection
    private List<String> favoriteSongs;
    @ElementCollection
    private List<String> favoriteMovies;
    @ElementCollection
    private List<String> favoriteBooks;

    // Hobbies and activities
    @ElementCollection
    private List<String> hobbies;
    @ElementCollection
    private List<String> dailyRoutines;

    // Health and wellness
    @ElementCollection
    private List<String> fitnessRoutines;
    @ElementCollection
    private List<String> dietaryPreferences;
    @ElementCollection
    private List<String> sleepSchedules;

    // Technological skills and preferences
    @ElementCollection
    private List<String> techSkillLevels;
    @ElementCollection
    private Map<String, String> deviceUsages; // e.g., "smartphone": "daily", "tablet": "occasionally"

    // Other fields for personalization
    @ElementCollection
    private List<String> storytellingPreferences; // e.g., "prefer interactive stories", "likes historical fiction"
    @ElementCollection
    private List<String> cognitiveTrainingGoals;
}
