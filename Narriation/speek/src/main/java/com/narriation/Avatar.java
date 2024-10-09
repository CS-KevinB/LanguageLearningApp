package com.narriation;
/**
 * Defines a class for a user Avatar
 * @author christianruff
 */
public class Avatar {
    private CharacterOptions character;
    private HatOptions hat;

    /**
     * Constructs the default avatar: a llama and no hats
     * @return Returns the character's avatar
     */
    public Avatar() {
        this.character = CharacterOptions.LLAMA;
        this.hat = HatOptions.NONE;
    }

    // Change this later
    public Avatar(String character, String hat) {
        if (character.equals("LLAMA")) {
            this.character = CharacterOptions.LLAMA;
        }
        if (character.equals("GIRAFFE")) {
            this.character = CharacterOptions.GIRAFFE;
        }
        if (character.equals("LIZARD")) {
            this.character = CharacterOptions.LIZARD;
        }
        if (hat.equals("NONE")) {
            this.hat = HatOptions.NONE;
        }
        if (hat.equals("SOMBRERO")) {
            this.hat = HatOptions.SOMBRERO;
        }
        if (hat.equals("CORDOBES")) { 
            this.hat = HatOptions.CORDOBES;
        }
        if (hat.equals("TXAPELA")) {
            this.hat = HatOptions.TXAPELA;
        }

    }

    /**
     * Returns this avatar's character option
     * @return Avatar's character option
     */
    public CharacterOptions getCharacter() {
        return this.character;
    }

    /**
     * Returns this avatar's hat option
     * @return Avatar's hat option
     */
    public HatOptions getHatOptions() {
        return this.hat;
    }

    /**
     * Sets the avatar's hat to a passed in parameter
     * @param hat A value in the HatOptions enum 
     * @return TRUE if the hat is set, FALSE if the hat is not set
     */
    public boolean setHat(HatOptions hat) {
        if (hat != null) {
            this.hat = hat;
            return true;
        }
        return false;
    }
    /**
     * Sets the character's hat to a passed in parameter
     * @param character A value in the CharacterOptions enum 
     * @return TRUE if the character is set, FALSE if the character is not set
     */
    public boolean setCharacter(CharacterOptions character) {
        if (character != null) {
            this.character = character;
            return true;
        }
        return false;
    }

    /**
     * Generates and returns a file path for the avatar image 
     * @return File path of the avatar's image
     */
    public String getImagePath() {
        return "";
    }

    public String toString(){
        return this.character.toString() + " " + this.hat.toString();
    }
}
