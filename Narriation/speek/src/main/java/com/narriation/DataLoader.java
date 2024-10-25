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
        // System.out.println(getUsers());
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

                // 0. store all variables
                UUID lessonID = UUID.fromString((String) currentLang.get(LANGUAGE_ID));
                String nameOfLanguage = (String) currentLang.get(LANGUAGE_NAME);
                ArrayList<Story> stories = parseStoriesFromLanguageObject((JSONObject) currentLang);
                ArrayList<Word> words = parseWordsFromLanguageObject((JSONObject) currentLang);
                ArrayList<Phrase> phrases = parsePhrasesFromLanguageObject((JSONObject) currentLang, words);

                languages.add(new Language(lessonID, nameOfLanguage, words, phrases, stories));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    private static ArrayList<Story> parseStoriesFromLanguageObject(JSONObject json) {
        ArrayList<Story> stories = new ArrayList<Story>();
        JSONArray jsonStories = (JSONArray) json.get(LANGUAGE_STORIES);

        for (int i = 0; i < jsonStories.size(); i++) {
            JSONObject currentStory = (JSONObject) jsonStories.get(i);
            String title = (String) currentStory.get(STORY_TITLE);
            String englishStory = (String) currentStory.get(STORY_ENGLISHSTORY);
            String spanishStory = (String) currentStory.get(STORY_SPANISHSTORY);
            stories.add(new Story(title, englishStory, spanishStory));
        }
        return stories;
    }

    /**
     * Parses the words from the json files
     * 
     * @param json requires the json file in order to parse
     * @return returns an array list of words
     */
    private static ArrayList<Word> parseWordsFromLanguageObject(JSONObject json) {
        ArrayList<Word> words = new ArrayList<Word>();
        JSONArray jsonWords = (JSONArray) json.get(LANGUAGE_WORDS);

        for (int j = 0; j < jsonWords.size(); j++) {
            JSONObject currentWord = (JSONObject) jsonWords.get(j);
            UUID wordID = UUID.fromString((String) currentWord.get(WORD_ID));
            String englishWord = (String) currentWord.get(WORD_INENGLISH);
            String translatedWord = (String) currentWord.get(WORD_INTARGETLANGUAGE);
            String pronounciation = (String) currentWord.get(WORD_PRONOUNCIATION);
            Gender gender = EnumUtilities.getEnumFromString(Gender.class,
                    (String) currentWord.get(WORD_GENDER));
            PartOfSpeech partOfSpeech = EnumUtilities.getEnumFromString(PartOfSpeech.class,
                    (String) currentWord.get(WORD_PARTOFSPEECH));
            int difficulty = Math.toIntExact((long) currentWord.get(WORD_DIFFICULTY));
            words.add(new Word(wordID, englishWord, translatedWord, pronounciation, partOfSpeech, gender,
                    difficulty));
        }
        return words;
    }

    /**
     * Parses the phrases from the json files
     * 
     * @param json needs the json file in order to parse
     * @return returns an array list of phrases
     */
    private static ArrayList<Phrase> parsePhrasesFromLanguageObject(JSONObject json, ArrayList<Word> words) {
        ArrayList<Phrase> phrases = new ArrayList<Phrase>();
        JSONArray jsonPhrases = (JSONArray) json.get(LANGUAGE_PHRASES);

        for (int j = 0; j < jsonPhrases.size(); j++) {
            JSONObject currentPhrase = (JSONObject) jsonPhrases.get(j);

            UUID phraseID = UUID.fromString((String) currentPhrase.get(PHRASE_ID));
            ArrayList<Word> englishPhrase = new ArrayList<Word>();
            ArrayList<Word> translatedPhrase = new ArrayList<Word>();
            int difficulty = Math.toIntExact((long) currentPhrase.get(PHRASE_DIFFICULTY));

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
            phrases.add(new Phrase(phraseID, englishPhrase, translatedPhrase, difficulty));
        }

        return phrases;
    }

    /**
     * Finds a word by its UUID
     * 
     * @param words needs the array list of words in order to search
     * @param id    needs the id
     * @return returns a word if found
     */
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
     * @return returns an array list of users
     */

    private static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileReader reader = new FileReader("Narriation/speek/json/user.json");
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
                UserProgress userProgress = convertJSONToUserProgress((JSONObject) personJSON.get(USERPROGRESS));

                // create user object
                User newUser = new User(id, firstName, lastName, username, password, emailAddress, birthday, avatar,
                        points, userProgress);
                // System.out.println(newUser);

                // record the user's friends as a list of UUIDs
                friendsHash.put(newUser, convertFriendsToArrayList((JSONArray) personJSON.get(FRIENDS)));
                users.add(newUser);
            }

            // 2. iteratively link all friend objects (referencing UUIDs) to each user
            for (int i = 0; i < users.size(); i++) {
                User updatedUser = users.get(i);
                ArrayList<UUID> friendsUUIDs = (ArrayList<UUID>) friendsHash.get(updatedUser);

                // create user list of friends for each user
                if (friendsUUIDs == null) {
                    System.out.println("User #" + i + " has no friends.");
                } else {
                    // iterate through each friend
                    for (int j = 0; j < friendsUUIDs.size(); j++) {
                        User friend = findUserByUUID(users, friendsUUIDs.get(j));
                        if (friend != null) {
                            updatedUser.addFriend(friend);
                            System.out.println(
                                    updatedUser.getFirstName() + " is now friended with " + friend.getFirstName());
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

    /**
     * Converts a string to a date
     * 
     * @param str requires the string in order to convert
     * @return returns a date
     */
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

    /**
     * Converts a json array to an array list
     * 
     * @param json requires the json array in order to convert
     * @return returns an array list
     */
    private static ArrayList<UUID> convertFriendsToArrayList(JSONArray json) {
        ArrayList<UUID> ret = new ArrayList<UUID>();
        if (json != null) {
            for (int i = 0; i < json.size(); i++) {
                ret.add(UUID.fromString((String) json.get(i)));
            }
        }
        return ret;
    }

    /**
     * Finds a user by its UUID
     * 
     * @param users requires the array list of users in order to search
     * @param id    requires the specific id in order to find
     * @return returns the user if found
     */
    private static User findUserByUUID(ArrayList<User> users, UUID id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUUID().equals(id))
                return users.get(i);
        }
        return null;
    }

    /**
     * Converts the json to an avatar
     * 
     * @param json requires the json object in order to create the avatar
     * @return returns the avatar
     */
    private static Avatar convertJSONToAvatar(JSONObject json) {
        String character = (String) json.get(CHARACTER);
        String hat = (String) json.get(HAT);
        return new Avatar(character, hat);
    }

    /**
     * Converts the json to a user progress
     * 
     * @param json requires the json object in order to create the user progress
     * @return returns the user progress
     */
    private static UserProgress convertJSONToUserProgress(JSONObject json) {
        System.out.println(
                "Entered\n" + json);

        int userDifficulty = Math.toIntExact((long) json.get(USERPROGRESS_DIFFICULTY));
        int currentStory = Math.toIntExact((long) json.get(USERPROGRESS_CURRENTSTORY));

        System.out.println(json.get(USERPROGRESS_WORDPROGRESS));

        HashMap<Phrase, Integer> phraseProgress = convertJSONToPhraseProgress(
                (JSONArray) json.get(USERPROGRESS_PHRASEPROGRESS));
        HashMap<Word, Integer> wordProgress = convertJSONToWordProgress(
                (JSONArray) json.get(USERPROGRESS_WORDPROGRESS));
        return new UserProgress(userDifficulty, currentStory, phraseProgress, wordProgress);
    }

    /**
     * Converts the json to a phrase progress
     * 
     * @param json requires the json array in order to create the phrase progress
     * @return returns the phrase progress
     */
    public static HashMap<Phrase, Integer> convertJSONToPhraseProgress(JSONArray json) {
        HashMap<Phrase, Integer> ret = new HashMap<Phrase, Integer>();
        for (int i = 0; i < json.size(); i++) {
            // 1. get key-value pair
            JSONObject keyValuePair = (JSONObject) json.get(i);

            // 2. get phrase
            UUID uuidOfPhrase = UUID.fromString((String) keyValuePair.get(USERPROGRESS_PHRASEPROGRESS_PHRASE));
            Phrase phrase = null;

            // TODO fix phrase above

            // 3. get value
            int integer = Math.toIntExact((long) keyValuePair.get(USERPROGRESS_PHRASEPROGRESS_INTEGER));
            ret.put(phrase, integer);
        }
        return ret;
    }

    /**
     * Converts the json to a word progress
     * 
     * @param json requires the json array in order to create the word progress
     * @return returns the word progress
     */
    public static HashMap<Word, Integer> convertJSONToWordProgress(JSONArray json) {
        HashMap<Word, Integer> ret = new HashMap<Word, Integer>();
        for (int i = 0; i < json.size(); i++) {
            // 1. get key-value pair
            JSONObject keyValuePair = (JSONObject) json.get(i);

            // 2. get phrase
            UUID uuidOfWord = UUID.fromString((String) keyValuePair.get(USERPROGRESS_WORDPROGRESS_WORD));
            Word word = null;

            // TODO fix word above

            // 3. get value
            int integer = Math.toIntExact((long) keyValuePair.get(USERPROGRESS_WORDPROGRESS_INTEGER));
            ret.put(word, integer);
        }
        return ret;
    }
}
