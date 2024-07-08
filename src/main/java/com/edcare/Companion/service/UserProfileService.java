package com.edcare.Companion.service;

import com.edcare.Companion.model.UserProfile;
import com.edcare.Companion.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public Optional<UserProfile> getUserProfileById(String id) {
        return userProfileRepository.findById(id);
    }

    public Optional<UserProfile> updateUserProfile(String id, UserProfile userProfileDetails) {
        return userProfileRepository.findById(id).map(userProfile -> {
            userProfile.setFirstName(userProfileDetails.getFirstName());
            userProfile.setLastName(userProfileDetails.getLastName());
            userProfile.setEmail(userProfileDetails.getEmail());
            userProfile.setPhoneNumber(userProfileDetails.getPhoneNumber());
            userProfile.setAge(userProfileDetails.getAge());
            userProfile.setGender(userProfileDetails.getGender());
            userProfile.setAddress(userProfileDetails.getAddress());
            userProfile.setCity(userProfileDetails.getCity());
            userProfile.setState(userProfileDetails.getState());
            userProfile.setCountry(userProfileDetails.getCountry());
            userProfile.setFavoriteActivities(userProfileDetails.getFavoriteActivities());
            userProfile.setDailyRoutines(userProfileDetails.getDailyRoutines());
            userProfile.setDietaryPreferences(userProfileDetails.getDietaryPreferences());
            userProfile.setEducationLevels(userProfileDetails.getEducationLevels());
            userProfile.setCloseFriends(userProfileDetails.getCloseFriends());
            userProfile.setFamilyMembers(userProfileDetails.getFamilyMembers());
            userProfile.setFitnessRoutines(userProfileDetails.getFitnessRoutines());
            userProfile.setHobbies(userProfileDetails.getHobbies());
            userProfile.setInterests(userProfileDetails.getInterests());
            userProfile.setMaritalStatuses(userProfileDetails.getMaritalStatuses());
            userProfile.setMedicalConditions(userProfileDetails.getMedicalConditions());
            userProfile.setMemorableEvents(userProfileDetails.getMemorableEvents());
            userProfile.setMemoryCareNeeds(userProfileDetails.getMemoryCareNeeds());
            userProfile.setMoods(userProfileDetails.getMoods());
            userProfile.setOccupations(userProfileDetails.getOccupations());
            userProfile.setPetNames(userProfileDetails.getPetNames());
            userProfile.setPreferredLanguages(userProfileDetails.getPreferredLanguages());
            userProfile.setSleepSchedules(userProfileDetails.getSleepSchedules());
            userProfile.setStorytellingPreferences(userProfileDetails.getStorytellingPreferences());
            userProfile.setTechSkillLevels(userProfileDetails.getTechSkillLevels());
            userProfile.setChildhoodMemories(userProfileDetails.getChildhoodMemories());
            userProfile.setCognitiveTrainingGoals(userProfileDetails.getCognitiveTrainingGoals());
            userProfile.setFavoriteBooks(userProfileDetails.getFavoriteBooks());
            userProfile.setFavoriteGenres(userProfileDetails.getFavoriteGenres());
            userProfile.setFavoriteMovies(userProfileDetails.getFavoriteMovies());
            userProfile.setFavoriteSongs(userProfileDetails.getFavoriteSongs());
            userProfile.setFavoriteVacationSpots(userProfileDetails.getFavoriteVacationSpots());
            return userProfileRepository.save(userProfile);
        });
    }

    public boolean deleteUserProfile(String id) {
        return userProfileRepository.findById(id).map(userProfile -> {
            userProfileRepository.delete(userProfile);
            return true;
        }).orElse(false);
    }
}
