package org.academiadecodigo.debuggingac;

public enum FolderType {

    CAR_CRASH("/resources/images/folders/carcrash.png"),
    SNIPER_ELITE("/resources/images/folders/sniper.png"),
    GUESS_A_NUMBER("/resources/images/folders/guessnumber.png"),
    //ARABIAN_NIGHT("/resources/images/game/folder_arabian-nights.png"),
    HOTEL("/resources/images/folders/hotel.png"),
    MONEY_IN_THE_BANK("/resources/images/folders/bank.png"),
    ROCK_PAPER_SCISSORS("/resources/images/folders/janken.png");
    // HELLO_WORLD("/resources/images/Folders-PNG-File.png");

    private String folderPic;

    FolderType(String folderPic){
        this.folderPic = folderPic;
    }

    public static FolderType getRandomFolder(){

        return FolderType.values()[(int)(Math.random() * FolderType.values().length)];

    }

    public String getFolderPic() {
        return folderPic;
    }
}