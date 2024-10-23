package com.narriation;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The FileReader class reads users and languages
 * 
 * @author Christian Ruff
 * @author Risha Patel
 */

public class DataLoader extends DataConstants {

    // temporary main
    public static void main(String args[]) {
        // getUsers();
        System.out.println(getLanguages());
    }

    // LANGUAGES
    /**
     * @author Christian Ruff
     * @return
     */
    public static ArrayList<Language> getLanguages() {
        ArrayList<Language> languages = new ArrayList<>();
        try {
            FileReader reader = new FileReader(LANGUAGE_FILE_NAME);
            JSONArray languageJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < languageJSON.size(); i++) {
                JSONObject currentLang = (JSONObject) languageJSON.get(i);
                UUID lessonID = UUID.fromString((String) currentLang.get(LANGUAGE_ID));
                String nameOfLanguage = (String) currentLang.get(LANGUAGE_NAME);
                ArrayList<Word> words = new ArrayList<Word>();
                ArrayList<Phrase> phrases = new ArrayList<Phrase>();
                ArrayList<Lesson> lessons = new ArrayList<Lesson>();

                // 1. create an ArrayList of words
                JSONArray jsonWords = (JSONArray) currentLang.get(LANGUAGE_WORDS);
                for (int j = 0; j < jsonWords.size(); j++) {
                    JSONObject currentWord = (JSONObject) jsonWords.get(j);
                    UUID wordID = UUID.fromString((String) currentWord.get(WORD_ID));
                    String englishWord = (String) currentWord.get(WORD_IN_ENGLISH);
                    String translatedWord = (String) currentWord.get(WORD_IN_TARGET_LANGUAGE);
                    String pronounciation = (String) currentWord.get(WORD_PRONOUNCIATION);
                    PartOfSpeech partOfSpeech = EnumUtilities.getEnumFromString(PartOfSpeech.class,
                            (String) currentWord.get(WORD_PART_OF_SPEECH));
                    Gender gender = EnumUtilities.getEnumFromString(Gender.class,
                            (String) currentWord.get(WORD_GENDER));
                    words.add(new Word(wordID, englishWord, translatedWord, pronounciation, partOfSpeech, gender));
                }

                // 2. create an ArrayList of phrases
                JSONArray jsonPhrases = (JSONArray) currentLang.get(LANGUAGE_PHRASES);
                for (int j = 0; j < jsonPhrases.size(); j++) {
                    JSONObject currentPhrase = (JSONObject) jsonPhrases.get(j);

                    UUID phraseID = UUID.fromString((String) currentPhrase.get(PHRASE_ID));
                    String feedback = (String) currentPhrase.get(PHRASE_FEEDBACK);
                    ArrayList<Word> englishPhrase = new ArrayList<Word>();
                    ArrayList<Word> translatedPhrase = new ArrayList<Word>();

                    // parse English phrase
                    JSONArray jsonEnglishPhrase = (JSONArray) currentPhrase.get(PHRASE_IN_ENGLISH);
                    for (int k = 0; k < jsonEnglishPhrase.size(); k++) {
                        Word englishWord = findWordByUUID(words, UUID.fromString((String) jsonEnglishPhrase.get(k)));
                        if (englishWord != null)
                            englishPhrase.add(englishWord);
                    }

                    // parse translated phrase
                    JSONArray jsonTranslatedPhrase = (JSONArray) currentPhrase.get(PHRASE_IN_TARGET_LANGUAGE);
                    for (int k = 0; k < jsonTranslatedPhrase.size(); k++) {
                        Word translatedWord = findWordByUUID(words,
                                UUID.fromString((String) jsonTranslatedPhrase.get(k)));
                        if (translatedWord != null)
                            translatedPhrase.add(translatedWord);
                    }
                    phrases.add(new Phrase(phraseID, feedback, englishPhrase, translatedPhrase));
                }

                // 3. create an ArrayList of questions (pulled from writing, listening, and
                // matching questions)

                // 4. create an ArrayList of exercises

                // 5. create an ArrayList of stories

                // 6. create ArrayList of lessons

                languages.add(new Language(lessonID, nameOfLanguage, words, phrases));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    private static Word findWordByUUID(ArrayList<Word> words, UUID id) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getUUID().equals(id))
                return words.get(i);
        }
        return null;
    }

    // USERS
    /**
     * @author Christian Ruff
     * @return
     */

    private static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileReader reader = new FileReader("json/user.json");
            JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);
            HashMap<User, ArrayList<UUID>> friendsHash = new HashMap<User, ArrayList<UUID>>();

            // 1. construct user objects without friends
            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);
                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String username = (String) personJSON.get(USER_USERNAME);
                String password = (String) personJSON.get(USER_PASSWORD);
                String emailAddress = (String) personJSON.get(USER_EMAIL);
                int points = Math.toIntExact((long) personJSON.get(USER_POINTS));

                // convert special data types
                Date birthday = convertStringToDate((String) personJSON.get(USER_BIRTHDAY));
                Avatar avatar = convertJSONToAvatar((JSONObject) personJSON.get(USER_AVATAR));
                UserProgress userProgress = convertJSONToUserProgress((JSONObject) personJSON.get(USER_PROGRESS));

                // create user object
                User newUser = new User(id, firstName, lastName, username, password, emailAddress, birthday, avatar,
                        points, userProgress);
                System.out.println(newUser);

                // record the user's friends as a list of UUIDs
                friendsHash.put(newUser, convertFriendsToArrayList((JSONArray) personJSON.get(FRIENDS)));
                users.add(newUser);
            }

            // 2. iteratively link all friend objects (referencing UUIDs) to each user
            for (int i = 0; i < users.size(); i++) {
                System.out.println("Entered loop #" + i);
                User currentUser = users.get(i);
                ArrayList<UUID> friendsUUIDs = (ArrayList<UUID>) friendsHash.get(currentUser);

                // create user list of friends for each user
                if (friendsUUIDs == null) {
                    System.out.println("User #" + i + " has no friends.");
                } else {
                    // iterate through each friend
                    for (int j = 0; j < friendsUUIDs.size(); j++) {
                        User friend = findUserByUUID(users, friendsUUIDs.get(j));
                        if (friend != null) {
                            currentUser.addFriend(friend);
                            System.out.println(
                                    currentUser.getFirstName() + " is now friended with " + friend.getFirstName());
                        }
                    }
                }
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Date convertStringToDate(String str) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDate.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static ArrayList<UUID> convertFriendsToArrayList(JSONArray json) {
        ArrayList<UUID> ret = new ArrayList<UUID>();
        if (json != null) {
            for (int i = 0; i < json.size(); i++) {
                ret.add(UUID.fromString((String) json.get(i)));
            }
        }
        return ret;
    }

    private static User findUserByUUID(ArrayList<User> users, UUID id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUUID().equals(id))
                return users.get(i);
        }
        return null;
    }

    private static Avatar convertJSONToAvatar(JSONObject json) {
        String character = (String) json.get(CHARACTER);
        String hat = (String) json.get(HAT);
        return new Avatar(character, hat);
    }

    private static UserProgress convertJSONToUserProgress(JSONObject json) {
        int currentLesson = Math.toIntExact((long) json.get(CURRENT_LESSON));
        int currentExercise = Math.toIntExact((long) json.get(CURRENT_EXERCISE));
        return new UserProgress(currentLesson, currentExercise);
    }

}
